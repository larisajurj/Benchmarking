package bench.cpu;
import java.lang.Math;
import bench.IBenchmark;

public class CPUThreadedRoots implements IBenchmark {

    private double result;
    private int size;
    private boolean running;

    @Override
    public void initialize(Object... params) {
        // save size from params array
        this.size = (int)params[0];
    }

    @Override
    public void warmUp() {
        // call run method: call run() once
        // detect number of cores: Runtime.....availableProcessors();
        run(4);
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException(
                "Method not implemented. Use run(Objects...) instead");
    }

    @Override
    public void run(Object... options) {
        // options[0] -> number of threads
        // ...
        int nThreads= (int) options[0];

        Thread[] threads = new Thread[nThreads];

        final int jobPerThread = (size + nThreads - 1) / nThreads;

        running = true; // flag used to stop all started threads

        for (int i = 0; i < nThreads; ++i) {
            final int start = i * jobPerThread;
            final int end = Math.min(start + jobPerThread, size);

            threads[i] = new Thread(new SquareRootTask(start, end));
            threads[i].start();
        }

        // join threads
        for (int i = 0; i < nThreads; ++i) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // compute total result
        /* double totalResult = 0.0;
        for (int i = 0; i < nThreads; ++i) {
            SquareRootTask task = threads[i].start();
            totalResult += task.getResult();
        }
        this.result = totalResult;*/
    }
    @Override
    public void clean() {
        // only implement if needed
    }
    public void cancel(){

    }

    @Override
    public String getResult() {
        return String.valueOf(result);
    }
    public double testSquareRootTask(int from, int to){
        SquareRootTask task = new SquareRootTask(from, to);
        task.run();
        return task.getResult();
    }
    class SquareRootTask implements Runnable {

        private int from, to;
        private final double precision = 1e-4; // fixed
        private double result = 0.0;

        public SquareRootTask(int from, int to) {
            // save params to class members
            this.from = from;
            this.to = to;
        }

        @Override
        public void run() {
            // compute Newtonian square root on each number from i = 'from' to 'to', and also check 'running'
            // save (+=) each computed square root in the local 'result' variable
            // extra: send 'result' back to main thread and sum up with all results
            for(int i = from; i < to; i++){
                result += getNewtonian(i);
            }


        }

        private double getNewtonian(double x) {
            // ... implement the algorithm for Newton's square root(x) here
            double s = x;
            while(Math.abs(s*s - x) > precision){
                s = (x/s +s)/2;
            }
            return s;
        }

        public double getResult(){
            return result;
        }
        // extra: compute sum, pass it back to wrapper class. Use synchronized
    }

}