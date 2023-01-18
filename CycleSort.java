
import java.util.*;

public class CycleSort {

	public static void main(String[] args) {
		int[] array1 = {2, -1, 3, 4, -2, 6, -7, 49, 2, 8, 5, 1, 4};
		int[] array2 = {9, 8, 2, 10, 6, 5, 1, 3, 14, 4};
		int[] array3 = {9, 10, 12, 9, 6, 9, 10, 7, 12, 9, 10, 6, 9, 6, 10};
		int[] array4 = {7, 9, 12, 10, 6};
		int[] array5 = {3, 10, 65, 8, 45, 23, 9, 24, 18, 58, 69, 9, 2};
		int[] array6 = {2, 6, 4, 3, 7, 1, 5};
		int[] array7 = {85, 21, 43, 51, 68, 48, 24, 18, 91, 86, 1, 10, 35, 45, 16, 19, 14, 93, 99, 42, 57, 15, 23, 38, 50, 28, 84, 27, 67, 
		                58, 44, 3, 6, 17, 22, 30, 33, 36, 47, 71, 29, 61, 73, 97, 4, 20, 83, 13, 90, 7};
		cycleSort(array1);
		cycleSort(array2);
		cycleSort(array3);
		cycleSort(array4);
		cycleSort(array5);
	    cycleSort(array6);
	    cycleSort(array7);
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
		cycleSort(array8);
		for (int i = 0; i < array8.length - 1; i++) {
			if (array8[i] > array8[i + 1]) {
				System.out.println("false");
			}
		}
		System.out.println("true");
	}
	
	public static void swap(int[] array, int i, int j) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}
	
	
	public static Map<Integer, Integer> createFrequencyMap(int[] array) {
		HashMap<Integer, Integer> frequencies = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			int element = array[i];
			if (!frequencies.containsKey(element)) {
				frequencies.put(element, 1);
			} else {
				frequencies.put(element, frequencies.get(element) + 1);
			}
		}
		return frequencies;
	}
	
	public static int sortedPosition(int[] array, int element) {
		int lesserCount = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < element) {
				lesserCount++;
			}
		}
		return lesserCount;
	}
	
	public static void cycleSort(int[] array) {
		Map<Integer, Integer> frequencyMap = createFrequencyMap(array);
		int startIndex = 0;
		boolean finished = false;
		while (!finished) {
			int targetPosition = sortedPosition(array, array[startIndex]);
			while (targetPosition > startIndex || targetPosition  <= startIndex - frequencyMap.get(array[startIndex])) {
				while (array[targetPosition] == array[startIndex]) {
					targetPosition++;
				}
				swap(array, startIndex, targetPosition);
				targetPosition = sortedPosition(array, array[startIndex]);
			}
			startIndex++;
			if (startIndex == array.length) {
				finished = true;
			}
		}
	}

}
