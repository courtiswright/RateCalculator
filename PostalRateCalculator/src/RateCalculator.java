import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.IllegalFormatCodePointException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;


public class RateCalculator {
	
	public static void main(String[] args) {

        if (args.length != 7){
            throw new IllegalArgumentException("ERROR: 7 arguments must be specified in the following order. " +
                    "Source postal code, Destination postal code, length, width, height, weight, type");
        }
		String sourcePostalCode = args[0];
		String destPostalCode = args[1];
		float length = Float.parseFloat(args[2]);
		float width = Float.parseFloat(args[3]);
		float height = Float.parseFloat(args[4]);
		float weight = Float.parseFloat(args[5]);
		String type = args[6];
		
//		Parcel parcel = new Parcel(sourcePostalCode, destPostalCode,
//				length,width,height,weight);

        Parcel parcel = new Parcel (null, null, -1f, -1f, -1f, -1f);
        parcel = setCheckSourcePostalCode(parcel, sourcePostalCode);
        parcel = setCheckDestPostalCode(parcel, destPostalCode);
        try {
            parcel = setCheckLegnth(parcel, length);
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex);
			return;
        }

        try {
            parcel = setCheckWidth(parcel, width);
        }
        catch (IllegalArgumentException ex) {
            System.out.println(ex);
			return;
        }

        try {
            parcel = setCheckHeight(parcel, height);
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex);
			return;
        }

        try {
            parcel = setCheckWeight(parcel, weight);
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex);
			return;
        }

		parcel = setCheckType(parcel, type);

        parcel.setTranslatedPostalCode(codeTranslationTableLookup(parcel.getSourcePostalCode()));
        rateTableLookup(parcel);
	}

	public static Parcel setCheckSourcePostalCode(Parcel parcel, String sourcePostalCode)throws IllegalArgumentException{
		if(sourcePostalCode.length() != 6) {
			throw new IllegalArgumentException("ERROR: source postal code is not correct length");
		}
		
		if(!Character.isLetter(sourcePostalCode.charAt(0)) ||
				!Character.isDigit(sourcePostalCode.charAt(1)) ||
				!Character.isLetter(sourcePostalCode.charAt(2)) ||
				!Character.isDigit(sourcePostalCode.charAt(3)) ||
				!Character.isLetter(sourcePostalCode.charAt(4)) ||
				!Character.isDigit(sourcePostalCode.charAt(5))) {
			throw new IllegalArgumentException("ERROR: source postal code is not valid");
		} else {
			parcel.setSourcePostalCode(sourcePostalCode);
		}
		return parcel;
	}

    public static Parcel setCheckDestPostalCode(Parcel parcel, String destPostalCode)throws IllegalArgumentException{
    	if(destPostalCode.length() != 6) {
			throw new IllegalArgumentException("ERROR: destination postal code is not correct length");
		}
		
		if(!Character.isLetter(destPostalCode.charAt(0)) ||
				!Character.isDigit(destPostalCode.charAt(1)) ||
				!Character.isLetter(destPostalCode.charAt(2)) ||
				!Character.isDigit(destPostalCode.charAt(3)) ||
				!Character.isLetter(destPostalCode.charAt(4)) ||
				!Character.isDigit(destPostalCode.charAt(5))) {
			throw new IllegalArgumentException("ERROR: source postal code is not valid");
		} else {
			parcel.setDestPostalCode(destPostalCode);
		}
		return parcel;
    }

    public static Parcel setCheckLegnth(Parcel parcel, float length) throws IllegalArgumentException{
        if(length<10){
            throw new IllegalArgumentException("ERROR: length must be at least 10cm");
        } else if (length > 20){
            throw new IllegalArgumentException("ERROR: length must be at most 20cm");
        } else {
            parcel.setLength(length);
        }
        return parcel;
    }

    public static Parcel setCheckWidth(Parcel parcel, float width) throws IllegalArgumentException{
        if(width<7){
            throw new IllegalArgumentException("ERROR: width must be at least 7cm");
        } else if (width > 20){
            throw new IllegalArgumentException("ERROR: width must be at most 20cm");
        } else {
            parcel.setWidth(width);
        }
        return parcel;
    }

    public static Parcel setCheckHeight(Parcel parcel, float height) throws IllegalArgumentException{
        if(height<0.1){
            throw new IllegalArgumentException("ERROR: height must be at least 0.1cm");
        } else if (height > 20){
            throw new IllegalArgumentException("ERROR: height must be at most 20cm");
        } else {
            parcel.setHeight(height);
        }
        return parcel;
    }

    public static Parcel setCheckWeight(Parcel parcel, float weight)throws IllegalArgumentException{
        if(weight<=0){
            throw new IllegalArgumentException("ERROR: cannot have a weight less than 0kg");
        } else {
            parcel.setWeight(weight);
        }
        return parcel;
    }

	public static Parcel setCheckType(Parcel parcel, String type){

        if(type.equalsIgnoreCase("xpress")) {
            parcel.setType(Parcel.Type.XPRESS);
        }
        if(type.equalsIgnoreCase("regular")) {
            parcel.setType(Parcel.Type.REGULAR);
        }
        if(type.equalsIgnoreCase("priority")) {
            parcel.setType(Parcel.Type.PRIORITY);
        }

		return parcel;
	}


	public float calculateRate(Parcel parcel) {

		return 0f;
	}
	
	public static String codeTranslationTableLookup(String postalCode) {
		Reader in;
		String translatedPostalCode = "";
		try {
			in = new BufferedReader(new FileReader("Postal-Tables/Montreal Postal Codes to Rate Codes.csv"));
			Iterable<CSVRecord> records;
			try {
				records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
				for (CSVRecord record : records) {
					String subPostalCode = record.get("Originated");
					if (subPostalCode.equals(postalCode.substring(0,3))) {
						translatedPostalCode = record.get("Translation");
						return translatedPostalCode;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		return translatedPostalCode;
	}

	public static float rateTableLookup(Parcel parcel) {
		Reader in;
		String tableName = "";
		if (parcel.getType().toString() == "XPRESS") {
			tableName = "Xpresspost.csv";	
		}
		if (parcel.getType().toString() == "REGULAR") {
			tableName = "Regular.csv";	
		}
		if (parcel.getType().toString() == "PRIORITY") {
			tableName = "Priority.csv";	
		}
		try {
			in = new BufferedReader(new FileReader("Postal-Tables/" + tableName));
			Iterable<CSVRecord> records;
			try {
				records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
				float volume = 0f;
				float price = 0f;
				for (CSVRecord record : records) {
					if(!record.get("Volumetric Equivalent").equals("Over 30")) {
						volume = Float.parseFloat(record.get("Volumetric Equivalent"));
						price = Float.parseFloat(record.get(parcel.getTranslatedPostalCode()));
						if(parcel.getWeight() <= volume) {
							System.out.println("Weight " + volume + "kg: " + price + "$");
							return price;
						}
					} else {
						float extra = Float.parseFloat(record.get(parcel.getTranslatedPostalCode()))*parcel.getWeight();
						price = price + extra;
						System.out.println("Weight +" + volume + "kg: " + price + "$" + " includes overweight charges (" + extra + "$)");
						return price;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		return 0;
	}

}
