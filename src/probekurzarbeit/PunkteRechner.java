package probekurzarbeit;

public class PunkteRechner {

    public static void pruefeCode(String code, int itemsize) throws PruefeException {
        if (code.length() != 6) {
            throw new PruefeException("Codelänge falsch: " + code);
        }

        for(char c : code.toCharArray()) {
            if(c < 'A' || c > 'Z') {
                throw new PruefeException("Ungültiges Zeichen: " + c);
            }
        }
        if (itemsize >= 5) {
            throw new PruefeException("Zu viele Tickets");
        }
    }
    
}
