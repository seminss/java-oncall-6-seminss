package oncall.model.vo;

import java.util.*;

public class WeekdayWorker {
    List<String> workerList = new ArrayList<>();

    private WeekdayWorker(List<String> workerList) {
        this.workerList = workerList;
    }

    public static WeekdayWorker of(List<String> workerList) {
        return new WeekdayWorker(workerList);
    }

    public List<String> getWorkerList() {
        return workerList;
    }
}
