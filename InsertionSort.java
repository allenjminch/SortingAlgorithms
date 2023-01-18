import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

	public static void main(String[] args) {
		int[] array1 = {2, -1, 3, 4, -2, 6, -7, 49, 2, 8, 5, 1, 4};
		int[] array2 = {9, 8, 2, 10, 6, 5, 1, 3, 14, 4};
		int[] array3 = {9, 10, 12, 9, 6, 9, 10, 7, 12, 9, 10, 6, 9, 6, 10};
		int[] array4 = {7, 9, 12, 10, 6};
		int[] array5 = {3, 10, 65, 8, 45, 23, 9, 24, 18, 58, 69, 9, 2};
		int[] array6 = {2, 6, 4, 3, 7, 1, 5};
		int[] array7 = {85, 21, 43, 51, 68, 48, 24, 18, 91, 86, 1, 10, 35, 45, 16, 19, 14, 93, 99, 42, 57, 15, 23, 38, 50, 28, 84, 27, 67, 
				58, 44, 3, 6, 17, 22, 30, 33, 36, 47, 71, 29, 61, 73, 97, 4, 20, 83, 13, 90, 7};
		insertionSort(array1);
		insertionSort(array2);
		insertionSort(array3);
		insertionSort(array4);
		insertionSort(array5);
		insertionSort(array6);
		insertionSort(array7);
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
		System.out.println(Arrays.toString(array3));
		System.out.println(Arrays.toString(array4));
		System.out.println(Arrays.toString(array5));
		System.out.println(Arrays.toString(array6));
		System.out.println(Arrays.toString(array7));
		int[] array8 = new int[1000];
		Random rand = new Random();
		for (int i = 0; i < 1000; i++) {
			array8[i] = rand.nextInt(1000);
		}
		System.out.println(Arrays.toString(array8));
		insertionSort(array8);
		for (int i = 0; i < array8.length - 1; i++) {
			if (array8[i] > array8[i + 1]) {
				System.out.println("false");
			}
		}
		System.out.println("true");
	}
	
	
	public static void insertionSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int value = a[i];
			int j = i;
			while (j > 0 && a[j - 1] > value) {
				a[j] = a[j - 1];
	            j--;
			}
			a[j] = value;
		}
	}

}