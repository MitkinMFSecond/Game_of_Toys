package view;

import java.io.IOException;
import java.util.ArrayList;
import controller.Controller;


public interface View {
    void setController(Controller controller);
    void start() throws ClassNotFoundException, IOException;
    void answer(Object obj);
    void answerNoData();
    void answerPrize(String str);
    void answerGivePrize(String str);
    int editChance();
    void menuLottery() throws ClassNotFoundException, IOException;
    ArrayList<String> createNodeForm();
    void answerIdAbsent(int id);
    int requestNodeId();
}
