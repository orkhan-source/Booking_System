package org.App.Utils;

public class PasswordUtil {

    public static boolean validatePassword(String password) {
        String specialCharacters = " !#$%&'()*+,-./:;<=>?@[]^_`{|}~0123456789";
        String strPassword[] = password.split("");

        for (int i = 0; i < strPassword.length; i++)
            if (specialCharacters.contains(strPassword[i]))
                return true;

        return false;
    }
}
