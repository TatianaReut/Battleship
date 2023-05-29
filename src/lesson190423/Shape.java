package lesson190423;

class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3, 4, 5);
        Rectangle rectangle = new Rectangle(5, 10);
        Circle circle = new Circle(10);

        System.out.println(triangle.getPerimeter());
        System.out.println(triangle.getArea());
        System.out.println(rectangle.getPerimeter());
        System.out.println(rectangle.getArea());
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());
    }
}
abstract class Shape {
    abstract double getPerimeter();
    abstract double getArea();
}

class Triangle extends Shape {
    private double a;
    private double b;
    private double c;
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    double getPerimeter() {
        return a + b + c;
    }

    @Override
    double getArea() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}

class Rectangle extends Shape {
    private double a;
    private double b;
    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }
    @Override
    double getPerimeter() {
        return a * 2 + b * 2;
    }

    @Override
    double getArea() {
        return a * b;
    }
}

class Circle extends Shape {
    private double r;
    public Circle(double r) {
        this.r = r;
    }
    @Override
    double getPerimeter() {
        return 2 * Math.PI * r;
    }

    @Override
    double getArea() {
        return Math.PI * Math.pow(r, 2);
    }
}