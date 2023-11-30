package hu.domparse.zuyisf;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import java.util.List;

class Ugyved {
    private String vedi;
    private String ugyvediId;
    private String szakterulet;
    private List<String> telefonszam;
    private String ugyved_nev;

    public Ugyved(String vedi, String ugyvediId, String szakterulet, List<String> telefonszam, String ugyved_nev) {
        this.vedi = vedi;
        this.ugyvediId = ugyvediId;
        this.szakterulet = szakterulet;
        this.telefonszam = telefonszam;
        this.ugyved_nev = ugyved_nev;
    }

    public String getVedi() {
        return vedi;
    }

    public void setVedi(String vedi) {
        this.vedi = vedi;
    }

    public String getUgyvediId() {
        return ugyvediId;
    }

    public void setUgyvediId(String ugyvediId) {
        this.ugyvediId = ugyvediId;
    }

    public String getSzakterulet() {
        return szakterulet;
    }

    public void setSzakterulet(String szakterulet) {
        this.szakterulet = szakterulet;
    }

    public List<String> getTelefonszam() {
        return telefonszam;
    }

    public void setTelefonszam(List<String> telefonszam) {
        this.telefonszam = telefonszam;
    }

    public String getUgyved_nev() {
        return ugyved_nev;
    }

    public void setUgyved_nev(String ugyved_nev) {
        this.ugyved_nev = ugyved_nev;
    }
}

class Vadlott {
    private String szemelyi_ig;
    private String lakcim;
    private String szulido;
    private String kor;
    private String priusz;
    private String vnev;
    private String knev;

    public Vadlott(String szemelyi_ig, String lakcim, String szulido, String kor, String priusz, String vnev, String knev) {
        this.szemelyi_ig = szemelyi_ig;
        this.lakcim = lakcim;
        this.szulido = szulido;
        this.kor = kor;
        this.priusz = priusz;
        this.vnev = vnev;
        this.knev = knev;
    }

    public String getSzemelyi_ig() {
        return szemelyi_ig;
    }

    public void setSzemelyi_ig(String szemelyi_ig) {
        this.szemelyi_ig = szemelyi_ig;
    }

    public String getLakcim() {
        return lakcim;
    }

    public void setLakcim(String lakcim) {
        this.lakcim = lakcim;
    }

    public String getSzulido() {
        return szulido;
    }

    public void setSzulido(String szulido) {
        this.szulido = szulido;
    }

    public String getKor() {
        return kor;
    }

    public void setKor(String kor) {
        this.kor = kor;
    }

    public String getPriusz() {
        return priusz;
    }

    public void setPriusz(String priusz) {
        this.priusz = priusz;
    }

    public String getVnev() {
        return vnev;
    }

    public void setVnev(String vnev) {
        this.vnev = vnev;
    }

    public String getKnev() {
        return knev;
    }

    public void setKnev(String knev) {
        this.knev = knev;
    } 
}

class Bunose {
    private String vadlott;
    private String ugy;
    private String vad;

    public Bunose(String vadlott, String ugy, String vad) {
        this.vadlott= vadlott;
        this.ugy = ugy;
        this.vad = vad;
    }

    public String getVadlott() {
        return vadlott;
    }

    public void setVadlott(String vadlott) {
        this.vadlott = vadlott;
    }

    public String getUgy() {
        return ugy;
    }

    public void setUgy(String ugy) {
        this.ugy = ugy;
    }

    public String getVad() {
        return vad;
    }

    public void setVad(String vad) {
        this.vad = vad;
    }
}

class Ugy {
    private String UgyszamId;
    private String tipus;
    private String datum;
    private String allapot;

    public Ugy(String UgyszamId, String tipus, String datum, String allapot) {
        this.UgyszamId = UgyszamId;
        this.tipus = tipus;
        this.datum = datum;
        this.allapot = allapot;
    }

    public String getUgyszamId() {
        return UgyszamId;
    }

    public void setUgyszamId(String UgyszamId) {
        this.UgyszamId = UgyszamId;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getAllapot() {
        return allapot;
    }

    public void setAllapot(String allapot) {
        this.allapot = allapot;
    }
}

class Iteletethoz {
    private String Ugy;
    private String Biro;
    private String Ugyek_szama;
    private String Itelet;

    public Iteletethoz(String Ugy, String Biro, String ugyek_szama, String Itelet) {
        this.Ugy = Ugy;
        this.Biro = Biro;
        this.Ugyek_szama = ugyek_szama;
        this.Itelet = Itelet;
    }

    public String getUgy() {
        return Ugy;
    }

    public void setUgy(String Ugy) {
        this.Ugy = Ugy;
    }

    public String getBiro() {
        return Biro;
    }

    public void setBiro(String Biro) {
        this.Biro = Biro;
    }

    public String getUgyek_szama() {
        return Ugyek_szama;
    }

    public void setUgyek_szama(String Ugyek_szama) {
        this.Ugyek_szama = Ugyek_szama;
    }

    public String getItelet() {
        return Itelet;
    }

    public void setItelet(String Itelet) {
        this.Itelet = Itelet;
    }
}
 
class Biro {
    private String biroId;
    private String biro_nev;
    private String tapasztalat;
    private String tanitvanyok;

    public Biro(String biroId, String biro_nev, String tapasztalat, String tanitvanyok) {
        this.biroId = biroId;
        this.biro_nev = biro_nev;
        this.tapasztalat = tapasztalat;
        this.tanitvanyok = tanitvanyok;
    }

    public String getBiroId() {
        return biroId;
    }

    public void setBiroId(String biroId) {
        this.biroId = biroId;
    }

    public String getBiro_nev() {
        return biro_nev;
    }

    public void setBiro_nev(String biro_nev) {
        this.biro_nev = biro_nev;
    }

    public String getTapasztalat() {
        return tapasztalat;
    }

    public void setTapasztalat(String tapasztalat) {
        this.tapasztalat = tapasztalat;
    }

    public String getTanitvanyok() {
        return tanitvanyok;
    }

    public void setTanitvanyok(String tanitvanyok) {
        this.tanitvanyok = tanitvanyok;
    }
}

class Jegyzo {
    private String jegyzo_Id;
    private String rogzites;
    private String jegyzo_nev;
    private String munkaIdo;
    private String nyelvtudas;

    public Jegyzo(String jegyzo_Id, String rogzites, String jegyzo_nev, String munkaIdo, String nyelvtudas) {
        this.jegyzo_Id = jegyzo_Id;
        this.rogzites = rogzites;
        this.jegyzo_nev = jegyzo_nev;
        this.munkaIdo = munkaIdo;
        this.nyelvtudas = nyelvtudas;
    }

    public String getJegyzo_Id() {
        return jegyzo_Id;
    }

    public void setegyzo_Id(String jegyzoAzonosito) {
        this.jegyzo_Id = jegyzoAzonosito;
    }

    public String getRogzites() {
        return rogzites;
    }

    public void setRogzites(String rogzitesAzonosito) {
        this.rogzites = rogzitesAzonosito;
    }

    public String getJegyzo_nev() {
        return jegyzo_nev;
    }

    public void setJegyzo_nev(String nev) {
        this.jegyzo_nev = nev;
    }

    public String getMunkaIdo() {
        return munkaIdo;
    }

    public void setMunkaIdo(String munkaIdo) {
        this.munkaIdo = munkaIdo;
    }

    public String getNyelvtudas() {
        return nyelvtudas;
    }

    public void setNyelvtudas(String nyelvtudas) {
        this.nyelvtudas = nyelvtudas;
    }
}


public class DOMWriteZUYISF {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            //XML fájl beolvasása.
            Document eredetiDoc = dBuilder.parse(new InputSource("XMLZUYISF.xml"));
            eredetiDoc.getDocumentElement().normalize();

            //Adatok előkészítése.
            List<Ugyved> ugyvedDataList = UgyvedXML(eredetiDoc);
            List<Vadlott> vadlottDataList = VadlottXML(eredetiDoc);
            List<Bunose> bunoseDataList = BunoseXML(eredetiDoc);
            List<Ugy> ugyDataList = UgyXML(eredetiDoc);
            List<Iteletethoz> IteletethozLista = IteletetHozXML(eredetiDoc);
            List<Biro> biroDataList = BiroXML(eredetiDoc);
            List<Jegyzo> jegyzoList = JegyzoXML(eredetiDoc);
            
            //Komment.
            List<String> kommentekList = getKommentek(eredetiDoc);

            //Új XML dokumentum létrehozása, ez lesz amivel kiírok.
            Document ujDoc = dBuilder.newDocument();

            //Felépíteni az XML fát a forrás dokumentum tartalmából.
            buildTree(ujDoc, ugyvedDataList, vadlottDataList, bunoseDataList, ugyDataList, IteletethozLista, biroDataList, jegyzoList, kommentekList);
            
            //Menti az új dokumentumot az XMLZUYISF1.xml fájlba.
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(ujDoc);
            StreamResult result = new StreamResult(new File("XMLZUYISF1.xml"));
            transformer.transform(source, result);

            //Kiírja a létrehozott XML fát a konzolra.
            Kiiras(ujDoc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static List<String> getKommentek(Document eredetiDoc) {
        List<String> kommentekList = new ArrayList<>();
        kommentgyujtes(eredetiDoc, kommentekList);
        return kommentekList;
    }

    private static void kommentgyujtes(Node node, List<String> kommentekList) {
        if (node.getNodeType() == Node.COMMENT_NODE) {
            kommentekList.add(((Comment) node).getTextContent());
        }

        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            kommentgyujtes(children.item(i), kommentekList);
        }
    }
    
    private static void Kiiras(Document doc) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));

            //Kiírja az XML dokumentumot a konzolra.
            System.out.println(writer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void buildTree(
            Document doc,
            List<Ugyved> ugyvedDataList,
            List<Vadlott> vadlottDataList,
            List<Bunose> bunoseDataList,
            List<Ugy> ugyDataList,
            List<Iteletethoz> Iteletethoz,
            List<Biro> biroDataList,
            List<Jegyzo> jegyzoList,
    		List<String> kommentekList) {

			        //Gyökér elem (Tárgyalás_ZUYISF) hozzáadása.
			        Element rootElement = doc.createElement("Tárgyalás_ZUYISF");
			        rootElement.setAttribute("xmlns:xs", "http://www.w3.org/2001/XMLSchema-instance");
			        rootElement.setAttribute("xs:noNamespaceSchemaLocation", "XMLSchemaZUYISF.xsd");
			        
			        boolean[] Comment = { false, false, false, false, false, false, false }; //Boolean primitív típus, nem működik vele a referenciaátadás, ezért boolean tömb.
			        
			        addUgyved(doc, rootElement, ugyvedDataList, kommentekList, Comment);
			        addVadlott(doc, rootElement, vadlottDataList, kommentekList, Comment);
			        addBunose(doc, rootElement, bunoseDataList, kommentekList, Comment);
			        addUgys(doc, rootElement, ugyDataList, kommentekList, Comment);
			        addIteletethoz(doc, rootElement, Iteletethoz, kommentekList, Comment);
			        addBiro(doc, rootElement, biroDataList, kommentekList, Comment);
			        addJegyzo(doc, rootElement, jegyzoList, kommentekList, Comment);
			        
			        doc.appendChild(rootElement);
			        
    		}

    private static void addUgyved(Document doc, Element rootElement, List<Ugyved> ugyvedDataList, List<String> kommentekList, boolean[] Comment) {
        for (Ugyved ugyvedData : ugyvedDataList) {
            addUgyved(doc, rootElement, ugyvedData, kommentekList, Comment);
        }
    }

    private static void addUgyved(Document doc, Element parentElement, Ugyved ugyvedData, List<String> kommentekList, boolean[] Comment) {
        
        if (kommentekList.stream().anyMatch(comment -> comment.contains("Ügyvéd")) && !Comment[0]) {
            Comment commentNode = doc.createComment("Ügyvéd");
            parentElement.appendChild(commentNode);
            Comment[0] = true;
        }
    	
    	Element ugyvedElement = doc.createElement("Ügyvéd");
        ugyvedElement.setAttribute("Ügyvédi_ID", ugyvedData.getUgyvediId());
        ugyvedElement.setAttribute("Védi", ugyvedData.getVedi());

        Element szakteruletElement = doc.createElement("Szakterület");
        szakteruletElement.setTextContent(ugyvedData.getSzakterulet());
        ugyvedElement.appendChild(szakteruletElement);

        for (String telefonszam : ugyvedData.getTelefonszam()) {
            Element telefonszamElement = doc.createElement("Telefonszám");
            telefonszamElement.setTextContent(telefonszam);
            ugyvedElement.appendChild(telefonszamElement);
        }

        Element nevElement = doc.createElement("Ügyvéd_Név");
        nevElement.setTextContent(ugyvedData.getUgyved_nev());
        ugyvedElement.appendChild(nevElement);

        parentElement.appendChild(ugyvedElement);
    }

    private static void addVadlott(Document doc, Element rootElement, List<Vadlott> vadlottDataList, List<String> kommentekList, boolean[] Comment) {
         for (Vadlott vadlott : vadlottDataList) {
            addVadlott(doc, rootElement, vadlott, kommentekList, Comment);
        }
    }

    private static void addVadlott(Document doc, Element parentElement, Vadlott vadlott, List<String> kommentekList, boolean[] Comment) {

        if (kommentekList.stream().anyMatch(comment -> comment.contains("Vádlott")) && !Comment[1]) {
            Comment commentNode = doc.createComment("Vádlott");
            parentElement.appendChild(commentNode);
            Comment[1] = true;
        }
    	
        Element vadlottElement = doc.createElement("Vádlott");
        vadlottElement.setAttribute("Személyi_ig", vadlott.getSzemelyi_ig());

        Element lakcimElement = doc.createElement("Lakcím");
        lakcimElement.setTextContent(vadlott.getLakcim());
        vadlottElement.appendChild(lakcimElement);

        Element szulidoElement = doc.createElement("Szülidő");
        szulidoElement.setTextContent(vadlott.getSzulido());
        vadlottElement.appendChild(szulidoElement);

        Element korElement = doc.createElement("Kor");
        korElement.setTextContent(vadlott.getKor());
        vadlottElement.appendChild(korElement);

        Element priuszElement = doc.createElement("Priusz");
        priuszElement.setTextContent(vadlott.getPriusz());
        vadlottElement.appendChild(priuszElement);

        Element nevElement = doc.createElement("Név");
        Element vnevElement = doc.createElement("Vnév");
        vnevElement.setTextContent(vadlott.getVnev());
        Element knevElement = doc.createElement("Knév");
        knevElement.setTextContent(vadlott.getKnev());
        nevElement.appendChild(vnevElement);
        nevElement.appendChild(knevElement);
        vadlottElement.appendChild(nevElement);

        parentElement.appendChild(vadlottElement);
    }

    private static void addBunose(Document doc, Element rootElement, List<Bunose> bunoseDataList, List<String> kommentekList, boolean[] Comment) {
        for (Bunose bunose : bunoseDataList) {
            addBunose(doc, rootElement, bunose, kommentekList, Comment);
        }
    }

    private static void addBunose(Document doc, Element parentElement, Bunose bunose, List<String> kommentekList, boolean[] Comment) {
        
        if (kommentekList.stream().anyMatch(comment -> comment.contains("Bűnös-e")) && !Comment[2]) {
            Comment commentNode = doc.createComment("Bűnös-e");
            parentElement.appendChild(commentNode);
            Comment[2] = true;
        }
    	
        Element bunoseElement = doc.createElement("Bűnös-e");
        bunoseElement.setAttribute("Vádlott", bunose.getVadlott());
        bunoseElement.setAttribute("Ügy", bunose.getUgy());

        Element vadElement = doc.createElement("Vád");
        vadElement.setTextContent(bunose.getVad());
        bunoseElement.appendChild(vadElement);

        parentElement.appendChild(bunoseElement);
    }

    private static void addUgys(Document doc, Element rootElement, List<Ugy> ugyDataList, List<String> kommentekList, boolean[] Comment) {
        for (Ugy ugy : ugyDataList) {
            addUgy(doc, rootElement, ugy, kommentekList, Comment);
        };
    }

    private static void addUgy(Document doc, Element parentElement, Ugy ugy, List<String> kommentekList, boolean[] Comment) {
        
        if (kommentekList.stream().anyMatch(comment -> comment.contains("Ügy")) && !Comment[3]) {
            Comment commentNode = doc.createComment("Ügy");
            parentElement.appendChild(commentNode);
            Comment[3] = true;
        }
    	
    	
        Element ugyElement = doc.createElement("Ügy");
        ugyElement.setAttribute("Ügyszám_ID", ugy.getUgyszamId());

        Element tipusElement = doc.createElement("Típus");
        tipusElement.setTextContent(ugy.getTipus());
        ugyElement.appendChild(tipusElement);

        Element dateElement = doc.createElement("Dátum");
        dateElement.setTextContent(ugy.getDatum());
        ugyElement.appendChild(dateElement);

        Element allapotElement = doc.createElement("Állapot");
        allapotElement.setTextContent(ugy.getAllapot());
        ugyElement.appendChild(allapotElement);

        parentElement.appendChild(ugyElement);
    }

    private static void addIteletethoz(Document doc, Element rootElement, List<Iteletethoz> iteletethozList, List<String> kommentekList, boolean[] Comment) {
        for (Iteletethoz iteletethoz : iteletethozList) {
            addIteletethoz(doc, rootElement, iteletethoz, kommentekList, Comment);
        }
    }

    private static void addIteletethoz(Document doc, Element parentElement, Iteletethoz iteletethoz, List<String> kommentekList, boolean[] Comment) {

        if (kommentekList.stream().anyMatch(comment -> comment.contains("Ítéletet_hoz")) && !Comment[4]) {
            Comment commentNode = doc.createComment("Ítéletet_hoz");
            parentElement.appendChild(commentNode);
            Comment[4] = true;
        }
    	
        Element iteletethozElement = doc.createElement("Ítéletet_hoz");
        iteletethozElement.setAttribute("Ügy", iteletethoz.getUgy());
        iteletethozElement.setAttribute("Bíró", iteletethoz.getBiro());

        Element ugyekszamaElement = doc.createElement("Ügyek_száma");
        ugyekszamaElement.setTextContent(String.valueOf(iteletethoz.getUgyek_szama()));
        iteletethozElement.appendChild(ugyekszamaElement);

        Element iteletElement = doc.createElement("Ítélet");
        iteletElement.setTextContent(iteletethoz.getItelet());
        iteletethozElement.appendChild(iteletElement);

        parentElement.appendChild(iteletethozElement);
    }

    private static void addBiro(Document doc, Element rootElement, List<Biro> biroDataList, List<String> kommentekList, boolean[] Comment) {
        for (Biro biro : biroDataList) {
            addBiro(doc, rootElement, biro, kommentekList, Comment);
        }
    }

    private static void addBiro(Document doc, Element parentElement, Biro biro, List<String> kommentekList, boolean[] Comment) {
        
        if (kommentekList.stream().anyMatch(comment -> comment.contains("Bíró")) && !Comment[5]) {
            Comment commentNode = doc.createComment("Bíró");
            parentElement.appendChild(commentNode);
            Comment[5] = true;
        }
    	
        Element biroElement = doc.createElement("Bíró");
        biroElement.setAttribute("Bíró_ID", biro.getBiroId());

        Element nevElement = doc.createElement("Bíró_Név");
        nevElement.setTextContent(biro.getBiro_nev());
        biroElement.appendChild(nevElement);

        Element tapasztalatokElement = doc.createElement("Tapasztalat");
        tapasztalatokElement.setTextContent(biro.getTapasztalat());
        biroElement.appendChild(tapasztalatokElement);

        Element tanitvanyokElement = doc.createElement("Tanítványok");
        tanitvanyokElement.setTextContent(biro.getTanitvanyok());
        biroElement.appendChild(tanitvanyokElement);

        parentElement.appendChild(biroElement);
    }

    private static void addJegyzo(Document doc, Element rootElement, List<Jegyzo> jegyzoList, List<String> kommentekList, boolean[] Comment) {
        for (Jegyzo jegyzo : jegyzoList) {
            addJegyzo(doc, rootElement, jegyzo, kommentekList, Comment);
        }
    }

    private static void addJegyzo(Document doc, Element parentElement, Jegyzo jegyzo, List<String> kommentekList, boolean[] Comment) {
        
        if (kommentekList.stream().anyMatch(comment -> comment.contains("Jegyzo")) && !Comment[6]) {
            Comment commentNode = doc.createComment("Jegyzo");
            parentElement.appendChild(commentNode);
            Comment[6] = true;
        }
    	
        Element jegyzoElement = doc.createElement("Jegyző");
        jegyzoElement.setAttribute("Jegyző_ID", jegyzo.getJegyzo_Id());
        jegyzoElement.setAttribute("Rögzítés", jegyzo.getRogzites());

        Element nevElement = doc.createElement("Jegyző_Név");
        nevElement.setTextContent(jegyzo.getJegyzo_nev());
        jegyzoElement.appendChild(nevElement);

        Element munkaidoElement = doc.createElement("Munkaidő");
        munkaidoElement.setTextContent(jegyzo.getMunkaIdo());
        jegyzoElement.appendChild(munkaidoElement);

        Element nyelvtudasElement = doc.createElement("Nyelvtudás");
        nyelvtudasElement.setTextContent(String.join(", ", jegyzo.getNyelvtudas()));
        jegyzoElement.appendChild(nyelvtudasElement);

        parentElement.appendChild(jegyzoElement);
    }

    private static List<Ugyved> UgyvedXML(Document doc) {
        List<Ugyved> UgyvedList = new ArrayList<>();
        NodeList nodeList = doc.getElementsByTagName("Ügyvéd");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                
                String vedi = element.getAttribute("Védi");
                String ugyvediId = element.getAttribute("Ügyvédi_ID");
                String szakterulet = element.getElementsByTagName("Szakterület").item(0).getTextContent();
                
                NodeList telefonszamNodes = element.getElementsByTagName("Telefonszám"); //Többértékű.
                List<String> telefonszamList = new ArrayList<>();
                for (int j = 0; j < telefonszamNodes.getLength(); j++) {
                    Node telefonszamNode = telefonszamNodes.item(j);
                    if (telefonszamNode.getNodeType() == Node.ELEMENT_NODE) {
                        telefonszamList.add(telefonszamNode.getTextContent());
                    }
                }
                
                String ugyved_nev = element.getElementsByTagName("Ügyvéd_Név").item(0).getTextContent();
                
                //Ugyved objektum létrehozása és hozzáadása a listához.
                UgyvedList.add(new Ugyved(vedi, ugyvediId, szakterulet, telefonszamList, ugyved_nev));
            }
        }
        return UgyvedList;
    }

    private static List<Vadlott> VadlottXML(Document doc) {
        List<Vadlott> VadlottList = new ArrayList<>();
        NodeList nodeList = doc.getElementsByTagName("Vádlott");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                
                String szemelyi_ig = element.getAttribute("Személyi_ig");
                String lakcim = element.getElementsByTagName("Lakcím").item(0).getTextContent();
                String szulido = element.getElementsByTagName("Szülidő").item(0).getTextContent();
                String kor = element.getElementsByTagName("Kor").item(0).getTextContent();
                String priusz = element.getElementsByTagName("Priusz").item(0).getTextContent();
                String vnev = element.getElementsByTagName("Vnév").item(0).getTextContent();
                String knev = element.getElementsByTagName("Knév").item(0).getTextContent();
                
                //Vadlott objektum létrehozása és hozzáadása a listához.
                VadlottList.add(new Vadlott(szemelyi_ig, lakcim, szulido, kor, priusz, vnev, knev));
            }
        }
        return VadlottList;
    }

    private static List<Bunose> BunoseXML(Document doc) {
        List<Bunose> BunoseList = new ArrayList<>();
        NodeList nodeList = doc.getElementsByTagName("Bűnös-e");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                
                String vadlott = element.getAttribute("Vádlott");
                String ugy = element.getAttribute("Ügy");
                String vad = element.getElementsByTagName("Vád").item(0).getTextContent();
                
                //Bunose objektum létrehozása és hozzáadása a listához.
                BunoseList.add(new Bunose(vadlott, ugy, vad));
            }
        }
        return BunoseList;
    }

    private static List<Ugy> UgyXML(Document doc) {
        List<Ugy> UgyList = new ArrayList<>();
        NodeList nodeList = doc.getElementsByTagName("Ügy");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                String ugy = element.getAttribute("Ügyszám_ID");
                String tipus = element.getElementsByTagName("Típus").item(0).getTextContent();
                String datum = element.getElementsByTagName("Dátum").item(0).getTextContent();
                String allapot = element.getElementsByTagName("Állapot").item(0).getTextContent();
                
                //Ugy objektum létrehozása és hozzáadása a listához.
                UgyList.add(new Ugy(ugy, tipus, datum, allapot));
            }
        }
        return UgyList;
    }


    private static List<Iteletethoz> IteletetHozXML(Document doc) {
        List<Iteletethoz> IteletetHozList = new ArrayList<>();
        NodeList nodeList = doc.getElementsByTagName("Ítéletet_hoz");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                String ugy = element.getAttribute("Ügy");
                String biro = element.getAttribute("Bíró");
                String ugyek_szama = element.getElementsByTagName("Ügyek_száma").item(0).getTextContent();
                String itelet = element.getElementsByTagName("Ítélet").item(0).getTextContent();

                //Iteletethoz objektum létrehozása és hozzáadása a listához.
                IteletetHozList.add(new Iteletethoz(ugy, biro, ugyek_szama, itelet));
            }
        }
        return IteletetHozList;
    }
    
    private static List<Biro> BiroXML(Document doc) {
        List<Biro> BiroDataList = new ArrayList<>();
        NodeList nodeList = doc.getElementsByTagName("Bíró");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                String biro_Id = element.getAttribute("Bíró_ID");
                String biro_nev = element.getElementsByTagName("Bíró_Név").item(0).getTextContent();
                String tapasztalat = element.getElementsByTagName("Tapasztalat").item(0).getTextContent();
                String tanitvanyok = element.getElementsByTagName("Tanítványok").item(0).getTextContent();

                //Biro objektum létrehozása és hozzáadása a listához.
                BiroDataList.add(new Biro(biro_Id, biro_nev, tapasztalat, tanitvanyok));
            }
        }
        return BiroDataList;
    }
    

    private static List<Jegyzo> JegyzoXML(Document doc) {
        List<Jegyzo> jegyzoList = new ArrayList<>();
        NodeList nodeList = doc.getElementsByTagName("Jegyző");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                String jegyzo_Id = element.getAttribute("Jegyző_ID");
                String rogzites = element.getAttribute("Rögzítés");
                String jegyzo_nev = element.getElementsByTagName("Jegyző_Név").item(0).getTextContent();
                String munkaido = element.getElementsByTagName("Munkaidő").item(0).getTextContent();
                String nyelvtudas = element.getElementsByTagName("Nyelvtudás").item(0).getTextContent();

                //Jegyzo objektum létrehozása és hozzáadása a listához.
                jegyzoList.add(new Jegyzo(jegyzo_Id, rogzites, jegyzo_nev, munkaido, nyelvtudas));
            }
        }
        return jegyzoList;
    }
}


