package lld.questions.amazon;

public abstract class ProductCatalogFactory {
    public abstract ProductCatalog createProductCatalog();
}

class MobileCatalogFactory extends ProductCatalogFactory {
    @Override
    public ProductCatalog createProductCatalog() {
        return new ProductCatalog(ProductCategory.MOBILE);
    }
}
class LaptopCatalogFactory extends ProductCatalogFactory {
    @Override
    public ProductCatalog createProductCatalog() {
        return new ProductCatalog(ProductCategory.LAPTOP);
    }
}



