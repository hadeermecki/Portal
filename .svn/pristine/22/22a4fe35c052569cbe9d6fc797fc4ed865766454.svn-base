package com.cit.vericash.data.logging.model.common;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.cit.vericash.data.logging.model.IBaseModel;


@Entity
@Table(name = "EXTERNAL_MESSAGING_LOGGING")
public class ExternalMessagingLogging implements IBaseModel, Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "service_id", nullable = true)
	private String serviceId;
	
	@Column(name = "stack_id", nullable = true)
	private String stackId;

	@Column(name = "soap_response", nullable = true)

	@Lob
	private String soapResponse;

	@Column(name = "integration_service_name")
	private String integrationServiceName;

	@Column(name = "soap_request", nullable = true)
	@Lob
	private String soapRequest;
	
	@Column(name = "msisdn", nullable = true)
	private String msisdn;
	
	@Column(name = "log_Id", nullable = true)
	private String logId;
	
	@Column(name = "correlation_id", nullable = true)
	private String correlationId;

	public String getResponseSOAPMessageDateStr() {
		return responseSOAPMessageDateStr;
	}

	private void setResponseSOAPMessageDateStr(String responseSOAPMessageDateStr) {
		this.responseSOAPMessageDateStr = responseSOAPMessageDateStr;
	}

	public String getRequestSOAPMessageDateStr() {
		return requestSOAPMessageDateStr;
	}

	private void setRequestSOAPMessageDateStr(String requestSOAPMessageDateStr) {
		this.requestSOAPMessageDateStr = requestSOAPMessageDateStr;
	}

	@Column(name = "response_SOAP_Message_Date", nullable = true)
	private Timestamp responseSOAPMessageDate;

	@Column(name = "response_SOAP_Message_Date_STR", nullable = true)
	private String responseSOAPMessageDateStr;
	
	@Column(name = "request_SOAP_Message_Date", nullable = true)
	private Timestamp requestSOAPMessageDate;

	@Column(name = "request_SOAP_Message_Date_STR", nullable = true)
	private String requestSOAPMessageDateStr;
	
	
	
	public String getStackId() {
		return stackId;
	}
	
	public void setStackId(String stackId) {
		this.stackId = stackId;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getSoapResponse() {
		return soapResponse;
	}

	public void setSoapResponse(String soapResponse) {
		this.soapResponse = soapResponse;
	}

	public String getSoapRequest() {
		return soapRequest;
	}

	public void setSoapRequest(String soapRequest) {
		this.soapRequest = soapRequest;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public Timestamp getResponseSOAPMessageDate() {
		return responseSOAPMessageDate;
	}
	public String getIntegrationServiceName() {
		return integrationServiceName;
	}

	public void setIntegrationServiceName(String integrationServiceName) {
		this.integrationServiceName = integrationServiceName;
	}
	
	
	public void setResponseSOAPMessageDate(Timestamp timestamp){
		SimpleDateFormat simpleDateFormat =
				new SimpleDateFormat("yyyy-MM-dd");
		this.responseSOAPMessageDate = timestamp;
		String date  =simpleDateFormat.format(timestamp);
		setRequestSOAPMessageDateStr(date);
	}
	
	public Timestamp getRequestSOAPMessageDate() {
		return requestSOAPMessageDate;
	}

	public void setRequestSOAPMessageDate(Timestamp timestamp){
		SimpleDateFormat simpleDateFormat =
				new SimpleDateFormat("yyyy-MM-dd");
		this.requestSOAPMessageDate = timestamp;
		String date  =simpleDateFormat.format(timestamp);
		setRequestSOAPMessageDateStr(date);
	}
	
}	
