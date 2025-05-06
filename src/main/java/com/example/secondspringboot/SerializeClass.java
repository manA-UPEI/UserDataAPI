package com.example.secondspringboot;

import java.io.*;

public class SerializeClass implements Serializable {

    public String name;
    public int age;
    public SerializeClass(String name, int age){
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        SerializeClass sc = new SerializeClass("Ram", 20);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.ser"));
            oos.writeObject(sc);
            oos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fileIn = new FileInputStream("user.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            SerializeClass user = (SerializeClass) in.readObject();
            System.out.println("Deserialized object: " + user.name);
            in.close();
            fileIn.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }



    }
}
