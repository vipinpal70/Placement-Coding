package string;

public class ques4 {

    public static String upperCase(String str) {

        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                sb.append(Character.toUpperCase(str.charAt(i + 1)));
                i++;
            } else {
                sb.append(str.charAt(i));
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "hi i am vipin";
        // String[] nn = s.split(" ");
        // StringBuilder fn = new StringBuilder("");
        // for (int i = 0; i < nn.length; i++) {
        // Character ch = nn[i].charAt(0);
        // String result = ch.toString().toUpperCase() + nn[i].substring(1) + " ";
        // fn.append(result);
        // }
        // System.out.println(fn);
        System.out.println(upperCase(str));

    }
}
