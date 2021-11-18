package com.reza.robidummyapi;

import com.reza.robidummyapi.entity.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/robi/prepaid")
public class Controller {

    @PostMapping("/")
    ResponseEntity<?> prepaidRecharge(@RequestBody String xmlData) throws Exception{
        System.out.println(xmlData);
        Response response = Response.builder()
                .type("exppbres")
                .txnstatus(200)
                .date(new Date())
                .extrefnum("extref")
                .txnid(UUID.randomUUID().toString())
                .message("message")
                .build();

        //String responseXML = convertToXML(response);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        return ResponseEntity.status(200).headers(headers).body(response);
    }

    @PostMapping("/error/205")
    ResponseEntity<?> prepaidRechargeSenario1(@RequestBody String xmlData) throws Exception{
        Response response = Response.builder()
                .type("exppbres")
                .txnstatus(205)
                .date(new Date())
                .extrefnum("extref")
                .txnid(UUID.randomUUID().toString())
                .message("message")
                .build();

        //String responseXML = convertToXML(response);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        return ResponseEntity.status(200).headers(headers).body(response);
    }

    @PostMapping("/error/206")
    ResponseEntity<?> prepaidRechargeSenario2(@RequestBody String xmlData) throws Exception{
        Response response = Response.builder()
                .type("exppbres")
                .txnstatus(206)
                .date(new Date())
                .extrefnum("extref")
                .txnid(UUID.randomUUID().toString())
                .message("message")
                .build();

        //String responseXML = convertToXML(response);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        return ResponseEntity.status(200).headers(headers).body(response);
    }

    @PostMapping("/error/failed")
    ResponseEntity<?> prepaidRechargeFailed(@RequestBody String xmlData) throws Exception{
        Response response = Response.builder()
                .type("exppbres")
                .txnstatus(250)
                .date(new Date())
                .extrefnum("extref")
                .txnid(UUID.randomUUID().toString())
                .message("message")
                .build();

        //String responseXML = convertToXML(response);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        return ResponseEntity.status(200).headers(headers).body(response);
    }

    public String convertToXML(Response response) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Response.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter sw = new StringWriter();
        mar.marshal(response, sw);
        return sw.toString();
    }
}
