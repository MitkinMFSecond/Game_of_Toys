package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ToyShop  implements Serializable, Iterable<Toy> {

    private List<Toy> toys;

    public ToyShop(List<Toy> toys) {
        this.toys = toys;
    }

    public ToyShop() {
        this(new ArrayList<Toy>());
    }

    public void add(Toy toy) {
        toy.setId(getMaxId() + 1);
        toys.add(toy);
    }
     
    public List<Toy> getAll() {
        return this.toys;
    }
    
    public void editChance(Toy toy, int chance){
        int index = this.toys.indexOf(toy);
        toy.setChance(chance);
        this.toys.set(index, toy);
    }

    public void toySubtractQuantity (Toy toy){
        int index = this.toys.indexOf(toy);
        toy.subtractQuantity();
        this.toys.set(index, toy);
    }

    public ArrayList<Integer> getAllid() {
        ArrayList<Integer> ts_ids = new ArrayList<>();
        for (Toy toy : this.toys) {
            ts_ids.add(toy.getId());
        }
        return ts_ids;
    }

    
    private Integer getMaxId() {
        int maxId = -1;
        for (Toy toy : this.toys) {
            if (toy.getId() > maxId) {
                maxId = toy.getId();
            }
        }
        return maxId;
    }
    
    
    public Toy getToyById(int id) {
        for (Toy toy : this.toys) {
            if (toy.getId() == id) {
                return toy;
            }
        }
        return null;
    }

    public Toy getToyByName(String name) {
        for (Toy toy : toys) {
            if (toy.getName().equals(name)) {
                return toy;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return getAll().toString();
    }


    @Override
    public Iterator<Toy> iterator() {
        return new ToyShopIterator(this.toys);
    }
}