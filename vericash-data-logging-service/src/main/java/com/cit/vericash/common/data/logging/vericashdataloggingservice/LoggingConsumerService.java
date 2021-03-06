package com.cit.vericash.common.data.logging.vericashdataloggingservice;



import com.cit.vericash.data.logging.dto.Message;
import com.cit.vericash.data.logging.dto.Query;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;



import java.io.IOException;

@Component
public class LoggingConsumerService {
   private static final Logger log = LoggerFactory.getLogger(LoggingConsumerService.class);
   @Autowired
    KafkaTemplate<String,String> kafkaTemplate ;
   @Autowired
    LoggingPresistClient loggingPresistClient ;

    @KafkaListener(topics = "VericashLoggingTopic", containerFactory = "kafkaListenerContainerFactory")
    public void consumeDefaultTopic(@Payload String message, @Headers MessageHeaders headers) throws IOException {
        log.info("recieve kafka Message vericash logging .... :" + message);
        headers.keySet().forEach(key -> log.info("{}: {}", key, headers.get(key)));
        persist(message);
    }

   @KafkaListener(topics = "EndToEndLoggingTopic", containerFactory = "kafkaListenerContainerFactory")
    public void consumeEndtoEndTopic(@Payload String message, @Headers MessageHeaders headers) throws IOException {
        log.info("recieve kafka Message end to end .... :" + message);
        headers.keySet().forEach(key -> log.info("{}: {}", key, headers.get(key)));
        persist(message);
    }

    @KafkaListener(topics = "ServiceHistoryLoggingTopic", containerFactory = "kafkaListenerContainerFactory")
    public void consumeServiceLogTopic(@Payload String message, @Headers MessageHeaders headers) throws IOException {
        log.info("recieve kafka Message service history.... :" + message);
        headers.keySet().forEach(key -> log.info("{}: {}", key, headers.get(key)));
        persist(message);
    }

    @KafkaListener(topics = "TransactionHistoryLoggingTopic", containerFactory = "kafkaListenerContainerFactory")
    public void consumeTransactionLogTopic(@Payload String message, @Headers MessageHeaders headers) throws IOException {
        log.info("recieve kafka Message transaction history.... :" + message);
        headers.keySet().forEach(key -> log.info("{}: {}", key, headers.get(key)));
        persist(message);
    }

    @Async
    private void persist(String message)
    {
        Query query = prepareQueryMessage(message);
        loggingPresistClient.executeQuery(query);
    }

    private static Query prepareQueryMessage(String message){
        Gson gson = new Gson();
        Message  LoggingMessage = gson.fromJson(message, Message.class);
        System.out.println(LoggingMessage.getEntityModelClassPath());
        System.out.println("json message :"+ LoggingMessage.getEntityModelAsJson());
        Query query = new Query();
        query.setQueryObject(LoggingMessage.getEntityModelAsJson());
        query.setEntityModelClassPath(LoggingMessage.getEntityModelClassPath());;
        query.setType(Query.Type.UPDATE);
        return query ;
       // loggingPresistClient.executeQuery(query);
    }

    @KafkaListener(topics = "VericashUpdateTopic")
    public void recieveUpdateQueryKafka(@Payload String message){
       log.info("recieve update query from kafka "+ message);
       update(message);
     }

     @Async
     public void update(String message)
     {
         Query query = new Query() ;
         query.setQueryObject(message);
         query.setType(Query.Type.UPDATE_NATIVE);
         loggingPresistClient.executeQuery(query);
     }

    }
