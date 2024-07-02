package utils;

public class Functions {

    public static String printArr(int[] arr) {
        StringBuilder result = new StringBuilder();

        result.append("[");
        for (int i = 0; i < arr.length; i++) {
            result.append(arr[i]);
            if (i == arr.length - 1) {
                result.append("]");
                break;
            }
            result.append(",");
        }

        return result.toString();
    }

    public void A() {}

    public void testB() {
    }
}
