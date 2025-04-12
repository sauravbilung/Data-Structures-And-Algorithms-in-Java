package patterns.monotonicstack.consecutiveconstraints;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * The **Stock Span Problem** is a financial problem that calculates the span
 * of a stock’s price for a given day.
 *
 * <p>
 * The **span of a stock's price on a given day** is defined as the maximum
 * number of consecutive days (up to the current day) the price has been
 * **less than or equal to the current price**. This includes the current day itself.
 * </p>
 *
 * <h3>Problem Statement:</h3>
 * Given a stream of daily stock prices, find the stock span for each day.
 *
 * <h3>Example:</h3>
 * <pre>
 *  Input:  [100, 80, 60, 70, 60, 75, 85]
 *  Output: [1,   1,  1,  2,  1,  4,  6]
 *  </pre>
 */
public class _1_OnlineStockSpan {

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        int[] stockPrices = {28, 14, 28, 35, 46, 53, 66, 80, 87, 88};
        // Expected output : 1,1,3,4,5,6,7,8,9,10
        for (int stockPrice : stockPrices) {
            System.out.printf("Span of stock %d : %d \n", stockPrice, stockSpanner.next(stockPrice));
        }
    }
}

class StockSpanner {
    private Deque<int[]> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        stack.push(new int[]{price, span});
        return span;
    }
}