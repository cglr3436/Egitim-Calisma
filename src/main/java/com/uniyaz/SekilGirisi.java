package com.uniyaz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SekilGirisi extends HttpServlet {
    static class FileList implements Serializable {
        List<Sekil> Sekillist = new ArrayList<>();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter myResponse = resp.getWriter();
        String HATA="";

        String type = req.getParameter("adi");
        String Eni=req.getParameter("eni");
        String Boyu=req.getParameter("boyu");
        String Yaricap=req.getParameter("yaricap");

        Double eni=0.0;
        Double boyu=0.0;
        Double yaricapi=0.0;
        Sekil girilen_sekil=new Sekil();
        Double CEVRE=0.0,ALAN=0.0;
        if(!"".equals(type)){
            if ("kare".equals(type)){
                if("".equals(Eni))
                {
                    HATA+=" Eni girilmedi ";
                }
                if("".equals(Boyu)){
                    HATA+=" Boyu girilmedi ";
                }
                if(!"".equals(Eni)&&!"".equals(Boyu)) {
                    eni = Double.valueOf(Eni);
                    boyu = Double.valueOf(Boyu);
                    girilen_sekil = new Kare(eni, boyu);
                    ALAN = girilen_sekil.alan_hesabi();
                    CEVRE = girilen_sekil.cevre_hesabi();
                }
            }
            else if ("dikdortgen".equals(type)){
                if("".equals(Eni))
                {
                    HATA+=" Eni girilmedi ";
                }
                if("".equals(Boyu)){
                    HATA+=" Boyu girilmedi ";
                }
                if(!"".equals(Eni)&&!"".equals(Boyu)) {
                    eni = Double.valueOf(Eni);
                    boyu = Double.valueOf(Boyu);
                    girilen_sekil = new Dikdortgen(eni, boyu);
                    ALAN = girilen_sekil.alan_hesabi();
                    CEVRE = girilen_sekil.cevre_hesabi();
                }
            }
            else if ("daire".equals(type)){
                if(!"".equals(Yaricap)){
                    yaricapi= Double.valueOf(Yaricap);
                    girilen_sekil=new Daire(yaricapi);
                    ALAN=girilen_sekil.alan_hesabi();
                    CEVRE=girilen_sekil.cevre_hesabi();}
                else {
                    HATA+=" Yaricap girilmedi ";
                }
            }else {
                HATA+="Sekil ismi yanlis girildi";
              //  super.doPost(req, resp);
            }
        }else {
            HATA+="Sekil ismi Bos Birakilamaz ";
           // super.doPost(req, resp);
        }

        if (!"".equals(HATA)){
            myResponse.println("<script type=\"text/javascript\">");
            myResponse.println("alert('"+HATA+"');");
            myResponse.println("location='index.jsp';");
            myResponse.println("</script>");
            return;
        }

        myResponse.println(
                " <b>ALAN : " + ALAN + "\n" +
                "  CEVRE :" + CEVRE + "\n" +
                "\n" +
                "");

//        String dosya_adi2="C:\\Projeler\\servlet\\sekil.csv";
//        File file=new File(dosya_adi2);
//        if (file.createNewFile()) {
//            System.out.println("File created: " + file.getName());
//        } else {
//            System.out.println("File already exists.");
//        }
//        ArrayList<Sekil> SekilListe2=new ArrayList<Sekil>();
//        ArrayList<Sekil> OkunanListe=new ArrayList<Sekil>();
//        SekilListe2.add(girilen_sekil);
//        SekilListe2.add(girilen_sekil);
//       FileService  fileService=new FileService();
//        fileService.writeSerializeliste(dosya_adi2,SekilListe2);

        FileService  fileService=new FileService();
        String sekil_yolu="C:\\Projeler\\servlet\\sekiller.txt";
        File file2=new File(sekil_yolu);
        file2.createNewFile();
        fileService.writeFile(sekil_yolu,girilen_sekil.toString() );

        FileService fileService2=new FileService();
        String dosya_adi2="C:\\Projeler\\servlet\\text.csv";
        File file=new File(dosya_adi2);
        try {
            file2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Sekil> OgrenciListe = new ArrayList<>();
        OgrenciListe=new ArrayList<Sekil>();
        if (file.length() != 0) {
            OgrenciListe.addAll(fileService2.readSerializeListe(dosya_adi2));
        }
        OgrenciListe.add(girilen_sekil);
        fileService2.writeSerializeListe(dosya_adi2,OgrenciListe);
        System.out.println(OgrenciListe.toString());

        //super.doPost(req, resp);
    }
}
