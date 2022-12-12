package com.javarush.task.task26.task2613.command;


import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login");


    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
   while (true) {
       ConsoleHelper.writeMessage(res.getString("specify.data"));
       String number = ConsoleHelper.readString().trim();
       String pinNumber = ConsoleHelper.readString().trim();
       if (number.length() != 12 || pinNumber.length() != 4) {
           ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
           continue;
       }
       if (validCreditCards.containsKey(number)  && validCreditCards.getString(number).equals(pinNumber)) {
           ConsoleHelper.writeMessage(res.getString("success.format"));
           break;
       }
       else {
           ConsoleHelper.writeMessage(res.getString("not.verified.format"));
           ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
       }
   }
    }
}
