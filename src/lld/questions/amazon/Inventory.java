package lld.questions.amazon;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<ProductCatalog>   productCatalogs;
    private ProductCatalogFactory catalogFactory;

    public Inventory() {
        this.productCatalogs = new ArrayList<>();

    }

    public List<ProductCatalog> getProductCatalogs() {
        return productCatalogs;
    }

    public void setProductCatalogs(List<ProductCatalog> productCatalogs) {
        this.productCatalogs = productCatalogs;
    }

    public ProductCatalogFactory getCatalogFactory() {
        return catalogFactory;
    }

    public void setCatalogFactory(ProductCatalogFactory catalogFactory) {
        this.catalogFactory = catalogFactory;
    }
    public ProductCatalog createProductCatalog(ProductCatalogFactory catalogFactory) {
        this.catalogFactory = catalogFactory;
        ProductCatalog productCatalog = catalogFactory.createProductCatalog();
        productCatalogs.add(productCatalog);
        return productCatalog;
    }
}
