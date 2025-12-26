public class DateUtil {
    public static boolean isValidDate(String s) {
        if (s == null || s.length() != 10) return false;
        if (s.charAt(4) != '-' || s.charAt(7) != '-') return false;

        for (int i = 0; i < s.length(); i++) {
            if (i == 4 || i == 7) continue;
            char c = s.charAt(i);
            if (c < '0' || c > '9') return false;
        }

        int y = Integer.parseInt(s.substring(0, 4));
        int m = Integer.parseInt(s.substring(5, 7));
        int d = Integer.parseInt(s.substring(8, 10));

        if (m < 1 || m > 12) return false;
        if (d < 1 || d > 31) return false;

        return true;
    }
}