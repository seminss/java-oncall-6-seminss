package oncall.model.vo;

import oncall.exception.ErrorMessage;
import oncall.exception.OncallException;

import java.util.*;

public class Worker {
    private final List<String> weekdayWorkers;
    private final List<String> weekendWorkers;

    public Worker(List<String> weekdayWorkers, List<String> weekendWorkers) {
        validateNicknameLength(weekdayWorkers);
        validateNicknameLength(weekendWorkers);
        validateNumberOfWorker(weekdayWorkers, weekendWorkers);
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

    private void validateNicknameLength(List<String> workers) {
        for (String worker : workers) {
            if (worker.length() > 5) {
                throw new OncallException(ErrorMessage.INVALID_VALUE.getMessage());
            }
        }
    }

    private void validateNumberOfWorker(List<String> weekdayWorkers, List<String> weekendWorkers) {
        if (weekdayWorkers.size() + weekendWorkers.size() < 5 || weekdayWorkers.size() + weekendWorkers.size() > 35) {
            throw new OncallException(ErrorMessage.INVALID_VALUE.getMessage());
        }
    }

}
