import java.util.Scanner;

public class AltTest {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] data;
        char act;


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

        if (data.length != 2 || !data[0].startsWith("\"") || !data[0].endsWith("\"") || data[1].contains("\"")) {
            throw new Exception("Некорректный ввод");
        }

        String firstValue = data[0].substring(1, data[0].length() - 1);
        if (firstValue.length() > 10) {
            throw new Exception("Входная строка не должна превышать 10 символов");
        }
        int secondValue;

        try {
            secondValue = Integer.parseInt(data[1].trim());
        } catch (NumberFormatException e) {
            throw new Exception("Второе значение должно быть целым числом");
        }

        if (secondValue < 1 || secondValue > 10) {
            throw new Exception("Число должно быть от 1 до 10 включительно");
        }

        String result = "";
        switch (act) {
            case '+':
                result = firstValue + data[1].trim();
                break;
            case '*':
                result = firstValue.repeat(secondValue);
                break;
            case '-':
                result = firstValue.replace(data[1].trim(), "");
                break;
            case '/':
                int length = firstValue.length() / secondValue;
                result = firstValue.substring(0, length);
                break;
            default:
                throw new Exception("Некорректное действие");
        }

        quot(result);
    }

    static void quot(String str) throws Exception {
        if (str.length() > 40) {
            str = str.substring(0, 40) + "...";
        }
        System.out.println("\"" + str + "\"");
    }
}
