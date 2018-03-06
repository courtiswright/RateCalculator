import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RateCalculatorTest {

    @Test
    public void correctArgumentNumber() throws Exception {
        boolean exception = false;
        String[] args4 = {"H2X1S4", "M2S4F5", "15", "9.7", "0.345", "3", "regular"};
        try{
            RateCalculator.main(args4);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertFalse(exception);
    }

    @Test
    public void incorrectArgumentNumber() throws Exception {
        boolean exception = false;
        String[] args = {"abcd", "3"};
        try{
            RateCalculator.main(args);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertTrue(exception);

        exception = false;
        String[] args1 = {"abcd", "3", "943"};
        try{
            RateCalculator.main(args1);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertTrue(exception);

        exception = false;
        String[] args2 = {"abcd", "3", "04821", "soiejr"};
        try{
            RateCalculator.main(args2);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertTrue(exception);

        exception = false;
        String[] args3 = {"abcd", "3", "04821", "soiejr", "39ndke4"};
        try{
            RateCalculator.main(args3);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertTrue(exception);

        exception = false;
        String[] args4 = {"abcd", "3", "04821", "soiejr", "39ndke4", "23nsdjk53"};
        try{
            RateCalculator.main(args4);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertTrue(exception);
    }

    Parcel testParcel = new Parcel(null, null, -1f, -1f, -1f, -1f);

    @Test
    public void validPostalCodeTo() throws Exception {
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
    public void invalidPostalCodeTo() throws Exception {
        boolean exception = false;
        testParcel = new Parcel(null, null, -1f, -1f, -1f, -1f);
        
        String newPostalCode = "HAZ 2Y7";
        try {
            testParcel = RateCalculator.setCheckDestPostalCode(testParcel, newPostalCode);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertNotEquals(testParcel.getDestPostalCode(), newPostalCode);
        assertTrue(exception);

        exception = false;
        newPostalCode = "054031";
        try {
            testParcel = RateCalculator.setCheckDestPostalCode(testParcel, newPostalCode);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertNotEquals(testParcel.getDestPostalCode(), newPostalCode);
        assertTrue(exception);

        exception = false;
        newPostalCode = "HAZAY7";
        try {
            testParcel = RateCalculator.setCheckDestPostalCode(testParcel, newPostalCode);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertNotEquals(testParcel.getDestPostalCode(), newPostalCode);
        assertTrue(exception);

        exception = false;
        newPostalCode = "H3Z2Y";
        try {
            testParcel = RateCalculator.setCheckDestPostalCode(testParcel, newPostalCode);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertNotEquals(testParcel.getDestPostalCode(), newPostalCode);
        assertTrue(exception);

        exception = false;
        newPostalCode = "H3Z2Y7A";
        try {
            testParcel = RateCalculator.setCheckDestPostalCode(testParcel, newPostalCode);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertNotEquals(testParcel.getDestPostalCode(), newPostalCode);
        assertTrue(exception);
    }

    @Test
    public void validPostalCodeFrom() throws Exception {
        testParcel = new Parcel(null, null, -1f, -1f, -1f, -1f);
        boolean exception = false;

        String newPostalCode = "H3Z2Y7";
        try{
            testParcel = RateCalculator.setCheckSourcePostalCode(testParcel, newPostalCode);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertEquals(testParcel.getSourcePostalCode(), newPostalCode);
        assertFalse(exception);
    }

    @Test
    public void invalidPostalCodeFrom() throws Exception {
    	boolean exception = false;
        testParcel = new Parcel(null, null, -1f, -1f, -1f, -1f);
        
        String newPostalCode = "HAZ 2Y7";
        try {
            testParcel = RateCalculator.setCheckSourcePostalCode(testParcel, newPostalCode);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertNotEquals(testParcel.getSourcePostalCode(), newPostalCode);
        assertTrue(exception);

        exception = false;
        newPostalCode = "054031";
        try {
            testParcel = RateCalculator.setCheckSourcePostalCode(testParcel, newPostalCode);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertNotEquals(testParcel.getSourcePostalCode(), newPostalCode);
        assertTrue(exception);

        exception = false;
        newPostalCode = "HAZAY7";
        try {
            testParcel = RateCalculator.setCheckSourcePostalCode(testParcel, newPostalCode);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertNotEquals(testParcel.getSourcePostalCode(), newPostalCode);
        assertTrue(exception);

        exception = false;
        newPostalCode = "H3Z2Y";
        try {
            testParcel = RateCalculator.setCheckSourcePostalCode(testParcel, newPostalCode);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertNotEquals(testParcel.getSourcePostalCode(), newPostalCode);
        assertTrue(exception);

        exception = false;
        newPostalCode = "H3Z2Y7A";
        try {
            testParcel = RateCalculator.setCheckSourcePostalCode(testParcel, newPostalCode);
        }
        catch (IllegalArgumentException ex){
            exception = true;
        }
        assertNotEquals(testParcel.getSourcePostalCode(), newPostalCode);
        assertTrue(exception);
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

    @Test
    public void postalCodeTranslation() throws Exception {
        testParcel = new Parcel("H2X1S4", "H3A1B9", 15.29385f, 9.23593f, 0.193477f, 12.2475f);
        String translation = RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode());
        assertEquals(translation, "A3");

        testParcel = RateCalculator.setCheckSourcePostalCode(testParcel, "J8R3U5");
        translation = RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode());
        assertEquals(translation, "B1");

        testParcel = RateCalculator.setCheckSourcePostalCode(testParcel, "K7N3U5");
        translation = RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode());
        assertEquals(translation, "B3");

        testParcel = RateCalculator.setCheckSourcePostalCode(testParcel, "N8X3U5");
        translation = RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode());
        assertEquals(translation, "B5");

        testParcel = RateCalculator.setCheckSourcePostalCode(testParcel, "N7W3U5");
        translation = RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode());
        assertEquals(translation, "D1");

        testParcel = RateCalculator.setCheckSourcePostalCode(testParcel, "B1R3U5");
        translation = RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode());
        assertEquals(translation, "E1");

        testParcel = RateCalculator.setCheckSourcePostalCode(testParcel, "P7C3U5");
        translation = RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode());
        assertEquals(translation, "E5");

        testParcel = RateCalculator.setCheckSourcePostalCode(testParcel, "B1H3U5");
        translation = RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode());
        assertEquals(translation, "F1");

        testParcel = RateCalculator.setCheckSourcePostalCode(testParcel, "P8N3U5");
        translation = RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode());
        assertEquals(translation, "F2");

        testParcel = RateCalculator.setCheckSourcePostalCode(testParcel, "B0M3U5");
        translation = RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode());
        assertEquals(translation, "F3");

        testParcel = RateCalculator.setCheckSourcePostalCode(testParcel, "R0A3U5");
        translation = RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode());
        assertEquals(translation, "F4");

        testParcel = RateCalculator.setCheckSourcePostalCode(testParcel, "P0T3U5");
        translation = RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode());
        assertEquals(translation, "F6");

        testParcel = RateCalculator.setCheckSourcePostalCode(testParcel, "S9V3U5");
        translation = RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode());
        assertEquals(translation, "G1");

        testParcel = RateCalculator.setCheckSourcePostalCode(testParcel, "T2C3U5");
        translation = RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode());
        assertEquals(translation, "G2");

        testParcel = RateCalculator.setCheckSourcePostalCode(testParcel, "V2S3U5");
        translation = RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode());
        assertEquals(translation, "G3");

        testParcel = RateCalculator.setCheckSourcePostalCode(testParcel, "V8A3U5");
        translation = RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode());
        assertEquals(translation, "H1");

        testParcel = RateCalculator.setCheckSourcePostalCode(testParcel, "S0J3U5");
        translation = RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode());
        assertEquals(translation, "H3");

        testParcel = RateCalculator.setCheckSourcePostalCode(testParcel, "V0V3U5");
        translation = RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode());
        assertEquals(translation, "H5");
    }

    @Test
    public void correctPriceAssignment() throws Exception {
        testParcel = new Parcel("S9V3U5", "H3A1B9", 15.29385f, 9.23593f, 0.193477f, 12.2475f);
        RateCalculator.setCheckType(testParcel, "regular");
        testParcel.setTranslatedPostalCode(RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode()));

        float price = RateCalculator.rateTableLookup(testParcel);
        assertEquals(price, 32.24f, 0f);

        RateCalculator.setCheckType(testParcel, "xpress");
        testParcel.setTranslatedPostalCode(RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode()));

        price = RateCalculator.rateTableLookup(testParcel);
        assertEquals(price, 86.52f, 0f);

        RateCalculator.setCheckType(testParcel, "priority");
        testParcel.setTranslatedPostalCode(RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode()));

        price = RateCalculator.rateTableLookup(testParcel);
        assertEquals(price, 115.53f, 0f);

        testParcel = new Parcel("E4X3U5", "H3A1B9", 15.29385f, 9.23593f, 0.193477f, 24.943f);
        RateCalculator.setCheckType(testParcel, "regular");
        testParcel.setTranslatedPostalCode(RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode()));

        price = RateCalculator.rateTableLookup(testParcel);
        assertEquals(price, 44.92f, 0f);

        RateCalculator.setCheckType(testParcel, "xpress");
        testParcel.setTranslatedPostalCode(RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode()));

        price = RateCalculator.rateTableLookup(testParcel);
        assertEquals(price, 112.99f, 0f);

        RateCalculator.setCheckType(testParcel, "priority");
        testParcel.setTranslatedPostalCode(RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode()));

        price = RateCalculator.rateTableLookup(testParcel);
        assertEquals(price, 192.92f, 0f);

        testParcel = new Parcel("N8R3U5", "H3A1B9", 15.29385f, 9.23593f, 0.193477f, 59.32f);
        RateCalculator.setCheckType(testParcel, "regular");
        testParcel.setTranslatedPostalCode(RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode()));

        price = RateCalculator.rateTableLookup(testParcel);
        assertEquals(price, 32.39f+(59.32f*0.25f), 0f);

        RateCalculator.setCheckType(testParcel, "xpress");
        testParcel.setTranslatedPostalCode(RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode()));

        price = RateCalculator.rateTableLookup(testParcel);
        assertEquals(price, 37.06f+(59.32f*0.31f), 0f);

        RateCalculator.setCheckType(testParcel, "priority");
        testParcel.setTranslatedPostalCode(RateCalculator.codeTranslationTableLookup(testParcel.getSourcePostalCode()));

        price = RateCalculator.rateTableLookup(testParcel);
        assertEquals(price, 56.49f+(59.32f*0.47f), 0f);
    }
}