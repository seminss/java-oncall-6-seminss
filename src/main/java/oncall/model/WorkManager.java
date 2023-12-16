package oncall.model;

import oncall.model.vo.WeekdayWorker;
import oncall.model.vo.WeekendWorker;

import java.util.*;

public class WorkManager {

    private final List<WorkingAssignment> workingAssignments;

    private WorkManager(WeekdayWorker weekdayWorker, WeekendWorker weekendWorker, List<DetailOfDay> details) {
        this.workingAssignments = makeWorkingAssignments(weekdayWorker, weekendWorker, details);
    }

    private List<WorkingAssignment> makeWorkingAssignments
            (WeekdayWorker weekdayWorker, WeekendWorker weekendWorker, List<DetailOfDay> details) {
        List<WorkingAssignment> workingAssignments = new ArrayList<>();
        List<String> weekdayWorkerList = weekdayWorker.getWorkers();
        List<String> weekendWorkerList = weekendWorker.getWorkers();
        int weekdayWorkerSize = weekdayWorkerList.size();
        int weekendWorkerSize = weekendWorkerList.size();
        int weekdayWorkerIndex = 0;
        int weekendWorkerIndex = 0;
        for (DetailOfDay detailOfDay : details) {
            if (detailOfDay.isHoliday()) {
                workingAssignments.add(new WorkingAssignment(detailOfDay, weekendWorkerList.get(weekendWorkerIndex)));
                weekendWorkerIndex = (weekendWorkerIndex + 1) % weekendWorkerSize;
            } else {
                workingAssignments.add(new WorkingAssignment(detailOfDay, weekdayWorkerList.get(weekdayWorkerIndex)));
                weekdayWorkerIndex = (weekdayWorkerIndex + 1) % weekdayWorkerSize;
            }
        }
        return workingAssignments;
    }

    // TODO: 다 만들어진 Assigment에서 연속되어 근무하는 사람이 있으면 수정해서 반환
    
    public static WorkManager of(WeekdayWorker weekdayWorker, WeekendWorker weekendWorker, List<DetailOfDay> details) {
        return new WorkManager(weekdayWorker, weekendWorker, details);
    }

    public List<WorkingAssignment> getWorkingAssignments() {
        return workingAssignments;
    }

    public static class WorkingAssignment {
        private final DetailOfDay detailOfDay;
        private final String worker;

        public WorkingAssignment(DetailOfDay detailOfDay, String worker) {
            this.detailOfDay = detailOfDay;
            this.worker = worker;
        }
    }

}
