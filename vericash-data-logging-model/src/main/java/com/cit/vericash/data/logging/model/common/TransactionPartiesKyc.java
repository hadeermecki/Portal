package com.cit.vericash.data.logging.model.common;

import com.cit.vericash.data.logging.model.IBaseModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Transaction_Parties_Kyc")
public class TransactionPartiesKyc implements IBaseModel , Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer infoID;
    @Column(name="sender_msisdn")
    private String senderMsisdn;
    @Column(name="reciever_msisdn")
    private String recieverMsisdn;
    @Column(name="reciever_first_name")
    private String recieverFirstName;
    @Column(name="reciever_middle_name")
    private String recieverMiddleName;
    @Column(name="reciever_last_name")
    private String recieverLastName;
    @Column(name="reciever_biller_id")
    private String recieverBillerId;
    @Column(name="reciever_bill_id")
    private String recieverBillId;
    @Column(name="reciever_biller_Name")
    private String recieverBillerName;

    public long getServicelogId() {
        return servicelogId;
    }

    public void setServicelogId(long servicelogId) {
        this.servicelogId = servicelogId;
    }

    @Column(name="service_log_id")
    private long servicelogId;

    @Column(name="Transaction_Reference")
    private String transactionReference;

    @Column(name="Transaction_Id")
    private Long transactionId;
    public String getRecieverBillerId() {
        return recieverBillerId;
    }
    public void setRecieverBillerId(String recieverBillerId) {
        this.recieverBillerId = recieverBillerId;
    }
    public String getRecieverBillId() {
        return recieverBillId;
    }
    public void setRecieverBillId(String recieverBillId) {
        this.recieverBillId = recieverBillId;
    }
    public String getRecieverBillerName() {
        return recieverBillerName;
    }
    public void setRecieverBillerName(String recieverBillerName) {
        this.recieverBillerName = recieverBillerName;
    }

    public int getInfoID() {
        return infoID;
    }
    public void setInfoID(int infoID) {
        this.infoID = infoID;
    }
    public String getSenderMsisdn() {
        return senderMsisdn;
    }
    public void setSenderMsisdn(String senderMsisdn) {
        this.senderMsisdn = senderMsisdn;
    }
    public String getRecieverMsisdn() {
        return recieverMsisdn;
    }
    public void setRecieverMsisdn(String recieverMsisdn) {
        this.recieverMsisdn = recieverMsisdn;
    }
    public String getRecieverFirstName() {
        return recieverFirstName;
    }
    public void setRecieverFirstName(String recieverFirstName) {
        this.recieverFirstName = recieverFirstName;
    }
    public String getRecieverMiddleName() {
        return recieverMiddleName;
    }
    public void setRecieverMiddleName(String recieverMiddleName) {
        this.recieverMiddleName = recieverMiddleName;
    }
    public String getRecieverLastName() {
        return recieverLastName;
    }
    public void setRecieverLastName(String recieverLastName) {
        this.recieverLastName = recieverLastName;
    }
    public Long getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
    public String getTransactionReference() {
        return transactionReference;
    }
    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

}
