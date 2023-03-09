package view;

import controller.Controller;

public class CommandDraw implements CommandOption {
    
    @Override
    public String discription() {
        return "Провести розыгрыш";
    }

    @Override
    public void exec(Controller controller) {
        controller.execDraw();
    }
}
