public class DataType {
    public static void main(String[] args) {


            int a = 100;
            int b = 99;
            double c = 10.1;
            double d = 10.1;
            byte e = 126;
            byte f = 100;
            boolean g = true;
            boolean h = false;

            System.out.println("Сложение: " + (a + b));
            System.out.println("Вычитание: " + (a - c));
            System.out.println("Деление" + ":" + " " + (a / b));
            System.out.println("Умножение: " + (a * b));
            System.out.println("Сравнение: " + (a > b));
            System.out.println("Остаток от деления: " + (a % b));

            Long maxLong = Long.MAX_VALUE;
            Long sum = maxLong + 15;
            short aShort = 32_767;
            short bShort = 1;
            short sumShort = (short) (aShort + bShort);

            System.out.println("Переполнение MAX_VALUE: " + sum);
            System.out.println("Переполнение Short: " + sumShort);

            if (a > b) {
                System.out.println("False");
            } else {
                System.out.println("True");
            }
        }
    }

