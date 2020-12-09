/**
 * Class ColorCMYK extends Color with fields <b>cyan</b> and <b>magenta</b> and <b>yellow</b> and <b>key</b>
 * @author Трощий Алексей
 * @version 1.0
 */

public class ColorCMYK extends Color {

    /** field cyan */
    private final Float cyan;

    /** field magenta */
    private final Float magenta;

    /** field yellow */
    private final Float yellow;

    /** field key */
    private final Float key;

    /**
     * Constructor - to create a new object
     * @see ColorCMYK#ColorCMYK(float, float, float, float)
     */
    ColorCMYK(float cyan, float magenta, float yellow, float key) {
        this.cyan = cyan;
        this.magenta = magenta;
        this.yellow = yellow;
        this.key = key;
    }

    /**
     * Method of get cyan {@link ColorCMYK}
     * @return hue
     */
    public float getCyan() {
        return cyan;
    }

    /**
     * Method of get magenta {@link ColorCMYK}
     * @return magenta
     */
    public float getMagenta() {
        return magenta;
    }

    /**
     * Method of get yellow {@link ColorCMYK}
     * @return yellow
     */
    public float getYellow() {
        return yellow;
    }

    /**
     * Method of get key {@link ColorCMYK}
     * @return key
     */
    public float getKey() {
        return key;
    }

    /**
     * Method to show features of color {@link ColorCMYK#}
     */
    @Override
    public void show() {
        System.out.println("ColorCMYK with features: " + this.cyan + " " + this.magenta + " " + this.yellow + " " + this.key);
    }

    @Override
    public int valueInt() {
        return 1;
    }

    @Override
    public float valueFloat() {
        return 1.0f;
    }
}
