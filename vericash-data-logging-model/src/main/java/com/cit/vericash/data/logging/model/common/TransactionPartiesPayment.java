package com.cit.vericash.data.logging.model.common;

import com.cit.vericash.data.logging.model.IBaseModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Transaction_Parties_Payment")
public class TransactionPartiesPayment implements IBaseModel , Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID",nullable=false)
    private Integer ID;
    @Column(name="account_no")
    private String accountNumber;
    @Column(name="card_no")
    private String cardNumber;
    @Column(name="card_type")
    private String cardType;
    @Column(name="payment_type")
    private int paymentType;
    @Column(name="account_type")
    @Enumerated(EnumType.ORDINAL)
    private AccountOwner ownerType;
    @Column(name="bank_code")
    private String bankCode;
    @Column(name="bank_name")
    private String bankName;
    @Column(name = "transaction_info_id")
    private long transactionInfoId;

    public enum AccountOwner {
        NONE,
        SENDER,
        RECEIVER;
    }


    public long getTransactionInfoId() {
        return transactionInfoId;
    }

    public void setTransactionInfoId(long transactionInfoId) {
        this.transactionInfoId = transactionInfoId;
    }

    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    public int getPaymentType() {
        return paymentType;
    }
    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public String getBankCode() {
        return bankCode;
    }
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
    public AccountOwner getOwnerType() {
        return ownerType;
    }
    public void setOwnerType(AccountOwner ownerType) {
        this.ownerType = ownerType;
    }
}
