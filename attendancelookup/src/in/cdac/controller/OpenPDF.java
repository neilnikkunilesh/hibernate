package in.cdac.controller;

import java.io.File;

public class OpenPDF {

	public String OpenPDFFile(String centre_code, String slot, int ht_page_no, HallTicket theHallTicket) {
		
		System.out.println("Inside OpenPDFFile Method\n");
        
		System.out.println("centre code: "+centre_code+" Slot: "+slot+" PageNumber: "+ht_page_no);
        
		String PDF_FILE_PATH = "./resources/Attendance_Data"+"/"+centre_code+"/"+centre_code+"_"+slot+"."+"pdf";//+"#"+"page"+"="+pageNumber;
        
        /*try {
            
            if(exist){
            	System.out.println("Inside filepath exists function");
                Process p =Runtime
                .getRuntime()
                .exec("rundll32 url.dll,FileProtocolHandler "+PDF_FILE_PATH);
            p.waitFor();
            return PDF_FILE_PATH;
            }
            else{
                System.out.println("File doesn't exists");
                //return PDF_FILE_PATH="";
                
            }
            //System.out.println("DONE");


        } catch (Exception e) {
            e.printStackTrace();
        }*/
        
        return PDF_FILE_PATH;
		
	}

}
