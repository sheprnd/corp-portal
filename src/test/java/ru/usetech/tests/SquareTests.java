package ru.usetech.tests;


import org.testng.annotations.Test;

@Test
public class SquareTests {
    public void testArea() {
        Square s = new Square(5.0);
        assert s.area() == 25;

        Rectangle r = new Rectangle(5.0, 6.0);
        assert r.area() == 30;
    }

}
