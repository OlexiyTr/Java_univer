import java.util.Scanner;
//2.2 Трощий Олексій
public class task_2_2 {
    public static String binar(int a){
        int b;
        String temp = "";
        while(a !=0){
            b = a%2;
            temp = b + temp;
            a = a/2;
        }
        return temp;
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] n_ = binar(n).toCharArray();
        String res = "";
        for(int i = 1; i < n_.length; i++){
            res += n_[i];
        }
        res += n_[0];
        int ans = Integer.parseInt(res, 2);
        System.out.println(ans);
    }
}
