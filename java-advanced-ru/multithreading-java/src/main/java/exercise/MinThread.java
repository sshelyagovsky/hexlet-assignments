package exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// BEGIN
public class MinThread extends Thread{

    private List<Integer> numbers;
    private Optional<Integer> minVal;

    public MinThread(int[] num) {
        this.numbers = Arrays.stream(num).boxed().toList();
    }

    @Override
    public void run() {
        minVal = numbers.stream().reduce(Integer::min);
    }

    public int getMinVal() {
        return minVal.get();
    }
}
// END
