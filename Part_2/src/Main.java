import java.io.IOException;

import controller.Controller;
import model.*;
import view.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException {

        View view = new ConsoleUI();
        ToyShopService service = new ToyShopService();
        Controller controller = new Controller(view, service);
        view.start();
        
//для заполнения файла ToyShop.out и отладки

        // ToyShop toyShop = new ToyShop();
        // Toy toy0 = new Toy("Ничего", 0, 20);
        // Toy toy1 = new Toy("Конструктор", 10, 5);
        // Toy toy2 = new Toy("Кукла", 10, 10);
        // Toy toy3 = new Toy("Машинка", 10, 10);
        // Toy toy4 = new Toy("Ракета", 10, 5);
        // Toy toy5 = new Toy("Кораблик", 10, 5);
        // Toy toy6 = new Toy("Вертолет", 10, 5);
        // Toy toy7 = new Toy("Самолет", 10, 1);
        // Toy toy8 = new Toy("Робот", 10, 1);
        // toyShop.add(toy0);
        // toyShop.add(toy1);
        // toyShop.add(toy2);
        // toyShop.add(toy3);
        // toyShop.add(toy4);
        // toyShop.add(toy5);
        // toyShop.add(toy6);
        // toyShop.add(toy7);
        // toyShop.add(toy8);
        
        // Writer writer = new Writer();
        // writer.saveDb(toyShop);
        // System.out.println(toyShop.getAll());

    }
}