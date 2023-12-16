package oncall.dto;

import oncall.exception.OncallException;

import java.util.*;

public class PeopleRequest {

    private final List<String> people;

    private PeopleRequest(String userInput) {
        this.people = parsePeople(userInput);
    }

    public static PeopleRequest of(String userInput) {
        return new PeopleRequest(userInput);
    }

    private void validateNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new OncallException("입력값이 없습니다.");
        }
    }

    private List<String> parsePeople(String userInput) {
        return Arrays.asList(userInput.split(","));
    }

}
