package view;

import controller.Controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Controller controller;
    private Scanner scanner;

    public ConsoleUI() {
        scanner = new Scanner(System.in, "cp866");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void start() throws ClassNotFoundException, IOException {
        List<CommandOption> commandList = new ArrayList<>();   
        commandList.add(new CommandReadShop());
        commandList.add(new CommandShow());
        commandList.add(new CommandCreateNode());
        commandList.add(new CommandEditChance());
        commandList.add(new CommandSortById());
        commandList.add(new CommandMenuLottery());
        commandList.add(new CommandSaveShop());
        commandList.add(new CommandExit());
        menu("Главное меню", commandList);
    }


    @Override
    public void menuLottery() throws ClassNotFoundException, IOException {
        List<CommandOption> commandList = new ArrayList<>();   
        commandList.add(new CommandShowPrizeList());
        commandList.add(new CommandDraw());
        commandList.add(new CommandGivePrize());
        commandList.add(new CommandExit());
        menu("Меню розыгрыша", commandList);
    }

    
    @Override
    public ArrayList<String> createNodeForm() {
        ArrayList<String> prop = new ArrayList<>();
        System.out.println("Введите название игрушки:");
        String str = scanner.nextLine();
        while (str.strip().length() == 0 ) {
            System.out.println("Название должно содержать хотя-бы один символ");
            str = scanner.nextLine();
        }
        prop.add(str);
        System.out.println("Введите количество:");
        int num = getNumber();
        while (num < 0 ) {
            System.out.println("Введите целое число от 0 и более");
            num = getNumber();
        }
        prop.add(""+ num);
        prop.add(""+ editChance());
        return prop;
    }


    @Override
    public int editChance() {
        System.out.println("Введите шанс выпадения в % (от 0 до 30):");
        int num = getNumber();
        while (num < 0  && num > 30 ) {
            System.out.println("Введите число от 0 до 30");
            num = getNumber();
        }
        return num;
    }

    @Override
    public int requestNodeId(){
        System.out.println("Введите id:");
        return getNumber();
    }

  
    @Override
    public void answerIdAbsent(int id) {
        System.out.println("id"+ id + " не существует");
    }

    @Override
    public void answerNoData() {
        System.out.println("Нет данных\n");
    }

    @Override
    public void answer(Object obj) {
        System.out.println(obj + "\n");
    }

    @Override
    public void answerPrize(String str) {
        System.out.println("Ваш выигрыш: " + str + "\n");
    }

    @Override
    public void answerGivePrize(String str) {
        if (str == "0"){
            System.out.println("Список призов пуст\n");
        } else {
            System.out.println("Выдан приз: " + str + "\n");
        }
    }
    
    private int getNumber() {
        while (!scanner.hasNextInt()) {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз:");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private int scan(int commandListSize) {
        System.out.println("Введите команду:");
        int command = getNumber();
        if (command>=1 && command<=commandListSize) {
            return command;
        } else {
            System.out.println("Команда не распознана.");
            command = scan(commandListSize);
        }
        return command;
    }
    
    private void menu (String type, List<CommandOption> commandList ) throws ClassNotFoundException, IOException{
        boolean flag = true;
        while (flag){
            System.out.println(type);
            for (int i = 0; i < commandList.size(); i++) {
                System.out.println(i+1 + "-" + commandList.get(i).discription());
            }
            int command = scan(commandList.size());
            if (command==commandList.size()){
                flag=false;
                commandList.get(command-1).exec(controller);
            } else {
                commandList.get(command-1).exec(controller);
            }
            System.out.println("======================================================");
        }
    }
}
