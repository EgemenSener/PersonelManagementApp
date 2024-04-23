package tr.com.cs.kepbasvuru.entity.bireysel;

import jakarta.persistence.*;

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
    public Products() {

    }
    public Products(int id, String productType, String productSku, String productName, String productDesc) {
        this.id = id;
        this.productType = productType;
        this.productSku = productSku;
        this.productName = productName;
        this.productDesc = productDesc;
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

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", productType='" + productType + '\'' +
                ", productSku='" + productSku + '\'' +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                '}';
    }
}
