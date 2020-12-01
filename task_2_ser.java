import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class task_2_ser {
    public static void main(String[] args) {

        String filename = "toys.dat";

        ArrayList<Toy> toys = new ArrayList<Toy>();
        toys.add(new Toy("Robot", 20, 5));
        toys.add(new Toy("Lego", 35, 5));
        toys.add(new Toy("Barbie", 8, 3));
        toys.add(new Toy("Soldatik", 100, 5));
        toys.add(new Toy("HotWeels", 10, 3));
        toys.add(new Toy("Cube", 100, 3));
        toys.add(new Toy("Cube", 120, 2));
        toys.add(new Toy("Cube", 4, 3));
        toys.add(new Toy("Cube", 60, 8));



        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(toys);
            System.out.println("File has been written!");
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

        ArrayList<Toy> newToys = new ArrayList<Toy>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {

            newToys = ((ArrayList<Toy>) ois.readObject());
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

        for (Toy p : newToys)
            System.out.printf("Name of toy: %s \t minimal age: %s cost of toy: %s \n", p.getName(), p.getAge(), p.getCost());
        func_1(newToys);
        func_2(newToys);
        func_3(newToys);
        func_4(newToys);
        func_5(newToys);
        func_6(newToys);
    }

    public static void func_1(ArrayList<Toy> arr) {
        System.out.println("____Іграшки вартість яких не перевищує 40 грн і призначені дітям 5ти років____");
        for (Toy toy : arr) {
            if (toy.getAge() == 5 & toy.getCost() < 40) {
                System.out.printf("Name of toy: %s \t minimal age: %s cost of toy: %s \n", toy.getName(), toy.getAge(), toy.getCost());
            }
        }
        System.out.println("_____________________________________________________________");
    }

    public static void func_2(ArrayList<Toy> arr) {
        System.out.println("____Іграшки для дітей від 4 до 10 років____");

        for (Toy toy : arr) {
            if (toy.getAge() >= 4 && toy.getAge() <= 10) {
                System.out.printf("Name of toy: %s \t minimal age: %s cost of toy: %s \n", toy.getName(), toy.getAge(), toy.getCost());
            }
        }
        System.out.println("_____________________________________________________________");
    }

    public static void func_3(ArrayList<Toy> arr) {
        System.out.println("___Найдорожча іграшка___");

        Toy max = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            if (max.getCost() < arr.get(i).getCost()) {
                max = arr.get(i);
            }
        }
        System.out.printf("Name of toy: %s \t minimal age: %s cost of toy: %s \n", max.getName(), max.getAge(), max.getCost());
    }

    public static void func_4(ArrayList<Toy> arr) {
        System.out.println("___Найдорожчий конструктор___");

        ArrayList<Toy> lego_list = new ArrayList<Toy>();

        for (Toy toy: arr){
            if (toy.getName().equals("Lego")){
                lego_list.add(toy);
            }
        }

        Toy max = lego_list.get(0);

        for (Toy toy : lego_list) {
            if (max.getCost() < toy.getCost()) {
                max = toy;
            }
        }
        System.out.printf("Name of toy: %s \t minimal age: %s cost of toy: %s \n", max.getName(), max.getAge(), max.getCost());
    }
    public static void func_5(ArrayList<Toy> arr) {
        System.out.println("___Ціна всіх кубиків___");

        ArrayList<Toy> cube_list = new ArrayList<Toy>();

        for (Toy toy: arr){
            if (toy.getName().equals("Cube")){
                cube_list.add(toy);
            }
        }

        int sum = 0;

        for (Toy toy : cube_list) {
            sum += toy.getCost();
        }
        System.out.println("Ціна всіх кубиків : " + sum);
    }
    public static void func_6(ArrayList<Toy> arr) {
        System.out.println("Дві іграшки ,  що  призначені  дітям  трьох  років, сумарна вартість яких не перевищує 20 грн");

        ArrayList<Toy> list = new ArrayList<Toy>();

        for (Toy toy : arr){
            if (toy.getAge() == 3){
                list.add(toy);
            }
        }
        for (int i = 0; i < list.size(); i++){
            Toy temp = list.get(i);
            for (int j = i+1; j < list.size(); j++ ){
                if (temp.getCost() + list.get(j).getCost() < 20){
                    System.out.println("______________________________________________________");
                    System.out.println(temp.getName() + ' ' + temp.getAge() + " " + temp.getCost());
                    System.out.println(list.get(j).getName() + ' ' + list.get(j).getAge() + " " + list.get(j).getCost());
                }
            }
        }
        System.out.println("______________________________________________________");
    }

    public static void show(ArrayList<Toy> arr){
        for (Toy toy : arr){
            System.out.println(toy.getName() + " " + toy.getCost() + " " + toy.getAge());
        }
    }

}


class Toy implements Serializable {
        private final String name;
        private final int cost;
        private final int min_age;

        Toy(String name, int cost, int age) {
            this.name = name;
            this.cost = cost;
            this.min_age = age;
        }


        public String getName() {
            return name;
        }

        public int getCost() {
            return cost;
        }

        public int getAge() {
            return min_age;
        }
    }
