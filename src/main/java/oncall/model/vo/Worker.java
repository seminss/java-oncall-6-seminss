package oncall.model.vo;

import oncall.exception.OncallException;

import java.util.*;

public class Worker {
    private final List<String> weekdayWorkers;
    private final List<String> weekendWorkers;

    public Worker(List<String> weekdayWorkers, List<String> weekendWorkers) {
        validateNicknameDuplication(weekdayWorkers, weekendWorkers);
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

    private void validateNicknameDuplication(List<String> weekdayWorkers, List<String> weekendWorkers) {
        Set<String> set = new HashSet<>(weekdayWorkers);
        set.addAll(weekendWorkers);
        if (set.size() != weekdayWorkers.size() + weekendWorkers.size()) {
            throw new OncallException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    private void validateNicknameLength(List<String> workers) {
        for (String worker : workers) {
            if (worker.length() > 5) {
                throw new OncallException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
            }
        }
    }

    private void validateNumberOfWorker(List<String> weekdayWorkers, List<String> weekendWorkers) {
        if (weekdayWorkers.size() + weekendWorkers.size() < 5 || weekdayWorkers.size() + weekendWorkers.size() > 35) {
            throw new OncallException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

}
