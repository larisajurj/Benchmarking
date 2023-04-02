package timing;

public interface ITimer {
	void start();
	long stop();
	void resume();
	long pause();
	float Convert(int s, long time);

}
