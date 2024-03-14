import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator calcul = new Calculator();

        int numberOfPeople = 0;
        boolean isValidNumberOfPeople = false;

        while (!isValidNumberOfPeople) {
            try {
                System.out.println("На скольких человек необходимо разделить счёт?");
                numberOfPeople = Integer.parseInt(scanner.nextLine());// условие исключения введение данных не "инт"

                if (numberOfPeople > 1) {
                    isValidNumberOfPeople = true; // выход из цикла
                } else if (numberOfPeople == 1) {
                    System.out.println("В таком случае весь счет оплачивать Вам");
                } else {
                    System.out.println("Введите число больше 1.");
                }
            } catch (NumberFormatException e) { // исключение при использовнии не "инт"
                System.out.println("Ошибка ввода. Введите корректное количество людей.");
            }
        }

        String productName;

        while (true) {
            System.out.println("Добавьте название товара. (или введите 'завершить' для расчета.)");
            productName = scanner.nextLine();

            if (productName.equalsIgnoreCase("завершить")) {
                break; // выход из цикла
            }

            double productPrice = 0;
            boolean isValidPrice = false;

            while (!isValidPrice) {
                try {
                    System.out.println("Укажите стоимость товара:");
                    productPrice = Double.parseDouble(scanner.nextLine());// условие исключения введение данных не "дабл"

                    if (productPrice > 0) {
                        isValidPrice = true;// выход из цикла
                    } else if (productPrice == 0) {
                        System.out.println("Жаль, но бесплатных товаров не бывает");
                    } else {
                        System.out.println("Стоимость не может быть отрицательной!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода. Введите корректную стоимость товара.");
                }// исключение при использовнии не "дабл"
            }

            calcul.addProduct(productName, productPrice); // добавляем в хешмап товар с ценой (ключ/значение)
        }

        System.out.println("Добавленные товары:");

        for (Map.Entry<String, Double> table : calcul.getProduct().entrySet()) {  // через цикл выводим все пары (ключ значение) за счет линкед в порядке добавления.
            String formatedPrice = Format.formatPrice(table.getValue());// получаем значение цены с копейками (при целочисленном добавляем (.00))
            System.out.println(table.getKey() + ": " + formatedPrice + " " + Format.rublesEnd(table.getValue()));//выводим ключ (товар) + цену с копейками + верное склонение рублей
        }

        String formatedTotalCost = Format.formatPrice(calcul.calculateTotalCost());// получаем значение суммы с копейками
        System.out.println("Общая стоимость: " + formatedTotalCost + " " + Format.rublesEnd(calcul.calculateTotalCost()));//выводим сумму с копейками + верное склонение рублей

        String formatedCostPerPerson = Format.formatPrice(calcul.calculateCostPerPerson(numberOfPeople));// считаем на количество человек
        System.out.println("Каждый человек должен заплатить: " + formatedCostPerPerson + " " + Format.rublesEnd(calcul.calculateCostPerPerson(numberOfPeople)));//выводим сумму с копейками + верное склонение рублей
    }
}
