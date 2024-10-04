import java.util.Scanner;

public class AltTest {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] data;
        char act;


        if (input.length() > 10) {
            throw new Exception("Входная строка не должна превышать 10 символов");
        }


        if (input.contains("+")) {
            data = input.split("\\+");
            act = '+';
        } else if (input.contains("-")) {
            data = input.split("-");
            act = '-';
        } else if (input.contains("*")) {
            data = input.split("\\*");
            act = '*';
        } else if (input.contains("/")) {
            data = input.split("/");
            act = '/';
        } else {
            throw new Exception("Некорректное действие");
        }

        if (data.length < 2 || data[1].contains("\"")) {
            throw new Exception("Делить и умножать можно только на число");
        }

        int secondValue = Integer.parseInt(data[1]);
        if (secondValue > 10) {
            throw new Exception("Число не должно превышать 10");
        }

        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }


        String result = "";
        if (act == '+') {
            result = data[0] + data[1];
        } else if (act == '*') {
            result = data[0].repeat(secondValue);
        } else if (act == '-') {
            int index = data[0].indexOf(data[1]);
            if (index == -1) {
                result = data[0];
            } else {
                result = data[0].substring(0, index) + data[0].substring(index + data[1].length());
            }
        } else if (act == '/') {
            int secondIndex = data[0].length() / secondValue;
            result = data[0].substring(0, secondIndex);
        }


        quot(result);
    }

    static void quot(String str) throws Exception {
        if (str.length() > 40) {
            throw new Exception("Результирующая строка не должна превышать 40 символов");
        } else {
            System.out.println("\"" + str + "\"");
        }
    }
}
