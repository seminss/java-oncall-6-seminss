package oncall.model.vo;

import java.util.*;

public class WeekdayWorker {

    private final List<String> workers;

    public WeekdayWorker(List<String> workers) {
        this.workers = workers;
    }

    public static WeekdayWorker of(List<String> workers) {
        return new WeekdayWorker(workers);
    }

    public List<String> getWorkers() {
        return workers;
    }
}
