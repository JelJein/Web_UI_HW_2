package org.example.lesson4;

public class Triangle {
    public double triangleSquare(int a, int b, int c) {
        if (!checkTriangle(a,b,c)) throw new TriangleException();
        // calculate the perimeter
        double p = (a + b + c) / 2D;
        // calculate the triangle area
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    // check a, b and c for our triangle
    private boolean checkTriangle(int a, int b, int c) {
        return (a < b + c) && (b < a + c) && (c < a + b);
    }

    //for testing @Nested
    public double division(int divisible, int divider) {
        if (divider == 0) throw new ArithmeticException();
        return divisible / divider;
    }
}