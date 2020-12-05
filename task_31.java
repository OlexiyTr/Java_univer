import java.util.Arrays;

public class task_31 {
    public static void main(String[] args) {
        String line = "абвмсдавіаів";
        char[] line_arr = line.toCharArray();
        Arrays.sort(line_arr);
        String res = new String(line_arr);
        System.out.println(res);
    }
}
