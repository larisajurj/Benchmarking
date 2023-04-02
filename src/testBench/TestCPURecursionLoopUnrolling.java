package testBench;

import bench.IBenchmark;
import bench.cpu.CPURecursionLoopUnrolling;
import timing.ITimer;
import timing.Timer;
import logging.*;

public class TestCPURecursionLoopUnrolling {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();

        IBenchmark bench = new CPURecursionLoopUnrolling();
        bench.initialize(10000);
        timer.start();
        bench.run(true, 3);
        log.write("The sum is: " + bench.getResult() + " \nCalculated UNROLLED in " + timer.Convert(1, timer.pause()) +"s\n");

        timer.resume();
        bench.run(false);
        log.write("The sum is: " + bench.getResult() + " \nCalculated ROLLED in " + timer.Convert(1, timer.stop()) +"s\n");

        bench.clean();
        log.close();
    }
}
