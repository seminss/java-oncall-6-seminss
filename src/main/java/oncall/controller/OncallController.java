package oncall.controller;

import oncall.dto.MonthRequest;
import oncall.dto.OncallResponse;
import oncall.dto.WorkerRequest;
import oncall.service.OncallService;
import oncall.view.InputView;
import oncall.view.OutputView;

import java.util.function.Supplier;

public class OncallController {
    private final OutputView outputView;
    private final InputView inputView;
    private final OncallService oncallService;

    public OncallController(OutputView outputView, InputView inputView, OncallService oncallService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.oncallService = oncallService;
    }

    public void start() {
        MonthRequest workingRequest = getValidRequest(inputView::readWorkingMonth);
        oncallService.makeDetailOfMonth(workingRequest);
        WorkerRequest weekDayWorkingPeople = inputView.readWeekDayPeople();
        WorkerRequest weekendWorkingPeople = inputView.readWeekendPeople();
        OncallResponse response = oncallService.showOncallResult(weekDayWorkingPeople, weekendWorkingPeople);
        outputView.showOncallResult(response);
        inputView.readClose();
    }

    private <T> T getValidRequest(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }
}
