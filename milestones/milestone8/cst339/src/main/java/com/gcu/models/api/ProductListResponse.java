package com.gcu.models.api;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.gcu.data.entity.ProductEntity;

// Wrapper model so the "all products" endpoint can return cleaner XML and JSON.
@JacksonXmlRootElement(localName = "products")
/**
 * Wrapper response model used to return a product list in JSON or XML format.
 */
public class ProductListResponse {

    @JacksonXmlProperty(localName = "product")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<ProductEntity> products;

    public ProductListResponse() {
    }

    public ProductListResponse(List<ProductEntity> products) {
        this.products = products;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
