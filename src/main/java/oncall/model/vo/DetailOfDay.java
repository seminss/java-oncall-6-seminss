package oncall.model.vo;

import oncall.exception.ErrorMessage;
import oncall.exception.OncallException;
import oncall.model.calender.EndOfMonth;
import oncall.model.calender.Week;

public class DetailOfDay {

    private final int month; //월
    private final int day; //일
    private final Week dayOfWeek; //요일
    private final boolean isHoliday; //휴일인가요

    public DetailOfDay(int month, int day, Week dayOfWeek, boolean isHoliday) {
        validateMonthRange(month);
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

    public void validateMonthRange(final int month) {
        if (EndOfMonth.isInMonthRange(month)) {
            throw new OncallException(ErrorMessage.INVALID_VALUE.getMessage());
        }
    }

    public void validateDayRange(final int month, final int day) {
        if (EndOfMonth.isInDayRange(month, day)) {
            throw new OncallException(ErrorMessage.INVALID_VALUE.getMessage());
        }
        ;
    }
}
