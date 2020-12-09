/**
 * Class ColorHSV extends Color with fields <b>hue</b> and <b>saturation</b> and <b>value</b>
 * @author Трощий Алексей
 * @version 1.0
 */

public class ColorHSV extends Color {
    /** field hue */
    private final Float hue;

    /** field saturation */
    private final Float saturation;

    /** field value */
    private final Float value;

    /**
     * Constructor - to create a new object
     * @see ColorHSV#ColorHSV(float, float, float)
     */
    ColorHSV(float hue, float saturation, float value) {
        this.hue = hue;
        this.saturation = saturation;
        this.value = value;
    }

    /**
     * Method of get hue {@link ColorHSV}
     * @return hue
     */
    public float getHue() {
        return hue;
    }

    /**
     * Method of get saturation {@link ColorHSV}
     * @return saturation
     */
    public float getSaturation() {
        return saturation;
    }

    /**
     * Method of get value {@link ColorHSV}
     * @return value
     */
    public float getValue() {
        return value;
    }

    /**
     * Method to show features of color {@link ColorHSV#}
     */
    @Override
    public void show() {
        System.out.println("ColorHSB with features: " + this.hue + " " + this.saturation + " " + this.value);
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
