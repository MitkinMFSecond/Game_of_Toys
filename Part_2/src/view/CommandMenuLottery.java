package view;

import java.io.IOException;

import controller.Controller;

public class CommandMenuLottery implements CommandOption {
    
    @Override
    public String discription() {
        return "Меню розыгрыша";
    }

    @Override
    public void exec(Controller controller) throws ClassNotFoundException, IOException {
        controller.execMenuLottery();
    }
}
