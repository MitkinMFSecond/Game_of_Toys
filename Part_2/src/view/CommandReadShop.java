package view;

import java.io.IOException;

import controller.Controller;

public class CommandReadShop implements CommandOption {
    
    @Override
    public String discription() {
        return "Загрузка магазина";
    }

    @Override
    public void exec(Controller controller) throws ClassNotFoundException, IOException{
        controller.execRead(); 
    }
}
