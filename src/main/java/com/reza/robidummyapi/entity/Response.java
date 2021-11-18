package com.reza.robidummyapi.entity;

import lombok.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@XmlRootElement(name = "command")
//@XmlType(
//        propOrder = {"type", "txnstatus", "date", "extrefnum", "txnid", "message"}
//)
public class Response {
    private String type;
    private Integer txnstatus;
    private Date date;
    private String extrefnum;
    private String txnid;
    private String message;

}
