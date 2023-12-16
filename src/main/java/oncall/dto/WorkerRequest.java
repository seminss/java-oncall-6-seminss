package oncall.dto;

import oncall.exception.ErrorMessage;
import oncall.exception.OncallException;

import java.util.*;

public class WorkerRequest {

    private final List<String> worker;

    private WorkerRequest(String userInput) {
        validateNotEmpty(userInput);
        List<String> names = parseName(userInput);
        validateDuplication(parseName(userInput));
        this.worker = names;
    }

    public static WorkerRequest of(String userInput) {
        return new WorkerRequest(userInput);
    }

    public List<String> getWorker() {
        return worker;
    }

    private void validateNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new OncallException(ErrorMessage.INVALID_VALUE.getMessage());
        }
    }

    private List<String> parseName(String userInput) {
        return Arrays.asList(userInput.split(","));
    }

    public void validateDuplication(List<String> workers) {
        Set<String> set = new HashSet<>(workers);
        if (set.size() != workers.size()) {
            throw new OncallException(ErrorMessage.INVALID_VALUE.getMessage());
        }
    }
}
