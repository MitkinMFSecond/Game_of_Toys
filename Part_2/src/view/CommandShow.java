package view;

import controller.Controller;

public class CommandShow implements CommandOption {
    
    @Override
    public String discription() {
        return "Просмотр магазина";
    }

    @Override
    public void exec(Controller controller) {
        controller.execShow(); 
    }
}
