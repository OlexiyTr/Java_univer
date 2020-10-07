import java.util.Scanner;
//6.6 Трощий Олексій
class task_6_6 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        double x,max = 0.0;
        int m = scanner.nextInt(), n = scanner.nextInt();
        for (int i = 0; i < m; i++){
            double s = 0.0;
            for (int j = 0; j < n; j++){
                x = scanner.nextInt();
                s += Math.abs(x);
            }
            if (s > max)
            max = s;
        }
        System.out.println(max);
    }
}