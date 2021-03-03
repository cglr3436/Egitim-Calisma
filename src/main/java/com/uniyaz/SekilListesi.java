package com.uniyaz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SekilListesi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


//        String dosya_adi2="C:\\Projeler\\servlet\\sekil.csv";
//        File file=new File(dosya_adi2);
//        if (file.createNewFile()) {
//            System.out.println("File created: " + file.getName());
//        } else {
//            System.out.println("File already exists.");
//        }
/*
        ArrayList<Sekil> OkunanListe=new ArrayList<Sekil>();
        FileService  fileService2=new FileService();
        OkunanListe= fileService2.readSerializeliste(dosya_adi2);
        System.out.println(OkunanListe.toString());

       Sekil A= new Kare(4,4);
       A.alan_hesabi();
       A.cevre_hesabi();
        Sekil B= new Kare(3,3);
        B.alan_hesabi();
        B.cevre_hesabi();
        OkunanListe.add(A);
        OkunanListe.add(B);
*/

/*
        FileService  fileService2=new FileService();
        String sekil_yolu="C:\\Projeler\\servlet\\sekiller.txt";
        File file2=new File(sekil_yolu);
        file2.createNewFile();
        List<String> SekilLis=new ArrayList<>();
        SekilLis=fileService2.oku(sekil_yolu);
*/
        FileService fileService2=new FileService();
        String dosya_adi2="C:\\Projeler\\servlet\\text.csv";
        File file2=new File(dosya_adi2);
        file2.createNewFile();
        ArrayList<Sekil> OgrenciListe = new ArrayList<>();
        OgrenciListe=new ArrayList<Sekil>();
        if (file2.length() != 0) {
            OgrenciListe.addAll(fileService2.readSerializeListe(dosya_adi2));
        }


        PrintWriter myResponse = resp.getWriter();
        try {

        myResponse.println("<!DOCTYPE html>");
        myResponse.println("<html><head>");
        myResponse.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
        myResponse.println("<title>Hello, World</title></head>");
        myResponse.println("<body>");
       // System.out.println(OgrenciListe.toString());
        boolean kontrol=OgrenciListe.isEmpty();
        if(!kontrol){
            myResponse.println("<table>");
            for (Sekil A:OgrenciListe){

                if(A.getAdi().equals("kare"))
                {
                    myResponse.println("<tr style='color:blue;'>"+
                                "<td>" + (String)(A.toString()) + "</td>" +
                                "</tr>");
                }
                if(A.getAdi().equals("dikdortgen"))
                {
                    myResponse.println("<tr style='color:green;'>"+
                            "<td>" + (String)(A.toString()) + "</td>" +
                            "</tr>");
                }
                if(A.getAdi().equals("daire"))
                {
                    myResponse.println("<tr style='color:red;'>"+
                            "<td>" + (String)(A.toString()) + "</td>" +
                            "</tr>");
                }

            }
            myResponse.println("</table>");
        }else {
            myResponse.println("<h2 align=\"center\">" + "KAYIT LISTELENEMEDI" +" </h2>"+"\n");
           // super.doGet(req, resp);
        }
        myResponse.println("</body>");
        myResponse.println("</html>");
    } finally {
        myResponse.close();  // Always close the output writer
    }

    }
}
