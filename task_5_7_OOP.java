import java.util.Scanner;

public class task_5_7_OOP {
    public static void main(String args[]) {
        Helmet obj1= new Helmet("Redbull",4);
        Helmet obj2= new Helmet("Nike",6);
        Vest obj3= new Vest("Puma",1);
        Vest obj4= new Vest("Cropp",0);
        Gloves obj5= new Gloves("OVER",10);
        Armor armor = new Armor();
        armor.addElement(obj1);
        armor.addElement(obj2);
        armor.addElement(obj3);
        armor.addElement(obj4);
        armor.addElement(obj5);
        armor.showItems();
        armor.sortByWeight();
        armor.showItems();
        float p = armor.getPrice();
        Item z = armor.getByPrice(10,20);
        System.out.println(z);

    }
}

class Item{
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

    private float weight;

    protected void setWeight(float weight) {this.weight = weight; }

    public float getWeight() { return weight; }

}

class Helmet extends Item{

    String name;
    int strength;

    void set_name(String name){ this.name = name; }
    String get_name(String name){ return name; }

    void setStrength(int strength){ this.strength = strength; }
    int getStrength(int strength){ return strength; }

    Helmet(String name, int strength){
        super();
        this.name = name;
        this.strength = strength;
    }

}

class Gloves extends Item{

    String name;
    int strength;

    void set_name(String name){ this.name = name; }
    String get_name(String name){ return name; }

    void setStrength(int strength){ this.strength = strength; }
    int getStrength(int strength){ return strength; }

    Gloves(String name, int strength){
        super();
        this.name = name;
        this.strength = strength;
    }

}

class Vest extends Item{

    String name;
    int strength;

    void set_name(String name){ this.name = name; }
    String get_name(String name){ return name; }

    void setStrength(int strength){ this.strength = strength; }
    int getStrength(int strength){ return strength; }

    Vest(String name, int strength){
        super();
        this.name = name;
        this.strength = strength;
    }

}

class Armor{
    int size;
    Item[] outfit;
    protected String name;

    void addElement(Item x){
        outfit[size++] = x;
    }
    void showItems(){
        for (Item it: outfit){
            System.out.println(it.getName() + it.getPrice());
        }
    }
    boolean removeElement(Item x){
        int k = 0;
        for(Item it : outfit){
            if(it.equals(x)){
                for(int i=k; i < outfit.length;i++){
                    outfit[k] = outfit[k+1];
                }
            }
            k++;
        }
        return false;
    }
    float getPrice(){
        float sum = 0;
        for (Item it: outfit){
            sum += it.getPrice();
        }
        return sum;
    }

    Item getByPrice(float a, float b){
        for(Item it: outfit){
            if(it instanceof Helmet){
                Helmet z = (Helmet) it;
                if(z.getPrice() >= a && z.getPrice() <= b){
                    return z;
                }
            }
            else if(it instanceof Gloves){
                Gloves z = (Gloves) it;
                if(z.getPrice() >= a && z.getPrice() <= b){
                    return z;
                }
            }
            else if(it instanceof Vest){
                Vest z = (Vest) it;
                if(z.getPrice() >= a && z.getPrice() <= b){
                    return z;
                }
            }
        }
        return new Helmet("!",0);
    }

    void sortByWeight() {
        for (int i = 0; i < outfit.length; i++) {
            Item cur = outfit[i];
            Item next = outfit[i + 1];
            if (cur.getWeight() > next.getWeight()) {
                Item temp = cur;
                cur = next;
                next = temp;
            }
            else{
                continue;
            }
        }
    }
}