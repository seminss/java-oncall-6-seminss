package oncall.model;

import org.junit.jupiter.api.Test;

class MonthMakerTest {

    @Test
    void test(){
        MonthMaker monthMaker = new MonthMaker(5, "월");
        //details 목록을 출력
        for (DetailOfDay detail : monthMaker.getDetails()) {
            System.out.println(detail.getDay() + " " + detail.getDayOfWeek() + " " + detail.isHoliday());
        }
    }
}