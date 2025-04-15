package patterns.stringManipulation;


public class _1_RemoveAllOccurrencesOfSubstring {

    public static void main(String[] args) {
        RemoveAllOccurrencesOfSubstringSolution solution = new RemoveAllOccurrencesOfSubstringSolution();
        String text = "daabcbaabcbc"; // Expected output : dab
        String part = "abc";
        System.out.printf("Text : %s\n", text);
        System.out.printf("Part : %s\n", part);
        System.out.printf("Output : %s", solution.removeOccurrences(text, part));
    }
}

class RemoveAllOccurrencesOfSubstringSolution {
    public String removeOccurrences(String s, String part) {
        int index = s.indexOf(part); // returns the first occurrences of part in s.
        if (index != -1) {
            s = s.substring(0, index) + "" + s.substring(index + part.length(), s.length());
            return removeOccurrences(s, part);
        } else return s;
    }
}
