package com.cit.vericash.data.logging.model.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cit.vericash.data.logging.model.IBaseModel;
import com.cit.vericash.data.logging.model.common.TransactionExecutionSummary.TransactionStatus;



@Entity
@Table(name = "TRANS_EXEC_STEPS")
public class TransactionExecutionStep implements IBaseModel, Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Trans_Step_ID", nullable = false)
	private Long transactionStepID;
	@Column(name = "Reversible")
	private boolean reversible=false;
	@Column(name = "Need_Approval")
	private Boolean needApproval=false;
	@Column(name = "Account_ID", nullable = false)
	private Long accountID;
	

	@Column(name = "Account_Owner_Type_ID")
	private int accountOwnerType;
	
	@Column(name = "Step_Action_Type", nullable = false)
	private TransactionActionType stepActionType;
	
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

	@Column(name = "Step_Start_Date_Str", nullable = false)
	private String stepStartDateStr;

	@Column(name = "Step_End_Date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date stepEndDate;

	public String getStepStartDateStr() {
		return stepStartDateStr;
	}

	private void setStepStartDateStr(String stepStartDateStr) {
		this.stepStartDateStr = stepStartDateStr;
	}

	public String getStepEndDateStr() {
		return stepEndDateStr;
	}

	private void setStepEndDateStr(String stepEndDateStr) {
		this.stepEndDateStr = stepEndDateStr;
	}

	@Column(name = "Step_End_Date_Str", nullable = false)
	private String stepEndDateStr;

	@Column(name = "Risk_Profile")
	private Long riskProfile;

	@Column(name = "Fee_Profile")
	private Long feeProfile;
	
	@Column(name = "Commission_Profile")
	private Long commissionProfile;
	private boolean isCommissionStep=false;
	private boolean isFeesStep=false;
	private BigDecimal balance;
	@Column(name="wallet_Short_Code")
	private String walletShortCode;

	public enum TransactionActionType
	{
		NONE,
		CREDIT,
		DEBIT;
	}
	public enum AmountType {
		TRANSACTION,
		FIXED_FEES,
		FEES,
		EXTERNAL_CHARGES,
		SUBSTITUTION,
		COMMISSION,
		PRE_CALCULATED_FEES,
		SIMPLE_COMMISSION;
	}
	public Long getTransactionStepID() {
		return transactionStepID;
	}

	public void setTransactionStepID(Long transactionStepID) {
		this.transactionStepID = transactionStepID;
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
		SimpleDateFormat simpleDateFormat =
				new SimpleDateFormat("yyyy-MM-dd");
		this.stepStartDate = stepStartDate;
		String date = simpleDateFormat.format(stepStartDate);
		setStepStartDateStr(date);
	}

	public Date getStepEndDate() {
		return stepEndDate;
	}

	public void setStepEndDate(Date stepEndDate) {
		SimpleDateFormat simpleDateFormat =
				new SimpleDateFormat("yyyy-MM-dd");
		this.stepEndDate = stepEndDate;
		String date = simpleDateFormat.format(stepEndDate);
		setStepEndDateStr(date);
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

	public TransactionActionType getStepActionType() {
		return stepActionType;
	}

	public void setStepActionType(TransactionActionType stepActionType) {
		this.stepActionType = stepActionType;
	}

	public AmountType getAmountType() {
		return amountType;
	}

	public void setAmountType(AmountType amountType) {
		this.amountType = amountType;
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

	public Boolean getNeedApproval() {
		return needApproval;
	}

	public boolean equals(Object obj) {
		if (obj instanceof TransactionExecutionStep) {
			TransactionExecutionStep other = (TransactionExecutionStep) obj;
			if (this.getTransactionStepID() != null) {
				return this.getTransactionStepID().equals(
						other.getTransactionStepID());
			}
		}
		return false;
	}

	public int hashCode() {
		if (getTransactionStepID() != null) {
			return getTransactionStepID().intValue();
		} else {
			return 1;
		}

	}

	public String toString() {
		return "TransactionExecutionStep [transactionStepID="
				+ transactionStepID + ", reversible=" + reversible
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
}