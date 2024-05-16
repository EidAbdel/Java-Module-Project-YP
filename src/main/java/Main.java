import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalculateDishes calc = new CalculateDishes();
        Scanner sc = new Scanner(System.in);
//        System.out.println("Hello world!");
        int countPeople;
        System.out.println("Введите число участников, на которых будет разделен счет:");

        while (true) {
            if (sc.hasNextInt()) {
                countPeople = sc.nextInt();
                if (countPeople <= 1) {
                    System.out.println("Количество людй не может быть менее 2\n" +
                            "Пожалуйста повторите ввод снова");
                } else {
                    break;
                }
            } else {
                System.out.println("Вам необходмо ввести целое число\n" +
                        "Пожалуста повторите ввод снова");
                sc.next();
            }
        }

        calc.setCountPeople(countPeople);

        System.out.println("Далее Вам необходимо ввести наименование блюда" +
                "и его стоимость в формате рубли.копейки");
        String query = "";
        while (true) {
            if (query.trim().replace("'", "").equalsIgnoreCase("завершить")) {
                System.out.println(calc.toString());
                printFormatRub.outFormattedRub(calc.getAmout() / calc.getCountPeople());
                break;
            } else {
                try {
                    System.out.println("Ведите наименование блюда:");
                    String dishName = new Scanner(System.in).nextLine().trim();
                    System.out.println("Введите стоимость блюда:");
                    double price = Double.parseDouble(new Scanner(System.in).next().trim());
                    if (price <= 0 || dishName.isEmpty()) {
                        System.out.println("Некорректное значение, товар не был добавлен!");
                        System.out.println("Повторите попытку ввода данных");
                    } else {
                        calc.addDish(new Dish(dishName, price));
                        System.out.println("Товар успешно добавлен!");
                        System.out.println("Текущая сумма =" + calc.getAmout());
                        System.out.println("Если вы закончить ввод блюд введите команду команду " +
                                "`завершить'\n" +
                                "В противном случае введите клавишу Enter");
                        query = new Scanner(System.in).nextLine();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Некорректное цена, блюдо не был добавлен!");
                    System.out.println("Повторите попытку ввода данных");
                }
            }
        }


    }
}
