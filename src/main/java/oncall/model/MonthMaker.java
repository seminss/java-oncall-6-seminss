package oncall.model;

import oncall.model.calender.EndOfMonth;
import oncall.model.calender.Holiday;
import oncall.model.calender.Week;

import java.util.*;

public class MonthMaker {
    private final int month;
    private final List<DetailOfDay> details;

    public MonthMaker(int month, String korDayOfWeek) {
        this.month = month;
        this.details = makeDetails(korDayOfWeek);
    }

    private List<DetailOfDay> makeDetails(String koreanOfDayOfWeek) {
        List<DetailOfDay> details = new ArrayList<>();
        Week dayOfWeek = Week.from(koreanOfDayOfWeek);
        int endDay = EndOfMonth.of(month).getEndDay();
        for (int day = 1; day <= endDay; day++) {
            boolean isHoliday = Holiday.isHoliday(month, day) || dayOfWeek.isWeekend(dayOfWeek);
            details.add(new DetailOfDay(day, dayOfWeek, isHoliday));
            dayOfWeek = Week.next(dayOfWeek);
        }
        return details;
    }


    public int getMonth() {
        return month;
    }

    public List<DetailOfDay> getDetails() {
        return details;
    }

}
