package exercise;

import java.util.ArrayList;
import java.util.List;

public class SafetyList {
    // BEGIN
    private final List<Integer> list;

    public SafetyList() {
        this.list = new ArrayList<Integer>();
    }

    public int getSize() {
        return list.size();
    }


    public int get(int index) {
        return list.get(index);
    }


    public synchronized void add(int num) {
        this.list.add(num);
    }
    // END
}
