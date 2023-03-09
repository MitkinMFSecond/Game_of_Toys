package model;

import java.util.Iterator;
import java.util.List;

    
public class ToyShopIterator implements Iterator<Toy> {

    private List<Toy> toyList;
    private int index;
    
    public ToyShopIterator(List<Toy> toyList) {
        this.toyList = toyList;
    }

    @Override
    public boolean hasNext() {
        return index < toyList.size();
    }

    @Override
    public Toy next() {
        return toyList.get(index++);
    }
}

