package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.dto.MonthRequest;
import oncall.dto.PeopleRequest;

public class InputView {

    public MonthRequest readWorkingMonth() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        String userInput = read();
        return MonthRequest.of(userInput);
    }

    public PeopleRequest readWeekDayPeople() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        String userInput = read();
        return PeopleRequest.of(userInput);
    }

    public PeopleRequest readWeekendPeople() {
        System.out.print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        String userInput = read();
        return PeopleRequest.of(userInput);
    }


    public void readClose() {
        Console.close();
    }

    private String read() {
        return Console.readLine();
    }
}