import java.util.Scanner;

public class task_5_7_OOP {
    public static void main(String args[]){

        Armor[] Biker = new Armor[3];
        Biker[0] = new Helmet("RedBull",1000,3);
        Biker[1] = new Vest("PUMA",1500,3);
        Biker[2] = new Gloves("Nike",1200,1);

        Print(Biker);

        System.out.println(PriceofArmor(Biker));
        Biker = weightSort(Biker);
        Print(Biker);
        rangePrice(Biker);
    }
    public static int PriceofArmor(Armor[] arr)
    {
        int Price = 0;

        for (int i = 0; i < arr.length; i++) {
            Price += arr[i].price;
        }
        return Price;
    }
    public static Armor[] weightSort(Armor[] arr){
        for (int i = arr.length - 1; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (arr[j].weight > arr[j + 1].weight)
                {
                    Armor tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.println("Sorted!");
        return arr;
    }

    public static void Print(Armor[] arr){
        System.out.println("Brand" + " Price " + " Weight");
        for (int i = 0; i < arr.length; i++) {
            arr[i].ShowArmor();
        }
    }

    public static void rangePrice(Armor[] arr){
        Scanner inputer = new Scanner(System.in);
        System.out.println("Диапозон: ");
        int valFirst = inputer.nextInt();
        int valSecond = inputer.nextInt();
        for (int i = 0; i < 5;i++){
            if (arr[i].price >= valFirst && arr[i].price <= valSecond){
                arr[i].ShowArmor();
            }
            else{
                continue;
            }
        }

    }
}
class Armor{
    String brand;
    int price;
    int weight;
    Armor(String brand, int price,int weight){
        this.brand = brand;
        this.price = price;
        this.weight = weight;
    }
    void ShowArmor() {
        System.out.println(brand + " " + price + " " + weight);
    }
}
class Helmet extends Armor{
    Helmet(String brand, int price, int weight){
        super(brand,price,weight);
    }
}
class Vest extends Armor{
    Vest(String brand, int price, int weight){
        super(brand,price,weight);
    }
}
class Gloves extends Armor{
    Gloves(String brand, int price, int weight){
        super(brand,price,weight);
    }
}