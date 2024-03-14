import java.util.LinkedHashMap;
import java.util.Map;

public class Calculator {

    protected Map<String, Double> product;// на случай класса наследника

    public Calculator() {
        this.product = new LinkedHashMap<>(32,0.9f);
    }// linked-пусть идут в порядке заполнения, capasity - врядли кто-то будет вбивать больше 32 блюд:), loadFactor - просто попробовать.

    public void addProduct(String name, double price) {
        product.put(name, price); // реализуем добавление
    }

    public Map<String, Double> getProduct() {
        return product;// реализуем извлечение
    }


    public double calculateTotalCost() {
        return product.values().stream().mapToDouble(Double::doubleValue).sum(); //расчет суммы всех товаров через поток значений приведенных в дабл
    }

    public double calculateCostPerPerson(int numberOfPeople) {
        return calculateTotalCost() / numberOfPeople;// расчет стоимости на человека
    }
}

