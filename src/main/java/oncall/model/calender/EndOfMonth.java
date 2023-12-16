package oncall.model.calender;

import oncall.exception.ErrorMessage;
import oncall.exception.OncallException;

public enum EndOfMonth {
    JANUARY(1, 31),
    FEBRUARY(2, 28),
    MARCH(3, 31),
    APRIL(4, 30),
    MAY(5, 31),
    JUNE(6, 30),
    JULY(7, 31),
    AUGUST(8, 31),
    SEPTEMBER(9, 30),
    OCTOBER(10, 31),
    NOVEMBER(11, 30),
    DECEMBER(12, 31);

    private final int month;

    private final int endDay;

    EndOfMonth(int month, int endDay) {
        this.month = month;
        this.endDay = endDay;
    }

    public static EndOfMonth of(int month) {
        for (EndOfMonth endOfMonth : values()) {
            if (endOfMonth.month == month) {
                return endOfMonth;
            }
        }
        throw new OncallException(ErrorMessage.INVALID_VALUE.getMessage());
    }

    public int getMonth() {
        return month;
    }

    public int getEndDay() {
        return endDay;
    }
}
