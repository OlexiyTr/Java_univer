import java.util.Scanner;
//12 Трощий Олексій
public class task_12 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();

        int[] temp_symbols_array = new int[str.length()];

        for (int i = 0; i < str.length(); i++){
            temp_symbols_array[i] = (int) str.charAt(i);
        }

        int begin_ = 0;
        int end_ = 0;
        int size_ = 1;
        String[] mas_res = new String[size_];
        int i = 0;
        while(i < str.length()){
            System.out.println("Start!");
            if (temp_symbols_array[i++] - temp_symbols_array[i] == 1){
                System.out.println("!");
                begin_ = temp_symbols_array[i];
                for (int j = i++; j < str.length(); j++){
                    if (temp_symbols_array[j++] - temp_symbols_array[j] == 1){
                        System.out.println("!continue!");
                        continue;
                    }
                    else{
                        end_ = j;
                    }
                    System.out.println(str.substring(begin_, end_));
                    mas_res[size_] = str.substring(begin_, end_);
                    size_++;
                    begin_ = 0;
                    i = end_;
                    end_ = 0;
                }
            }
            else {
                i++;
                }
            }
        for (int jj = 0; jj < mas_res.length; jj++){
            System.out.println(mas_res[jj]);
        }
    }
}
