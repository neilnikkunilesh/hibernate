package in.cdac.controller;



public class HallTicket {
	private String hallticket;
	private int pageNumber;
	private String pdfLink;
	private String message;
	private String contextPath;
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	public String getHallticket() {
		return hallticket;
	}

	public void setHallticket(String hallticket) {
		this.hallticket = hallticket;
	}

	public String getPdfLink() {
		return pdfLink;
	}

	public void setPdfLink(String pdfLink) {
		this.pdfLink = pdfLink;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	
}
