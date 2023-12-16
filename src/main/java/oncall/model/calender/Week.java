package oncall.model.calender;

import oncall.exception.OncallException;

public enum Week {
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일");

    private final String dayOfWeek;

    Week(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public static Week from(String koreanOfDayOfWeek) {
        for (Week dayOfWeek : values()) {
            if (dayOfWeek.dayOfWeek.equals(koreanOfDayOfWeek)) {
                return dayOfWeek;
            }
        }
        throw new OncallException("요일을 잘못 입력하셨습니다.");
    }

    public static Week next(Week dayOfWeek) {
        int nextDayOfWeekIndex = (dayOfWeek.ordinal() + 1) % 7;
        return values()[nextDayOfWeekIndex];
    }

    public boolean isWeekend(Week dayOfWeek) {
        return dayOfWeek == SATURDAY || dayOfWeek == SUNDAY;
    }
}
