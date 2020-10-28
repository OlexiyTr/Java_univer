import java.util.Scanner;
public class task_5_10 {

    public static void main(String args[]){

        Car[] cars = new Car[5];
        cars[0] = new Jeep(1000,"Tesla",10,15);
        cars[1] = new Jeep(2000,"BMW",20,100);
        cars[2] = new Sedan(3500,"Tesla",11,60);
        cars[3] = new Hatchback(4000,"Audi",15,20);
        cars[4] = new Jeep(1000,"Ford",19,90);

        Print(cars);

        System.out.println(PriceofCars(cars));
        cars = mileageSort(cars);
        Print(cars);
        rangeSpeed(cars);

    }

    public static int PriceofCars(Car[] arr)
    {
        int PriceOfCars = 0;

        for (int i = 0; i < arr.length; i++) {
            PriceOfCars += arr[i].priceofAuto;
        }
        return PriceOfCars;
    }
    public static Car[] mileageSort(Car[] arr){
        for (int i = arr.length - 1; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (arr[j].mileage > arr[j + 1].mileage)
                {
                    Car tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.println("Sorted!");
        return arr;
    }

    public static void Print(Car[] arr){
        System.out.println("brand" + " " + "mileage" + " " + "speed" + " " + "priceofAuto");
        for (int i = 0; i < arr.length; i++) {
            arr[i].ShowCars();
        }
    }

    public static void rangeSpeed(Car[] arr){
        Scanner inputer = new Scanner(System.in);
        System.out.println("Диапозон: ");
        int valFirst = inputer.nextInt();
        int valSecond = inputer.nextInt();
        for (int i = 0; i < 5;i++){
            if (arr[i].speed >= valFirst && arr[i].speed <= valSecond){
                arr[i].ShowCars();
            }
            else{
                continue;
            }
        }

    }
}

abstract class Car {
    int priceofAuto;
    String brand;
    int mileage;
    int speed;

    Car(int priceofAuto, String brand, int mileage, int speed) {
        this.priceofAuto = priceofAuto;
        this.brand = brand;
        this.mileage = mileage;
        this.speed = speed;
    }

    void ShowCars() {
        System.out.println(brand + " " + mileage + " " + speed + " " + priceofAuto);
    }
}

class Jeep extends Car{
    Jeep(int priceofAuto, String brand, int mileage, int speed){
        super(priceofAuto,brand,mileage,speed);
    }
}
class Sedan extends Car{
    Sedan(int priceofAuto, String brand, int mileage, int speed){
        super(priceofAuto, brand,mileage,speed);
    }
}
class Hatchback extends Car{
    Hatchback(int priceofAuto, String brand, int mileage, int speed){
        super(priceofAuto,brand,mileage,speed);
    }
}
