package main.java.circuitBreaker;

// Класс, представляющий паттерн Circuit Breaker
class CircuitBreaker {
    private boolean isOpen = false;         // Флаг, указывающий, открыт ли Circuit Breaker
    private int failureThreshold = 3;       // Количество ошибок для срабатывания Circuit Breaker
    private int failureCount = 0;           // Счетчик ошибок

    // Метод, разрешающий или блокирующий запросы в зависимости от состояния Circuit Breaker
    public boolean allowRequest() {
        if (isOpen) {
            System.out.println("Circuit Breaker is open, blocking the request");
            return false;
        }

        if (failureCount >= failureThreshold) {
            isOpen = true;
            System.out.println("Circuit Breaker opened");
            return false;
        }

        return true;
    }

    // Метод для записи ошибки в Circuit Breaker
    public void recordFailure() {
        failureCount++;
        System.out.println("Failure recorded. Failure count: " + failureCount);
    }

    // Метод для сброса состояния Circuit Breaker
    public void reset() {
        isOpen = false;
        failureCount = 0;
        System.out.println("Circuit Breaker reset");
    }
}

// Класс, представляющий сервис пользователя
class UserService {
    private CircuitBreaker circuitBreaker;

    // Конструктор, принимающий экземпляр Circuit Breaker
    public UserService(CircuitBreaker circuitBreaker) {
        this.circuitBreaker = circuitBreaker;
    }

    // Метод для получения информации о пользователе
    public String getUserInfo(int userId) {
        if (!circuitBreaker.allowRequest()) {
            return "Service is unavailable due to Circuit Breaker";
        }

        // Здесь был бы код для получения информации о пользователе
        // В данном примере мы просто имитируем успешный запрос
        System.out.println("getUserInfo() method is called");
        return "User info for user " + userId;
    }

    // Метод для сообщения об ошибке в Circuit Breaker
    public void reportFailure() {
        circuitBreaker.recordFailure();
        System.out.println("reportFailure() method is called");
    }

    // Метод для сброса состояния Circuit Breaker
    public void resetCircuitBreaker() {
        circuitBreaker.reset();
        System.out.println("resetCircuitBreaker() method is called");
    }
}

// Класс для запуска примера
public class Main {
    public static void main(String[] args) {
        CircuitBreaker circuitBreaker = new CircuitBreaker();
        UserService userService = new UserService(circuitBreaker);

        // Имитируем 5 запросов, включая три ошибки
        for (int i = 0; i < 5; i++) {
            String userInfo = userService.getUserInfo(123);
            System.out.println(userInfo);

            if (i == 2) {
                userService.reportFailure();
            }
        }

        userService.resetCircuitBreaker(); // Сбрасываем Circuit Breaker

        // Пробуем снова после сброса
        String userInfoAfterReset = userService.getUserInfo(123);
        System.out.println(userInfoAfterReset);
    }
}
