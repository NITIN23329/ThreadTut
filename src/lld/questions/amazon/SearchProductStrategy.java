package lld.questions.amazon;

import java.util.ArrayList;
import java.util.List;

public abstract class SearchProductStrategy {
    abstract List<Product> getProductList(Inventory inventory);
}
class SearchByCategory extends SearchProductStrategy {
    private ProductCategory category;

    public SearchByCategory(ProductCategory category) {
        this.category = category;
    }

    @Override
    List<Product> getProductList(Inventory inventory) {
        List<ProductCatalog> productCatalogs = inventory.getProductCatalogs();
        for (ProductCatalog productCatalog : productCatalogs) {
            if(productCatalog.getProductCategory().equals(category)) {
                return productCatalog.getProducts();
            }
        }
        return null;
    }
}
class SearchByPrice extends SearchProductStrategy {
    private double price;
    public SearchByPrice(double price) {
        this.price = price;
    }
    @Override
    List<Product> getProductList(Inventory inventory) {
        List<Product> result = new ArrayList<>();
        List<ProductCatalog> productCatalogs = inventory.getProductCatalogs();
        for (ProductCatalog productCatalog : productCatalogs) {
            for (Product product : productCatalog.getProducts()) {
                if(product.getPrice() <= price) {
                    result.add(product);
                }
            }

        }
        return result;
    }
}
