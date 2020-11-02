import java.util.Scanner;

public class task_5_10 {
    public static void main(String args[]) {
        Jeep obj1= new Jeep("BMW1");
        obj1.setSpeed(14);
        obj1.setPrice(15000);
        obj1.setMileage(100);

        Hatchback obj2 = new Hatchback("T-34");
        obj2.setSpeed(20);
        obj2.setPrice(2000);
        obj2.setMileage(140);

        Bus obj3 = new Bus("Audi");
        obj1.setSpeed(15);
        obj1.setPrice(1000);
        obj1.setMileage(200);

        Park park = new Park();
        park.addCar(obj1);
        park.addCar(obj2);
        park.addCar(obj3);
        park.showCars();
        park.sortByMileage();
        park.showCars();
        System.out.println(park.getPirce());
        System.out.println(park.getBySpeed(10,15));
    }
}

abstract class Car{
    protected String name;

    protected void setName(String name){
        this.name = name;
    }

    public String getName(){ return name; }

    private float price;

    protected void setPrice(float price){
        this.price = price;
    }

    public float getPrice(){ return price; }

    private float mileage;

    protected void setMileage(float mileage) {this.mileage = mileage; }

    public float getMileage() { return mileage; }

    private float speed;

    protected void setSpeed(float speed) { this.speed = speed; }

    public float getSpeed(){ return speed; }

}

class Jeep extends Car{

    String name;
    float speed;

    void set_name(String name){ this.name = name; }
    String get_name(String name){ return name; }

    void setSpeed(int speed){ this.speed = speed; }
    int getSpeed(int speed){ return speed; }

    Jeep(String name){
        super();
        this.name = name;
    }

}
class Hatchback extends Car{

    String name;
    float speed;

    void set_name(String name){ this.name = name; }
    String get_name(String name){ return name; }

    void setSpeed(int speed){ this.speed = speed; }
    int getSpeed(int speed){ return speed; }

    Hatchback(String name){
        super();
        this.name = name;
    }

}

class Bus extends Car{

    String name;
    float speed;

    void set_name(String name){ this.name = name; }
    String get_name(String name){ return name; }

    void setSpeed(int speed){ this.speed = speed; }
    int getSpeed(int speed){ return speed; }

    Bus(String name) {
        super();
        this.name = name;
    }


}

class Park {
    int size;
    Car[] park;
    protected String name;

    void addCar(Car x) {
        park[size++] = x;
    }

    void showCars() {
        for (Car it : park) {
            System.out.println(it.getName() + it.getPrice());
        }
    }

    boolean removeCar(Car x) {
        int k = 0;
        for (Car it : park) {
            if (it.equals(x)) {
                for (int i = k; i < park.length; i++) {
                    park[k] = park[k + 1];
                }
            }
            k++;
        }
        return false;
    }

    float getPirce() {
        float sum = 0;
        for (Car it : park) {
            sum += it.getSpeed();
        }
        return sum;
    }

    Car getBySpeed(float a, float b){
        for(Car it: park){
            if(it instanceof Jeep){
                Jeep z = (Jeep) it;
                if(z.getPrice() >= a && z.getPrice() <= b){
                    return z;
                }
            }
            else if (it instanceof Hatchback){
                Hatchback z = (Hatchback) it;
                if(z.getPrice() >= a && z.getPrice() <= b){
                    return z;
                }
            }
            else if (it instanceof Bus){
                Bus z = (Bus) it;
                if(z.getPrice() >= a && z.getPrice() <= b){
                    return z;
                }
            }
        }
        return new Jeep("Null");
    }

        void sortByMileage(){
            for (int i = 0; i < park.length; i++) {
                Car cur = park[i];
                Car next = park[i + 1];
                if (cur.getMileage() > next.getMileage()) {
                    Car temp = cur;
                    cur = next;
                    next = temp;
                } else {
                    continue;
                }
            }
        }
    }
