package patterns.monotonicstack.ngep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _4_DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatureSolution solution = new DailyTemperatureSolution();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73}; // Expected output : 1,1,4,2,1,1,0,0
        System.out.printf("Temperatures %s\n", Arrays.toString(temperatures));
        System.out.printf("Days to warmer temperature : %s", Arrays.toString(solution.dailyTemperatures(temperatures)));
    }
}


class DailyTemperatureSolution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] daysToWarmerTemp = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            // Pop elements while the current temperature is higher than the top of the stack
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int prevIndex = stack.pop();
                daysToWarmerTemp[prevIndex] = i - prevIndex; // Compute the wait time for a warmer temp
            }
            stack.push(i); // Store the index for future comparison
        }
        return daysToWarmerTemp;
    }
}

