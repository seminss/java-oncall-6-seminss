package oncall.controller;

import oncall.dto.MonthRequest;
import oncall.dto.PeopleRequest;
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
        MonthRequest workingMonth = getValidRequest(inputView::readWorkingMonth);
        PeopleRequest weekDayWorkingPeople = getValidRequest(inputView::readWeekDayPeople);
        PeopleRequest weekendWorkingPeople = getValidRequest(inputView::readWeekendPeople);
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

    private void runMethod(Runnable function) {
        while (true) {
            try {
                function.run();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }
}
