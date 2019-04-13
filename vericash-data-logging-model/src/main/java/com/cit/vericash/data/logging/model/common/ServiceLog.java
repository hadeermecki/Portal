package com.cit.vericash.data.logging.model.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cit.vericash.data.logging.model.IBaseModel;

@Entity
@Table(name = "SERVICE_LOG")
public class ServiceLog implements IBaseModel, Serializable {
    public ServiceLog() {
        setId(new Date().getTime());
    }

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(name = "request_id")
    private String requestId;

    @Column(name = "service_id")
    private String serviceId;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "service_code")
    private String serviceCode;

    @AttributeOverrides({
        @AttributeOverride(name = "userKey", column = @Column(name = "sender_user_key")),
        @AttributeOverride(name = "msisdn", column = @Column(name = "sender_msisdn")),
        @AttributeOverride(name = "walletShortCode", column = @Column(name = "sender_wallet_short_code")),
        @AttributeOverride(name = "type", column = @Column(name = "sender_type")),
        @AttributeOverride(name = "account", column = @Column(name = "sender_account"))})
    @Embedded
    private PartyDetail sender;

    @AttributeOverrides({
        @AttributeOverride(name = "userKey", column = @Column(name = "receiver_user_key")),
        @AttributeOverride(name = "msisdn", column = @Column(name = "receiver_msisdn")),
        @AttributeOverride(name = "walletShortCode", column = @Column(name = "receiver_wallet_short_code")),
        @AttributeOverride(name = "type", column = @Column(name = "receiver_type")),
        @AttributeOverride(name = "account", column = @Column(name = "receiver_account"))})
    @Embedded
    private PartyDetail receiver;

    @Column(name = "Creation_date")
    private Date creationDate;

    @Column(name = "Creation_date_Str")
    private String creationDateStr;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "start_date_Str")
    private String startDateStr;


    @Column(name = "end_date")
    private Date endDate;

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    @Column(name = "end_date_Str")
    private String endDateStr;

    @Column(name = "wallet")
    private String wallet;

    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

    @Column(name = "last_modified_date_Str")
    private String lastModifiedDateStr;



    @Enumerated
    private ServiceStatus status;
    private String comments;
    private String walletShortCode;

    @Column(name = "failedreason")
    private String failedReason;


    @Column
    private Long parent;

    @Column(name = "Segmentation_Type")
    private Long segmentationType;

    @Column(name = "Is_Exposed")
    private boolean exposed = false;

    @Column(name = "Is_Default")
    private boolean defaultService = false;

    @Column(name = "Business_Entity")
    private Long businessEntity;

    @Column(name = "Amount", nullable = true)
    private BigDecimal amount;

    @Column(name = "INITIATOR_IP_ADDRESS", nullable = true)
    private String initiatorIpAddress;

    @Column(name = "LEG")
    private String leg;

    @Column(name = "CHANNEL_ID")
    private String channelID;

    public enum ServiceStatus {
    	Initiated,
    	Succeeded,
    	Failed,
    	Pending
    }

    
    public PartyDetail getSender() {
        return this.sender;
    }

    public void setSender(PartyDetail sender) {
        this.sender = sender;
    }

    public PartyDetail getReceiver() {
        return this.receiver;
    }

    public void setReceiver(PartyDetail receiver) {
        this.receiver = receiver;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceCode() {
        return this.serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd");
        this.creationDate = creationDate;
        String date = simpleDateFormat.format(creationDate);
        setCreationDateStr(date);
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd");
        this.startDate = startDate;
        String date = simpleDateFormat.format(startDate);
        setStartDateStr(date);
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd");
        this.endDate = endDate;
        String date = simpleDateFormat.format(endDate);
        setEndDateStr(date);
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd");
        this.lastModifiedDate = lastModifiedDate;
        String date = simpleDateFormat.format(lastModifiedDate);
        setLastModifiedDateStr(date);
    }

    public ServiceStatus getStatus() {
        return this.status;
    }

    public void setStatus(ServiceStatus status) {
        this.status = status;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getWalletShortCode() {
        return this.walletShortCode;
    }

    public void setWalletShortCode(String walletShortCode) {
        this.walletShortCode = walletShortCode;
    }

   

    public String getFailedReason() {
        return this.failedReason;
    }

    public void setFailedReason(String failedReason) {
        this.failedReason = failedReason;
    }

    public Long getSegmentationType() {
        return this.segmentationType;
    }

    public void setSegmentationType(Long segmentationType) {
        this.segmentationType = segmentationType;
    }

    public boolean isExposed() {
        return this.exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public boolean isDefaultService() {
        return this.defaultService;
    }

    public void setDefaultService(boolean defaultService) {
        this.defaultService = defaultService;
    }

    public Long getBusinessEntity() {
        return this.businessEntity;
    }

    public void setBusinessEntity(Long businessEntity) {
        this.businessEntity = businessEntity;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public String getCreationDateStr() {
        return creationDateStr;
    }

    private void setCreationDateStr(String creationDateStr) {
        this.creationDateStr = creationDateStr;
    }

    public String getStartDateStr() {
        return startDateStr;
    }

    private void setStartDateStr(String startDateStr) {
        this.startDateStr = startDateStr;
    }

    public String getEndDateStr() {
        return endDateStr;
    }

    private void setEndDateStr(String endDateStr) {
        this.endDateStr = endDateStr;
    }

    public String getLastModifiedDateStr() {
        return lastModifiedDateStr;
    }

    private void setLastModifiedDateStr(String lastModifiedDateStr) {
        this.lastModifiedDateStr = lastModifiedDateStr;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getInitiatorIpAddress() {
        return this.initiatorIpAddress;
    }

    public void setInitiatorIpAddress(String initiatorIpAddress) {
        this.initiatorIpAddress = initiatorIpAddress;
    }

    public String getLeg() {
        return this.leg;
    }

    public void setLeg(String leg) {
        this.leg = leg;
    }

    public String getChannelID() {
        return this.channelID;
    }

    public void setChannelID(String channelID) {
        this.channelID = channelID;
    }

	public Long getParent() {
		return parent;
	}

	public void setParent(Long parent) {
		this.parent = parent;
	}
}
