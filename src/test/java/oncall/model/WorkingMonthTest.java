package oncall.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkingMonthTest {

    @Test
    void test(){
        WorkingMonth workingMonth = new WorkingMonth(5, "월");
        //details 목록을 출력
        for (WorkingMonth.Detail detail : workingMonth.getDetails()) {
            System.out.println(detail.getDay() + " " + detail.getDayOfWeek() + " " + detail.isHoliday());
        }
    }
}