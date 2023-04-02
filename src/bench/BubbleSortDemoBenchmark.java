package bench;

import java.util.Random;

public class BubbleSortDemoBenchmark implements IBenchmark{
	private int size;
	private int[] arr;
	
	public void run() {
		for (int i = 0; i < size - 1; i++)
			for (int j = 0; j < size - i - 1; j++)
				if (arr[j] > arr[j + 1]) {
					// swap arr[j+1] and arr[j]
					int temp = arr[j];
		            arr[j] = arr[j + 1];
		            arr[j + 1] = temp;
		        }
		
	}
	
	public void run(Object ... params) {
	}
	
	public void initialize(Object ...params) {
		Random random = new Random();
		size =(Integer) params[0];
		arr = new int[size];
		
		for(int i = 0; i < size; i++) {
			arr[i] = random.nextInt(1000);
			//System.out.print(arr[i]+" ");
		}
		//System.out.println("");
	
	}
	public void clean() {}
	public void cancel() {}
	public void warmUp() {}
	public String getResult() { return "";}
}