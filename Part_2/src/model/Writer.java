package model;

import java.io.*;

public class Writer {
        public Writer() {
        }

        public void saveDb(ToyShop toyShop) throws ClassNotFoundException, IOException {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                                new FileOutputStream("ToyShop.out"));
                objectOutputStream.writeObject(toyShop);
                objectOutputStream.close();
        }

        public ToyShop readDb() throws ClassNotFoundException, IOException {
                ObjectInputStream objectInputStream = new ObjectInputStream(
                        new FileInputStream("ToyShop.out"));
                ToyShop familyTreeRestored = (ToyShop) objectInputStream.readObject();
                objectInputStream.close();
                return familyTreeRestored;
        }
        
        public void saveTxt(String text ) throws  IOException {
                try(FileWriter writer = new FileWriter("PrizeToys.txt", true)){
                        writer.write(text +"\n");
                } catch(IOException ex){
                        System.out.println(ex.getMessage());
                } 
               
        
        } 

        }
