import org.w3c.dom.CharacterData;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/*
 0 USD US DOLLAR 15.2012 15.2621 15.2118 15.2392 1
1 AUD AUSTRALIAN DOLLAR 10.8621 11.0494 10.9123 10.9835 1
2 DKK DANISH KRONE 2.3072 2.3255 2.3088 2.3202 1
3 EUR EURO 17.1836 17.2525 17.1957 17.2267 1
4 GBP POUND STERLING 20.1503 20.2999 20.1644 20.2695 1
5 CHF SWISS FRANK 16.3996 16.5544 16.4242 16.5297 1
6 SEK SWEDISH KRONA 1.6697 1.6921 1.6709 1.6882 1
7 CAD CANADIAN DOLLAR 11.8308 11.9736 11.8747 11.9283 1
8 KWD KUWAITI DINAR 49.1167 51.2749 49.8647 50.5172 1
9 NOK NORWEGIAN KRONE 1.6871 1.7035 1.6883 1.6996 1
10 SAR SAUDI RIYAL 4.0237 4.0918 4.0541 4.0614 1
11 JPY JAPENESE YEN 13.2456 13.4337 13.2948 13.3829 100
12 BGN BULGARIAN LEV   8.7425 8.8569 1
13 RON NEW LEU   3.4544 3.4996 1
14 RUB RUSSIAN ROUBLE   0.20575 0.20844 1
15 IRR IRANIAN RIAL   0.03602 0.03649 100
16 CNY CHINESE RENMINBI   2.3756 2.4067 1
17 PKR PAKISTANI RUPEE   0.08489 0.08600 1
18 QAR QATARI RIAL   4.1545 4.2089 1
19 KRW SOUTH KOREAN WON   0.01278 0.01294 1
*/

public class main {
    public static ArrayList<Infos> currencies= new ArrayList<>();


    public static void main(String[] args) {
        getAllCurrencies();
        getCurrency("CNY");
        System.out.println(getCurrency("USD").forexBuying);


    }
    private static Infos getCurrency(String currencyname){
        return currencies.get(CurrencyName(currencyname));


    }
    private static void getAllCurrencies(){
        URL xmlURL;
        try {
            xmlURL = new URL("https://www.tcmb.gov.tr/kurlar/today.xml");

            InputStream xml = xmlURL.openStream();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xml);



            doc.getDocumentElement().normalize();



            NodeList nodes = doc.getElementsByTagName("Currency");
            Element element;
            for (int i = 0; i <20; i++) {

                element = (Element) nodes.item(i);
                String code=element.getAttribute("CurrencyCode");
                String currencyName=getValueofElement(element,"CurrencyName");
                String BanknoteBuying=getValueofElement(element,"BanknoteBuying");
                String BanknoteSelling=getValueofElement(element,"BanknoteSelling");
                String ForexBuying= getValueofElement(element,"ForexBuying");
                String ForexSelling=getValueofElement(element,"ForexSelling");
                String Unit= getValueofElement(element, "Unit");
               // System.out.println(i+" "+code+" "+currencyName+" "+BanknoteBuying+" "+BanknoteSelling+" "+ForexBuying+" "+ForexSelling+" "+Unit);

                currencies.add(new Infos(i,code,currencyName,BanknoteBuying,BanknoteSelling,ForexBuying,ForexSelling,Unit));



            }
            xml.close();

        } catch (MalformedURLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }





    }
    private static int CurrencyName(String CurrencyName){
        if(CurrencyName.equals("USD")) return 0;
        else if(CurrencyName.equals("AUD")) return 1;
        else if(CurrencyName.equals("DKK")) return 2;
        else if(CurrencyName.equals("EUR")) return 3;
        else if(CurrencyName.equals("GBP")) return 4;
        else if(CurrencyName.equals("CHF")) return 5;
        else if(CurrencyName.equals("SEK")) return 6;
        else if(CurrencyName.equals("CAD")) return 7;
        else if(CurrencyName.equals("KWD")) return 8;
        else if(CurrencyName.equals("NOK")) return 9;
        else if(CurrencyName.equals("SAR")) return 10;
        else if(CurrencyName.equals("JPY")) return 11;
        else if(CurrencyName.equals("BGN")) return 12;
        else if(CurrencyName.equals("RON")) return 13;
        else if(CurrencyName.equals("RUB")) return 14;
        else if(CurrencyName.equals("IRR")) return 15;
        else if(CurrencyName.equals("CNY")) return 16;
        else if(CurrencyName.equals("PKR")) return 17;
        else if(CurrencyName.equals("QAR")) return 18;
        else if(CurrencyName.equals("KRW")) return 19;
        else return -1;

    }
    private static String getValueofElement(Element parentElement, String label) {

        String retval="";
        Element requiredElement=(Element) parentElement.getElementsByTagName(label).item(0);

        try {
            Node child = requiredElement.getFirstChild();
            if (child instanceof CharacterData) {
                CharacterData cd = (CharacterData) child;
                retval= cd.getData();
            }
            else
            {

            }

        } catch (Exception ex) {
        }

        return retval;
    }
}
