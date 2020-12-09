/**
 * Class Mask with fields <b>m</b> and <b>n</b> and <b>massive_</b>
 * @author Трощий Алексей
 * @version 1.0
 */

import java.util.Arrays;

public class Mask {
    /** field m */
    private int m;

    /** field n */
    private int n;

    /** field massive_ */
    private int[][] massive_;

    /**
     * Constructor - to create a new object
     * @see Mask#Mask(int, int, int[][])
     */
    Mask(int m, int n, int[][] arr) {
        this.m = m;
        this.n = n;
        massive_ = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                assert false;
                massive_[i][j] = arr[i][j];
            }
        }
    }

    /**
     * Method to show massive of collors{@link Mask#massive_}
     */
    public void showMassive() {
        System.out.println(Arrays.deepToString(massive_));
    }

}
