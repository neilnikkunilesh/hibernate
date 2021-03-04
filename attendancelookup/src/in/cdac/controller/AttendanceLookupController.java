package in.cdac.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AttendanceLookupController {
	
	@GetMapping("/")
	public String showHome(Model model) {
		System.out.println("in home");
		return "home";
	}
	
	@RequestMapping("/attendancefind")
	public String ShowHTPage(Model model) {
		model.addAttribute("findermodel", new HallTicket());

		return "findht";
	}

	@RequestMapping("/findpdf")
	public String findpdf(@ModelAttribute("findermodel") HallTicket theHallTicket, HttpServletRequest httpServeltRequest) {
		String PDF_FILE_PATH;
		HallTicketDAO hallTicketDAO = new HallTicketDAO();
		
		//Getting Context path
		System.out.println("Context Path: "+httpServeltRequest.getContextPath());
		theHallTicket.setContextPath(httpServeltRequest.getContextPath());
		
		System.out.println("TheHallTicket: " + theHallTicket.getHallticket());
		
		// Checking Hall Ticket Number
		if(theHallTicket.getHallticket() != null && theHallTicket.getHallticket().length() ==19 && theHallTicket.getHallticket() != "") {
			
			PDF_FILE_PATH = hallTicketDAO.generateLink(theHallTicket);
			System.out.println("inside findpdf: "+ PDF_FILE_PATH);
	
			theHallTicket.setPdfLink(PDF_FILE_PATH+"#"+"page"+"="+theHallTicket.getPageNumber());
			theHallTicket.setMessage("Click on the Hallticket To View Attendance: ");
		}
		else if(theHallTicket.getHallticket().length() !=19) {
			theHallTicket.setMessage("You Have entered wrong hall ticket number");
			theHallTicket.setPdfLink("");
			return "findht";
		}
		else {
			theHallTicket.setMessage("You Have entered wrong hall ticket number");
			theHallTicket.setPdfLink("");
			return "findht";
		}
		
		
		//PDF_FILE_PATH = hallTicketDAO.generateLink(theHallTicket);
		//theHallTicket.setPdfLink(PDF_FILE_PATH+"#"+"page"+"="+theHallTicket.getPageNumber());
		//theHallTicket.setMessage("Click on the Hallticket To View Attendance: ");
		return "findht";
	}
	
	@RequestMapping(value = "errors", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
         
        ModelAndView errorPage = new ModelAndView("404");
        String errorMsg = "";
        int httpErrorCode = getErrorCode(httpRequest);
 
        switch (httpErrorCode) {
            case 400: {
                errorMsg = "Http Error Code: 400. Bad Request";
                break;
            }
            case 401: {
                errorMsg = "Http Error Code: 401. Unauthorized";
                break;
            }
            case 404: {
                errorMsg = "Http Error Code: 404. Resource not found";
                break;
            }
            case 500: {
                errorMsg = "Http Error Code: 500. Internal Server Error";
                break;
            }
        }
        errorPage.addObject("errorMsg", errorMsg);
        return errorPage;
    }
     
    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
          .getAttribute("javax.servlet.error.status_code");
    }
	
}
