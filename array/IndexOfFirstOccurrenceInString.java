package array;

public class IndexOfFirstOccurrenceInString {
    public static int indexOfFirstOccurrenceInString(String haystack, String needle) {
        int i = 0;
        int j = 0;
        haystack.contains(needle);

        while (i < haystack.length()) {
            j = 0;
            if (haystack.charAt(i) == needle.charAt(j)) {
                while (j < needle.length() && i + j < haystack.length()) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                    j++;
                }
                if (j == needle.length()){
                    return i;
                }
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Testcase 1 (expected 0): " + indexOfFirstOccurrenceInString("sadbutsad", "sad"));
        System.out.println("Testcase 2 (expected -1): " + indexOfFirstOccurrenceInString("leetcode", "leeto"));
        System.out.println("Testcase 3 (expected -1): " + indexOfFirstOccurrenceInString("aaa", "aaaa"));
    }
}
