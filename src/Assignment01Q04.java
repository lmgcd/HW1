import java.util.Arrays;

public class Assignment01Q04 {

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        int shiftOp = switch (direction) {
            case 'R' -> move;
            case 'L' -> (-1) * move;
            default -> 0;
        };

        if (array.length == 0 || shiftOp == 0)
            return array;

        int cycleStartIdx = 0, replacedVal, currVal = array[0];
        int currIdx = 0, nextIdx;
        for (int i = 0; i < array.length; i++, currIdx = nextIdx, currVal = replacedVal) {
            if (currIdx == cycleStartIdx && i != 0) {
                cycleStartIdx = currIdx = (currIdx + 1) % array.length;
                currVal = array[currIdx];
            }
            nextIdx = ((currIdx + shiftOp) % array.length + array.length) % array.length;
            replacedVal = array[nextIdx];
            array[nextIdx] = currVal;
        }

        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}