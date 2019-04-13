package com.cit.vericash.data.logging.model.common;

import com.cit.vericash.data.logging.model.IBaseModel;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "SMS_Logging")
public class SmsLogging implements IBaseModel , Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    @Column(name = "service_name")

    private String serviceName;

    @Column(name = "service_code")
    private String serviceCode ;

    @Column(name = "service_id", nullable = true)
    private String serviceId;

    @Column(name = "stack_id", nullable = true)
    private String stackId;

    @Column(name = "service_log_id", nullable = true)
    private Long serviceLogId;

    @Column(name = "message_id", nullable = true)
    private String messageId;

    @Column(name = "msisdn", nullable = true)
    private String msisdn;

    @Column(name = "message", nullable = true)
    private String message;

    @Column(name = "response", nullable = true)
    private String response;

    @Column(name = "response_timestamp", nullable = true)
    private Timestamp responseTimeStamp;

    @Column(name = "status", nullable = true)
    private SmsStatus status;

    public enum SmsStatus {
        Success, Fail
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

    public String getStackId() {
        return stackId;
    }

    public void setStackId(String stackId) {
        this.stackId = stackId;
    }

    public Long getServiceLogId() {
        return serviceLogId;
    }

    public void setServiceLogId(Long serviceLogId) {
        this.serviceLogId = serviceLogId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Timestamp getResponseTimeStamp() {
        return responseTimeStamp;
    }

    public void setResponseTimeStamp(Timestamp responseTimeStamp) {
        this.responseTimeStamp = responseTimeStamp;
    }

    public SmsStatus getStatus() {
        return status;
    }

    public void setStatus(SmsStatus status) {
        this.status = status;
    }
}
