package view;

import controller.Controller;

public class CommandShowPrizeList implements CommandOption {
    
    @Override
    public String discription() {
        return "Показать список разыграных призов";
    }

    @Override
    public void exec(Controller controller) {
        //System.out.println("Список");
        controller.execShowPrizeList();
    }
}
