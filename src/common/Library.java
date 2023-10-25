/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.Locale;

/**
 *
 * @author DELL
 */
public class Library {
    private static final char[] chars = {'1', 'A', 'a', 'B', 'b', 'C',
        'c', '2', 'D', 'd', 'E', 'e', 'F', 'f', '3', 'G', 'g', 'H', 'h',
        'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', '4', 'M', 'm', 'N', 'n',
        'O', 'o', '5', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't',
        '6', '7', 'U', 'u', 'V', 'v', 'U', 'u', 'W', 'w', '8', 'X', 'x',
        'Y', 'y', 'Z', 'z', '9'};
    
    
    public void login(Locale language) {
        Validate.getLocalizedString(language, "enterAccountNumber");
        int accountNumber = Validate.checkValidAccountNumber(language);
        Validate.getLocalizedString(language, "enterPassword");
        String passString = Validate.checkValidPassword(language);
        String captchaGenerated = generateCaptcha();
        while (true) {
            if (Validate.checkValidCaptcha(captchaGenerated, language)) {
                Validate.getLocalizedString(language, "loginSuccess");
                System.out.print("\n");
                return;
            } else {
                Validate.getLocalizedString(language, "errCaptchaIncorrect");
                System.out.print("\n");
            }
        }
    }

    public String generateCaptcha() {
        String randomStrValue = "";
        final int LENGTH = 6;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < LENGTH; i++) {
            index = (int) (Math.random() * (chars.length - 1));
            sb.append(chars[index]);
        }
        return sb.toString();
    }
    
    
    
    
    
}
