package com.eshoppers.service.impl.amazon;


import com.eshoppers.model.Product;
import com.eshoppers.service.AmazonService;
import com.eshoppers.service.ProductService;
import com.eshoppers.service.impl.amazon.amazonwsdl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class AmazonServiceImpl implements AmazonService {

    @Autowired
    ProductService productService;

    private String endpoint = "webservices.amazon.in";
    private String accessKeyId;
    private String secretKey;
    private String associateTag;


    @Override
    public List<Product> lookupStuff(String keywords, String category, HttpServletRequest request) throws JAXBException, SAXException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        Resource resource = context.getResource("classpath:amazonPasswords.properties");
        try {
            File file = resource.getFile();
            FileInputStream fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();

            Enumeration enuKeys = properties.keys();
            while (enuKeys.hasMoreElements()) {
                String key = (String) enuKeys.nextElement();
                String value = properties.getProperty(key);
                if (key.equals("accessKeyId")) {
                    this.accessKeyId = value;
                }
                if (key.equals("secretKey")) {
                    this.secretKey = value;
                }
                if (key.equals("associateTag")) {
                    this.associateTag = value;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Product> amazonProducts;
        RequestHelper helper = new RequestHelper(this.endpoint, this.accessKeyId, this.secretKey);
        Map<String, String> params = new HashMap<>();
        params.put("Service", "AWSECommerceService");
        params.put("Operation", "ItemSearch");
        params.put("SubscriptionId", this.accessKeyId);
        params.put("AssociateTag", this.associateTag);
        params.put("SearchIndex", category);
        params.put("ResponseGroup", "Images,ItemAttributes,Offers");
        params.put("Keywords", keywords);

        String requestUrl = helper.sign(params);
        System.out.println(requestUrl);
        String response = requestAmazon(requestUrl);

        String noNullResponse = response.replaceFirst("null", "");
        System.out.println("Raw xml:\n" + noNullResponse);
        amazonProducts =

                getProducts(noNullResponse, request);
        return amazonProducts;
    }

    private String requestAmazon(String stringUrl) {
        String response = null;
        try {
            URL url = new URL(stringUrl);
            URLConnection conn = url.openConnection();
            conn.setDoInput(true);

            BufferedReader in =
                    new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String chunk = null;
            while ((chunk = in.readLine()) != null) response += chunk;
            in.close();
        } catch (Exception e) {
            throw new RuntimeException("Arrrg! " + e);
        }
        return response;
    }

    private List<Product> getProducts(String xml, HttpServletRequest request) {
        List<Product> amazonProducts = new ArrayList<>();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        Path path = Paths.get(rootDirectory + "WEB-INF/resources/schema/aws.xsd");

        System.out.println(path);
        File file = path.toFile();
        if (!file.exists()) {
            System.out.println("Schema file not found");
            return amazonProducts;
        }
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = null;
        try {
            schema = factory.newSchema(new StreamSource(file));
        } catch (SAXException e) {
            System.out.println("Problem with SAX");
            e.printStackTrace();
        }
        ItemSearchResponse ilr = null;
        try {
            JAXBContext ctx = JAXBContext.newInstance(ItemSearchResponse.class);
            Unmarshaller um = ctx.createUnmarshaller();
            um.setSchema(schema);
            ilr = (ItemSearchResponse) um.unmarshal(new ByteArrayInputStream(xml.getBytes()));
        } catch (JAXBException e) {
            System.out.println("Not able to parse properly-JAXB");
        }

        List<Items> itemsList = ilr.getItems();
        for (Items items : itemsList) {
            List<Item> list = items.getItem();
            for (Item item : list) {

                Product product = new Product();
                ItemAttributes itemAttributes = item.getItemAttributes();
                if (itemAttributes.getTitle() != null)
                    product.setProductName(itemAttributes.getTitle());
                if (itemAttributes.getBinding() != null)
                    product.setProductCategory(itemAttributes.getBinding());
                product.setASIN(item.getASIN());

                Image image = item.getLargeImage();
                String url = image.getURL();
                if (url != null)
                    product.setProductImageUrl(url);

                if (itemAttributes.getBrand() != null)
                    product.setProductManufacturer(itemAttributes.getBrand());

                OfferSummary offerSummary = item.getOfferSummary();

                Price price = offerSummary.getLowestNewPrice();
                double i = (price.getAmount().doubleValue()) / 100;
                product.setProductPrice(i);

                product.setProductCondition("New");

                String description = "";
                List<String> features = itemAttributes.getFeature();

                int size = 0;
                if (features.size() <= 4) {
                    size = features.size();
                } else {
                    size = 4;
                }
                for (int j = 0; j < size; j++) {
                    description = description + "<li class=\"slick-dots li\">" + features.get(j) + "</li>";
                }
                product.setProductDescription(description);
                product.setProductStatus("Active");
                product.setUnitInStock(10);
                amazonProducts.add(product);
                productService.addProduct(product);
            }
        }
        return amazonProducts;
    }
}