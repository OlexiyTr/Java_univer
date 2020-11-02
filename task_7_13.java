public class task_7_13 {
    public static void main(String args[]){
        Tram obj = new Tram("A1",10,20);

    }
}

interface Transport{
    void run(double speed, double length);
}
abstract class CityTransport implements Transport{
    double speed;
    double length;

    CityTransport(){
        this.speed = 20.0;
        this.length = 10.0;
    }
    @Override
    public void run(double speed, double length){
        this.speed += speed;
        this.length += length;
    }
}

class Tram extends CityTransport implements Transport{
    String name;
    Tram(String name,double speed, double length){
        this.name = name;
        this.speed = speed;
        this.length = length;
    }
    public void run(double speed, double length){
        this.speed += speed;
        this.length += length;
    }
}