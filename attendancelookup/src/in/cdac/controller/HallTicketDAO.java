package in.cdac.controller;


import org.springframework.beans.factory.annotation.Autowired;

public class HallTicketDAO {
	static String full_hall_ticket_no, centre_code, slot, hall_ticket;
	static int hall_ticket_integer, OFF_SET = 1;
	static int page_count, index, ht_page_no;
	String PDF_FILE_PATH;

	public String generateLink(HallTicket theHallTicket) {
		
		OpenPDF opdf = new OpenPDF();
		System.out.println("inside generateLink " + theHallTicket.getHallticket());
		try {
			full_hall_ticket_no = theHallTicket.getHallticket();

			// getting centre code
			centre_code = full_hall_ticket_no.substring(9, 12);

			// getting slot
			slot = full_hall_ticket_no.substring(14, 15);

			// getting hall ticket no
			hall_ticket = full_hall_ticket_no.substring(15);

		} catch (Exception e) {
			return PDF_FILE_PATH="";
		}
		
		System.out.println("Centre Code is: " + centre_code);
		System.out.println("Slot: " + slot);
		System.out.println("Hall Ticket: " + hall_ticket);

		// Parsing of Hall ticket No
		hall_ticket_integer = Integer.parseInt(hall_ticket);
		System.out.println("Integer Hall ticket No: " + hall_ticket_integer);
		
		if(hall_ticket_integer >=175) {
			return PDF_FILE_PATH="";
		}
		
		else if(hall_ticket_integer <= 4){
            ht_page_no= OFF_SET+1;
            theHallTicket.setPageNumber(ht_page_no);
            System.out.println("Attendance will be in Page No.:"+ht_page_no);
            
            //Opening PDF file
            opdf.OpenPDFFile(centre_code, slot, ht_page_no, theHallTicket);
             
        }else{
            index = hall_ticket_integer/5;
            ht_page_no = index+1+OFF_SET;
            theHallTicket.setPageNumber(ht_page_no);
            System.out.println("Attendance of HallTicket "+hall_ticket+" is on page number: "+ht_page_no);
            
            //Opening PDF file
           PDF_FILE_PATH = opdf.OpenPDFFile(centre_code, slot, ht_page_no, theHallTicket);
        }
		return PDF_FILE_PATH;
	}
	
}
