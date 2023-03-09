package view;

import java.io.IOException;

import controller.Controller;

public class CommandSaveShop implements CommandOption {
    
    @Override
    public String discription() {
        return "Сохранить магазин";
    }

    @Override
    public void exec(Controller controller) throws ClassNotFoundException, IOException {
        controller.execSave();
    }
}
