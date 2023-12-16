package oncall.model.vo;

import oncall.exception.OncallException;

import java.util.*;

public class Worker {

    private final List<String> weekdayWorkers;
    private final List<String> weekendWorkers;

    public Worker(List<String> weekdayWorkers, List<String> weekendWorkers) {
        this.weekdayWorkers = weekdayWorkers;
        this.weekendWorkers = weekendWorkers;
    }

    public static Worker of(List<String> weekdayWorkers, List<String> weekendWorkers) {
        return new Worker(weekdayWorkers, weekendWorkers);
    }

    public List<String> getWeekendWorkers() {
        return weekendWorkers;
    }

    public List<String> getWeekdayWorkers() {
        return weekdayWorkers;
    }


}
