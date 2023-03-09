package controller;

import java.io.IOException;
import java.util.ArrayList;

import view.*;
import model.*;

public class Controller {
    private View view;
    private ToyShopService service;

    public Controller(View view, ToyShopService service) {
        this.view = view;
        this.service = service;
        view.setController(this);
    }

    public View getView() {
        return this.view;
    }

    public void execRead() throws ClassNotFoundException, IOException {
        view.answer(service.read());
    }

    public void execShow() {
        view.answer(service.show());
    }

    public void execSortById() {
        view.answer(service.sortById());
    }

    public void execSave() throws ClassNotFoundException, IOException {
        service.save();
    }

    public void execCommandExit() {
        return;
    }

    public void execCreateNode(ArrayList<String> prop) {
        service.createNode(prop);
    }

    public void execEditChance(int[] nums) {
        boolean check = service.checkId(nums[0]);
        if (check == true) {
            service.editChance(nums);
        } else {
            view.answerIdAbsent(nums[0]);
        }
    }
               
    
    public void execMenuLottery() throws ClassNotFoundException, IOException {
        view.menuLottery();
    }


    public void execShowPrizeList(){
        view.answer(service.showPrizeListSv());
    }

    public void execDraw(){
        String toyName =service.drawSv();
        view.answerPrize(toyName);
    }


    public void execGivePrize() throws IOException{
        String toyName = service.givePrizeSv();
        if (toyName =="0"){
            view.answerGivePrize(toyName);
        } else {
            view.answerGivePrize(toyName);
        }    
    }
}
