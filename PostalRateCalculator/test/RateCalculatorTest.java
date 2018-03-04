import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RateCalculatorTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    Parcel testParcel = new Parcel("H2X1S4", "H1A4K2", 10, 10, 10, 15);

    @Test
    public void validPostalCodeTo() throws Exception {
        String newPostalCode = "H3Z2Y7";
        testParcel.setSourcePostalCode(newPostalCode);
        assertEquals(testParcel.getSourcePostalCode(), newPostalCode);

    }

    @Test
    public void invalidPostalCodeTo() throws Exception {
        String newPostalCode = "HAZ2Y7";
        testParcel.setSourcePostalCode(newPostalCode);
        assertEquals(testParcel.getSourcePostalCode(), newPostalCode);

        newPostalCode = "054031";
        testParcel.setSourcePostalCode(newPostalCode);
        assertEquals(testParcel.getSourcePostalCode(), newPostalCode);

        newPostalCode = "HAZAY7";
        testParcel.setSourcePostalCode(newPostalCode);
        assertEquals(testParcel.getSourcePostalCode(), newPostalCode);

        newPostalCode = "H3Z2Y";
        testParcel.setSourcePostalCode(newPostalCode);
        assertEquals(testParcel.getSourcePostalCode(), newPostalCode);

        newPostalCode = "H3Z2Y7A";
        testParcel.setSourcePostalCode(newPostalCode);
        assertEquals(testParcel.getSourcePostalCode(), newPostalCode);
    }

    @Test
    public void validPostalCodeFrom() throws Exception {
        String newPostalCode = "H3Z2Y7";
        testParcel.setDestPostalCode(newPostalCode);
        assertEquals(testParcel.getDestPostalCode(), newPostalCode);
    }

    @Test
    public void invalidPostalCodeFrom() throws Exception {
        String newPostalCode = "HAZ2Y7";
        testParcel.setDestPostalCode(newPostalCode);
        assertNotEquals(testParcel.getDestPostalCode(), newPostalCode);

        newPostalCode = "054031";
        testParcel.setDestPostalCode(newPostalCode);
        assertNotEquals(testParcel.getDestPostalCode(), newPostalCode);

        newPostalCode = "HAZAY7";
        testParcel.setDestPostalCode(newPostalCode);
        assertNotEquals(testParcel.getDestPostalCode(), newPostalCode);

        newPostalCode = "H3Z2Y";
        testParcel.setDestPostalCode(newPostalCode);
        assertNotEquals(testParcel.getDestPostalCode(), newPostalCode);

        newPostalCode = "H3Z2Y7A";
        testParcel.setDestPostalCode(newPostalCode);
        assertNotEquals(testParcel.getDestPostalCode(), newPostalCode);
    }

    @Test
    public void validLWH() throws Exception {
        float newLWH = 7.0123f;
        testParcel.setLength(newLWH);
        testParcel.setWidth(newLWH);
        testParcel.setHeight(newLWH);
        assertEquals(testParcel.getLength(), newLWH, 0.000f);
        assertEquals(testParcel.getWidth(), newLWH, 0.000f);
        assertEquals(testParcel.getHeight(), newLWH, 0.000f);

        newLWH = 0.000001f;
        testParcel.setLength(newLWH);
        testParcel.setWidth(newLWH);
        testParcel.setHeight(newLWH);
        assertEquals(testParcel.getLength(), newLWH, 0.000f);
        assertEquals(testParcel.getWidth(), newLWH, 0.000f);
        assertEquals(testParcel.getHeight(), newLWH, 0.000f);

        newLWH = 20.000001f;
        testParcel.setLength(newLWH);
        testParcel.setWidth(newLWH);
        testParcel.setHeight(newLWH);
        assertEquals(testParcel.getLength(), newLWH, 0.000f);
        assertEquals(testParcel.getWidth(), newLWH, 0.000f);
        assertEquals(testParcel.getHeight(), newLWH, 0.000f);
    }

    @Test
    public void invalidLWH() throws Exception {
        float newLWH = -1.2945f;
        testParcel.setLength(newLWH);
        testParcel.setWidth(newLWH);
        testParcel.setHeight(newLWH);
        assertNotEquals(testParcel.getLength(), newLWH, 0.000f);
        assertEquals(testParcel.getWidth(), newLWH, 0.000f);
        assertEquals(testParcel.getHeight(), newLWH, 0.000f);

        newLWH = 0.00000f;
        testParcel.setLength(newLWH);
        testParcel.setWidth(newLWH);
        testParcel.setHeight(newLWH);
        assertNotEquals(testParcel.getLength(), newLWH, 0.000f);
        assertEquals(testParcel.getWidth(), newLWH, 0.000f);
        assertEquals(testParcel.getHeight(), newLWH, 0.000f);

        newLWH = 20.00001f;
        testParcel.setLength(newLWH);
        testParcel.setWidth(newLWH);
        testParcel.setHeight(newLWH);
        assertNotEquals(testParcel.getLength(), newLWH, 0.000f);
        assertEquals(testParcel.getWidth(), newLWH, 0.000f);
        assertEquals(testParcel.getHeight(), newLWH, 0.000f);
    }

    @Test
    public void validWeight() throws Exception {

    }

    @Test
    public void invalidWeight() throws Exception {

    }

    @Test
    public void validType() throws Exception {
        RateCalculator.setCheckType(testParcel, "xpress");
        assertEquals(testParcel.getType(), Parcel.Type.XPRESS);

        RateCalculator.setCheckType(testParcel, "Xpress");
        assertEquals(testParcel.getType(), Parcel.Type.XPRESS);

        RateCalculator.setCheckType(testParcel, "XPress");
        assertEquals(testParcel.getType(), Parcel.Type.XPRESS);

        RateCalculator.setCheckType(testParcel, "regular");
        assertEquals(testParcel.getType(), Parcel.Type.REGULAR);

        RateCalculator.setCheckType(testParcel, "Regular");
        assertEquals(testParcel.getType(), Parcel.Type.REGULAR);

        RateCalculator.setCheckType(testParcel, "priority");
        assertEquals(testParcel.getType(), Parcel.Type.PRIORITY);

        RateCalculator.setCheckType(testParcel, "Priority");
        assertEquals(testParcel.getType(), Parcel.Type.PRIORITY);
    }

    @Test
    public void invalidType() throws Exception {
        RateCalculator.setCheckType(testParcel, "");
        assertNull(testParcel.getType());

        RateCalculator.setCheckType(testParcel, " ");
        assertNull(testParcel.getType());

        RateCalculator.setCheckType(testParcel, "express");
        assertNull(testParcel.getType());

        RateCalculator.setCheckType(testParcel, "regullaarr");
        assertNull(testParcel.getType());

        RateCalculator.setCheckType(testParcel, "PrioriTea");
        assertNull(testParcel.getType());
    }

}