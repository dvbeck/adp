package nl.han.adp.utility;

public class Measurement {
    public static long measureElapsedTimeOfTargetCode(Runnable target) {
        long start = System.nanoTime();
        target.run();
        return System.nanoTime() - start;
    }

    public static void outputDuration(long elapsedTimeOfTargetCode) {
        System.out.println(String.format("Target code executed in: \n-%,d nanoseconds\n-%,d microseconds\n-%,d milliseconds\n\n", elapsedTimeOfTargetCode, elapsedTimeOfTargetCode / 1000, elapsedTimeOfTargetCode / 1000000));
    }

    public static void outputDuration(int elapsedTimeOfTargetCode, String text) {
        System.out.println(String.format("Target code for %s executed in: \n-%,d nanoseconds\n-%,d microseconds\n-%,d milliseconds\n\n", text, elapsedTimeOfTargetCode, elapsedTimeOfTargetCode / 1000, elapsedTimeOfTargetCode / 1000000));

    }
}
