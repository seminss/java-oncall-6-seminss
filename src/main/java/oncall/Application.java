package oncall;

import oncall.controller.OncallController;
import oncall.service.OncallService;
import oncall.view.InputView;
import oncall.view.OutputView;

import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        try {
            OncallController oncallController = new OncallController(
                    new OutputView(),
                    new InputView(),
                    new OncallService()
            );
            oncallController.start();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

    }
}
