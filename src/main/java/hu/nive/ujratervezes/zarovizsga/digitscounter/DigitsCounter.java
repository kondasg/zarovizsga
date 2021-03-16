package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;
import java.util.Set;

public class DigitsCounter {

    public int getCountOfDigits(String s) {
        if (s == null) {
            return 0;
        }
        Set<Character> digits = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (c > '0' && c < '9') {
                digits.add(c);
            }
        }
        return digits.size();
    }
}
