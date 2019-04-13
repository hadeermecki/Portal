package com.cit.vericash.data.logging.model.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.cit.vericash.data.logging.model.IBaseModel;

@Entity
@Table(name = "COMMISSION_EXEC_SUMMARY")
public class CommissionExecutionSummary implements IBaseModel, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Comm_Exec_Summary_ID")
    private Long commissionExecutionSummaryID;

    @Column(name = "service_id")
    private Long serviceLogId;
    private Long sender;
    private Long receiver;


    @Column(name = "Sender_Type", nullable = true)
    @Enumerated
    private AccountOwnerType senderType;

    @Column(name = "Commission_Type")
    private int CommissionType ;

    public String getSolId() {
        return SolId;
    }

    public int getCommissionType() {
        return CommissionType;
    }

    public void setCommissionType(int commissionType) {
        CommissionType = commissionType;
    }

    public void setSolId(String solId) {
        SolId = solId;
    }

    public String getCommissionReceiver() {
        return commissionReceiver;
    }

    public void setCommissionReceiver(String commissionReceiver) {
        this.commissionReceiver = commissionReceiver;
    }

    @Column(name = "Receiver_Type", nullable = true)
    @Enumerated
    private AccountOwnerType receiverType;

    @Column(name = "Master_Transaction")
    private Long masterTransaction;

    @Column(name = "SolId")
    private String SolId ;

    public Long getBusinessService() {
        return BusinessService;
    }

    public void setBusinessService(Long businessService) {
        BusinessService = businessService;
    }

    @Column(name = "Transaction_Configuration_Id")
    private Long transactionConfigurationId;

    @Column(name = "sender_wallet_code")
    private String senderWalletShortCode;

    public BigDecimal getVatAmount() {
        return VatAmount;
    }

    public void setVatAmount(BigDecimal vatAmount) {
        VatAmount = vatAmount;
    }

    @Column(name = "receiver_wallet_code")
    private String receiverWalletShortCode;

    @Column(name = "Business_Service")
    private Long BusinessService ;
    @Column(name = "Vat_Amount")
    private BigDecimal VatAmount;
    
    @Column(name = "Service_Code")
    private Long serviceCode;
    
    @Column(name = "Service_Name")
    private String serviceName;

    @Column(name = "commission_Receiver")
    private String commissionReceiver ;

    @Column(name = "reversal_reason")
    private String reversalReason;

    @Column(name = "sender_msisdn")
    private String senderMsisdn;

    @Column(name = "receiver_msisdn")
    private String receiverMsisdn;
    
    @Column(name = "sender_details")
    private String senderDetails;

    @Column(name = "receiver_details")
    private String receiverDetails;

    @Column(name = "Wallet_Settlement_Process_Id")
    private Long walletSettlementProcessId;

    @Column(name = "WALLET_SHORT_CODE")
    private String walletShortCode;


    @Column(name = "Settlement_Status")
    @Enumerated
    private SettlementStatusEnum settlementStatusEnum = SettlementStatusEnum.Non_Reconcilied;

    @Column(name = "Recon_Process_Id")
    private Long reconciliationProcess;

    @Column(name = "Execution_Type")
    @Enumerated
    private ExecutionTypeEnum executionType;

    @Column(name = "Sender_Account", nullable = true)
    private Long SenderAccountID;

    @Column(name = "Receiever_Account", nullable = true)
    private Long receieverAccountID;

    @Column(name = "Transaction_Amount", nullable = true)
    private BigDecimal transactionAmount;

    @Column(name = "Total_Fee_Amount", nullable = true)
    private BigDecimal totalFeeAmount;

    @Column(name = "Total_Commission_Amount", nullable = true)
    private BigDecimal totalCommissionAmount;

    @Column(name = "Transaction_Status")
    @Enumerated
    private TransactionExecutionSummary.TransactionStatus transactionStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Transaction_Start_Date", nullable = false)
    private Date transactionStartDate;

    @Column(name = "Transaction_Start_Date_Str", nullable = false)
    private String transactionStartDateStr;

    @Column(name = "Failed_Reason")
    private String failedReason;

    public Set<CommissionExecutionStep> getCommissionexecutionsteps() {
        return commissionexecutionsteps;
    }

    public void setCommissionexecutionsteps(Set<CommissionExecutionStep> commissionexecutionsteps) {
        this.commissionexecutionsteps = commissionexecutionsteps;
    }

    @OneToMany(fetch = FetchType.LAZY , cascade = {CascadeType.ALL})
    @JoinColumn(name = "Comm_Exec_Summary_ID", referencedColumnName = "Comm_Exec_Summary_ID")
    private Set<CommissionExecutionStep> commissionexecutionsteps;

    public Long getCommissionExecutionSummaryID() {
        return commissionExecutionSummaryID;
    }

    public void setCommissionExecutionSummaryID(Long commissionExecutionSummaryID) {
        this.commissionExecutionSummaryID = commissionExecutionSummaryID;
    }

    public String getTransactionStartDateStr() {
        return transactionStartDateStr;
    }

    private void setTransactionStartDateStr(String transactionStartDateStr) {
        this.transactionStartDateStr = transactionStartDateStr;
    }

    public String getTransactionEndDateStr() {
        return transactionEndDateStr;
    }

    private void setTransactionEndDateStr(String transactionEndDateStr) {
        this.transactionEndDateStr = transactionEndDateStr;
    }

    @Temporal(TemporalType.TIMESTAMP)

    @Column(name = "Transaction_End_Date")
    private Date transactionEndDate;

    @Column(name = "Transaction_End_Date_Str")
    private String transactionEndDateStr;

    public enum SettlementStatusEnum
	{
		Non_Reconcilied ("Non Reconcilied"),
		Reconcilied("Reconcilied"),
		Settled("Settled");
		public String name;
		SettlementStatusEnum(String name)
		{
			this.name=name;
		}
		public void setName(String name)
		{
			this.name=name;
		}
		public String getName()
		{
			return this.name;
		}
	}
    public enum AccountOwnerType
    {
    	NONE,
    	CUSTOMER,
    	BUSINESS_ENTITY;
    }


    public String getReversalReason() {
        return this.reversalReason;
    }

    public void setReversalReason(String reversalReason) {
        this.reversalReason = reversalReason;
    }

    public Long getTransactionConfigurationId() {
        return this.transactionConfigurationId;
    }

    public void setTransactionConfigurationId(Long transactionConfigurationId) {
        this.transactionConfigurationId = transactionConfigurationId;
    }

    public Long getMasterTransaction() {
        return this.masterTransaction;
    }

    public void setMasterTransaction(Long masterTransaction) {
        this.masterTransaction = masterTransaction;
    }

    public AccountOwnerType getSenderType() {
        return this.senderType;
    }

    public void setSenderType(AccountOwnerType senderType) {
        this.senderType = senderType;
    }

    public AccountOwnerType getReceiverType() {
        return this.receiverType;
    }

    public void setReceiverType(AccountOwnerType receiverType) {
        this.receiverType = receiverType;
    }

    public String getFailedReason() {
        return this.failedReason;
    }

    public void setFailedReason(String failedReason) {
        this.failedReason = failedReason;
    }

  

    public Long getServiceLogId() {
        return this.serviceLogId;
    }

    public void setServiceLogId(Long serviceLogId) {
        this.serviceLogId = serviceLogId;
    }

    public Long getSender() {
        return this.sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public Long getReceiver() {
        return this.receiver;
    }

    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

    public Long getSenderAccountID() {
        return this.SenderAccountID;
    }

    public void setSenderAccountID(Long senderAccountID) {
        this.SenderAccountID = senderAccountID;
    }

    public Long getReceieverAccountID() {
        return this.receieverAccountID;
    }

    public void setReceieverAccountID(Long receieverAccountID) {
        this.receieverAccountID = receieverAccountID;
    }

    public BigDecimal getTransactionAmount() {
        return this.transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public BigDecimal getTotalFeeAmount() {
        return this.totalFeeAmount;
    }

    public void setTotalFeeAmount(BigDecimal totalFeeAmount) {
        this.totalFeeAmount = totalFeeAmount;
    }

    public BigDecimal getTotalCommissionAmount() {
        return this.totalCommissionAmount;
    }

    public void setTotalCommissionAmount(BigDecimal totalCommissionAmount) {
        this.totalCommissionAmount = totalCommissionAmount;
    }

    public TransactionExecutionSummary.TransactionStatus getTransactionStatus() {
        return this.transactionStatus;
    }

    public void setTransactionStatus(TransactionExecutionSummary.TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Date getTransactionStartDate() {
        return this.transactionStartDate;
    }

    public void setTransactionStartDate(Date transactionStartDate) {
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd");
        this.transactionStartDate = transactionStartDate;
        String date = simpleDateFormat.format(transactionStartDate);
        setTransactionStartDateStr(date);
    }

    public Date getTransactionEndDate() {
        return this.transactionEndDate;
    }

    public void setTransactionEndDate(Date transactionEndDate) {
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd");
        this.transactionEndDate = transactionEndDate;
        String date = simpleDateFormat.format(transactionEndDate);
        setTransactionEndDateStr(date);
    }

    public ExecutionTypeEnum getExecutionType() {
        return this.executionType;
    }

    public void setExecutionType(ExecutionTypeEnum executionType) {
        this.executionType = executionType;
    }

    public String getSenderWalletShortCode() {
        return this.senderWalletShortCode;
    }

    public void setSenderWalletShortCode(String walletShortCode) {
        this.senderWalletShortCode = walletShortCode;
    }

    public String getReceiverWalletShortCode() {
        return this.receiverWalletShortCode;
    }

    public void setReceiverWalletShortCode(String receiverWalletShortCode) {
        this.receiverWalletShortCode = receiverWalletShortCode;
    }

    public String getSenderMsisdn() {
        return this.senderMsisdn;
    }

    public void setSenderMsisdn(String senderMsisdn) {
        this.senderMsisdn = senderMsisdn;
    }

    public String getReceiverMsisdn() {
        return this.receiverMsisdn;
    }

    public void setReceiverMsisdn(String receiverMsisdn) {
        this.receiverMsisdn = receiverMsisdn;
    }

    public Long getWalletSettlementProcessId() {
        return this.walletSettlementProcessId;
    }

    public void setWalletSettlementProcessId(Long walletSettlementProcessId) {
        this.walletSettlementProcessId = walletSettlementProcessId;
    }

    public String getWalletShortCode() {
        return this.walletShortCode;
    }

    public void setWalletShortCode(String walletShortCode) {
        this.walletShortCode = walletShortCode;
    }

    public SettlementStatusEnum getSettlementStatusEnum() {
        return this.settlementStatusEnum;
    }

    public void setSettlementStatusEnum(SettlementStatusEnum settlementStatusEnum) {
        this.settlementStatusEnum = settlementStatusEnum;
    }

    public Long getReconciliationProcess() {
        return this.reconciliationProcess;
    }

    public void setReconciliationProcess(Long reconciliationProcess) {
        this.reconciliationProcess = reconciliationProcess;
    }


    public String toString() {
        return "TransactionExecutionSummary [transactionExecutionSummaryID="
                + this.commissionExecutionSummaryID + ", serviceId=" + this.serviceLogId
                + ", senderType=" + this.senderType
                + ", receiverType=" + this.receiverType
                + ", masterTransaction="
                + this.masterTransaction
                + ", transactionConfigurationId=" + this.transactionConfigurationId
                + ", executionType=" + this.executionType + ", SenderAccountID="
                + this.SenderAccountID + ", receieverAccountID="
                + this.receieverAccountID + ", transactionAmount="
                + this.transactionAmount + ", totalFeeAmount=" + this.totalFeeAmount
                + ", totalCommissionAmount=" + this.totalCommissionAmount
                + ", transactionStatus=" + this.transactionStatus
                + ", transactionStartDate=" + this.transactionStartDate
                + ", failedReason=" + this.failedReason
                + ", transactionEndDate=" + this.transactionEndDate + "]";
    }

    public static enum ExecutionTypeEnum {
        USER_INITIATED,
        COMMISSION,
        REVERSAL,
        FEES_CYCLE,
        COMMISION_ROLLUP,
        BULK_MONEY_TRANSFER,
        SETTLEMENT;
    }


	public Long getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(Long serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getSenderDetails() {
		return senderDetails;
	}

	public void setSenderDetails(String senderDetails) {
		this.senderDetails = senderDetails;
	}

	public String getReceiverDetails() {
		return receiverDetails;
	}

	public void setReceiverDetails(String receiverDetails) {
		this.receiverDetails = receiverDetails;
	}
}
