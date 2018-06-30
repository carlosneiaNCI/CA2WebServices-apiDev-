package com.mycompany.converter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
 
/**
 * @authors: Joseph McDonnell - X17164761  
 *           Marcin Krzeminski – X17158851 
 *           Kevin Shannon - X17160324 
 *           Carlos Neia – X12116394 
 *
 * 
 *  To access the roman to decimal please use (Replace XC with any other number):
 *      http://localhost:49000/api/Converter/toDecimal/XC
 * 
 *  The reverse conversion can can be accessed by the following url:
 *      http://localhost:49000/api/Converter/toRoman/10 
 */
@Path("/Converter")
public class RomanDecimal {

    private static final String[] NUMERALS = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private static final int[] NUMBERS = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    static int decimalNum;
    
    @GET
    @Path("/toRoman/{param}")
    public Response sayHelloWorldC(@PathParam("param") int number) {

        String roman = convertToRomanNumerals(number);

        return Response.status(200).entity(roman).build();
    }

    @GET
    @Path("/toDecimal/{param}")
    public Response sayHelloWorldD(@PathParam("param") String number) {

        int decimalNum = convertToDecimal(number);

        return Response.status(200).entity(decimalNum).build();
    }
    
    //converts the decimal numbers to roman
    private String convertToRomanNumerals(int number) {
        String roman = "";
        StringBuilder numeral = new StringBuilder();
        int i = 0;
        while (number > 0) {
            if (number - NUMBERS[i] >= 0) {
                numeral.append(NUMERALS[i]);
                number = number - NUMBERS[i];
            } else {
                i++;
            }
        }
        roman = numeral.toString();
        return roman;

    }
    //converts the roman to decimal
    private int convertToDecimal (String number) {
                
                
                String myNumber = number.toUpperCase();
                
                int l=  myNumber.length();
                int num=0;
                int previousnum = 0;
                for (int i=l-1;i>=0;i--)
                { 
                        char x =  myNumber.charAt(i);
                        x = Character.toUpperCase(x);
                        switch(x)
                        {  
                                case 'I':
                                previousnum = num;
                                num = 1;
                                break;
                             case 'V':
                                     previousnum = num;
                                num = 5;
                                break;
                                case 'X':
                                        previousnum = num;
                                num = 10;
                                break;
                                case 'L':
                                        previousnum = num;
                                num = 50;
                                break;
                                case 'C':
                                        previousnum = num;
                                num = 100;
                                break;
                                case 'D':
                                        previousnum = num;
                                num = 500;
                                break;
                                case 'M':
                                        previousnum = num;
                                num = 1000;
                                break;
                        }           
                        if (num<previousnum)
                        {decimalNum= decimalNum-num;}
                         else
                        decimalNum= decimalNum+num;
                }
        return decimalNum;
        }

    
    

}
