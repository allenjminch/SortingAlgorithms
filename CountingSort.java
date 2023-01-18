import java.util.Arrays;
import java.util.Random;

public class CountingSort {

	public static void main(String[] args) {
		int[] array1 = {2, -1, 3, 4, -2, 6, -7, 49, 2, 8, 5, 1, 4};
		int[] array2 = {9, 8, 2, 10, 6, 5, 1, 3, 14, 4};
		int[] array3 = {9, 10, 12, 9, 6, 9, 10, 7, 12, 9, 10, 6, 9, 6, 10};
		int[] array4 = {7, 9, 12, 10, 6};
		int[] array5 = {3, 10, 65, 8, 45, 23, 9, 24, 18, 58, 69, 9, 2};
		int[] array6 = {2, 6, 4, 3, 7, 1, 5};
		int[] array7 = {85, 21, 43, 51, 68, 48, 24, 18, 91, 86, 1, 10, 35, 45, 16, 19, 14, 93, 99, 42, 57, 15, 23, 38, 50, 28, 84, 27, 67, 
                        58, 44, 3, 6, 17, 22, 30, 33, 36, 47, 71, 29, 61, 73, 97, 4, 20, 83, 13, 90, 7};
		System.out.println(Arrays.toString(countingSort(array1)));
		System.out.println(Arrays.toString(countingSort(array2)));
		System.out.println(Arrays.toString(countingSort(array3)));
		System.out.println(Arrays.toString(countingSort(array4)));
		System.out.println(Arrays.toString(countingSort(array5)));
		System.out.println(Arrays.toString(countingSort(array6)));
		System.out.println(Arrays.toString(countingSort(array7)));
		int[] array8 = new int[1000];
		Random rand = new Random();
		for (int i = 0; i < 1000; i++) {
			array8[i] = rand.nextInt(1000);
		}
		System.out.println(Arrays.toString(array8));
		array8 = countingSort(array8);
		for (int i = 0; i < array8.length - 1; i++) {
			if (array8[i] > array8[i + 1]) {
				System.out.println("false");
			}
		}
		System.out.println("true");
	}
	
	public static int[] countingSort(int[] A, int k) {
		int[] B = new int[A.length];
		int[] C = new int[k + 1];
		for (int i = 0; i < A.length; i++) {
			C[A[i]]++;
		}
		for (int i = 1; i <= k; i++) {
			C[i] = C[i] + C[i - 1];
		}
		for (int j = A.length - 1; j >= 0; j--) {
			B[C[A[j]] - 1] = A[j];
			C[A[j]]--;
		}
		return B;
	}
	
	public static int[] countingSort(int[] A) {
		int min = A[0];
		int max = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] < min) {
				min = A[i];
			}
			if (A[i] > max) {
				max = A[i];
			}
		}
		for (int j = 0; j < A.length; j++) {
			A[j] -= min;
		}
		int[] B = countingSort(A, max - min);
		for (int k = 0; k < B.length; k++) {
			B[k] += min;
		}
		return B;
	}
				
}
