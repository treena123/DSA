package performanceMeasurement;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author trinapal
 */
public class MaxFinderMapReduce {
    public static void main(String[] args) {
        int[] largeArray = new Random().ints(10_000_000, 0, 1_000_000).toArray();
        int max1 = findMaxByStream(largeArray);
        int max2 = findMaxByParallelStream(largeArray);
       // int max = findMaxMapReduce(largeArray, 100_000);
    }

    private static int findMaxByParallelStream(int[] largeArray) {
        //good for CPU heavy workloads
        /*
        parallel streams come with overhead: thread management, splitting, and joining. So I’d only use them if benchmarks show benefit. Also, I’d be careful about using streams with boxed types (like Stream<Integer>) because of autoboxing costs.
         For most cases, unless the array is millions of elements
         and we’re hitting performance bottlenecks, the enhanced for loop is still the most efficient and clear."
         */
        /*
        it uses box stream under the hood
         */
        return Arrays.stream(largeArray).parallel().max().getAsInt(); //cost of abstraction (e.g., autoboxing, stream overhead).
    }
    private static int findMaxMapReduce(int[] largeArray, int chunkSize) {
        int n = largeArray.length;
        int numChunks = (int) Math.ceil((double) n / chunkSize);
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        return 0;
    }

    private static int findMaxByStream(int[] largeArray) {
        return Arrays.stream(largeArray).max().getAsInt(); // But as it is single threaded, it would be time consuming for large array
    }
}
