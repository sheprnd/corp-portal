package ru.usetech.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {
    @Test
    public void testArea() {
        Square s = new Square(5.0);
        Assert.assertEquals(s.area(), 25.0);
        Rectangle r = new Rectangle(5.0, 6.0);
        Assert.assertEquals(r.area(), 30.0);

    }

}
