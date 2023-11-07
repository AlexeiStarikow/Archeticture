package test.java.taskOne;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestTwo {

    @Test
    public void testStringEquality() {
        String expected = "Hello, World!";
        String actual = "Hello, World!";

        // Используем AssertJ для проверки равенства строк
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testArrayEquality() {
        int[] expectedArray = {1, 2, 3};
        int[] actualArray = {1, 2, 3};

        // Используем AssertJ для проверки равенства массивов
        assertThat(actualArray).isEqualTo(expectedArray);
    }

    @Test
    public void testBooleanCondition() {
        boolean condition = true;

        // Используем AssertJ для проверки условия
        assertThat(condition).isTrue();
    }
}
