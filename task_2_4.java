import java.util.Scanner;
public class task_2_4 {
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
        int a = scanner.nextInt();
        System.out.println(binar(n));
        char[] n_ = binar(n).toCharArray();
        String res = "";
        a -= 1;
        for (int i = 0; i<a;i++) {
            res += n_[i];
        }
        for (int i = a+1; i<n_.length;i++) {
            res += n_[i];
        }
        int ans = Integer.parseInt(res, 2);
        System.out.println(ans);
    }
}
