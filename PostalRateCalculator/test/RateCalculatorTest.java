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

    Parcel testParcel = new Parcel(null, null, -1f, -1f, -1f, -1f);

    @Test
    public void validPostalCodeTo() throws Exception {
        testParcel = new Parcel(null, null, -1f, -1f, -1f, -1f);
        String newPostalCode = "H3Z2Y7";
        testParcel = RateCalculator.setCheckSourcePostalCode(testParcel, newPostalCode);
        assertEquals(testParcel.getSourcePostalCode(), newPostalCode);

    }

    @Test
    public void invalidPostalCodeTo() throws Exception {
//        String newPostalCode = "HAZ2Y7";
//        testParcel.setSourcePostalCode(newPostalCode);
//        assertEquals(testParcel.getSourcePostalCode(), newPostalCode);
//
//        newPostalCode = "054031";
//        testParcel.setSourcePostalCode(newPostalCode);
//        assertEquals(testParcel.getSourcePostalCode(), newPostalCode);
//
//        newPostalCode = "HAZAY7";
//        testParcel.setSourcePostalCode(newPostalCode);
//        assertEquals(testParcel.getSourcePostalCode(), newPostalCode);
//
//        newPostalCode = "H3Z2Y";
//        testParcel.setSourcePostalCode(newPostalCode);
//        assertEquals(testParcel.getSourcePostalCode(), newPostalCode);
//
//        newPostalCode = "H3Z2Y7A";
//        testParcel.setSourcePostalCode(newPostalCode);
//        assertEquals(testParcel.getSourcePostalCode(), newPostalCode);
    }

    @Test
    public void validPostalCodeFrom() throws Exception {
        testParcel = new Parcel(null, null, -1f, -1f, -1f, -1f);
        boolean exception = false;

        String newPostalCode = "H3Z2Y7";
        try{
            testParcel = RateCalculator.setCheckDestPostalCode(testParcel, newPostalCode);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertEquals(testParcel.getDestPostalCode(), newPostalCode);
        assertFalse(exception);
    }

    @Test
    public void invalidPostalCodeFrom() throws Exception {
//        String newPostalCode = "HAZ2Y7";
//        testParcel.setDestPostalCode(newPostalCode);
//        assertNotEquals(testParcel.getDestPostalCode(), newPostalCode);
//
//        newPostalCode = "054031";
//        testParcel.setDestPostalCode(newPostalCode);
//        assertNotEquals(testParcel.getDestPostalCode(), newPostalCode);
//
//        newPostalCode = "HAZAY7";
//        testParcel.setDestPostalCode(newPostalCode);
//        assertNotEquals(testParcel.getDestPostalCode(), newPostalCode);
//
//        newPostalCode = "H3Z2Y";
//        testParcel.setDestPostalCode(newPostalCode);
//        assertNotEquals(testParcel.getDestPostalCode(), newPostalCode);
//
//        newPostalCode = "H3Z2Y7A";
//        testParcel.setDestPostalCode(newPostalCode);
//        assertNotEquals(testParcel.getDestPostalCode(), newPostalCode);
    }

    @Test
    public void validLength() throws Exception {
        testParcel = new Parcel(null, null, -1f, -1f, -1f, -1f);
        boolean exception = false;

        float newLength = 10.000f;
        try{
            testParcel = RateCalculator.setCheckLegnth(testParcel, newLength);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertEquals(testParcel.getLength(), newLength, 0f);
        assertFalse(exception);

        exception = false;
        newLength = 20.00000f;
        try{
            testParcel = RateCalculator.setCheckLegnth(testParcel, newLength);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertEquals(testParcel.getLength(), newLength, 0f);
        assertFalse(exception);

        exception = false;
        newLength = 17.1380204f;
        try{
            testParcel = RateCalculator.setCheckLegnth(testParcel, newLength);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertEquals(testParcel.getLength(), newLength, 0f);
        assertFalse(exception);
    }

    @Test
    public void invalidLength() throws Exception {
        testParcel = new Parcel(null, null, -1f, -1f, -1f, -1f);
        boolean exception = false;

        float newLength = 9.999999f;
        try{
            testParcel = RateCalculator.setCheckLegnth(testParcel, newLength);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertNotEquals(testParcel.getLength(), newLength, 0f);
        assertTrue(exception);

        exception = false;
        newLength = 9.000f;
        try{
            testParcel = RateCalculator.setCheckLegnth(testParcel, newLength);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertNotEquals(testParcel.getLength(), newLength, 0f);
        assertTrue(exception);

        exception = false;
        newLength = 20.000001f;
        try{
            testParcel = RateCalculator.setCheckLegnth(testParcel, newLength);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertNotEquals(testParcel.getLength(), newLength, 0f);
        assertTrue(exception);

        exception = false;
        newLength = 23.13482f;
        try{
            testParcel = RateCalculator.setCheckLegnth(testParcel, newLength);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertNotEquals(testParcel.getLength(), newLength, 0f);
        assertTrue(exception);
    }

    @Test
    public void validWidth() throws Exception {
        testParcel = new Parcel(null, null, -1f, -1f, -1f, -1f);
        boolean exception = false;

        float newWidth = 7.0000f;
        try{
            testParcel = RateCalculator.setCheckWidth(testParcel, newWidth);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertEquals(testParcel.getWidth(), newWidth, 0f);
        assertFalse(exception);

        exception = false;
        newWidth = 9.120489f;
        try{
            testParcel = RateCalculator.setCheckWidth(testParcel, newWidth);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertEquals(testParcel.getWidth(), newWidth, 0f);
        assertFalse(exception);

        exception = false;
        newWidth = 20.000f;
        try{
            testParcel = RateCalculator.setCheckWidth(testParcel, newWidth);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertEquals(testParcel.getWidth(), newWidth, 0f);
        assertFalse(exception);
    }

    @Test
    public void invalidWidth() throws Exception {
        testParcel = new Parcel(null, null, -1f, -1f, -1f, -1f);
        boolean exception = false;

        float newWidth = 6.999999f;
        try{
            testParcel = RateCalculator.setCheckWidth(testParcel, newWidth);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertNotEquals(testParcel.getWidth(), newWidth, 0f);
        assertTrue(exception);

        exception = false;
        newWidth = 284.285028f;
        try{
            testParcel = RateCalculator.setCheckWidth(testParcel, newWidth);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertNotEquals(testParcel.getWidth(), newWidth, 0f);
        assertTrue(exception);

        exception = false;
        newWidth = 20.00001f;
        try{
            testParcel = RateCalculator.setCheckWidth(testParcel, newWidth);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertNotEquals(testParcel.getWidth(), newWidth, 0f);
        assertTrue(exception);
    }

    @Test
    public void validHeight() throws Exception {
        testParcel = new Parcel(null, null, -1f, -1f, -1f, -1f);
        boolean exception = false;

        float newHeight = 0.100000f;
        try{
            testParcel = RateCalculator.setCheckHeight(testParcel, newHeight);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertEquals(testParcel.getHeight(), newHeight, 0f);
        assertFalse(exception);

        exception = false;
        newHeight = 13.10184f;
        try{
            testParcel = RateCalculator.setCheckHeight(testParcel, newHeight);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertEquals(testParcel.getHeight(), newHeight, 0f);
        assertFalse(exception);

        exception = false;
        newHeight = 20.0000f;
        try{
            testParcel = RateCalculator.setCheckHeight(testParcel, newHeight);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertEquals(testParcel.getHeight(), newHeight, 0f);
        assertFalse(exception);
    }

    @Test
    public void invalidHeight() throws Exception {
        testParcel = new Parcel(null, null, -1f, -1f, -1f, -1f);
        boolean exception = false;

        float newHeight = 0.0999999f;
        try{
            testParcel = RateCalculator.setCheckHeight(testParcel, newHeight);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertNotEquals(testParcel.getHeight(), newHeight, 0f);
        assertTrue(exception);

        exception = false;
        newHeight = 174.10184f;
        try{
            testParcel = RateCalculator.setCheckHeight(testParcel, newHeight);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertNotEquals(testParcel.getHeight(), newHeight, 0f);
        assertTrue(exception);

        exception = false;
        newHeight = 20.00001f;
        try{
            testParcel = RateCalculator.setCheckHeight(testParcel, newHeight);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertNotEquals(testParcel.getHeight(), newHeight, 0f);
        assertTrue(exception);
    }

    @Test
    public void validWeight() throws Exception {
        testParcel = new Parcel(null, null, -1f, -1f, -1f, -1f);
        boolean exception = false;

        float newWeight = 0.000001f;
        try {
            testParcel = RateCalculator.setCheckWeight(testParcel, newWeight);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertEquals(testParcel.getWeight(), newWeight, 0f);
        assertFalse(exception);

        exception = false;
        newWeight = 30.0001f;
        try {
            testParcel = RateCalculator.setCheckWeight(testParcel, newWeight);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertEquals(testParcel.getWeight(), newWeight, 0f);
        assertFalse(exception);

        exception = false;
        newWeight = 23495.293f;
        try {
            testParcel = RateCalculator.setCheckWeight(testParcel, newWeight);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertEquals(testParcel.getWeight(), newWeight, 0f);
        assertFalse(exception);

        exception = false;
        newWeight = 18.12845f;
        try {
            testParcel = RateCalculator.setCheckWeight(testParcel, newWeight);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertEquals(testParcel.getWeight(), newWeight, 0f);
        assertFalse(exception);
    }

    @Test
    public void invalidWeight() throws Exception {
        testParcel = new Parcel(null, null, -1f, -1f, -1f, -1f);
        boolean exception = false;

        float newWeight = -12.0842f;
        try {
            testParcel = RateCalculator.setCheckWeight(testParcel, newWeight);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertNotEquals(testParcel.getWeight(), newWeight, 0f);
        assertTrue(exception);

        exception = false;
        newWeight = 0.00000f;
        try {
            testParcel = RateCalculator.setCheckWeight(testParcel, newWeight);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertNotEquals(testParcel.getWeight(), newWeight, 0f);
        assertTrue(exception);

        exception = false;
        newWeight = -0.0000001f;
        try {
            testParcel = RateCalculator.setCheckWeight(testParcel, newWeight);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertNotEquals(testParcel.getWeight(), newWeight, 0f);
        assertTrue(exception);
    }

    @Test
    public void validType() throws Exception {
        testParcel = new Parcel(null, null, -1f, -1f, -1f, -1f);

        testParcel = RateCalculator.setCheckType(testParcel, "xpress");
        assertEquals(testParcel.getType(), Parcel.Type.XPRESS);

        testParcel = RateCalculator.setCheckType(testParcel, "Xpress");
        assertEquals(testParcel.getType(), Parcel.Type.XPRESS);

        testParcel = RateCalculator.setCheckType(testParcel, "XPress");
        assertEquals(testParcel.getType(), Parcel.Type.XPRESS);

        testParcel = RateCalculator.setCheckType(testParcel, "regular");
        assertEquals(testParcel.getType(), Parcel.Type.REGULAR);

        testParcel = RateCalculator.setCheckType(testParcel, "Regular");
        assertEquals(testParcel.getType(), Parcel.Type.REGULAR);

        testParcel = RateCalculator.setCheckType(testParcel, "priority");
        assertEquals(testParcel.getType(), Parcel.Type.PRIORITY);

        testParcel = RateCalculator.setCheckType(testParcel, "Priority");
        assertEquals(testParcel.getType(), Parcel.Type.PRIORITY);
    }

    @Test
    public void invalidType() throws Exception {
        testParcel = new Parcel(null, null, -1f, -1f, -1f, -1f);

        testParcel = RateCalculator.setCheckType(testParcel, "");
        assertNull(testParcel.getType());

        testParcel = RateCalculator.setCheckType(testParcel, " ");
        assertNull(testParcel.getType());

        testParcel = RateCalculator.setCheckType(testParcel, "express");
        assertNull(testParcel.getType());

        testParcel = RateCalculator.setCheckType(testParcel, "regullaarr");
        assertNull(testParcel.getType());

        testParcel = RateCalculator.setCheckType(testParcel, "PrioriTea");
        assertNull(testParcel.getType());
    }

}