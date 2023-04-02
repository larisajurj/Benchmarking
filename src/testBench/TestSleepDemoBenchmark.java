package testBench;

import bench.IBenchmark;
import bench.SleepDemoBenchmark;
import logging.ConsoleLogger;
import logging.ILog;
import timing.ITimer;
import timing.Timer;

public class TestSleepDemoBenchmark {

	public static void main(String[] args) {
		ITimer timer = new Timer();
		ILog log = new ConsoleLogger();
		IBenchmark bench = new SleepDemoBenchmark();
		int n = 500;
		bench.initialize(n);
		timer.start();
		bench.run();
		long time = timer.stop();
		log.write("\nFinished in", time, "ns");
		log.write("\nFinished in " + timer.Convert(1,time), "s");
		System.out.println("The offset is: " + 100*(time - n * 1000000)/(n*1000000));
		log.close();
		bench.clean();

	}

}
