package oncall.model;

import oncall.model.calender.Week;

public class DetailOfDay {

    private final int month; //월
    private final int day; //일
    private final Week dayOfWeek; //요일
    private final boolean isHoliday; //휴일인가요

    public DetailOfDay(int month, int day, Week dayOfWeek, boolean isHoliday) {
        this.month = month;
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

    public boolean isWeekday() {
        return !(dayOfWeek == Week.SATURDAY || dayOfWeek == Week.SUNDAY);
    }

    public int getMonth() {
        return month;
    }
}
