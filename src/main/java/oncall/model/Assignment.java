package oncall.model;
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
}