package com.cit.vericash.data.logging.model.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.cit.vericash.data.logging.model.IBaseModel;

@Entity
@Table(name = "TRANS_EXEC_SUMMARY")
public class TransactionExecutionSummary implements IBaseModel, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Trnas_Exec_Summary_ID")
    private Long transactionExecutionSummaryID;

    @Column(name = "service_id")
    private Long serviceLogId;

    public int getIsApplyAgentCommission() {
        return isApplyAgentCommission;
    }

    public void setIsApplyAgentCommission(int isApplyAgentCommission) {
        this.isApplyAgentCommission = isApplyAgentCommission;
    }

    public int getIsApplyPartnerCommission() {
        return isApplyPartnerCommission;
    }

    public void setIsApplyPartnerCommission(int isApplyPartnerCommission) {
        this.isApplyPartnerCommission = isApplyPartnerCommission;
    }

    private Long sender;
    private Long receiver;

   @Column(name = "Is_Apply_Agent_Commission")
    private int isApplyAgentCommission ;
   @Column(name = "Is_Apply_Partner_Commission")
   private int isApplyPartnerCommission ;

    @Column(name = "Sender_Type", nullable = true)
    @Enumerated
    private AccountOwnerType senderType;


    @Column(name = "Receiver_Type", nullable = true)
    @Enumerated
    private AccountOwnerType receiverType;

    @JoinColumn(name = "Master_Transaction")
    private Long masterTransaction;

    @Column(name = "Transaction_Configuration_Id")
    private Long transactionConfigurationId;

    @Column(name = "sender_wallet_code")
    private String senderWalletShortCode;

    @Column(name = "receiver_wallet_code")
    private String receiverWalletShortCode;

    @Column(name = "wallet")
    private String wallet;

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    @Column(name = "Service_Code")
    private Long serviceCode;

    public Long getTraceId() {
        return traceId;
    }

    public void setTraceId(Long traceId) {
        this.traceId = traceId;
    }

    @Column(name = "trace_id")
    private Long traceId;
    
    @Column(name = "Service_Name")
    private String serviceName;

    @Column(name = "reversal_reason")
    private String reversalReason;

    @Column(name = "sender_msisdn")
    private String senderMsisdn;

    @Column(name = "receiver_msisdn")
    private String receiverMsisdn;

    public Long getBusinessService() {
        return businessService;
    }

    public void setBusinessService(Long businessService) {
        this.businessService = businessService;
    }

    @Column(name = "sender_details")
    private String senderDetails;

    @Column(name = "business_service")
    private Long businessService ;


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
    private TransactionStatus transactionStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Transaction_Start_Date", nullable = false)
    private Date transactionStartDate;


    @Column(name = "Transaction_Start_Date_Str", nullable = false)
    private String transactionStartDateStr;

    @Column(name = "Failed_Reason")
    private String failedReason;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Transaction_End_Date")
    private Date transactionEndDate;


    @Column(name = "Transaction_End_Date_Str")
    private String transactionEndDateStr;

    public Set<TransactionExecutionStep> getTransactionExecutionSteps() {
        return transactionExecutionSteps;
    }

    public void setTransactionExecutionSteps(Set<TransactionExecutionStep> transactionExecutionSteps) {
        this.transactionExecutionSteps = transactionExecutionSteps;
    }

    @OneToMany(fetch = FetchType.LAZY , cascade = {CascadeType.ALL})
    @JoinColumn(name = "Trnas_Exec_Summary_ID", referencedColumnName = "Trnas_Exec_Summary_ID")
    private Set<TransactionExecutionStep> transactionExecutionSteps;




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
    public enum TransactionStatus {
    	/*
    	 * Used when transaction created but not executed.
    	 * */
    	INITIATED,
    	/*
    	 * If transaction run successfully.
    	 * */
    	SUCCEEDED,
    	/*
    	 * If transaction failed.
    	 * */
    	FAILED,
    	/*
    	 * If transaction reversed successfully.
    	 * */
    	REVERSED,
    	/*
    	 * If transaction wait for approval to complete action.
    	 * */
    	WAIT_APPROVAL,
    	/*
    	 * If transaction pending for reversal approval.
    	 * */
    	PENDING_REVERSAL,
    	/*
    	 * If some of steps of transaction reversed not all steps.
    	 * */
    	PARTIALLY_REVERSED,
    	
    	REDEEMED;
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

    public Long getTransactionExecutionSummaryID() {
        return this.transactionExecutionSummaryID;
    }

    public void setTransactionExecutionSummaryID(Long transactionExecutionSummaryID) {
        this.transactionExecutionSummaryID = transactionExecutionSummaryID;
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

    public TransactionStatus getTransactionStatus() {
        return this.transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
                + this.transactionExecutionSummaryID + ", serviceId=" + this.serviceLogId
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Long getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(Long serviceCode) {
		this.serviceCode = serviceCode;
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
