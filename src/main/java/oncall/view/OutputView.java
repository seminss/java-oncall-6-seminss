package oncall.view;

import oncall.dto.OncallResponse;
import oncall.model.Assignment;

import java.util.StringJoiner;

public class OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void showOncallResult(OncallResponse response) {
        for (Assignment assignment : response.getAssignments()) {
            String dayOfWeekStr = assignment.getDetailOfDay().getDayOfWeek().getKoreanDayOfWeek();
            String holidaySuffix = "";

            if (assignment.isSpecialHoliday() && assignment.getDetailOfDay().isWeekday()) {
                holidaySuffix = "(휴일)";
            }

            System.out.printf("%d월 %d일 %s%s %s" + LINE_SEPARATOR,
                    response.getMonth(),
                    assignment.getDetailOfDay().getDay(),
                    dayOfWeekStr,
                    holidaySuffix,
                    assignment.getWorker());
        }
    }

}
