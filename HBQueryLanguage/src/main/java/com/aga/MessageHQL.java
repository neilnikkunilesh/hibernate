package com.aga;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@NamedQuery(
		name = "findMessageBySenderName",
		query = "from MessageHQL where senderName = :senderName"//HQL
		)
/*
 * @NamedQueries({
 * 
 * @NamedQuery( name = "findMessageBySenderName", query =
 * "from MessageHQL where senderName = :senderName" ),
 * 
 * @NamedQuery( name = "findMessageById", query =
 * "from MessageHQL where messageId = :messageId"//HQL ) })
 */
public class MessageHQL {

	@Id
	@GeneratedValue
	private int messageId;
	
	@Column(name = "messageText", nullable = false, length = 200, unique = false)
	private String messageText;
	private String senderName;
	
	@Temporal(TemporalType.TIMESTAMP)//it is default
	private Date sendDate;

	public MessageHQL() {
		
	}
	public MessageHQL(String messageText, String senderName) {
		super();
		this.messageText = messageText;
		this.senderName = senderName;
	}

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

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	
	
	
}
