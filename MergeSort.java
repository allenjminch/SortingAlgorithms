
import java.util.*;

public class MergeSort {

	public static void main(String[] args) {
		int[] array1 = {2, -1, 3, 4, -2, 6, -7, 49, 2, 8, 5, 1, 4};
		int[] array2 = {9, 8, 2, 10, 6, 5, 1, 3, 14, 4};
		int[] array3 = {9, 10, 12, 9, 6, 9, 10, 7, 12, 9, 10, 6, 9, 6, 10};
		int[] array4 = {7, 9, 12, 10, 6};
		int[] array5 = {3, 10, 65, 8, 45, 23, 9, 24, 18, 58, 69, 9, 2};
		int[] array6 = {2, 6, 4, 3, 7, 1, 5};
		int[] array7 = {85, 21, 43, 51, 68, 48, 24, 18, 91, 86, 1, 10, 35, 45, 16, 19, 14, 93, 99, 42, 57, 15, 23, 38, 50, 28, 84, 27, 67, 
                        58, 44, 3, 6, 17, 22, 30, 33, 36, 47, 71, 29, 61, 73, 97, 4, 20, 83, 13, 90, 7};
		System.out.println(Arrays.toString(mergeSort(array1)));
		System.out.println(Arrays.toString(mergeSort(array2)));
		System.out.println(Arrays.toString(mergeSort(array3)));
		System.out.println(Arrays.toString(mergeSort(array4)));
		System.out.println(Arrays.toString(mergeSort(array5)));
		System.out.println(Arrays.toString(mergeSort(array6)));
		System.out.println(Arrays.toString(mergeSort(array7)));
		int[] array8 = new int[1000];
		Random rand = new Random();
		for (int i = 0; i < 1000; i++) {
			array8[i] = rand.nextInt(1000);
		}
		System.out.println(Arrays.toString(array8));
		array8 = mergeSort(array8);
		for (int i = 0; i < array8.length - 1; i++) {
			if (array8[i] > array8[i + 1]) {
				System.out.println("false");
			}
		}
		System.out.println("true");
	}
	
	private static int[] merge(int[] array1, int[] array2) {
		int[] merged = new int[array1.length + array2.length];
		int index1 = 0;
		int index2 = 0;
		while (index1 < array1.length && index2 < array2.length) {
			if (array1[index1] <= array2[index2]) {
				merged[index1 + index2] = array1[index1];
				index1++;
			} else {
				merged[index1 + index2] = array2[index2];
				index2++;
			}
		}
		if (index1 == array1.length && index2 != array2.length) {
			for (int j = index2; j < array2.length; j++) {
				merged[array1.length + j] = array2[j]; 
			}
		} else if (index2 == array2.length && index1 != array1.length) {
			for (int i = index1; i < array1.length; i++) {
				merged[array2.length + i] = array1[i];
			}
		}
		return merged;
	}
	
	public static int[] subarray(int[] array, int i, int j) {
		if (i < 0 || j > array.length) {
			throw new ArrayIndexOutOfBoundsException();
		} else if (j < i) {
			throw new UnsupportedOperationException();
		} else {
			int[] sub = new int[j - i];
			for (int k = 0; k < j - i; k++) {
				sub[k] = array[i + k];
			}
			return sub;
		}
	}
	
	public static int[] subarray(int[] array, int beginIndex) {
		return subarray(array, beginIndex, array.length);
	}
	
	public static int[] mergeSort(int[] array) {
		if (array.length <= 1) {
			return array;
		} else {
			int middleIndex = array.length / 2;
			int[] left = subarray(array, 0, middleIndex);
			int[] right = subarray(array, middleIndex);
			int[] sortedLeft = mergeSort(left);
			int[] sortedRight = mergeSort(right);
			return merge(sortedLeft, sortedRight);
		}
	}
			
}
