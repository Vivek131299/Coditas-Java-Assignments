import java.util.ArrayList;

public class TrappingRainWater {

    public static void main(String[] args) {

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int waterUnits = 0;

        for (int i = 1; i < height.length-1; i++) { // looping through 'height' array from 2nd element to 2nd last element.

            int maxLeft = height[i]; // for storing maximum height towards left of current element.
            for (int j = 0; j < i; j++) { // looping from starting till the current element.
                if (height[j] > maxLeft) { // checking maximum element/height.
                    maxLeft = height[j]; // and storing it to 'maxLeft'.
                }
            }

            int maxRight = height[i]; // for storing maximum height towards right of current element.
            for (int k = i+1; k < height.length; k++) { // looping from next of the current element till the end.
                if (height[k] > maxRight) { // checking maximum element/height.
                    maxRight = height[k]; // and storing it to 'maxRight'.
                }
            }

            waterUnits += Math.min(maxLeft, maxRight) - height[i]; // To calculate space for water for current element.
            // Above, taking the minimum from the maxLeft and maxRight because water can be trapped only till the
            // minimum height of either end(left or right) else it will overflow. And then subtracting the height
            // of current element from it to calculate actual remaining units/space for water.
        }

        System.out.println("Trapped water: " + waterUnits + " units.");
    }
}
