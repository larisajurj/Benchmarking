package bench.cpu;

import bench.IBenchmark;

public class CPUFixedPoint implements IBenchmark {
	private int workload;
	private int[] num;
	private int j, k, l, i;
	private double op;
	private int a[];
	private int b[];
	private int c[];
;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Give as argument the type of test: ARITHMETIC, BRANCHING, ARRAY_OPERATIONS");
	}

	@Override
	public void run(Object... params) {
		switch ((FixedPointTest) params[0]) {
		case ARITHMETIC:
			ArithmeticTest();
			op = 18.0;
			break;
		case BRANCHING:
			BranchingTest();
			op = 15.0;
			break;
		case ARRAY_OPERATIONS:
			ArrayOperationsTest();
			op = 15.0;
			break;
		default:
			break;
		}
		
	}

	@Override
	public void initialize(Object... params) {
		this.workload = (int)params[0];
		a = new int[workload];
		b = new int[workload];
		c = new int[workload];
		int[] num2 = {0, 1, 2, 3, 4};
		num = num2;
		j = 0; k = 0; l = 0; i = 0;

	}

	public void ArithmeticTest() {
		//18 mops
		for(i = 0; i < workload; i++) {
			j = i * 7 ;
			k = (j + 2) * (i + 7);
			l = j * 9 + k * 2 + (i + k)/3;
		}
	}
	public void BranchingTest() {
		//15 mops
		for(i = 0; i < workload; i++) {
			if(i == 1) {
				j = num[0];
			}else
				j = num[1];
			if(i >= 2) {
				j = num[2];
			}else
				j = num[3];
			if(i < 10) {
				j = num[4];
			}else
				j = num[0];
			if(i > 10 ) {
				j = num[1];
			}else
				j = num[2];
		}
	}
	public void ArrayOperationsTest() {
		//15 mops
		for(i = 0 ; i < workload; i++) {
			a[i] = i;
			b[i] = i * (-1);
		}
		for(i = 0 ; i < workload; i++) {
			c[i] = b[a[i]];
		}
		
	}
	public double getOp() {
		return op;
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
		for(i = 0; i < 1000; i++) {
			j = i * 7 ;
			k = (j + 2) * (i + 7);
			l = j * 9 + k * 2 + (i + k)/3;
		}
		for(i = 0; i < 1000; i++) {
			if(i == 1) {
				j = num[0];
			}else
				j = num[1];
			if(i >= 2) {
				j = num[2];
			}else
				j = num[3];
			if(i < 10) {
				j = num[4];
			}else
				j = num[0];
			if(i > 10 ) {
				j = num[1];
			}else
				j = num[2];
		}
		for(i = 0 ; i < 1000; i++) {
			a[i] = i;
			b[i] = i * (-1);
		}
		for(i = 0 ; i < 1000; i++) {
			c[i] = b[a[i]];
		}
		
	}


	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
