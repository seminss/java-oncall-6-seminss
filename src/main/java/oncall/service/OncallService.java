package oncall.service;

import oncall.dto.OncallResponse;
import oncall.dto.MonthRequest;
import oncall.dto.PeopleRequest;
import oncall.model.DetailOfDay;
import oncall.model.Assignment;
import oncall.model.calender.EndOfMonth;
import oncall.model.calender.SpecialHoliday;
import oncall.model.calender.Week;
import oncall.model.vo.WeekdayWorker;
import oncall.model.vo.WeekendWorker;

import java.util.ArrayList;
import java.util.List;

public class OncallService {

    public OncallResponse showOncallResult(MonthRequest workingRequest
            , PeopleRequest weekDayWorkingPeople, PeopleRequest weekendWorkingPeople) {
        List<DetailOfDay> details = makeDetails(workingRequest.getMonth(), workingRequest.getKoreanDayOfWeek());
        List<Assignment> assignments = assignOncall(new WeekdayWorker(weekDayWorkingPeople.getPeople()),
                new WeekendWorker(weekendWorkingPeople.getPeople()), details);
        return new OncallResponse(workingRequest.getMonth(), assignments);
    }

    private List<DetailOfDay> makeDetails(int month, String koreanOfDayOfWeek) {
        List<DetailOfDay> details = new ArrayList<>();
        Week dayOfWeek = Week.from(koreanOfDayOfWeek);
        int endDay = EndOfMonth.of(month).getEndDay();
        for (int day = 1; day <= endDay; day++) {
            boolean isHoliday = SpecialHoliday.isHoliday(month, day) || dayOfWeek.isWeekend(dayOfWeek);
            details.add(new DetailOfDay(day, dayOfWeek, isHoliday));
            dayOfWeek = Week.next(dayOfWeek);
        }
        return details;
    }

    public List<Assignment> assignOncall
            (WeekdayWorker weekdayWorker, WeekendWorker weekendWorker, List<DetailOfDay> details) {
        List<Assignment> assignments = new ArrayList<>();
        List<String> weekdayWorkerList = weekdayWorker.getWorkers();
        List<String> weekendWorkerList = weekendWorker.getWorkers();
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
