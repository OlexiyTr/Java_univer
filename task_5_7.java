import java.util.Scanner;
//5.7 Трощий Олексій
public class task_5_7 {
    public static Integer func(Integer a) {
        String temp = a.toString();
        int[] temp_array = new int[temp.length()];
        int counter = 1;
        for (int i = 0; i < temp.length(); i++){
            temp_array[i] = temp.charAt(i) - '0';
        }
        int start = temp_array[0];
        for (int i = 1; i < temp.length(); i++){
            if (start < temp_array[i]){
                start = temp_array[i];
                continue;
            }
            else {
                counter = 0;
                break;
            }
        }
        return counter;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int inputer = input.nextInt();
        int[] myArray = new int[inputer];
        for (int i = 0; i < inputer; i++) {
            myArray[i] = input.nextInt();
        }
        for (int i = 0; i < inputer; i++) {
            if(func(myArray[i]) == 1){
                System.out.println(myArray[i]);
            }
        }
    }
}