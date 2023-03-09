package view;

import controller.Controller;

public class CommandSortById implements CommandOption {
    
    @Override
    public String discription() {
        return "Сортировка товара по ID";
    }

    @Override
    public void exec(Controller controller) {
        controller.execSortById(); 
    }
}
