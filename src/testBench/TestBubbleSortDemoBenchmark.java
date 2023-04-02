package testBench;

import bench.IBenchmark;
import bench.SleepDemoBenchmark;
import logging.ConsoleLogger;
import logging.ILog;
import timing.ITimer;
import timing.Timer;

public class TestBubbleSortDemoBenchmark{
	public static void main(String args[]) {
		ITimer timer = new Timer();
		ILog log = new ConsoleLogger();
		IBenchmark bench = new SleepDemoBenchmark();
		
		final int workload = 500;
		bench.initialize(workload);
		timer.start();
		for(int i = 0; i < 12; ++i) {
			timer.resume();
			bench.run();
			long time = timer.pause();
			
			log.write("Run " + i + ":", timer.Convert(1, time), "s");
		}
		log.write("Finished in", timer.Convert(1,timer.stop()), "s");
	}
}