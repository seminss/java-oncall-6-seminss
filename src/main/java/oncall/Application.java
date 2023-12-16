package oncall;

import oncall.controller.OncallController;
import oncall.service.OncallService;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OncallController oncallController = new OncallController(
                new OutputView(),
                new InputView(),
                new OncallService()
        );
        oncallController.start();
    }
}
