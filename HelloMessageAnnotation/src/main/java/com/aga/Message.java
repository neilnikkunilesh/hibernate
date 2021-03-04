package com.aga;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/* @Entity annotation mark this class as entity class
 * So it must have a no-argument constructor that is visible with at least protected scope.
 * Hibernate support package scope as the minimum, but you  loose portability to other containers if you
 * take advantage of this
 * JPA 2 rules for an entity bean class are that the class must not be final, and the entity bean class must
 * be concrete
 * 	*/
@Entity
public class Message {
	
	
	/*
	 * The use of the GeneratedValue annotation is onlyrequired to be supported for
	 * simple primary keys. Use of the GeneratedValue annotation is not supported
	 * for derived primary keys.
	 * >>>>>If you annotate the attribute itself, Hibernate uses field-based access.
	 */ 
	@Id
	@GeneratedValue 
	/* Default Generator Type is AUTO ##@GeneratedValue & @GeneratedValue(strategy=GenerationType.AUTO) is same 
		AUTO: Hibernate decide which generator type to use, based on the database's support for primary key generation(identity column, sequence or table)
		IDENTITY: The DB is responsible for determining and assigning the next primary key
		SEQUENCE: Some DB support a SEQUENCE column type
		TABLE: This type keeps a separate table with the primary key values.
	*/
	
	/* MySql Doesn't support sequence	*/
	/*
	 * @Id
	 * @SequenceGenerator(name="seqRef", sequenceName="message_seq",
	 * initialValue=100, allocationSize=2)
	 * @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqRef")
	 */
	private int messageId;
	
	/*
	 * @Id
	 * @GeneratedValue(strategy=GenerationType.IDENTITY) //Same as AUTO, but diff is a separate identity generator
	 * 	//is managed per type hierarchy, so generated value are unique only per type Hierarchy
	*/
	
	private String messageText;
	private Date dateOfMessage;
	/* if instead the annotation is applied to the getter for the field,
	 * then property access will be used.	
	 */
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
