package lld.questions.amazon;

import java.util.ArrayList;
import java.util.List;

enum ProductCategory {
    MOBILE, LAPTOP;
}

public class ProductCatalog {
    private ProductCategory productCategory;
    private List<Product> products;

    public ProductCatalog(ProductCategory productCategory) {
        this.productCategory = productCategory;
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }
    public List<Product> getProducts() {
        return products;
    }
    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
