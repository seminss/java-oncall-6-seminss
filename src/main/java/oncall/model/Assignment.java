package oncall.model;

import oncall.model.calender.SpecialHoliday;
import oncall.model.vo.DetailOfDay;

public class Assignment {
    private final DetailOfDay detailOfDay;
    private final String worker;

    public Assignment(DetailOfDay detailOfDay, String worker) {
        this.detailOfDay = detailOfDay;
        this.worker = worker;
    }

    public DetailOfDay getDetailOfDay() {
        return detailOfDay;
    }

    public String getWorker() {
        return worker;
    }

    public boolean isSpecialHoliday() {
        return SpecialHoliday.containDay(detailOfDay.getMonth(), detailOfDay.getDay());
    }
}