package com.cit.vericash.data.logging.model.common;

import com.cit.vericash.data.logging.model.IBaseModel;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Commission_Exec_Steps")
public class CommissionExecutionStep implements IBaseModel , Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Commission_Step_ID", nullable = false)
    private Long commissionStepID;
    @Column(name = "Reversible")
    private boolean reversible=false;
    @Column(name = "Need_Approval")
    private Boolean needApproval=false;
    @Column(name = "Account_ID", nullable = false)
    private Long accountID;



    @Column(name = "Account_Owner_Type_ID")
    private int accountOwnerType;


    @Column(name = "Step_Action_Type", nullable = false)
    private int stepActionType;
    @Column(name = "Amount_Type", nullable = true)
    @Enumerated
    private AmountType amountType;

    @Column(name = "Amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "Transaction_Status")
    @Enumerated
    private TransactionStatus stepStatus;
    @Column(name = "Step_Start_Date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date stepStartDate;
    @Column(name = "Step_End_Date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date stepEndDate;

    @Column(name = "Risk_Profile")
    private Long riskProfile;

    @Column(name = "Fee_Profile")
    private Long feeProfile;

    /*public CommissionExecutionSummary getCommissionExecutionSummary() {
        return commissionExecutionSummary;
    }

    public void setCommissionExecutionSummary(CommissionExecutionSummary commissionExecutionSummary) {
        this.commissionExecutionSummary = commissionExecutionSummary;
    }*/


    /*@ManyToOne
    @JoinColumn(name = "Comm_Exec_Summary_ID", nullable = false)
    private CommissionExecutionSummary commissionExecutionSummary;*/

    @Column(name = "Commission_Profile")
    private Long commissionProfile;
    private boolean isCommissionStep=false;
    private boolean isFeesStep=false;
    private BigDecimal balance;
    @Column(name="wallet_Short_Code")
    private String walletShortCode;

    public Long getCommissionStepID() {
        return commissionStepID;
    }

    public void setCommissionStepID(Long transactionStepID) {
        this.commissionStepID = transactionStepID;
    }

    public boolean isReversible() {
        return reversible;
    }

    public void setReversible(boolean reversible) {
        this.reversible = reversible;
    }

    public Boolean isNeedApproval() {
        return needApproval;
    }

    public void setNeedApproval(Boolean needApproval) {
        this.needApproval = needApproval;
    }

    public Long getAccountID() {
        return accountID;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    public int getAccountOwnerType() {
        return accountOwnerType;
    }

    public void setAccountOwnerType(int accountOwnerType) {
        this.accountOwnerType = accountOwnerType;
    }

    public int getStepActionType() {
        return stepActionType;
    }

    public void setStepActionType(int stepActionType) {
        this.stepActionType = stepActionType;
    }

    public AmountType getAmountType() {
        return amountType;
    }

    public void setAmountType(AmountType amountType) {
        this.amountType = amountType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TransactionStatus getStepStatus() {
        return stepStatus;
    }

    public void setStepStatus(TransactionStatus stepStatus) {
        this.stepStatus = stepStatus;
    }

    public Date getStepStartDate() {
        return stepStartDate;
    }

    public void setStepStartDate(Date stepStartDate) {
        this.stepStartDate = stepStartDate;
    }

    public Date getStepEndDate() {
        return stepEndDate;
    }

    public void setStepEndDate(Date stepEndDate) {
        this.stepEndDate = stepEndDate;
    }

    public Long getRiskProfile() {

        return riskProfile;
    }

    public void setRiskProfile(Long riskProfile) {
        this.riskProfile = riskProfile;
    }

    public Long getFeeProfile() {
        return feeProfile;
    }

    public void setFeeProfile(Long feeProfile) {
        this.feeProfile = feeProfile;
    }

    public Long getCommissionProfile() {
        return commissionProfile;
    }

    public void setCommissionProfile(Long commissionProfile) {
        this.commissionProfile = commissionProfile;
    }

    public boolean isCommissionStep() {
        return isCommissionStep;
    }

    public void setCommissionStep(boolean isCommissionStep) {
        this.isCommissionStep = isCommissionStep;
    }

    public boolean isFeesStep() {
        return isFeesStep;
    }

    public void setFeesStep(boolean isFeesStep) {
        this.isFeesStep = isFeesStep;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getWalletShortCode() {
        return walletShortCode;
    }

    public void setWalletShortCode(String walletShortCode) {
        this.walletShortCode = walletShortCode;
    }

 /*   public boolean equals(Object obj) {
        if (obj instanceof CommissionExecutionStep) {
            CommissionExecutionStep other = (CommissionExecutionStep) obj;
            if (this.getCommissionStepID() != null) {
                return this.getCommissionStepID().equals(
                        other.getCommissionStepID());
            }
        }
        return false;
    }

    public int hashCode() {
        if (getCommissionStepID() != null) {
            return getCommissionStepID().intValue();
        } else {
            return 1;
        }

    }*/

    public String toString() {
        return "CommissionExecutionStep [commissionStepID="
                + commissionStepID + ", reversible=" + reversible
                + ", needApproval=" + needApproval + ", accountID=" + accountID
                + ", accountOwnerType=" + accountOwnerType
                + ", stepActionType=" + stepActionType + ", amountType="
                + amountType + ", amount=" + amount + ", stepStatus="
                + stepStatus + ", stepStartDate=" + stepStartDate
                + ", stepEndDate=" + stepEndDate + ", riskProfile="
                + riskProfile + ", feeProfile=" + feeProfile
                + ", commissionProfile=" + commissionProfile
                + ", isCommissionStep=" + isCommissionStep + ", isFeesStep="
                + isFeesStep + ", balance=" + balance + "]";
    }


    public static enum AmountType {
        TRANSACTION,
        FIXED_FEES,
        FEES,
        EXTERNAL_CHARGES,
        SUBSTITUTION,
        COMMISSION,
        PRE_CALCULATED_FEES,
        SIMPLE_COMMISSION;

        private AmountType() {
        }
    }
    public enum TransactionStatus {
        INITIATED,
        SUCCEEDED,
        FAILED,
        REVERSED,
        WAIT_APPROVAL,
        PENDING_REVERSAL,
        PARTIALLY_REVERSED,
        REDEEMED;

        private TransactionStatus() {
        }
    }

}

