﻿package view;

import controller.Controller;

public class CommandCreateNode implements CommandOption  {
    
    @Override
    public String discription() {
        return "Добавить новую запись";
    }

    @Override
    public void exec(Controller controller) {     
        controller.execCreateNode(controller.getView().createNodeForm());
    }
}
