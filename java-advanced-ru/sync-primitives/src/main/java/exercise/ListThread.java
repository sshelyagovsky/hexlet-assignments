package exercise;

import java.util.List;

// BEGIN
public class ListThread extends Thread {

    private final SafetyList list;

    public ListThread(SafetyList safetyList) {
        this.list = safetyList;
    }

    @Override
    public void run() {
        for(var i = 0; i < 1000; i++ ) {

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            this.list.add(i);
        }
    }
}
// END
