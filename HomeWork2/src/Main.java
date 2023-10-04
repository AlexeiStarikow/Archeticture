
import decorator.Drawable;
import decorator.GreenDrawableDecorator;
import decorator.Triangle;
import observer.Publisher;
import observer.SubscriberOne;
import observer.SubscriberTwo;

public class Main {
    public static void main(String[] args) {
        Drawable triangle = new Triangle();
        triangle.draw();
        Drawable greenTriangle = new GreenDrawableDecorator(new Triangle());
        greenTriangle.draw();

        SubscriberOne subscriberOne = new SubscriberOne();
        SubscriberTwo subscriberTwo = new SubscriberTwo();
        Publisher publisher = new Publisher();

        publisher.attach(subscriberOne);
        publisher.attach(subscriberTwo);

        publisher.notify("test message");

    }
}