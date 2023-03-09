package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ToyShopService  {
    
    private ToyShop toyShop;
    private Lottery lottery;
    private Writer writer;

    Toy toy0 = new Toy("Ничего", 0, 30);
    
       
    public ToyShopService() {
        this.toyShop = new ToyShop();
        this.lottery = new Lottery();
        this.writer = new Writer();
        toyShop.add(toy0);
    }

    public List<Toy> read() throws ClassNotFoundException, IOException {
        toyShop = writer.readDb();
        return toyShop.getAll();
    }

    public List<Toy> show() {
       return toyShop.getAll();
    }

    public ToyShop sortById() {
        Collections.sort(toyShop.getAll(), new ComparatorById());
        return toyShop;
    }

    public void save() throws ClassNotFoundException, IOException {
        this.writer.saveDb(this.toyShop);
    }

    public void createNode(ArrayList<String> prop) {
        Toy node = new Toy (prop.get(0), Integer.parseInt(prop.get(1)), Integer.parseInt(prop.get(2)));
        toyShop.add(node);
    }
    

    public void editChance(int[] nums) {
        Toy toy = toyShop.getToyById(nums[0]);
        toyShop.editChance(toy,nums[1]);
    }


    public void sortByName(){
        Collections.sort(this.toyShop.getAll());
    }
    

    public boolean checkId(int checked_id){
        List<Integer> ts_ids = this.toyShop.getAllid();
        for (int id : ts_ids){
            if (id==checked_id) 
            return true;
        }
        return false;
    }
  
    public String drawSv(){
        lottery.refresh(toyShop);
        return lottery.draw();
    }
    
    public String givePrizeSv() throws IOException{
        if (lottery.getSizePrizeList()== 0 ){
            return "0";
        } 
        Toy toy = lottery.givePrize();
        this.toyShop.toySubtractQuantity(toy);
        writer.saveTxt(toy.getName());
        return toy.getName();
    }

    public List<String> showPrizeListSv(){
        return lottery.getPrizeNamesList();
    }
 
}
