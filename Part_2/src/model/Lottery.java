package model;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {

    private ToyShop ts;
    private List<Toy> prizeList;
    private Random random = new Random(); 


    public Lottery() {
        this.ts = new ToyShop();
        this.prizeList = new ArrayList<>();
    }

    public void refresh(ToyShop ts){
        this.ts = ts;
    }

    public List<Toy> getPrizeList(){
        return prizeList;
    }
    public Integer getSizePrizeList(){
        return prizeList.size();
    }


    public List<String> getPrizeNamesList(){
        List<String> prizeNames = new ArrayList<>();
        for (Toy toy : prizeList) {
            prizeNames.add(toy.getName());            
        }
        return prizeNames;
    }


    public String draw() {
        List<Toy> drawList = createDrawList();
        int index = random.nextInt(drawList.size());
        Toy toy = drawList.get(index);
        if (toy.getId() != 0 ){
            prizeList.add(toy);
            return toy.getName();
        }
        return toy.getName();
    }

    public Toy givePrize() {
        Toy toy = prizeList.get(0);
        prizeList.remove(0);
        return toy;
    }

    private List<Toy> createDrawList() {
        List<Toy> drawList = new ArrayList<>();
        List<Toy> preDrawList = new ArrayList<>();
        List<Toy> toyList = ts.getAll();
        preDrawList.add(toyList.get(0));
        List<Toy> fToyList = new ArrayList<>();
        for (int i = 1; i < toyList.size(); i++) {
            Toy toy = toyList.get(i);
            if (toy.getChance() != 0 && toy.getQuantity() != 0) {
                fToyList.add(toyList.get(i));
            }
        }
        int emptyChance = preDrawList.get(0).getChance();
        int maxChance = 100 - emptyChance;
        int newMaxChance = 0;
        boolean flag = true;
        while (flag) {
            if (fToyList.size() > 0) {
                int index = random.nextInt(fToyList.size());
                Toy toy = fToyList.get(index);
                int chance = toy.getChance();
                if (newMaxChance < maxChance) {
                    newMaxChance += chance;
                    preDrawList.add(toy);
                    fToyList.remove(toy);
                } else {
                    flag = false;
                }
            } else {
                flag = false;
            }
        }
        int mult = 10;
        for (Toy toy : preDrawList) {
            int chance = toy.getChance();
            for (int i = 0; i < chance * mult; i++) {
                drawList.add(toy);
            }
        }
        return drawList;
    }
}
