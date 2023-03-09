package view;

import controller.Controller;

public class CommandExit implements CommandOption {
    
    @Override
    public String discription() {
        return "Выход";
    }

    @Override
    public void exec(Controller controller) {
        controller.execCommandExit();
    }
}
