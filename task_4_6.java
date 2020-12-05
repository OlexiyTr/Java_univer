public class task_4_6 {
    public static void main(String[] args) {
        double e = 0.00001;
        double sum = 0;
        int k = 0;
        double x = 0.05;
        double cur = func(x,k);
        sum += cur;
        k++;
        double prev;
        do{
            prev = cur;
            cur = func(x,k);
            sum += cur;
            k++;
        } while(Math.abs(cur - prev) > e);
        System.out.println(sum);

    }
    public static double func(double res, int k){
        res = (Math.pow(res,k))/(Math.pow((k+1),2));
        return res;
    }
}
