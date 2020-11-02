import java.util.Scanner;

public class task_4_8 {
    public static void main(String args[]) {
        Square obj = new Square(1.0,1.0,1.0,5.0,5.0,5.0,"red");
        obj.showSquare();
        obj.change_color("green");
        obj.scale(5.0);
        obj.showSquare();
    }
}

interface Rotatable{
    void rotate(double angle);
}


interface Scalable {
    void scale(double factor);
}

class Pair<T1, T2>{
    private T1 first;
    private T2 second;

    public Pair(T1 first,T2 second){
        this.first = first;
        this.second = second;
    }
    T1 getFirst(){
        return first;
    }
    T2 getSecond(){
        return second;
    }
}

class Point implements Rotatable{
    private Pair<Double,Double> coordinates;
    Point(double x, double y){
        this.coordinates = new Pair<>(x,y);
    }
    double getX(){
        return coordinates.getFirst();
    }
    double getY(){
        return coordinates.getSecond();
    }
    void scaleCoordinates(double factor){
        double x = coordinates.getFirst();
        double y = coordinates.getSecond();

        double newX = x * factor;
        double newY = y * factor;

        coordinates = new Pair<>(newX,newY);
    }
    @Override
    public void rotate(double angle){
        double x = coordinates.getFirst();
        double y = coordinates.getSecond();

        double newX = x * Math.cos(angle) - y * Math.sin(angle);
        double newY = x * Math.sin(angle) + y * Math.cos(angle);

        coordinates = new Pair<>(newX,newY);
    }
}

class Segment implements Rotatable, Scalable{
    private Pair<Point,Point> ends;
    Segment(double x1,double y1,double x2,double y2){
        ends = new Pair<>(new Point(x1,y1),new Point(x2,y2));
    }
    double length(){
        double x1 = ends.getFirst().getX();
        double y1 = ends.getFirst().getY();
        double x2 = ends.getSecond().getX();
        double y2 = ends.getSecond().getY();

        return Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2));
    }

    @Override
    public void rotate(double angle){
        ends.getFirst().rotate(angle);
        ends.getSecond().rotate(angle);
    }
    @Override
    public void scale(double factor){
        ends.getFirst().scaleCoordinates(factor);
        ends.getSecond().scaleCoordinates(factor);
    }

}

class Square implements Rotatable, Scalable{
    private Pair<Segment,Segment> sides;
    private String color;
    public Square(double x1,double y1,double x2,double y2, double x3,double y3, String color){
        Segment side1 = new Segment(x1,y1,x2,y2);
        Segment side2 = new Segment(x2,y2,x3,y3);
        sides = new Pair<>(side1,side2);
        this.color = color;
    }
    @Override
    public void rotate(double angle){
        sides.getFirst().rotate(angle);
        sides.getSecond().rotate(angle);
    }
    @Override
    public void scale(double factor){
        sides.getFirst().scale(factor);
        sides.getSecond().scale(factor);
    }
    void change_color(String newColor){
        color = newColor;
    }

    void showSquare(){
        System.out.println("Цвет: " + color + "\nРазмеры: " + sides.getFirst().length());
    }
}