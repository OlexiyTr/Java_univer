import java.util.Scanner;
import java.io.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class task
{
    public static int readSum(int[] mas){
        int sum_ = 0;
        for (int i = 0; i < mas.length; i++) {
            sum_ += mas[i];
        }
        return sum_;
    }
    public static int showNeg(int[] mas){
        int count = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < 0){
                count += 1;
                System.out.println(mas[i]);
            }
        }
        return count;
    }

    public static int maxMas(int[] mas){
        int max_ = mas[0];
        for (int i = 0; i < mas.length; i++){
            if (max_ < mas[i]){
                max_ = mas[i];
            }
            else{
                continue;
            }
        }
        return max_;
    }
    public static int minMas(int[] mas){
        int max_ = mas[0];
        for (int i = 0; i < mas.length; i++){
            if (max_ > mas[i]){
                max_ = mas[i];
            }
            else{
                continue;
            }
        }
        return max_;
    }
    public static int min_Mas_with_i_equals_2(int[] mas){
        int[] min_c = new int[(mas.length - 1)/2];
        for (int i = 0; i < 100; i++){
            if (i%2 == 0){
                min_c[i] = mas[i];
            }
        }
        int min_ =min_c[0];
        for (int i = 0; i < min_c.length; i ++){
            if (min_ < min_c[i]){
                continue;
            }
            else if(min_ > min_c[i]){
                min_ = min_c[i];
            }
        }
        return min_;
    }

    public static int countArMas(int[] mas){
        int ser_ar = readSum(mas)/mas.length;
        int res = 0;
        for(int i =0; i < mas.length; i++){
            if (mas[i] < ser_ar){
                res += 1;
            }
        }
        return res;
    }
    public static void main() {
        int[] c = new int[100];
        try {
            RandomAccessFile file = new RandomAccessFile(new File("E:/binary.dat"), "rw");
            int[]matrix = new int[10];
            Random rnd = new Random();
            for (int i = 0; i < 10; i++){
                file.writeInt(matrix[i] = rnd.nextInt(10) - 0);
                file.seek(0);

                 c[i] = file.readInt();
                 file.seek(i);
                }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(c[i]);
        }

        System.out.println(readSum(c));
        System.out.println(showNeg(c));
        System.out.println(c[c.length-1]);
        System.out.println(maxMas(c));
        System.out.println(min_Mas_with_i_equals_2(c));
        System.out.println(maxMas(c) + minMas(c));
        System.out.println(c[0] - c[c.length -1]);
        System.out.println(countArMas(c));

    }
}