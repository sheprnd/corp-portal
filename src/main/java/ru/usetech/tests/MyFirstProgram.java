package ru.usetech.tests;

public class MyFirstProgram {

    public static void main(String[] args) {

        Square s = new Square(4.0);
        //s.l = 4.0; - не нужно

        Rectangle r = new Rectangle(5.0, 6.0);
   /* r.a = 5.0;
    r.b = 6.0; - не нужно*/

        System.out.println("Площадь квадрата со стороной " + s.l + " = " + area(s));
        System.out.println("Площадь квадрата со сторонами " + r.a + " и " + r.b + " равно " + area(r));
    }

    public static double area (Rectangle r){
        return r.a * r.b;
    }

    public static  double area (Square s){
        return s.l * s.l;
    }

}
