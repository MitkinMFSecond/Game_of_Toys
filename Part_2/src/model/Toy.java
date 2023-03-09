package model;

import java.io.*;


public class Toy implements Serializable, Comparable<Toy> {
    private String name;
    private int chance;
    private int quantity;
    private int id;

    public Toy(String name, Integer quantity,  Integer chance) {
        this.id = 0;
        this.name = name;
        this.quantity = quantity;
        this.chance = chance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void subtractQuantity(){
        this.quantity -= 1;
    } 

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public Integer getChance() {
        return chance;
    }

    @Override
    public String toString() {
        String str = "id: " + id + " " + name + " , Количество: " + quantity + " , Шанс выпадения: " +  chance;
        return str + "\n";
    }

    @Override
    public int compareTo(Toy toy) {
        return name.compareTo(toy.name);
    }
}

