package com.uniyaz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Dosya {


   static SekilList MyClassList = new SekilList();
    static ArrayList<Sekil> recordList = new ArrayList<Sekil>();

    public static void main(String[] args) {
Dosya dosya=new Dosya();
Sekil A=new Kare(2,2);
A.cevre_hesabi();
A.alan_hesabi();


        MyClassList.liste.add(A);

        String filepath =  "C:\\Projeler\\servlet\\sekil.txt";;

        System.out.println("kayit");
        System.out.println(A.toString());
        dosya.WriteObjectToFile(filepath,A);
        System.out.println("-----------------");
        List<Object> B= new ArrayList<Object>( dosya.ReadObjectFromFile(filepath));

    System.out.println("okunan");
    System.out.println(B.toString());

        //System.out.println(recordList.toString());

    }

        public void WriteObjectToFile(String filepath,Object a) {
            ObjectOutputStream oos = null;
            FileOutputStream fout = null;
            try {
                fout = new FileOutputStream(filepath, true);
                oos = new ObjectOutputStream(fout);
                oos.writeObject(a);
            } catch (Exception ex) {
                ex.printStackTrace();

            } finally {
                if (oos != null) {
                    try {
                        oos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }if (fout != null) {
                    try {
                        fout.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    public List<Object> ReadObjectFromFile(String filepath) {
        ObjectInputStream objectIn=null;
        FileInputStream fileIn=null;
        List<Object> a=new ArrayList<Object>();
        try {

            fileIn = new FileInputStream(filepath);
            objectIn = new ObjectInputStream(fileIn);
            Object obj= objectIn.readObject();
            System.out.println("The Object has been read from the file");
            objectIn.close();
            return a;

        } catch (Exception ex) {
           // ex.printStackTrace();
            return a;
        } finally {
            if(objectIn != null){
                try {
                    objectIn .close();
                    return a;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileIn != null){
                try {
                    fileIn .close();
                    return a;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
