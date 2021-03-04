package com.aga;

public class Message {
	
	private int messageId;
	private String messageText;
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", messageText=" + messageText + "]";
	}
	public Message() {
	}
	public Message(int messageId, String messageText) {
		super();
		this.messageId = messageId;
		this.messageText = messageText;
	}
	
	
}
