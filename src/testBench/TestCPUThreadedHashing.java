package testBench;

import bench.IBenchmark;
import bench.cpu.CPUThreadedHashing;
import logging.ConsoleLogger;
import logging.ILog;
import timing.ITimer;
import timing.Timer;


public class TestCPUThreadedHashing {
    public static void main(String[] args) {

        ITimer timer = new Timer();
        IBenchmark bench = new CPUThreadedHashing();
        ILog log = new ConsoleLogger();

        int maxLength = 10;
        int nThreads = 16;
        int hashCode = 1018655712;
        //int hashCode = 317266982;

        timer.start();
        bench.run(maxLength, nThreads, hashCode);
        long time = timer.stop();
        log.write("Result is", bench.getResult());
        log.write("Time is", timer.Convert(1,time)+ "s");



    }
}
