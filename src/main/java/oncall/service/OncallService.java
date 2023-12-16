package oncall.service;

import oncall.dto.OncallResponse;
import oncall.dto.MonthRequest;
import oncall.dto.WorkerRequest;
import oncall.model.vo.DetailOfDay;
import oncall.model.Assignment;
import oncall.model.calender.EndOfMonth;
import oncall.model.calender.SpecialHoliday;
import oncall.model.calender.Week;
import oncall.model.vo.Worker;

import java.util.ArrayList;
import java.util.List;

public class OncallService {

    private int month;
    private List<DetailOfDay> detailOfMonth;

    public void makeDetailOfMonth(MonthRequest workingRequest) {
        this.month = workingRequest.getMonth();
        this.detailOfMonth = makeDetails(workingRequest.getMonth(), workingRequest.getKoreanDayOfWeek());
    }

    public OncallResponse showOncallResult(WorkerRequest weekDayWorkingPeople, WorkerRequest weekendWorkingPeople) {
        List<Assignment> assignments = assignOncall(
                new Worker(weekDayWorkingPeople.getWorker(), weekendWorkingPeople.getWorker()), detailOfMonth);
        return new OncallResponse(month, assignments);
    }

    private List<DetailOfDay> makeDetails(int month, String koreanOfDayOfWeek) {
        List<DetailOfDay> details = new ArrayList<>();
        Week dayOfWeek = Week.from(koreanOfDayOfWeek);
        int endDay = EndOfMonth.of(month).getEndDay();
        for (int day = 1; day <= endDay; day++) {
            boolean isHoliday = SpecialHoliday.containDay(month, day) || dayOfWeek.isWeekend(dayOfWeek);
            details.add(new DetailOfDay(month, day, dayOfWeek, isHoliday));
            dayOfWeek = Week.next(dayOfWeek);
        }
        return details;
    }

    public List<Assignment> assignOncall
            (Worker worker, List<DetailOfDay> details) {
        List<Assignment> assignments = new ArrayList<>();
        List<String> weekdayWorkerList = worker.getWeekdayWorkers();
        List<String> weekendWorkerList = worker.getWeekendWorkers();
        int weekdayWorkerSize = weekdayWorkerList.size();
        int weekendWorkerSize = weekendWorkerList.size();
        int weekdayWorkerIndex = 0;
        int weekendWorkerIndex = 0;
        for (DetailOfDay detailOfDay : details) {
            if (detailOfDay.isHoliday()) {
                assignments.add(new Assignment(detailOfDay, weekendWorkerList.get(weekendWorkerIndex)));
                weekendWorkerIndex = (weekendWorkerIndex + 1) % weekendWorkerSize;
            } else {
                assignments.add(new Assignment(detailOfDay, weekdayWorkerList.get(weekdayWorkerIndex)));
                weekdayWorkerIndex = (weekdayWorkerIndex + 1) % weekdayWorkerSize;
            }
        }
        return assignments;
    }

}
