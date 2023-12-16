package oncall.dto;

import oncall.exception.OncallException;

public class MonthRequest {

    private final int month;
    private final String koreanDayOfWeek;

    private MonthRequest(String userInput) {
        validateNotEmpty(userInput);
        validateFormat(userInput);
        String[] parts = getParsedArray(userInput);
        this.month = Integer.parseInt(parts[0]);
        this.koreanDayOfWeek = parts[1];
    }

    public static MonthRequest of(String userInput) {
        return new MonthRequest(userInput);
    }

    private void validateFormat(String userInput) {
        //1,금 형태로 숫자,한글 형태인지 검증한다.
    }

    private void validateNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new OncallException("입력값이 없습니다.");
        }
    }

    private String[] getParsedArray(String userInput) {
        return userInput.trim().split(",");
    }

}
