public class PhoneNumberValidator {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;
        if (telNumber.matches("^\\+.*")) {
            if (telNumber.replaceAll("\\D+","").length() != 12) return false;
        }
        if (telNumber.matches("^\\d.*") || telNumber.matches("^\\(.*")) {
            if (telNumber.replaceAll("\\D+","").length() != 10) return false;
        }
        if (telNumber.matches(".*-.*")) {
            if (telNumber.replaceAll("[^-]","").length() > 2) return false;
            if (telNumber.matches(".*--.*")) return false;
        }
        if (telNumber.matches(".*\\(.*") || telNumber.matches(".*\\).*")) {
            if (telNumber.replaceAll("[^(]","").length() > 1 || telNumber.replaceAll("[^)]","").length() > 1) return false;
            if (!telNumber.matches(".*\\(.*\\).*")) return false;
            if (telNumber.matches(".*-.*\\(.*")) return false;
            if (!telNumber.matches(".*\\(\\d{3}\\).*")) return false;
        }
        if (telNumber.matches(".*[a-zA-Z].*") || telNumber.matches(".*[а-яА-Я].*")) return false;
        if (!telNumber.matches(".*\\d$")) return false;
        return true;

    }

    public static void main(String[] args) {

    }
}
