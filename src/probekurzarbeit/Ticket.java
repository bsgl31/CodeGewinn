package probekurzarbeit;

public class Ticket {

    private String code;

    public Ticket(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public int getPoints() {
        int points = 0;
        char[] chars = code.toCharArray();
        for(char c : chars) {
            switch (c) {
                case 'A':
                    points++;
                    break;
                case 'B':
                    points+=2;
                    break;
                case 'C':
                    points+=4;
                    break;
            }
        }
        return points;
    }

    @Override
    public String toString() {
        return code;
    }
    
}
