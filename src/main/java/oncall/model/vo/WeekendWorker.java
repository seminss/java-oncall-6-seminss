package oncall.model.vo;

import java.util.*;

public class WeekendWorker {
    private final List<String> workers;

    public WeekendWorker(List<String> worker) {
        this.workers = worker;
    }

    public static WeekendWorker of(List<String> worker) {
        return new WeekendWorker(worker);
    }

    public List<String> getWorkers() {
        return workers;
    }
}
