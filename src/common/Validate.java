/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Validate {
    
    private static final String ACCOUNT_NUMBER_VALID = "^\\d{10}$";
    
    public static void getLocalizedString(Locale currentLocate, String key ) {
       ResourceBundle words = ResourceBundle.getBundle("language", currentLocate);
        String value = words.getString(key);
        System.out.format(value);
    }

    public static String checkInputString(Locale language) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String input = sc.nextLine();
            if(input.length() == 0) {
                getLocalizedString(language ,"errorCheckInputString");
            } else {
                return input;
            }
        }
    }

    
    public static int checkValidAccountNumber (Locale language) {
        Scanner sc = new Scanner(System.in);
         while (true) {
            String result = sc.nextLine();
            if (result.matches(ACCOUNT_NUMBER_VALID)) {
                return Integer.parseInt(result);
            }
            getLocalizedString(language, "errCheckInputAccount");
            System.out.println();
        }
    }
    
    
    public static boolean isValidPassword (String password, Locale language) {
        int lengthPassword = password.length();
        if (lengthPassword < 8 || lengthPassword > 31) {
            getLocalizedString(language, "errCheckLengthPassword");
            System.out.print("\n");
            return false;
        } else {
            int countDigit = 0;
            int countLetter = 0;
            for (int i = 0; i < lengthPassword - 1; i++) {
                if (Character.isDigit(password.charAt(i))) {
                    countDigit++;
                } else if (Character.isLetter(password.charAt(i))) {
                    countLetter++;
                }
            }
            if (countDigit < 1 || countLetter < 1) {
                getLocalizedString(language, "errCheckAlphanumericPassword");
                System.out.print("\n");
                return false;
            }
        }
        return true;
    }
    public static String checkValidPassword(Locale language) {
        String result;
        while (true) {
            result = checkInputString(language);
            if (isValidPassword(result, language)) {
                return result;
            }
        }
    }
    
    
    
    
    public static boolean checkValidCaptcha(String captchaGenerated, Locale language) {
        System.out.println(captchaGenerated);
        getLocalizedString(language, "enterCaptcha");
        String captchaInput = checkInputString(language);
        for (int i = 0; i < captchaInput.length(); i++) {
            if (!captchaGenerated.contains(Character.toString(captchaInput.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    
}
