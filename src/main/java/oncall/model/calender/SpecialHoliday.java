package oncall.model.calender;

import java.util.*;

public enum SpecialHoliday {
    NEW_YEAR(1, 1),
    INDEPENDENCE_MOVEMENT_DAY(3, 1),
    CHILDREN_DAY(5, 5),
    MEMORIAL_DAY(6, 6),
    LIBERATION_DAY(8, 15),
    NATIONAL_FOUNDATION_DAY(10, 3),
    HANGUL_DAY(10, 9),
    CHRISTMAS(12, 25);

    private final int month;
    private final int day;

    SpecialHoliday(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean containDay(int month, int day) {
        for (SpecialHoliday specialHoliday : values()) {
            if (specialHoliday.month == month && specialHoliday.day == day) {
                return true;
            }
        }
        return false;
    }

    public static List<SpecialHoliday> getHolidays(int month) {
        List<SpecialHoliday> specialHolidays = new ArrayList<>();
        for (SpecialHoliday specialHoliday : values()) {
            if (specialHoliday.month == month) {
                specialHolidays.add(specialHoliday);
            }
        }
        return specialHolidays;
    }
}
