package geco;

import java.lang.StringBuffer;
import java.util.Random;

public class PasswordGeneration {

    public static String getRandomPassword() {
        StringBuffer pwd = new StringBuffer();
        for (int i = 0; i < 8; i++){
            pwd.append(String.valueOf(getAsciiAlea()));
        }
        return pwd.toString();
    }

    private static int getAsciiAlea(){
        Random r = new Random();
        return r.nextInt(128); // returns an integer between 0 and 127
    }
}
