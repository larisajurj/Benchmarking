package testBench;


import timing.*;

import bench.*;
import bench.cpu.CPUDigitsOfPi;
import logging.ConsoleLogger;
import logging.ILog;
import logging.*;

public class TestCPUDigitsOfPi {
	public static void main(String args[]){
	IBenchmark bench = new CPUDigitsOfPi();
	ILog log = new FileLogger("");
	ILog console = new ConsoleLogger();
		

	
	bench.warmUp();
	System.out.println("Finished warming up");
	ITimer timer = new Timer();
	
	timer.start();
	timer.resume();
	bench.run(50);
	long time = timer.pause();
	log.write(timer.Convert(1,time));
	console.write("Iterations " + 50 + ":", timer.Convert(1,time), "s");
	
	timer.resume();
	bench.run(100);
	time = timer.pause();
	log.write(timer.Convert(1,time));
	//console.write("Iterations " + 100 + ":", timer.Convert(1,time), "s");
	
	timer.resume();
	bench.run(500);
	time = timer.pause();
	log.write(timer.Convert(1,time));
	//console.write("Iterations " + 500 + ":", timer.Convert(1,time), "s");
	
	timer.resume();
	bench.run(1000);
	time = timer.pause();
	log.write(timer.Convert(1,time));
	//console.write("Iterations " + 500 + ":", timer.Convert(1,time), "s");
	
	timer.resume();
	bench.run(5000);
	time = timer.pause();
	log.write(timer.Convert(1,time));
	//console.write("Iterations " + 5000 + ":", timer.Convert(1,time), "s");
	
	timer.resume();
	bench.run(10000);
	time = timer.pause();
	log.write(timer.Convert(1,time));
	//console.write("Iterations " + 10000 + ":", timer.Convert(1,time), "s");
	
	timer.resume();
	bench.run(20000);
	time = timer.pause();
	log.write(timer.Convert(1,time));
	//console.write("Iterations " + 50000 + ":", timer.Convert(1,time), "s");
	
	timer.resume();
	bench.run(30000);
	time = timer.pause();
	log.write(timer.Convert(1,time));
	//console.write("Iterations " + 100000 + ":", timer.Convert(1,time), "s");
	timer.resume();
	bench.run(40000);
	time = timer.pause();
	log.write(timer.Convert(1,time));
	//console.write("Iterations " + 100000 + ":", timer.Convert(1,time), "s");
	
	timer.resume();
	bench.run(50000);
	time = timer.pause();
	log.write(timer.Convert(1,time));
	//console.write("Iterations " + 100000 + ":", timer.Convert(1,time), "s");
	
	System.out.println("Finished in" + timer.Convert(1,timer.stop()) +"s");
	log.close();
	}
}
