package bench.cpu;

import bench.IBenchmark;

public class CPURecursionLoopUnrolling implements IBenchmark {
	private long sum = 0;
	private int workload;
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run(Object... params) {
		boolean isRolling = (boolean)params[0];
		if(isRolling) {
			int unrollLevel = (int)params[1]; //how many iterations will we roll per loop
			
		}
		else {
			
		}
		

	}
	private boolean isPrime(long n) {
	    if (n <= 1) {
	        return false;
	    }
	    for (int i = 2; i <= Math.sqrt(n); i++) {
	        if (n % i == 0) {
	            return false;
	        }
	    }
	    System.out.println("Is prime: " + n);
	    return true;
	}
	
	 private long recursive(long start, long size, int counter) {
		 if (start > size) {
		        return 0;
		 }
		 
		 if (isPrime(start)) {
			 try {
		        return start + recursive(start + 1, size, counter+1);
			 }catch (StackOverflowError e) {
				 System.out.println("Reached nr " + start + "/" + size + " after " + counter + " calls.");
				 return 0;
			 }

		}
		 
		 try {
			 return recursive(start + 1, size, counter+1);
		 }catch (StackOverflowError e) {
			 System.out.println("Reached nr " + start + "/" + size + " after " + counter + " calls.");
			 return 0;
		 }

	}
	 private long recursiveUnrolled(long start, int unrollLevel, int size, int counter) {
		 if(start > size)
			 return 0;
		 
		 for(long i = start; i <= start + unrollLevel && i<size; i++) {
			 if(isPrime(i))
				 sum = sum + i;
		 }
		 return sum + recursiveUnrolled(start+unrollLevel, unrollLevel, size, counter+1);
		 
	 }
	@Override
	public void initialize(Object... params) {
		

	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void warmUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
	}

}
