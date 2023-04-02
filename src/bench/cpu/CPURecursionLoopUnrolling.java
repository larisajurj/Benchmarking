package bench.cpu;

import bench.IBenchmark;

public class CPURecursionLoopUnrolling implements IBenchmark {
	private long sum = 0;
	private int size;
	long result = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run(Object... params) {
		boolean isRolling = (boolean)params[0];
		if(isRolling) {
			int unrollLevel = (int)params[1]; //how many iterations will we roll per loop
			sum = 0;
			result = recursiveUnrolled( 0, unrollLevel ,size , 0);
			
		}
		else {
			sum = 0;
			result = recursive(0,  size, 0);
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
	    //System.out.println("Is prime: " + n);
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
	private long recursiveUnrolled(long start, int unrollLevel, long size, int counter) {
		if(start >= size)
			return 0;
		long increase_start= 0;
		for(long i = start; i < start+unrollLevel && i < size; i++, increase_start++) {
			if(isPrime(i))
			{
				sum += i;
				//System.out.println("sum is: " + sum + " (added " + i + ")");
			}
		}

		start += increase_start;
		try{
			recursiveUnrolled(start, unrollLevel, size, counter+1);
		}catch (StackOverflowError e) {
			System.out.println("Reached nr " + start + "/" + size + " after " + counter + " calls.");
			return 0;
		}
		return sum ;
	}
	@Override
	public void initialize(Object... params) {
		this.size = (int)params[0];

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
		return result + "";
	}

}
