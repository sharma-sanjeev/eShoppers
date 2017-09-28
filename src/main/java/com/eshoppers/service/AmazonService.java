package com.eshoppers.service;

import com.eshoppers.model.Product;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;
import java.util.List;

public interface AmazonService {

    List<Product> lookupStuff(String keywords, String category, HttpServletRequest request) throws JAXBException, SAXException;

}
