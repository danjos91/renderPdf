package org.example;

import com.ironsoftware.ironpdf.*;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>Hello from IronPDF!</h1>");
        pdf.saveAs("htmlstring_to_pdf.pdf");
        //PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>Hello from IronPDF!</h1>");
        //pdf.saveAs("htmlstring_to_pdf.pdf");
        System.out.println( "Hello World!";
    }
}
