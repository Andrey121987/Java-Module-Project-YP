public class Format {

    public static String formatPrice(double price) {
        return String.format("%.2f", price); // делаем два знака после запятой
    }

    public static String rublesEnd(double value) {   // выводим склонение
        long intValue = (long) value;
        if (intValue % 10 == 1 && intValue % 100 != 11) {
            return "рубль";
        } else if (intValue % 10 >= 2 && intValue % 10 <= 4 && (intValue % 100 < 10 || intValue % 100 >= 20)) {
            return "рубля";
        } else {
            return "рублей";
        }
    }

}

