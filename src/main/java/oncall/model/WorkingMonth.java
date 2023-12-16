package oncall.model;

import java.util.*;

public class WorkingMonth {
    private final int month;
    private final List<Detail> details;

    public WorkingMonth(int month, String korDayOfWeek) {
        this.month = month;
        this.details = makeDetails(korDayOfWeek);
    }

    private List<Detail> makeDetails(String koreanOfDayOfWeek) {
        List<Detail> details = new ArrayList<>();
        Week dayOfWeek = Week.from(koreanOfDayOfWeek);
        int endDay = EndOfMonth.of(month).getEndDay();
        for (int day = 1; day <= endDay; day++) {
            boolean isHoliday = Holiday.isHoliday(month, day);
            details.add(new Detail(day, dayOfWeek, isHoliday));
            dayOfWeek = Week.next(dayOfWeek);
        }
        return details;
    }

    public class Detail {
        private final int day;
        private final Week dayOfWeek;
        private final boolean isHoliday;

        public Detail(int day, Week dayOfWeek, boolean isHoliday) {
            this.day = day;
            this.dayOfWeek = dayOfWeek;
            this.isHoliday = isHoliday;
        }

        public int getDay() {
            return day;
        }

        public Week getDayOfWeek() {
            return dayOfWeek;
        }

        public boolean isHoliday() {
            return isHoliday;
        }
    }
}
