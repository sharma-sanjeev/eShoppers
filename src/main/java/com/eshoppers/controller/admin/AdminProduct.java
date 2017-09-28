package com.eshoppers.controller.admin;

import com.eshoppers.model.Product;
import com.eshoppers.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminProduct {

    @Autowired
    private ProductService productService;

    @RequestMapping("/product/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();
        product.setProductCategory("Mobile");
        product.setProductCondition("New");
        product.setProductStatus("Active");
        model.addAttribute("product", product);
        return "addProduct";
    }

    @RequestMapping(value = "/product/addProduct", method = RequestMethod.POST)
    public String addProductPost(
            @Valid @ModelAttribute("product") Product product,
            BindingResult result,
            HttpServletRequest request) {
        if (result.hasErrors()) {
            return "addProduct";
        }
        productService.addProduct(product);
        MultipartFile productImage = product.getProductImage();
        Path path = productService.getImagePath(product, request);
        if (productImage != null && (!productImage.isEmpty())) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }
        return "redirect:/admin/productInventory";
    }

    @RequestMapping(value = "/product/editProduct/{productId}")
    public String editProduct(@PathVariable int productId, Model model) {
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "editProduct";

    }

    @RequestMapping(value = "/product/editProduct", method = RequestMethod.POST)
    public String editProduct(
            @Valid @ModelAttribute("product") Product product,
            BindingResult result,
            HttpServletRequest request) {
        if (result.hasErrors()) {
            return "editProduct";
        }
        MultipartFile productImage = product.getProductImage();
        Path path = productService.getImagePath(product, request);
        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File((path.toString())));
            } catch (Exception e) {
                throw new RuntimeException("Product image saving failed");
            }
        }
        productService.editProduct(product);
        return "redirect:/admin/productInventory";
    }

    @RequestMapping(value = "/product/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable int productId, HttpServletRequest request) {
        try {
            Product product = productService.getProductById(productId);
            product.setProductStatus("Inactive");
            productService.editProduct(product);
            productService.deleteProduct(productId);
            Path path = productService.getImagePath(product, request);
            if (Files.exists(path)) {
                try {
                    Files.delete(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return "redirect:/admin/productInventory";
        }
    }

    @RequestMapping(value = "/product/inactiveProducts")
    public String inactiveProducts(Model model) {
        List<Product> products = productService.getInactiveProductList();
        model.addAttribute("products", products);
        return "inactiveProducts";
    }
}