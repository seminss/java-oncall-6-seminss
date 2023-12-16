package oncall.model.calender;

import oncall.exception.ErrorMessage;
import oncall.exception.OncallException;

public enum Week {
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일");

    private final String koreanDayOfWeek;

    Week(String dayOfWeek) {
        this.koreanDayOfWeek = dayOfWeek;
    }

    public String getKoreanDayOfWeek() {
        return koreanDayOfWeek;
    }

    public static Week from(String koreanOfDayOfWeek) {
        for (Week dayOfWeek : values()) {
            if (dayOfWeek.koreanDayOfWeek.equals(koreanOfDayOfWeek)) {
                return dayOfWeek;
            }
        }
        throw new OncallException(ErrorMessage.INVALID_VALUE.getMessage());
    }

    public static Week next(Week dayOfWeek) {
        int nextDayOfWeekIndex = (dayOfWeek.ordinal() + 1) % 7;
        return values()[nextDayOfWeekIndex];
    }

    public boolean isWeekend(Week dayOfWeek) {
        return dayOfWeek == SATURDAY || dayOfWeek == SUNDAY;
    }
}
