package dataStructures.stacks;

public class _3_EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        EvalRPNSolution solution = new EvalRPNSolution();
        int result = solution.evalRPN(tokens);
        System.out.printf("Result : %d", result);
    }
}

class EvalRPNSolution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int idx = 0;

        for (String token : tokens) {
            switch (token) {
                case "+" -> stack[--idx - 1] += stack[idx];
                case "-" -> stack[--idx - 1] -= stack[idx];
                case "*" -> stack[--idx - 1] *= stack[idx];
                case "/" -> stack[--idx - 1] /= stack[idx];
                default -> stack[idx++] = Integer.parseInt(token);
            }
        }

        return stack[0];
    }
}