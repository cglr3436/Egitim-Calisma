package com.uniyaz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    ArrayList<Sekil> _currentList;

    public void writeSerializeListe  (String file_name,ArrayList<Sekil> yazilacakSekiller){
        try
        {
            FileOutputStream fos = new FileOutputStream(file_name);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(yazilacakSekiller);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }

    }

    public List<Sekil> readSerializeListe (String file_name){
        List<Sekil> OkunanSekilListe=null;
        try {
            FileInputStream fileInputStream2=new FileInputStream(file_name);
            ObjectInputStream ObjectInputStream2 = new ObjectInputStream(fileInputStream2);

            OkunanSekilListe= (ArrayList<Sekil>)ObjectInputStream2.readObject();

            ObjectInputStream2.close();
            fileInputStream2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return OkunanSekilListe;
    }



    public List<String> oku(String fileName) {

        BufferedReader in = null;
        List<String> myList = new ArrayList<String>();
        try {
            in = new BufferedReader(new FileReader(fileName));
            String str;
            while ((str = in.readLine()) != null) {
                myList.add(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return myList;
    }


    public static void writeFile(String fileName, String satir)  {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(new File(fileName),true);
            bw = new BufferedWriter(fw);
                bw.write(satir);
                bw.write("\n");

        } catch (Exception e) {
            System.out.println("YAWIN:ERROR:" + e.getMessage());

        } finally {
            try {
                bw.close();
            } catch (Exception e) {
            }
            try {
                fw.close();
            } catch (Exception e) {
            }
        }

    }




}