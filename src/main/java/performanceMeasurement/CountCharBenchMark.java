package performanceMeasurement;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

/**
 * @author trinapal
 */
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class CountCharBenchMark {
    private String input;
    private char target;


    @Setup
    public void setup(){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 100_000; i++) {
            sb.append((char) ('a' + random.nextInt(26)));
        }
        input = sb.toString();
        target = 'e';
    }

    @Benchmark
    public long countWithStreams() {
        return input.chars().filter(c -> c == target).count();
    }
    @Benchmark
    public long countWithLoop() {
        long count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == target) {
                count++;
            }
        }
        return count;
    }
}
