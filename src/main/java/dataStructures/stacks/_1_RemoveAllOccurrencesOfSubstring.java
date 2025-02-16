package dataStructures.stacks;

public class _1_RemoveAllOccurrencesOfSubstring {

    public static void main(String[] args) {
        RemoveAllOccurrencesOfSubstringSolution solution = new RemoveAllOccurrencesOfSubstringSolution();
        String text = "daabcbaabcbc"; // Expected output: "dab"
        String part = "abc";
        System.out.printf("Text : %s\n", text);
        System.out.printf("Part : %s\n", part);
        System.out.printf("Output : %s", solution.removeOccurrences(text, part));
    }
}

class RemoveAllOccurrencesOfSubstringSolution {
    public String removeOccurrences(String text, String part) {
            char[] stack = new char[text.length()];
            int stackLength = 0;
            int partLength = part.length();

            for (char ch : text.toCharArray()) {
                stack[stackLength++] = ch;

                if (stackLength >= partLength) {
                    boolean match = true;
                    for (int i = 0; i < partLength; i++) {
                        if (stack[stackLength - partLength + i] != part.charAt(i)) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        stackLength -= partLength; // Remove the matched part
                    }
                }
            }

            return new String(stack, 0, stackLength);
    }
}
