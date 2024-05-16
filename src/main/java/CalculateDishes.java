import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class CalculateDishes {
    private int countPeople;
    private ArrayList<Dish> dishesArr = new ArrayList<>();

    public ArrayList<Dish> getDishesArr() {
        return dishesArr;
    }

    public int getCountPeople() {
        return this.countPeople;
    }

    public void setCountPeople(int countPeople) {
        this.countPeople = countPeople;
    }

    public void addDish(Dish dish) {
        this.dishesArr.add(dish);
    }

    public float getAmout(){
        float amount =0.00f;
        for (Dish dish: dishesArr){
            amount += (float) dish.getPrice();
        }
        return amount;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CalculateDishes that)) return false;
        return getCountPeople() == that.getCountPeople() && Objects.equals(getDishesArr(), that.getDishesArr());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountPeople(), getDishesArr());
    }

    @Override
    public String toString() {
        String messenger =  "Добавленные товары:\n";
        for (Dish dish : this.dishesArr){
            messenger = messenger + dish.getName() +'\n';
        }
        return messenger;
    }
}
