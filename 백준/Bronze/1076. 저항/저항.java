import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();
        x = num(x);
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        String y = st1.nextToken();
        y = num(y);

        int sireal_num = Integer.parseInt(x+y);
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        String z = st2.nextToken();
        z = ohm(z);
        long res = Long.parseLong(z);
        System.out.println(sireal_num*res);





    }

    private static String num(String alphabet) {
        switch (alphabet) {
            case "black":
                alphabet = "0";
                return alphabet;
            case "brown":
                alphabet = "1";
                return alphabet;
            case "red":
                alphabet = "2";
                return alphabet;
            case "orange":
                alphabet = "3";
                return alphabet;
            case "yellow":
                alphabet = "4";
                return alphabet;
            case "green":
                alphabet = "5";
                return alphabet;
            case "blue":
                alphabet = "6";
                return alphabet;
            case "violet":
                alphabet = "7";
                return alphabet;
            case "grey":
                alphabet = "8";
                return alphabet;
            case "white":
                alphabet = "9";
                return alphabet;

        }
        return alphabet;
    }

    private static String ohm(String alphabet) {
        switch (alphabet) {
            case "black":
                alphabet = "1";
                return alphabet;
            case "brown":
                alphabet = "10";
                return alphabet;
            case "red":
                alphabet = "100";
                return alphabet;
            case "orange":
                alphabet = "1000";
                return alphabet;
            case "yellow":
                alphabet = "10000";
                return alphabet;
            case "green":
                alphabet = "100000";
                return alphabet;
            case "blue":
                alphabet = "1000000";
                return alphabet;
            case "violet":
                alphabet = "10000000";
                return alphabet;
            case "grey":
                alphabet = "100000000";
                return alphabet;
            case "white":
                alphabet = "1000000000";
                return alphabet;
        }
        return alphabet;
    }
}