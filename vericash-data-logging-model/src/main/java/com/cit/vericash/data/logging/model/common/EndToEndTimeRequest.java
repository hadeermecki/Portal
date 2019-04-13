package com.cit.vericash.data.logging.model.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

import com.cit.vericash.data.logging.model.IBaseModel;


@Entity
@Table(name = "END_TO_END_TIME_REQUEST")
@Inheritance( strategy = InheritanceType.SINGLE_TABLE  )
@DiscriminatorColumn(name = "type")
public class EndToEndTimeRequest implements IBaseModel,Serializable {
	public EndToEndTimeRequest() {

		setId(new Date().getTime());
	}

	public enum EndToEndStatus {
		None,
		Completed,
		Not_Completed,;


	}

	@Id
	@Column(name = "Request_Id")
	private Long id;

	@Column(name = "test")
	private String test ;

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	@Column(name="SERVICE_CODE")

	private String serviceType;

	@Column(name="Id")
	private Long servicceLogId;
	
	@Column(name="SENDER_MSISDN")
	private String msisdn;
	
	@Column(name="SERVICE_NAME")
	private String serviceName;

	@Column(name = "MOBILE_REQUEST")
	private String mobileRequest ;

   @Column(name = "response_part1" , length = 10000)
	private  String responsePart1 ;

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	@Column(name = "response_part2", length = 10000)
   private String responsePart2 ;

	@Column(name = "request_part1" , length = 10000)
	private String requestPart1 ;

    @Column(name = "request_part2" ,length = 10000)
	private String requestPart2 ;

    @Column(name = "MOBILE_RESPONSE")
	private String mobileResponse ;

	@Column(name = "SENDER_WALLET_SHORT_CODE")
	private String senderWalletShortCode ;
	
	@Column(name="CREATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@Column(name = "service_id")
	private Long serviceId ;

	public String getWallet() {
		return wallet;
	}

	public void setWallet(String wallet) {
		this.wallet = wallet;
	}

	@Column(name="CREATION_DATE_STR")
	private String startDateStr ;
	
	@Column(name="LAST_MODIFIED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;


	@Column(name="LAST_MODIFIED_DATE_Str")
	private String endDateStr;

	@Column(name = "wallet")
	private String wallet;

	@Column(name="FAILEDREASON")
	private String errorDescription;
	
	@Column(name = "Amount", nullable = true)
	private BigDecimal amount;
	
	@Enumerated
	private EndToEndStatus status;
	
	@Column(name="LEG")
	private String leg;
	public String getResponsePart1() {
		return responsePart1;
	}

	public void setResponsePart1(String responsePart1) {
		this.responsePart1 = responsePart1;
	}

	public String getResponsePart2() {
		return responsePart2;
	}

	public void setResponsePart2(String responsePart2) {
		this.responsePart2 = responsePart2;
	}

	public String getRequestPart1() {
		return requestPart1;
	}

	public void setRequestPart1(String requestPart1) {
		this.requestPart1 = requestPart1;
	}

	public String getRequestPart2() {
		return requestPart2;
	}

	public void setRequestPart2(String requestPart2) {
		this.requestPart2 = requestPart2;
	}

	public String getMobileRequest() {
		return mobileRequest;
	}

	public void setMobileRequest(String mobileRequest) {
		this.mobileRequest = mobileRequest;
	}

	public String getMobileResponse() {
		return mobileResponse;
	}

	public void setMobileResponse(String mobileResponse) {
		this.mobileResponse = mobileResponse;
	}

	public String getSenderWalletShortCode() {
		return senderWalletShortCode;
	}

	public void setSenderWalletShortCode(String senderWalletShortCode) {
		this.senderWalletShortCode = senderWalletShortCode;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Long getServicceLogId() {
		return servicceLogId;
	}

	public void setServicceLogId(Long servicceLogId) {
		this.servicceLogId = servicceLogId;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getEndDateStr() {
		return endDateStr;
	}

	private void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;
	}

	public Date getStartDate() {
		return startDate;
	}
	public String getStartDateStr() {
		return startDateStr;
	}

	private void setStartDateStr(String startDateStr) {
		this.startDateStr = startDateStr;
	}

	public void setStartDate(Date startDate) {
		SimpleDateFormat simpleDateFormat =
				new SimpleDateFormat("yyyy-MM-dd");
		this.startDate = startDate;
		String startDateString = simpleDateFormat.format(startDate);
		setStartDateStr(startDateString);
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		SimpleDateFormat simpleDateFormat =
				new SimpleDateFormat("yyyy-MM-dd");
		this.endDate = endDate;
		String date = simpleDateFormat.format(endDate);
		setEndDateStr(date);
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public EndToEndStatus getStatus() {
		return status;
	}

	public void setStatus(EndToEndStatus status) {
		this.status = status;
	}

	public String getLeg() {
		return leg;
	}

	public void setLeg(String leg) {
		this.leg = leg;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
}
