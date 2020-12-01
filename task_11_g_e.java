import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class task_11_g_e {
    public static void main(String[] args) throws IOException {

        File file = new File("Test_file.txt");
        FileReader fr = new FileReader(file);
        Scanner scan = new Scanner(fr);

        int size = 1;
        String[] mas = new String[5];
        int counter = 0;
        while (scan.hasNextLine()){
            mas[counter] = scan.nextLine();
            counter++;
        }
        fr.close();
        String show_str = "";
        for (int i =0; i < mas.length; i++){
            show_str += mas[i] + "\n";
        }
        System.out.println(show_str);

        Student[] stud_mas = new Student[5];

        for (int i = 0; i < stud_mas.length; i++){
            String[] splt = mas[i].split(" ");
            stud_mas[i] = new Student(splt[0],splt[1],Integer. parseInt(splt[2]),splt[3]);
        }

        for (int i = 0; i < stud_mas.length; i++){
            System.out.println(stud_mas[i].getFirst_name() + ' ' + stud_mas[i].getLast_name());
        }

        check_students_in_parralel_classes(stud_mas);
        check_dif(stud_mas);
    }
    public static void check_students_in_parralel_classes(Student[] arr){
        System.out.println("____________________________");
        for (int i = 0; i < arr.length; i++){
            String f_name = arr[i].getFirst_name();
            String l_name = arr[i].getLast_name();
            int n_class = arr[i].getNumber_of_class();
            for (int j = i+1; j < arr.length; j++){
                if (f_name.equals(arr[j].getFirst_name()) & l_name.equals(arr[j].getLast_name()) & n_class == arr[j].getNumber_of_class()){
                    System.out.println(f_name + " " + l_name + " in " +
                            arr[i].getNumber_of_class() + " " +
                            arr[i].getSymbol_of_class() + " and " + arr[j].getSymbol_of_class());
                    break;
                }
                else{
                    continue;
                }
            }
        }
        System.out.println("____________________________");
    }

    public static void check_dif(Student[] arr){
        int sum_8 = 0;
        int sum_10 = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i].getNumber_of_class() == 8){
                sum_8 += 1;
            }
            else if(arr[i].getNumber_of_class() == 10){
                sum_10 += 1;
            }
        }
        System.out.println("Разница в 10ых и 8ых классах = " + Math.abs(sum_8 - sum_10));
    }
}

class Student{
    private final String first_name;
    private final String last_name;
    private final int number_of_class;
    private final String symbol_of_class;

    Student(String first_name, String last_name, int number_of_class, String symbol_of_class){
        this.first_name = first_name;
        this.last_name = last_name;
        this.number_of_class = number_of_class;
        this.symbol_of_class = symbol_of_class;
    }
    String getLast_name(){
        return last_name;
    }
    String getFirst_name(){
        return first_name;
    }
    int getNumber_of_class(){
        return number_of_class;
    }
    String getSymbol_of_class(){
        return symbol_of_class;
    }
}