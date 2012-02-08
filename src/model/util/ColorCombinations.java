package model.util;

import model.RGBColor;

/**
 * Combine two colors by combining their components.
 * 
 * This is a separate class from color since it is just one set of ways to
 * combine colors, many may exist and we do not want to keep modifying the
 * RGBColor class.
 * 
 * @author Robert C. Duvall
 */
public class ColorCombinations {
    /**
     * Combine two colors by adding their components.
     */
    public static RGBColor add(RGBColor left, RGBColor right) {
        return new RGBColor(left.getRed() + right.getRed(), left.getGreen()
                + right.getGreen(), left.getBlue() + right.getBlue());
    }

    /**
     * Combine two colors by subtracting their components.
     */
    public static RGBColor subtract(RGBColor left, RGBColor right) {
        return new RGBColor(left.getRed() - right.getRed(), left.getGreen()
                - right.getGreen(), left.getBlue() - right.getBlue());
    }

    /**
     * Combine two colors by multiplying their components.
     */
    public static RGBColor multiply(RGBColor left, RGBColor right) {
        return new RGBColor(left.getRed() * right.getRed(), left.getGreen()
                * right.getGreen(), left.getBlue() * right.getBlue());
    }

    /**
     * Combine two colors by dividing their components.
     */
    public static RGBColor divide(RGBColor left, RGBColor right) {
        return new RGBColor(left.getRed() / right.getRed(), left.getGreen()
                / right.getGreen(), left.getBlue() / right.getBlue());
    }

    /**
     * Combine two colors by taking the modulus of their components.
     */
    public static RGBColor modulus(RGBColor left, RGBColor right) {
        return new RGBColor(left.getRed() % right.getRed(), left.getGreen()
                % right.getGreen(), left.getBlue() % right.getBlue());
    }

    /**
     * Combine two colors by taking the left value to the exponent denoted by
     * the right value.
     */
    public static RGBColor exponent(RGBColor left, RGBColor right) {
        return new RGBColor(Math.pow(left.getRed(), right.getRed()), Math.pow(
                left.getGreen(), right.getGreen()), Math.pow(left.getBlue(),
                right.getBlue()));
    }

    /**
     * Combine three values and display in RGB color
     */
    public static RGBColor color(RGBColor red, RGBColor green, RGBColor blue) {
        // do stuff, like convert RGBColor into doubles
        double colorR = red.getRed();
        double colorG = green.getGreen();
        double colorB = blue.getBlue();
        return new RGBColor(colorR, colorG, colorB);
    }

    /**
     * take the invert of a givne color
     */
    public static RGBColor negate(RGBColor color) {

        return new RGBColor(-(color.getRed()), -(color.getGreen()),
                -(color.getBlue()));
    }

    public static RGBColor random() {
        double colorR = Math.random() * 2 - 1;
        double colorG = Math.random() * 2 - 1;
        double colorB = Math.random() * 2 - 1;

        return new RGBColor(colorR, colorG, colorB);
    }

    public static RGBColor floor(RGBColor color) {
        double colorR = Math.floor(color.getRed());
        double colorG = Math.floor(color.getGreen());
        double colorB = Math.floor(color.getBlue());

        return new RGBColor(colorR, colorG, colorB);
    }

    public static RGBColor ceiling(RGBColor color) {
        double colorR = Math.ceil(color.getRed());
        double colorG = Math.ceil(color.getGreen());
        double colorB = Math.ceil(color.getBlue());

        return new RGBColor(colorR, colorG, colorB);
    }

    public static RGBColor absolute(RGBColor color) {
        double colorR = Math.abs(color.getRed());
        double colorG = Math.abs(color.getGreen());
        double colorB = Math.abs(color.getBlue());

        return new RGBColor(colorR, colorG, colorB);
    }

    // how to clamp? (option: double/length of double
    public static RGBColor clamp(RGBColor color) {
        color.clamp();
        return color;
    }

    public static RGBColor wrap(RGBColor color) {
        color.wrap();
        return color;
    }

    public static RGBColor sin(RGBColor color) {
        double colorR = Math.sin(color.getRed());
        double colorG = Math.sin(color.getGreen());
        double colorB = Math.sin(color.getBlue());

        return new RGBColor(colorR, colorG, colorB);
    }

    public static RGBColor cos(RGBColor color) {
        double colorR = Math.cos(color.getRed());
        double colorG = Math.cos(color.getGreen());
        double colorB = Math.cos(color.getBlue());

        return new RGBColor(colorR, colorG, colorB);
    }

    public static RGBColor tan(RGBColor color) {
        double colorR = Math.tan(color.getRed());
        double colorG = Math.tan(color.getGreen());
        double colorB = Math.tan(color.getBlue());

        return new RGBColor(colorR, colorG, colorB);
    }

    public static RGBColor atan(RGBColor color) {
        double colorR = Math.atan(color.getRed());
        double colorG = Math.atan(color.getGreen());
        double colorB = Math.atan(color.getBlue());

        return new RGBColor(colorR, colorG, colorB);
    }

    public static RGBColor log(RGBColor color) {
        double colorR = Math.log(color.getRed());
        double colorG = Math.log(color.getGreen());
        double colorB = Math.log(color.getBlue());

        return new RGBColor(colorR, colorG, colorB);
    }

}
