package testBench;

import bench.IBenchmark;
import bench.cpu.CPUFixedVsFloatingPoint;
import bench.cpu.CPURecursionLoopUnrolling;
import bench.cpu.CPUThreadedRoots;
import bench.cpu.NumberRepresentation;
import logging.ConsoleLogger;
import logging.ILog;
import timing.ITimer;
import timing.Timer;

public class TestCPUThreadedRoots {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        CPUThreadedRoots bench = new CPUThreadedRoots();
        int n = 10000000;
        bench.initialize(n);
        bench.warmUp();

        timer.start();
        double result = bench.testSquareRootTask(0, 10);
        long time = timer.pause();
        log.write("Finished in", timer.Convert(1, time));
        //log.write("Result is", result);


        timer.resume();
        bench.run(1);
        time = timer.pause();
        log.write("Finished in", timer.Convert(1, time) + "s");
        //log.write("Threaded result is", result);
        double score =  n / (time*1.0)* 1000000;
        log.write("The score is: " +score + "\n");

        timer.resume();
        bench.run(2);
        time = timer.pause();
        log.write("Finished in", timer.Convert(1, time) + "s");
        score =  n / (time*2.0)* 1000000;
        log.write("The score is: " + score + "\n");

        timer.resume();
        bench.run(4);
        time = timer.pause();
        score =  n / (time*4.0)* 1000000;

        log.write("Finished in", timer.Convert(1, time) + "s");
        log.write("The score is: " + score + "\n");

        bench.clean();
        log.close();
    }
}
