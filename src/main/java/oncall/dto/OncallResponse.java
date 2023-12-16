package oncall.dto;

import oncall.model.Assignment;
import oncall.model.DetailOfDay;

import java.util.*;

public class OncallResponse {
    private final int month;
    private final List<Assignment> assignments;

    public OncallResponse(int month, List<Assignment> assignments) {
        this.month = month;
        this.assignments = assignments;
    }

    public int getMonth() {
        return month;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }
}
