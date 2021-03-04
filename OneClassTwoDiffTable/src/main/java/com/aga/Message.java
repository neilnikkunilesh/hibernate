package com.aga;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="message_details",uniqueConstraints = {@UniqueConstraint(columnNames = "messageTitle")})
@SecondaryTable(name = "sender_details")
/*
 * 
// custom column name for new table.
// @PrimaryKeyJoinColumn specifies a primary key column that is used as a foreign key
// to join to another table.
@SecondaryTable(name = "sender_details", pkJoinColumns = {
				@PrimaryKeyJoinColumn(name="message_id",
						referencedColumnName = "messageId")})
// using may secondary table
@SecondaryTables({
	@SecondaryTable(name = "sender_details"),
	@SecondaryTable(name = "receiver_details")
})
*/
public class Message {

	@Id
	@GeneratedValue
	private int messageId;
	private String messageTitle;
	
	@Basic(fetch = FetchType.LAZY, optional = false)
	@Column(name="messageText", length = 500, nullable = false, unique = false)
	private String messageText;
	
	@Transient
	private Date messageReceivedDate;
	
	@Column(table = "sender_details", name = "msg_sender_name")
	private String messageSendBy;
	
	@Column(table = "sender_details", name="msg_send_date")
	@Temporal(TemporalType.DATE)
	private Date messageSendDate;
	
	@Column(table = "sender_details", name="msg_send_time")
	@Temporal(TemporalType.TIME)
	private Date messageSendTime;
	
	@Column(table = "sender_details", precision = 5, scale = 2)
	private BigDecimal messageCost;
	
	
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getMessageTitle() {
		return messageTitle;
	}
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public Date getMessageReceivedDate() {
		return messageReceivedDate;
	}
	public void setMessageReceivedDate(Date messageReceivedDate) {
		this.messageReceivedDate = messageReceivedDate;
	}
	public String getMessageSendBy() {
		return messageSendBy;
	}
	public void setMessageSendBy(String messageSendBy) {
		this.messageSendBy = messageSendBy;
	}
	public Date getMessageSendDate() {
		return messageSendDate;
	}
	public void setMessageSendDate(Date messageSendDate) {
		this.messageSendDate = messageSendDate;
	}
	public Date getMessageSendTime() {
		return messageSendTime;
	}
	public void setMessageSendTime(Date messageSendTime) {
		this.messageSendTime = messageSendTime;
	}
	public BigDecimal getMessageCost() {
		return messageCost;
	}
	public void setMessageCost(BigDecimal messageCost) {
		this.messageCost = messageCost;
	}
	
	
}
