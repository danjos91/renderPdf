package org.example;

import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;
import java.io.IOException;
import java.nio.file.Paths;
import java.io.*;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.extend.FontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;
import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
public class App {
//    public static void main(String[] args) throws IOException, PrinterException {

    public static void main(String[] args) throws IOException, PrinterException {
        try (Playwright playwright = Playwright.create()) {
            List<BrowserType> browserTypes = Arrays.asList(
                    playwright.chromium()
                    //playwright.webkit(),
                    //playwright.firefox()
            );
            for (BrowserType browserType : browserTypes) {
                try (Browser browser = browserType.launch()) {
                    BrowserContext context = browser.newContext();
                    Page page = context.newPage();
                    page.navigate("http://192.168.0.194:8080/login");
                    page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot-" + browserType.name() + ".png")));
                }
            }
        }
    }
//        PdfDocument pdf = PdfDocument.renderUrlAsPdf("http://192.168.0.194:8080/login");
//        PdfDocument pdf1 = PdfDocument.renderHtmlAsPdf("<h1>hello</h1>>");
//        pdf1.saveAs("teset1000.pdf");
//        pdf.print();
//        pdf.saveAs("gg.pdf");
//        String test = pdf.extractAllText();
        //pdf.printWithoutDialog();
        // pdf.getBinaryData();
        //pdf.saveAs("C:\Users\Danny\Desktop\Work\pdf-reader\src\main\java\org\example\");


//        String html = "<h1>hello</h1>";
//        //Creating a HttpGet object
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        HttpGet httpget = new HttpGet("http://www.something.com/");
//        //Executing the Get request
//        HttpResponse httpresponse = httpclient.execute(httpget);
//        Scanner sc = new Scanner(httpresponse.getEntity().getContent());
//        //Instantiating the StringBuffer class to hold the result
//        StringBuffer sb = new StringBuffer();
//        while(sc.hasNext()) {
//            sb.append(sc.next());
//            //System.out.println(sc.next());
//        }
//        //Retrieving the String from the String Buffer object
//        String result = sb.toString();
//        String xhtml = htmlToXhtml(result);
//        xhtmlToPdf(xhtml, "output.pdf");
 //   }

    private static String htmlToXhtml(String html) {
        Document document = Jsoup.parse(html);
        document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
        return document.html();
    }

    private static void xhtmlToPdf(String xhtml, String outFileName) throws IOException {
        File output = new File(outFileName);
        ITextRenderer iTextRenderer = new ITextRenderer();
        FontResolver resolver = iTextRenderer.getFontResolver();
        //iTextRenderer.getFontResolver().addFont("MyFont.ttf", true);
        iTextRenderer.setDocumentFromString(xhtml);
        iTextRenderer.layout();
        OutputStream os = new FileOutputStream(output);
        iTextRenderer.createPDF(os);
        os.close();
    }
}


//        // Apply your license key
//        //License.setLicenseKey("YOUR-LICENSE-KEY");
//        System.out.println("TEST");
//        PdfDocument myPdf = PdfDocument.renderUrlAsPdf("https://ironpdf.com/java");
//        InternalPdfDocument internalPdfDocument = RenderPdf.renderUrlAsPdf("https://ironpdf.com/java");
//        byte[] pdfByte = internalPdfDocument.remoteDocument.toByteArray();
//
//       //PdfDocument pdfDocument = PdfDocument.renderUrlAsPdf("https://ironpdf.com/java/docs/");
//
//
//        // Set a log path
//        //Settings.setLogPath(Paths.get("C:/Users/Danny/Desktop/Work/IronPdfEngine.log"));
//        // Render the HTML as a PDF. Stored in myPdf as type PdfDocument
//        //PdfDocument myPdf = PdfDocument.renderHtmlAsPdf("<h1> ~Hello World~ </h1> Made with IronPDF!");
//        // Save the PdfDocument to a file
//        //myPdf.saveAs(Paths.get("C:/Users/Danny/Desktop/Work/html_saved.pdf"));
//        File newfile = new File("./test.pdf");
//        //myPdf.print();
//        //byte[] pdfByte = myPdf.getBinaryData();
//        try ( FileOutputStream fos = new FileOutputStream(newfile); ) {
//            // To be short I use a corrupted PDF string, so make sure to use a valid one if you want to preview the PDF file
//            //String b64 = "JVBERi0xLjUKJYCBgoMKMSAwIG9iago8PC9GaWx0ZXIvRmxhdGVEZWNvZGUvRmlyc3QgMTQxL04gMjAvTGVuZ3==";
//            //byte[] decoder = Base64.getDecoder().decode(b64);
//
//            fos.write(pdfByte);
//            System.out.println("PDF File Saved");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

//package org.example;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Scanner;
//import java.lang.Object.*;
//
//// import com.lowagie.text.pdf.PdfDocument;
//import com.lowagie.text.pdf.PdfDocument;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import com.ironsoftware.ironpdf.*;
//
//import java.nio.file.Paths;
//
///**
// * Hello world!
// *
// */
//public class App
//{
//    public static void main( String[] args ) throws IOException {
//
//        // Apply your license key
////        License.setLicenseKey("YOUR-LICENSE-KEY");
////
////// Set a log path
////        Settings.setLogPath(Paths.get("C:/tmp/IronPdfEngine.log"));
////
////// Render the HTML as a PDF. Stored in myPdf as type PdfDocument;
////        PdfDocument myPdf = PdfDocument.renderUrlAsPdf("https://ironpdf.com");
////        PdfDocument myPdf = PdfDocument.
//
//// Save the PdfDocument to a file
////        myPdf.saveAs(Paths.get("url.pdf"));
//
//        System.out.println( "Getting pdf!" );
//        //Creating a HttpClient object
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        //Creating a HttpGet object
//        HttpGet httpget = new HttpGet("http://www.something.com/");
//        //Executing the Get request
//        HttpResponse httpresponse = httpclient.execute(httpget);
//        Scanner sc = new Scanner(httpresponse.getEntity().getContent());
//        //Instantiating the StringBuffer class to hold the result
//        StringBuffer sb = new StringBuffer();
//        while(sc.hasNext()) {
//            sb.append(sc.next());
//            //System.out.println(sc.next());
//        }
//        //Retrieving the String from the String Buffer object
//        String result = sb.toString();
//        System.out.println(result);
//        //Removing the HTML tags
//        result = result.replaceAll("<[^>]*>", "");
//        System.out.println("Contents of the web page: "+result);
//    }
//
//}
