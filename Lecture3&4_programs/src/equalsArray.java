public class equalsArray {

    public boolean equalsArray(int[] a, int[] b) {
        if (a.length == b.length) {
            int i = 0;
            boolean elementsMatch = true;
            while (i < a.length && elementsMatch) {
                if (a[i] != b[i]) {
                    elementsMatch = false;
                }
                i++;
            }
            return elementsMatch;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        equalsArray utils = new equalsArray();
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        int[] array3 = {1, 2, 4};

        System.out.println("array1 equals array2: " + utils.equalsArray(array1, array2)); // true
        System.out.println("array1 equals array3: " + utils.equalsArray(array1, array3)); // false
    }
}
