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
        long time;
        timer.start();
        bench.run(true, 10);
        time = timer.pause();
        log.write("The sum is: " + bench.getResult() + " \nCalculated UNROLLED in " + timer.Convert(1, time) +"s\n");
        log.write("The score is: " + ((CPURecursionLoopUnrolling)bench).getScore(time) +"\n");

        timer.resume();
        bench.run(false);
        time = timer.stop();
        log.write("The sum is: " + bench.getResult() + " \nCalculated ROLLED in " + timer.Convert(1, time) +"s\n");
        log.write("The score is: " + ((CPURecursionLoopUnrolling)bench).getScore(time)+ "\n");
        bench.clean();
        log.close();
    }
}
