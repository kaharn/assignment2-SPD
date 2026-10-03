package main.java.bridge;

public class Main {
    public static void main(String[] args) {
        Renderer vectorRenderer = new VectorRenderer();
        Renderer rasterRenderer = new RasterRenderer();

        Shape circleWithVectors = new Circle(vectorRenderer, 5.0);
        Shape circleWithPixels = new Circle(rasterRenderer, 5.0);
        Shape squareWithVectors = new Square(vectorRenderer, 4.0);
        Shape squareWithPixels = new Square(rasterRenderer, 4.0);

        circleWithVectors.draw();
        circleWithPixels.draw();
        squareWithVectors.draw();
        squareWithPixels.draw();

        System.out.println("Switching the same circle from vector to raster rendering:");
        circleWithVectors.setRenderer(rasterRenderer);
        circleWithVectors.draw();
    }
}
