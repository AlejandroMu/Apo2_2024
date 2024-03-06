package co.icesi.edu.model;

import static org.junit.Assert.assertNull;

import org.junit.*;
import org.junit.Assert;

import co.icesi.edu.comparators.HeightComparator;
import co.icesi.edu.comparators.WidthComparator;

public class InfraestructureTest {

    @Test
    public void test() throws Exception {
        InfraestructureDeparment in = new InfraestructureDeparment();
        double average = in.averageHeight();
        Assert.assertEquals(2.0, average, 0);
    }

    @Test
    public void test2() throws Exception {
        InfraestructureDeparment in = new InfraestructureDeparment();
        Billboard b = new Billboard(2, 2, true, "Icesi");
        Billboard b2 = new Billboard(3, 3, true, "Icesi1");

        in.addBillboardOrder(b);
        in.addBillboardOrder(b2);

        Billboard b3 = new Billboard(0, 3, true, null);

        Billboard element = in.search(b3, new WidthComparator());
        assertNull(element);

    }

}
