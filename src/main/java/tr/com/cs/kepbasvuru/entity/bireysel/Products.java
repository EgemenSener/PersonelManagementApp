package tr.com.cs.kepbasvuru.entity.bireysel;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="product_type")
    private String productType;
    @Column(name="product_sku")
    private String productSku;
    @Column(name="product_name")
    private String productName;
    @Column(name="product_desc")
    private String productDesc;
    @Transient
    ProductCharge productCharge;
    @Transient
    List<ChildProducts> childProducts;

    public Products() {

    }
    public Products(int id, String productType, String productSku, String productName, String productDesc, ProductCharge productCharge, List<ChildProducts> childProducts) {
        this.id = id;
        this.productType = productType;
        this.productSku = productSku;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productCharge = productCharge;
        this.childProducts = childProducts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", productType='" + productType + '\'' +
                ", productSku='" + productSku + '\'' +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productCharge=" + productCharge +
                ", childProducts=" + childProducts +
                '}';
    }
}
