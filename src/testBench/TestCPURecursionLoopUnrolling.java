package testBench;

import bench.IBenchmark;
import bench.cpu.CPURecursionLoopUnrolling;
import timing.ITimer;
import timing.Timer;
import logging.*;

import java.util.ArrayList;

public class TestCPURecursionLoopUnrolling {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        ArrayList<Double> ScoreList = new ArrayList<Double>();
        ArrayList<Double> ScoreListUnrolled = new ArrayList<Double>();


        IBenchmark bench = new CPURecursionLoopUnrolling();
        bench.initialize(1000);
        //bench.warmUp();

        long time;
        timer.start();
        bench.run(true, 5);
        time = timer.pause();
        log.write("The sum is: " + bench.getResult() + " \nCalculated UNROLLED in " + timer.Convert(2, time) +"ms");
        log.write("The score is: " + ((CPURecursionLoopUnrolling)bench).getScore(time) +"\n");
        ScoreListUnrolled.add(((CPURecursionLoopUnrolling)bench).getScore(time));

        timer.resume();
        bench.run(false);
        time = timer.stop();
        log.write("The sum is: " + bench.getResult() + " \nCalculated ROLLED in " + timer.Convert(2, time) +"ms");
        log.write("The score is: " + ((CPURecursionLoopUnrolling)bench).getScore(time)+ "\n");
        ScoreList.add(((CPURecursionLoopUnrolling)bench).getScore(time));

        bench.initialize(2000);

        timer.resume();
        bench.run(true, 5);
        time = timer.pause();
        log.write("The sum is: " + bench.getResult() + " \nCalculated UNROLLED in " + timer.Convert(2, time) +"ms");
        log.write("The score is: " + ((CPURecursionLoopUnrolling)bench).getScore(time) +"\n");
        ScoreListUnrolled.add(((CPURecursionLoopUnrolling)bench).getScore(time));

        timer.resume();
        bench.run(false);
        time = timer.pause();
        log.write("The sum is: " + bench.getResult() + " \nCalculated ROLLED in " + timer.Convert(2, time) +"ms");
        log.write("The score is: " + ((CPURecursionLoopUnrolling)bench).getScore(time)+ "\n");
        ScoreList.add(((CPURecursionLoopUnrolling)bench).getScore(time));

        bench.initialize(5000);

        timer.resume();
        bench.run(true, 5);
        time = timer.pause();
        log.write("The sum is: " + bench.getResult() + " \nCalculated UNROLLED in " + timer.Convert(2, time) +"ms");
        log.write("The score is: " + ((CPURecursionLoopUnrolling)bench).getScore(time) +"\n");
        ScoreListUnrolled.add(((CPURecursionLoopUnrolling)bench).getScore(time));

        timer.resume();
        bench.run(false);
        time = timer.pause();
        log.write("The sum is: " + bench.getResult() + " \nCalculated ROLLED in " + timer.Convert(2, time) +"ms");
        log.write("The score is: " + ((CPURecursionLoopUnrolling)bench).getScore(time)+ "\n");
        ScoreList.add(((CPURecursionLoopUnrolling)bench).getScore(time));

        bench.initialize(7000);

        timer.resume();
        bench.run(true, 5);
        time = timer.pause();
        log.write("The sum is: " + bench.getResult() + " \nCalculated UNROLLED in " + timer.Convert(2, time) +"ms");
        log.write("The score is: " + ((CPURecursionLoopUnrolling)bench).getScore(time) +"\n");
        ScoreListUnrolled.add(((CPURecursionLoopUnrolling)bench).getScore(time));

        timer.resume();
        bench.run(false);
        time = timer.pause();
        log.write("The sum is: " + bench.getResult() + " \nCalculated ROLLED in " + timer.Convert(2, time) +"ms");
        log.write("The score is: " + ((CPURecursionLoopUnrolling)bench).getScore(time)+ "\n");
        ScoreList.add(((CPURecursionLoopUnrolling)bench).getScore(time));

        bench.initialize(10000);

        timer.resume();
        bench.run(true, 10);
        time = timer.pause();
        log.write("The sum is: " + bench.getResult() + " \nCalculated UNROLLED in " + timer.Convert(2, time) +"ms");
        log.write("The score is: " + ((CPURecursionLoopUnrolling)bench).getScore(time) +"\n");
        ScoreListUnrolled.add(((CPURecursionLoopUnrolling)bench).getScore(time));

        timer.resume();
        bench.run(false);
        time = timer.stop();
        log.write("The sum is: " + bench.getResult() + " \nCalculated ROLLED in " + timer.Convert(2, time) +"ms");
        log.write("The score is: " + ((CPURecursionLoopUnrolling)bench).getScore(time)+ "\n");
        ScoreList.add(((CPURecursionLoopUnrolling)bench).getScore(time));

        double averageScore = 0;
        for(Double score: ScoreList){
            averageScore += score;
        }
        System.out.println("The average score is: " + averageScore/ScoreList.size());
        averageScore = 0;
        for(Double score: ScoreListUnrolled){
            averageScore += score;
        }
        System.out.println("The average score UNROLLED is: " + averageScore/ScoreListUnrolled.size());

        bench.clean();
        log.close();
    }
}
