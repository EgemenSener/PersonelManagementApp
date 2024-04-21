package tr.com.cs.kepbasvuru.entity.bireysel;

import java.util.List;

public class Products {
    private String productType;
    private String productSku;
    private String productName;
    private String productDesc;
    ProductCharge productCharge;
    List<ChildProducts> childProducts;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public ProductCharge getProductCharge() {
        return productCharge;
    }

    public void setProductCharge(ProductCharge productCharge) {
        this.productCharge = productCharge;
    }

    public List<ChildProducts> getChildProducts() {
        return childProducts;
    }

    public void setChildProducts(List<ChildProducts> childProducts) {
        this.childProducts = childProducts;
    }
}
