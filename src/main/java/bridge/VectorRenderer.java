package main.java.bridge;

public class VectorRenderer implements Renderer {
    @Override
    public void renderCircle(double radius) {
        System.out.println("Drawing circle as vectors with radius: " + radius);
    }

    @Override
    public void renderSquare(double side) {
        System.out.println("Drawing square as vectors with side: " + side);
    }
}
