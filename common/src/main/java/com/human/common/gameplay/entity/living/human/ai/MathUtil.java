package com.human.common.gameplay.entity.living.human.ai;

public class MathUtil {

    public static double mapNormalized(double value, double inMin, double inMax) {
        return mapRange(value, inMin, inMax, 0, 1);
    }

    public static double mapRange(double value, double inMin, double inMax, double outMin, double outMax) {
        if (inMin == inMax) {
            return outMin;
        }

        var t = (value - inMin) / (inMax - inMin);
        t = normalize(t);

        return outMin + (outMax - outMin) * t;
    }

    public static double normalize(double value) {
        return Math.clamp(value, 0.0, 1.0);
    }

    // Constant progression.
    public static double linear(double normalizedProgress, double min, double max) {
        normalizedProgress = normalize(normalizedProgress);

        return min + (max - min) * normalizedProgress;
    }

    // Starts slow and accelerates toward the end.
    public static double quadraticIn(double normalizedProgress, double min, double max) {
        normalizedProgress = normalize(normalizedProgress);

        return min + (max - min) * (normalizedProgress * normalizedProgress);
    }

    // Fast at the beginning, slows near the end.
    public static double quadraticOut(double normalizedProgress, double min, double max) {
        normalizedProgress = normalize(normalizedProgress);
        var eased = 1.0 - (1.0 - normalizedProgress) * (1.0 - normalizedProgress);

        return min + (max - min) * eased;
    }

    // Fast at the beginning, slows near the end.
    public static double sqrtIn(double normalizedProgress) {
        normalizedProgress = normalize(normalizedProgress);
        return Math.sqrt(normalizedProgress);
    }

    // Starts slow and accelerates toward the end.
    public static double sqrtOut(double normalizedProgress) {
        normalizedProgress = normalize(normalizedProgress);
        return 1.0 - Math.sqrt(1.0 - normalizedProgress);
    }

    private MathUtil() {
        throw new UnsupportedOperationException();
    }
}
