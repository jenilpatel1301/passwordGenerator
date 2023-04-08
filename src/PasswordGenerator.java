import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {
    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String OTHER_CHAR = "!@#$%&*()_+-=[]?";

    private static final String PASSWORD_ALLOW_BASE = CHAR_LOWER + CHAR_UPPER + NUMBER + OTHER_CHAR;
    private static Random rnd;

    static {
        rnd = new SecureRandom();
    }

    public static void main(String[] args) {
        int passwordLength = 12;
        String password = generatePassword(passwordLength);
        System.out.println("Generated password: " + password);
    }

    public static String generatePassword(int length) {
        if (length < 6) throw new IllegalArgumentException("password length must be at least 6");

        // split base password string into char array
        char[] password = new char[length];
        int index = 0;
        password[index++] = getRandomChar(CHAR_LOWER);
        password[index++] = getRandomChar(CHAR_UPPER);
        password[index++] = getRandomChar(NUMBER);
        password[index++] = getRandomChar(OTHER_CHAR);

        // fill remaining length of the password using base password string
        for (; index < length; ++index) {
            password[index] = getRandomChar(PASSWORD_ALLOW_BASE);
        }

        // shuffle password characters
        List<Character> charList = Arrays.asList(new Character[length]);
        for (int i = 0; i < length; ++i) {
            charList.set(i, password[i]);
        }
        Collections.shuffle(charList, rnd);
        StringBuilder sb = new StringBuilder(length);
        for (Character c : charList) {
            sb.append(c.charValue());
        }
        return sb.toString();
    }

    private static char getRandomChar(String input) {
        int randomIndex = rnd.nextInt(input.length());
        return input.charAt(randomIndex);
    }
}
