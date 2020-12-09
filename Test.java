/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws IOException {
            /*
               Create objects of COLOR
             */
            ColorRGBA object1 = new ColorRGBA(1,2,3,5);
            object1.show();
            ColorHSV object2 = new ColorHSV(2,4,6);
            object2.show();
            ColorCMYK object3 = new ColorCMYK(3,5,7,1);
            object3.show();

            /*
                Transfer from one color type to another color type
             */
            ColorRGBA object4 = hsvToRGB(object2);
            ColorHSV object5 = rgbToHSV(object1);
            ColorRGBA object6 = cmykToRGB(object3);

            /*
                Integer value of RGBA color
             */
            System.out.println(object1.valueInt());
            System.out.println(object1.valueFloat());

            /*
                Write colors to file
             */
            ArrayList<Color> colors = new ArrayList<>();
            colors.add(object1);
            colors.add(object2);
            colors.add(object3);
            colors.add(object4);
            colors.add(object5);
            colors.add(object6);
            String file_name = "List_of_colors.txt";
            writeToFile(file_name, colors);

            /*
                Addition of different types of color
             */
            System.out.print("RGBA color + HSV color : "); colorAddition(object1,object2).show();
            System.out.print("HSV color + CMYK color : "); colorAddition(object2,object3).show();
            System.out.print("CMYK color + RGBA color : "); colorAddition(object3,object1).show();
            System.out.print("RGBA color + RGBA color : "); colorAddition(object1,object6).show();

            /*
                Byte operations
             */
            System.out.println("Byte AND : " + byteAND(object1,object4));
            System.out.println("Byte OR : " + byteOR(object1,object4));
            System.out.println("Byte XOR : " + byteXOR(object1,object4));

            /*
                Create a Image type
             */
            Color[][] colorListForImage = new Color[2][2];
            colorListForImage[0][0] = object1;
            colorListForImage[1][1] = object2;
            colorListForImage[1][0] = object3;
            colorListForImage[0][1] = object4;
            Image picture = new Image(2,2,colorListForImage);
            picture.showMassive();

            /*
                Create a Mask type
             */
            int[][] listForMask = {{1,2},{3,4}};

            Mask mask = new Mask(2,2,listForMask);
            mask.showMassive();
    }

    public static void writeToFile (String filename, ArrayList<Color> arr) throws IOException {
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(filename));
        for (Color color : arr) {
            if (color instanceof ColorRGBA) {
                outputWriter.write("Color RGBA format:" +
                        " Red feature: " + ((((ColorRGBA) color).getRed())) +
                        " Green feature: " + ((((ColorRGBA) color).getGreen())) +
                        " Blue feature: " + ((((ColorRGBA) color).getBlue())) +
                        " Opaquity: " + ((((ColorRGBA) color).getOpaquity())));
                outputWriter.newLine();
            } else if (color instanceof ColorHSV) {
                outputWriter.write("Color HSV format:" +
                        " Hue feature: " + ((((ColorHSV) color).getHue())) +
                        " Saturation feature: " + ((((ColorHSV) color).getSaturation())) +
                        " Value feature: " + ((((ColorHSV) color).getValue())));
                outputWriter.newLine();

            } else if (color instanceof ColorCMYK) {
                outputWriter.write("Color CMYK format:" +
                        " Cyan feature: " + ((((ColorCMYK) color).getCyan())) +
                        " Magenta feature: " + ((((ColorCMYK) color).getMagenta())) +
                        " Yellow feature: " + ((((ColorCMYK) color).getYellow())) +
                        " Key feature: " + ((((ColorCMYK) color).getKey())));
                outputWriter.newLine();

            }
        }

        outputWriter.flush();
        outputWriter.close();
    }

    public static Color byteXOR(Color a, Color b){
        ColorRGBA ans = new ColorRGBA(0,0,0,0);
        if (a instanceof ColorRGBA && b instanceof ColorRGBA){
            int red_ = (int) ((ColorRGBA) a).getRed() ^ (int) ((ColorRGBA) b).getRed();
            int green_ = (int) ((ColorRGBA) a).getGreen() ^ (int) ((ColorRGBA) b).getGreen();
            int blue_ = (int) ((ColorRGBA) a).getBlue() ^ (int) ((ColorRGBA) b).getBlue();
            int opaquity = (int) ((ColorRGBA) a).getOpaquity() ^ (int) ((ColorRGBA) b).getOpaquity();
            return new ColorRGBA((float) red_, (float) green_, (float) blue_, (float) opaquity);
        }
        else if (a instanceof ColorHSV & b instanceof ColorHSV){
            int hue_ = (int) (((ColorHSV) a).getHue()) ^ (int) ((ColorHSV) b).getHue();
            int saturation_ = (int) (((ColorHSV) a).getSaturation()) ^ (int) ((ColorHSV) b).getSaturation();
            int val_ = (int) (((ColorHSV) a).getValue()) ^ (int) ((ColorHSV) b).getValue();
            return new ColorHSV((float) hue_, (float) saturation_, (float) val_);
        }
        else if (a instanceof ColorCMYK & b instanceof ColorCMYK) {
            int cyan_ = (int) (((ColorCMYK) a).getCyan()) ^ (int) ((ColorCMYK) b).getCyan();
            int magenta_ = (int) (((ColorCMYK) a).getMagenta()) ^ (int) ((ColorCMYK) b).getMagenta();
            int yellow_ = (int) (((ColorCMYK) a).getYellow()) ^ (int) ((ColorCMYK) b).getYellow();
            int key_ = (int) (((ColorCMYK) a).getKey()) ^ (int) ((ColorCMYK) b).getKey();
            return new ColorCMYK((float) cyan_, (float) magenta_, (float) yellow_, (float) key_);
        }
        return ans;
    }

    public static Color byteAND(Color a, Color b){
        ColorRGBA ans = new ColorRGBA(0,0,0,0);
        if (a instanceof ColorRGBA && b instanceof ColorRGBA){
            int red_ = (int) ((ColorRGBA) a).getRed() & (int) ((ColorRGBA) b).getRed();
            int green_ = (int) ((ColorRGBA) a).getGreen() & (int) ((ColorRGBA) b).getGreen();
            int blue_ = (int) ((ColorRGBA) a).getBlue() & (int) ((ColorRGBA) b).getBlue();
            int opaquity = (int) ((ColorRGBA) a).getOpaquity() & (int) ((ColorRGBA) b).getOpaquity();
            return new ColorRGBA((float) red_, (float) green_, (float) blue_, (float) opaquity);
        }
        else if (a instanceof ColorHSV & b instanceof ColorHSV){
            int hue_ = (int) (((ColorHSV) a).getHue()) & (int) ((ColorHSV) b).getHue();
            int saturation_ = (int) (((ColorHSV) a).getSaturation()) & (int) ((ColorHSV) b).getSaturation();
            int val_ = (int) (((ColorHSV) a).getValue()) & (int) ((ColorHSV) b).getValue();
            return new ColorHSV((float) hue_, (float) saturation_, (float) val_);
        }
        else if (a instanceof ColorCMYK & b instanceof ColorCMYK){
            int cyan_ = (int) (((ColorCMYK) a).getCyan()) & (int) ((ColorCMYK) b).getCyan();
            int magenta_ = (int) (((ColorCMYK) a).getMagenta()) & (int) ((ColorCMYK) b).getMagenta();
            int yellow_ = (int) (((ColorCMYK) a).getYellow()) & (int) ((ColorCMYK) b).getYellow();
            int key_ = (int) (((ColorCMYK) a).getKey()) & (int) ((ColorCMYK) b).getKey();
            return new ColorCMYK((float) cyan_, (float) magenta_, (float) yellow_, (float) key_);
        }
        return ans;
    }

    public static Color byteOR(Color a, Color b){
        ColorRGBA ans = new ColorRGBA(0,0,0,0);
        if (a instanceof ColorRGBA && b instanceof ColorRGBA){
            int red_ = (int) ((ColorRGBA) a).getRed() | (int) ((ColorRGBA) b).getRed();
            int green_ = (int) ((ColorRGBA) a).getGreen() | (int) ((ColorRGBA) b).getGreen();
            int blue_ = (int) ((ColorRGBA) a).getBlue() | (int) ((ColorRGBA) b).getBlue();
            int opaquity = (int) ((ColorRGBA) a).getOpaquity() | (int) ((ColorRGBA) b).getOpaquity();
            return new ColorRGBA((float) red_, (float) green_, (float) blue_, (float) opaquity);
        }
        else if (a instanceof ColorHSV & b instanceof ColorHSV){
            int hue_ = (int) (((ColorHSV) a).getHue()) | (int) ((ColorHSV) b).getHue();
            int saturation_ = (int) (((ColorHSV) a).getSaturation()) | (int) ((ColorHSV) b).getSaturation();
            int val_ = (int) (((ColorHSV) a).getValue()) | (int) ((ColorHSV) b).getValue();
            return new ColorHSV((float) hue_, (float) saturation_, (float) val_);
        }
        else if (a instanceof ColorCMYK & b instanceof ColorCMYK){
            int cyan_ = (int) (((ColorCMYK) a).getCyan()) | (int) ((ColorCMYK) b).getCyan();
            int magenta_ = (int) (((ColorCMYK) a).getMagenta()) | (int) ((ColorCMYK) b).getMagenta();
            int yellow_ = (int) (((ColorCMYK) a).getYellow()) | (int) ((ColorCMYK) b).getYellow();
            int key_ = (int) (((ColorCMYK) a).getKey()) | (int) ((ColorCMYK) b).getKey();
            return new ColorCMYK((float) cyan_, (float) magenta_, (float) yellow_, (float) key_);
        }
        return ans;
    }

    public static Color colorAddition(Color a, Color b){
        ColorRGBA ans = new ColorRGBA(0,0,0,0);
        if (a instanceof ColorRGBA && b instanceof ColorRGBA){
            return new ColorRGBA(((((ColorRGBA) a).getRed() + ((ColorRGBA) b).getRed())/2),
                                            ((((ColorRGBA) a).getGreen() + ((ColorRGBA) b).getGreen())/2),
                                            ((((ColorRGBA) a).getBlue() + ((ColorRGBA) b).getBlue())/2),
                                            ((((ColorRGBA) a).getOpaquity() + ((ColorRGBA) b).getOpaquity())/2));
        }
        else if (a instanceof ColorHSV && b instanceof ColorRGBA){
            ColorRGBA a_new = hsvToRGB((ColorHSV) a);
            return new ColorRGBA((a_new.getRed() + ((ColorRGBA) b).getRed()/2),
                    ((a_new.getGreen() + ((ColorRGBA) b).getGreen())/2),
                    ((a_new.getBlue() + ((ColorRGBA) b).getBlue())/2),
                    ((a_new.getOpaquity() + ((ColorRGBA) b).getOpaquity())/2));
        }
        else if (b instanceof ColorHSV && a instanceof ColorRGBA){
            ColorRGBA b_new = hsvToRGB((ColorHSV) b);
            return new ColorRGBA(((b_new.getRed() + ((ColorRGBA) a).getRed())/2),
                    ((b_new.getGreen() + ((ColorRGBA) a).getGreen())/2),
                    ((b_new.getBlue() + ((ColorRGBA) a).getBlue())/2),
                    ((b_new.getOpaquity() + ((ColorRGBA) a).getOpaquity())/2));
        }
        else if (a instanceof ColorHSV && b instanceof ColorHSV){
            return new ColorHSV(((((ColorHSV) a).getHue() + ((ColorHSV) b).getHue()))/2,
                    ((((ColorHSV) a).getSaturation() + ((ColorHSV) b).getSaturation()))/2,
                    ((((ColorHSV) a).getValue() + ((ColorHSV) b).getValue()))/2);
        }
        else if (a instanceof ColorCMYK && b instanceof ColorCMYK){
            return new ColorCMYK(((((ColorCMYK) a).getCyan() + ((ColorCMYK) b).getCyan()))/2,
                    ((((ColorCMYK) a).getMagenta() + ((ColorCMYK) b).getMagenta()))/2,
                    ((((ColorCMYK) a).getYellow() + ((ColorCMYK) b).getYellow()))/2,
                    ((((ColorCMYK) a).getKey() + ((ColorCMYK) b).getKey()))/2);
        }
        else if (a instanceof ColorCMYK && b instanceof ColorRGBA){
            ColorRGBA a_new = cmykToRGB((ColorCMYK) a);
            return new ColorRGBA((a_new.getRed() + ((ColorRGBA) b).getRed()/2),
                    ((a_new.getGreen() + ((ColorRGBA) b).getGreen())/2),
                    ((a_new.getBlue() + ((ColorRGBA) b).getBlue())/2),
                    ((a_new.getOpaquity() + ((ColorRGBA) b).getOpaquity())/2));

        }
        else if(b instanceof ColorCMYK && a instanceof ColorRGBA){
            ColorRGBA b_new = cmykToRGB((ColorCMYK) b);
            return new ColorRGBA(((b_new.getRed() + ((ColorRGBA) a).getRed())/2),
                    ((b_new.getGreen() + ((ColorRGBA) a).getGreen())/2),
                    ((b_new.getBlue() + ((ColorRGBA) a).getBlue())/2),
                    ((b_new.getOpaquity() + ((ColorRGBA) a).getOpaquity())/2));
        }
        else if(a instanceof ColorHSV && b instanceof ColorCMYK){
            ColorRGBA a_new = hsvToRGB((ColorHSV) a);
            ColorRGBA b_new = cmykToRGB((ColorCMYK) b);
            return new ColorRGBA((a_new.getRed() + ((ColorRGBA) b_new).getRed()/2),
                    ((a_new.getGreen() + ((ColorRGBA) b_new).getGreen())/2),
                    ((a_new.getBlue() + ((ColorRGBA) b_new).getBlue())/2),
                    ((a_new.getOpaquity() + ((ColorRGBA) b_new).getOpaquity())/2));
        }
        else if (b instanceof ColorHSV && a instanceof ColorCMYK){
            ColorRGBA a_new = cmykToRGB((ColorCMYK) a);
            ColorRGBA b_new = hsvToRGB((ColorHSV) b);
            return new ColorRGBA((a_new.getRed() + ((ColorRGBA) b_new).getRed()/2),
                    ((a_new.getGreen() + ((ColorRGBA) b_new).getGreen())/2),
                    ((a_new.getBlue() + ((ColorRGBA) b_new).getBlue())/2),
                    ((a_new.getOpaquity() + ((ColorRGBA) b_new).getOpaquity())/2));
        }
        return ans;
    }

    public static ColorHSV rgbToHSV(ColorRGBA val){
        float h, s, v;

        float min, max, delta;

        min = Math.min(Math.min(val.getRed(), val.getGreen()), val.getBlue());
        max = Math.max(Math.max(val.getRed(), val.getGreen()), val.getBlue());

        v = max;

        delta = max - min;

        if( max != 0 )
            s = delta / max;
        else {
            s = 0;
            h = -1;
            return new ColorHSV(h,s,v);
        }

        if( val.getRed() == max )
            h = ( val.getGreen() - val.getBlue() ) / delta; // between yellow & magenta
        else if( val.getGreen() == max )
            h = 2 + ( val.getBlue() - val.getRed() ) / delta; // between cyan & yellow
        else
            h = 4 + ( val.getRed() - val.getGreen() ) / delta; // between magenta & cyan

        h *= 60;    // degrees

        if( h < 0 )
            h += 360;
        ColorHSV res = new ColorHSV(h,s,v);
        System.out.println(res.getHue() + " " + res.getSaturation() + " "  + res.getValue());
        return res;
    }

    public static ColorRGBA hsvToRGB(ColorHSV val) {
        float m, n, f;
        int i;

        float[] hsv = new float[3];
        float[] rgb = new float[3];

        hsv[0] = val.getHue();
        hsv[1] = val.getSaturation();
        hsv[2] = val.getValue();

        if (hsv[0] == -1)
        {
            rgb[0] = rgb[1] = rgb[2] = hsv[2];

            return new ColorRGBA(rgb[0],rgb[0],rgb[0],0);
        }
        i = (int) (Math.floor(hsv[0]));
        f = hsv[0] - i;
        if (i % 2 == 0)
        {
            f = 1 - f; // if i is even
        }
        m = hsv[2] * (1 - hsv[1]);
        n = hsv[2] * (1 - hsv[1] * f);
        switch (i) {
            case 6, 0 -> {
                rgb[0] = hsv[2];
                rgb[1] = n;
                rgb[2] = m;
            }
            case 1 -> {
                rgb[0] = n;
                rgb[1] = hsv[2];
                rgb[2] = m;
            }
            case 2 -> {
                rgb[0] = m;
                rgb[1] = hsv[2];
                rgb[2] = n;
            }
            case 3 -> {
                rgb[0] = m;
                rgb[1] = n;
                rgb[2] = hsv[2];
            }
            case 4 -> {
                rgb[0] = n;
                rgb[1] = m;
                rgb[2] = hsv[2];
            }
            case 5 -> {
                rgb[0] = hsv[2];
                rgb[1] = m;
                rgb[2] = n;
            }
        }
        return new ColorRGBA(rgb[0],rgb[1],rgb[2],0);
    }
    private static ColorRGBA cmykToRGB(ColorCMYK val) {
        float r = 255 * (1 - val.getCyan()/100) * (1 - val.getKey()/100);
        float g = 255 * (1 - val.getMagenta()/100) * (1 - val.getKey()/100);
        float b = 255 * (1 - val.getYellow()/100) * (1 - val.getKey()/100);
        ColorRGBA res = new ColorRGBA(r,g,b,0);
        System.out.println(res.getRed() + " " + res.getGreen() + " "  + res.getBlue() + " " + res.getOpaquity());
        return res;
    }
}


