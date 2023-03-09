package view;

import java.io.IOException;

import controller.Controller;

public interface CommandOption {
    String discription();
    void exec(Controller controller) throws ClassNotFoundException, IOException;
}
