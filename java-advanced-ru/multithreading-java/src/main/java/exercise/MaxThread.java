package exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// BEGIN
public class MaxThread extends Thread {

    private List<Integer> numbers;
    private Optional<Integer> maxVal;

    public MaxThread(int[] num) {
        this.numbers = Arrays.stream(num).boxed().toList();
    }

    @Override
    public void run() {
        maxVal = numbers.stream().reduce(Integer::max);
    }

    public int getMaxVal() {
        return maxVal.get();
    }
}
// END
