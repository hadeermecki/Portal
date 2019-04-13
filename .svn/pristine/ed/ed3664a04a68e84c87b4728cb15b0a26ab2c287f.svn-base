package com.cit.vericash.data.logging.model.common;

import com.cit.vericash.data.logging.model.IBaseModel;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Table(name="Transaction_External_Account")
public class TransactionExternalAccount implements IBaseModel , Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID", nullable=false)
    private Integer ID;

    @Column(name="receiver_account_no")
    private String receiverAccountNumber;

    @Column(name="receiver_card_no")
    private String receiverCardNumber;

    @Column(name="sender_account_no")
    private String senderAccountNumber;

    @Column(name="receiver_client_id")
    private String receiverClientId;

    @Column(name="sender_client_id")
    private String senderClientId;

    @Column(name="sender_card_no")
    private String senderCardNumber;

    @Column(name="transaction_id")
    private Long transID;



    @Column(name="Transaction_Reference")
    private String transactionReference;

    @Column(name="Transaction_Start_Date")
    private Date transactionDate;

    @Column(name="Transaction_Start_Date_Str")
    private String transactionDateStr;

    @Column(name="Stack_Number")
    private String stackNumber;

    @Column(name="amount")
    private BigDecimal amount;

    @Column(name="status")
    @Enumerated
    private TransactionExecutionSummary.TransactionStatus transactionStatus;

    @Column(name="narration")
    private String narration;

    @Column(name="Reversal_comment")
    private String comment;

    public BigDecimal getAmount()
    {
        return this.amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public String getStackNumber() {
        return this.stackNumber;
    }
    public void setStackNumber(String stackNumber) {
        this.stackNumber = stackNumber;
    }
    public String getTransactionDateStr() {
        return transactionDateStr;
    }

    private void setTransactionDateStr(String transactionDateStr) {
        this.transactionDateStr = transactionDateStr;
    }
    public Date getTransactionDate() {
        return this.transactionDate;
    }
    public void setTransactionDate(Date transactionDate) {
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd");
        this.transactionDate = transactionDate;
        String date = simpleDateFormat.format(transactionDate);
        setTransactionDateStr(date);
    }
    public Integer getID() {
        return this.ID;
    }
    public void setID(Integer iD) {
        this.ID = iD;
    }
    public String getReceiverCardNumber() {
        return this.receiverCardNumber;
    }
    public void setReceiverCardNumber(String receiverCardNumber) {
        this.receiverCardNumber = receiverCardNumber;
    }
    public String getSenderCardNumber() {
        return this.senderCardNumber;
    }
    public void setSenderCardNumber(String senderCardNumber) {
        this.senderCardNumber = senderCardNumber;
    }
    public String getReceiverAccountNumber() {
        return this.receiverAccountNumber;
    }
    public void setReceiverAccountNumber(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }
    public Long getTransID() {
        return this.transID;
    }
    public void setTransID(Long transID) {
        this.transID = transID;
    }
    public String getTransactionReference() {
        return this.transactionReference;
    }
    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }
    public String getSenderAccountNumber() {
        return this.senderAccountNumber;
    }
    public void setSenderAccountNumber(String senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }
    public TransactionExecutionSummary.TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }
    public void setTransactionStatus(TransactionExecutionSummary.TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
    public String getReceiverClientId() {
        return receiverClientId;
    }
    public void setReceiverClientId(String receiverClientId) {
        this.receiverClientId = receiverClientId;
    }
    public String getSenderClientId() {
        return senderClientId;
    }
    public void setSenderClientId(String senderClientId) {
        this.senderClientId = senderClientId;
    }
    public String getNarration() {
        return narration;
    }
    public void setNarration(String narration) {
        this.narration = narration;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

}

