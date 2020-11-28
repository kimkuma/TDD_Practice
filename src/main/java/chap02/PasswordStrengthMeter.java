package chap02;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String s) {
        if(s == null || s.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        int meetCounts = getMeetCounts(s);
        if(meetCounts <= 1) return PasswordStrength.WEAK;
        if(meetCounts == 2) return PasswordStrength.NORMAL;

        return PasswordStrength.STRONG;
    }

    private int getMeetCounts(String s) {
        int meetCounts = 0;

        if(s.length() >=8) meetCounts++;
        if(meetsContainingNumberCriteria(s)) meetCounts++;
        if(isContainsUppercase(s)) meetCounts++;

        return meetCounts;
    }

    /**
     * 숫자포함여부
     * @param s
     * @return
     */
    private boolean meetsContainingNumberCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }

    /**
     * 대문자포함여부
     * @param s
     * @return
     */
    private boolean isContainsUppercase(String s) {
        for(char ch : s.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }
}
