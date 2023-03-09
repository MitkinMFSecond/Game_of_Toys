package view;

import java.io.IOException;

import controller.Controller;

public class CommandGivePrize implements CommandOption {
    
    @Override
    public String discription() {
        return "Выдать первый по списку приз";
    }

    @Override
    public void exec(Controller controller) throws IOException {
        //System.out.println("Выдан");
        controller.execGivePrize();
    }
}
