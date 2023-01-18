import java.util.Arrays;
import java.util.Random;

public class MSDRadixSort {
	
	public static void main(String[] args) {
	    int[] array1 = {170, 45, 75, 90, 2, 802, 2, 66};
	    int[] array2 = {9, 8, 2, 10, 6, 5, 1, 3, 14, 4};
		int[] array3 = {9, 10, 12, 9, 6, 9, 10, 7, 12, 9, 10, 6, 9, 6, 10};
		int[] array4 = {7, 9, 12, 10, 6};
		int[] array5 = {3, 10, 65, 8, 45, 23, 9, 24, 18, 58, 69, 9, 2};
		int[] array6 = {2, 6, 4, 3, 7, 1, 5};
		int[] array7 = {85, 21, 43, 51, 68, 48, 24, 18, 91, 86, 1, 10, 35, 45, 16, 19, 14, 93, 99, 42, 57, 15, 23, 38, 50, 28, 84, 27, 67, 
                        58, 44, 3, 6, 17, 22, 30, 33, 36, 47, 71, 29, 61, 73, 97, 4, 20, 83, 13, 90, 7};
	    System.out.println(Arrays.toString(MSDradixSort(array1)));
	    System.out.println(Arrays.toString(MSDradixSort(array2)));
		System.out.println(Arrays.toString(MSDradixSort(array3)));
		System.out.println(Arrays.toString(MSDradixSort(array4)));
		System.out.println(Arrays.toString(MSDradixSort(array5)));
		System.out.println(Arrays.toString(MSDradixSort(array6)));
		System.out.println(Arrays.toString(MSDradixSort(array7)));
		int[] array8 = new int[1000];
		Random rand = new Random();
		for (int i = 0; i < 1000; i++) {
			array8[i] = rand.nextInt(1000);
		}
		System.out.println(Arrays.toString(array8));
		array8 = MSDradixSort(array8);
		for (int i = 0; i < array8.length - 1; i++) {
			if (array8[i] > array8[i + 1]) {
				System.out.println("false");
			}
		}
		System.out.println("true");
	}
	
	
	public static int digit(int n, int pos) {
		return (n / ((int) Math.pow(10, pos))) % 10;
	}
	
	private static int[] digitCountingSort(int[] A, int pos, int low, int high) {
		int[] B = new int[high - low + 1];
		int[] C = new int[10];
		for (int i = low; i <= high; i++) {
			int digit = digit(A[i], pos);
			C[digit]++;
		}
		for (int i = 1; i <= 9; i++) {
			C[i] = C[i] + C[i - 1];
		}
		for (int j = high; j >= low; j--) {
			int num = digit(A[j], pos);
			B[C[num] - 1] = A[j];
			C[num]--;
		}
		return B;
	}
	
	public static int findMax(int[] A, int low, int high) {
		int max = A[low];
		for (int i = low + 1; i <= high; i++) {
			if (A[i] > max) {
				max = A[i];
			}
		}
		return max;
	}
	
	public static int numDigits(int n) {
		int result = 1;
		int count = 1;
		while (result * 10 <= n) {
			result = result * 10;
			count++;
		}
		return count;
	}
	
	public static int[] concatenate(int[] front, int[] back) {
		int[] result = new int[front.length + back.length];
		for (int i = 0; i < front.length; i++) {
			result[i] = front[i];
		}
		for (int j = 0; j < back.length; j++) {
			result[front.length + j] = back[j];
		}
		return result;
	}
	
	private static int[] MSDradixSort(int[] A, int low, int high, int w) {
		if (w == 0) {
			int[] result = new int[high - low + 1];
			for (int i = 0; i < result.length; i++) {
				result[i] = A[low];
			}
			return result;
		} else {
		    int[] B = digitCountingSort(A, w - 1, low, high);
		    int k = 0;
		    int start = 0;
		    int end = 0;
		    int[][] bins = new int[A.length][10];
		    int numBins = 0;
		    while (k < B.length - 1) {
		    	if (digit(B[k], w - 1) != digit(B[k + 1], w - 1)) {
		    		end = k;
		    		bins[numBins] = MSDradixSort(B, start, end, w - 1);
		    		start = k + 1;
		    		numBins++;
		    	}
		    	k++;
		    }
		    if (start == 0) {
		    	return B;
		    } else {
		    	bins[numBins] = MSDradixSort(B, start, B.length - 1, w - 1);
		    	int[] result = bins[0];
		    	for (int i = 1; i <= numBins; i++) {
		    		result = concatenate(result, bins[i]);
		    	}
		    	return result;
		    }
		}
	}
	
	public static int[] MSDradixSort(int[] A) {
		return MSDradixSort(A, 0, A.length - 1, numDigits(findMax(A, 0, A.length - 1)));
	}

}
