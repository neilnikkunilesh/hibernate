package com.aga;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

/* @Entity annotation mark this class as entity class
 * So it must have a no-argument constructor that is visible with at least protected scope.
 * Hibernate support package scope as the minimum, but you  loose portability to other containers if you
 * take advantage of this
 * JPA 2 rules for an entity bean class are that the class must not be final, and the entity bean class must
 * be concrete
 * 	*/
@Entity
public class Message {
	
	
	
	@Id
	@TableGenerator(name="tablegenRef", table="key_generator", pkColumnName="pk_id", pkColumnValue="pk_value",
	valueColumnName="next_id", allocationSize=2)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tablegenRef")
	private int messageId;
	
	private String messageText;
	private Date dateOfMessage;

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
	
	public Date getDateOfMessage() {
		return dateOfMessage;
	}
	public void setDateOfMessage(Date dateOfMessage) {
		this.dateOfMessage = dateOfMessage;
	}
	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", messageText=" + messageText + ", dateOfMessage=" + dateOfMessage
				+ "]";
	}
	public Message() {
	}
	
	public Message(int messageId, String messageText, Date dateOfMessage) {
		super();
		this.messageId = messageId;
		this.messageText = messageText;
		this.dateOfMessage = dateOfMessage;
	}
	
	
}
