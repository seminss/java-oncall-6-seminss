package oncall.view;

import oncall.dto.OncallResponse;
import oncall.model.Assignment;

import java.util.StringJoiner;

public class OutputView {
    StringBuilder sb = new StringBuilder();
    StringJoiner sj = new StringJoiner(", ");

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void showOncallResult(OncallResponse response) {
        for (Assignment assignment : response.getAssignments()) {
            System.out.printf("%d월 %d일 %s %s\n", response.getMonth(), assignment.getDetailOfDay().getDay(),
                    assignment.getDetailOfDay().getDayOfWeek().getKoreanDayOfWeek(), assignment.getWorker());
        }
    }
}
