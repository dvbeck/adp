package nl.han.adp.utility;

public class Measurement {
    public static long measureElapsedTimeOfTargetCode(Runnable target) {
        long start = System.nanoTime();
        target.run();
        return System.nanoTime() - start;
    }

}
