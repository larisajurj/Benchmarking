package bench;

public class SleepDemoBenchmark implements IBenchmark {
	private int n;

	@Override
	public void run() {
		try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void run(Object... params) {
		// TODO Auto-generated method stub
		try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

	}

	@Override
	public void initialize(Object... params) {
		this.n = (Integer)params[0];

	}
	public void warmUp() {};


	@Override
	public void clean() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub

	}
	public void printOffset(int stoptime) {
		System.out.println("The offset is: " + 100*(stoptime - n * 1000000)/(n*1000000));
	}

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
	}

}
