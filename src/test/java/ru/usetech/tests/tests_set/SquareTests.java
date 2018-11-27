package ru.usetech.tests.tests_set;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.usetech.tests.Rectangle;
import ru.usetech.tests.Square;

public class SquareTests {
    @Test
    public void testArea() {
        Square s = new Square(5.0);
        Assert.assertEquals(s.area(), 25.0);
        Rectangle r = new Rectangle(5.0, 6.0);
        Assert.assertEquals(r.area(), 30.0);

    }

}
