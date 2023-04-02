package timing;

public class Timer implements ITimer{
	private long startTime;
    private long savedTime;
    private boolean running;
    
    public Timer() {
        running = false;
    }
    
    public void start() {
        savedTime = 0;
        startTime = System.nanoTime();
        running = true;
    }
    
    public long stop() {
        if (!running) {
            return savedTime;
        }
        long currentTime = System.nanoTime();
        savedTime += currentTime - startTime;
        running = false;
        return savedTime;
    }
    
    public void resume() {
        if (running) {
            return;
        }
        startTime = System.nanoTime();
        running = true;
    }
    
    public long pause() {
        if (!running) {
            return savedTime;
        }
        long currentTime = System.nanoTime();
        savedTime += currentTime - startTime;
        long toReturn = currentTime - startTime;
        startTime = currentTime;
        //return savedTime;
        return toReturn;
    }
    public float Convert(int s, long time) {
		if(s == 0) {
			//nanoseconds
			return time;
		}else
			if(s == 1) {
				return (float)time/1000000000;
				//seconds
		}else
			if(s == 2) {
				//miliseconds
				return (float)time/1000000;
		}else {
			System.out.println("\nChoose between 0 for ns, 1 for s or 2 for ms");
			return -1;
		}
	}
}
