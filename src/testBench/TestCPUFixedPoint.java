package testBench;
import bench.*;
import bench.cpu.CPUFixedPoint;
import logging.ConsoleLogger;
import logging.ILog;
import timing.ITimer;
import timing.Timer;
import bench.cpu.FixedPointTest;

public class TestCPUFixedPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ITimer timer = new Timer();
		ILog log = new ConsoleLogger();
		IBenchmark bench = new CPUFixedPoint();
		
		final int workload = 900000;
		bench.initialize(workload);
		bench.warmUp();
		long time;
		
		timer.start();
		bench.run(FixedPointTest.ARITHMETIC);
		time = timer.pause();
		log.write("MOPS for arithmetic test = " + ((CPUFixedPoint)bench).getOp()*workload/timer.Convert(1, time)/1000000);
		//log.write("Time = " + timer.Convert(1, time));
		
		timer.resume();
		bench.run(FixedPointTest.BRANCHING);
		time = timer.pause();
		log.write("MOPS for branching test = " + ((CPUFixedPoint)bench).getOp()*workload/timer.Convert(1, time)/1000000);
		//log.write("Time = " + timer.Convert(1, time));
		
		timer.resume();
		bench.run(FixedPointTest.ARRAY_OPERATIONS);
		time = timer.stop();
		log.write("MOPS for array operations test = " + ((CPUFixedPoint)bench).getOp()*workload/timer.Convert(1, time)/1000000);
		//log.write("Time = " + timer.Convert(1, time));

	}

}
