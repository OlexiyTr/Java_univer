/**
 * Class Image with fields <b>m</b> and <b>n</b> and <b>massive of colors</b>
 * @author Трощий Алексей
 * @version 1.0
 */

import java.util.Arrays;

public class Image {
    /** field m */
    private int m;
    /** field n */
    private int n;
    /** field massive of collors */
    private Color[][] massiveOfColors;

    /**
     * Constructor - to create a new object
     * @see Image#Image(int, int, Color[][])
     */
    Image(int m, int n, Color[][] arr) {
        this.m = m;
        this.n = n;
        massiveOfColors = new Color[m][n];
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                massiveOfColors[i][j] = arr[i][j];
            }
        }
    }

    /**
     * Method of get color from show massive of collors {@link Image#massiveOfColors}
     * @param i,j
     * @return color from massive of colors
     */
    public Color getColorfromMassive(int i, int j) {
        return massiveOfColors[i][j];
    }

    /**
     * Method of set color to show massive of collors {@link Image#massiveOfColors}
     * @param i, j, el
     */
    public void setColortoMassive(int i, int j, Color el) {
        massiveOfColors[i][j] = el;
    }

    /**
     * Method to show massive of collors{@link Image#massiveOfColors}
     */
    public void showMassive() {
        System.out.println(Arrays.deepToString(massiveOfColors));
    }

}
