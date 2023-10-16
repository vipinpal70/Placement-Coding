package string;

public class ques2 {
    public static void move(String directions) {
        int x = 0, y = 0;
        for (int i = 0; i < directions.length(); i++) {
            if (directions.charAt(i) == 'E') {
                x++;
            }
            if (directions.charAt(i) == 'W') {
                x--;
            }
            if (directions.charAt(i) == 'N') {
                y++;
            }
            if (directions.charAt(i) == 'S') {
                y--;
            }
        }
        double result = Math.sqrt((x * x) + (y * y));
        System.out.println((float) result);
    }

    public static void main(String[] args) {
        String dt = "WNEENESENNN";
        // String dt = "NS";
        move(dt);
    }
}
