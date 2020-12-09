/**
 * Class ColorRGBA extends Color with fields <b>red</b> and <b>blue</b> and <b>green</b> and <b>opaquity</b>
 * @author Трощий Алексей
 * @version 1.0
 */

public class ColorRGBA extends Color {
    /** field red */
    private final Float red;

    /** field blue */
    private final Float blue;

    /** field green */
    private final Float green;

    /** field opaquity */
    private final Float opaquity;

    /**
     * Constructor - to create a new object
     * @see ColorRGBA#ColorRGBA(float, float, float, float)
     */
    ColorRGBA(float red, float green, float blue, float opaquity) {
        this.red = red;
        this.blue = blue;
        this.green = green;
        this.opaquity = opaquity;
    }

    /**
     * Method of get red {@link ColorRGBA}
     * @return red
     */
    public float getRed() {
        return red;
    }

    /**
     * Method of get blue {@link ColorRGBA}
     * @return blue
     */
    public float getBlue() {
        return blue;
    }

    /**
     * Method of get green {@link ColorRGBA}
     * @return green
     */
    public float getGreen() {
        return green;
    }

    /**
     * Method of get opaquity {@link ColorRGBA}
     * @return opaquity
     */
    public float getOpaquity() {
        return opaquity;
    }

    /**
     * Method to show features of color {@link ColorRGBA#}
     */
    @Override
    public void show() {
        System.out.println("ColorRGB with features: " + this.red + " " + this.green + " " + this.blue);
    }

    /**
     * Method of get Integer value of color {@link ColorRGBA}
     * @return integer value of color
     */
    @Override
    public int valueInt() {
        int R = Math.round(255 * red);
        int G = Math.round(255 * green);
        int B = Math.round(255 * blue);

        R = (R << 16) & 0x00FF0000;
        G = (G << 8) & 0x0000FF00;
        B = B & 0x000000FF;
        return 0xFF000000 | R | G | B;
    }

    /**
     * Method of get float value of color {@link ColorRGBA}
     * @return float value of color
     */
    @Override
    public float valueFloat() {
        return (float) valueInt();
    }

}
