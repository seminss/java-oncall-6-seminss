package oncall.model.vo;

public class WeekendWorker {
    private final String worker;

    private WeekendWorker(String worker) {
        this.worker = worker;
    }

    public static WeekendWorker of(String worker) {
        return new WeekendWorker(worker);
    }

    public String getWorker() {
        return worker;
    }
}
