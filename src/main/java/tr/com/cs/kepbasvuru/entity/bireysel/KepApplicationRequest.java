package tr.com.cs.kepbasvuru.entity.bireysel;

public class KepApplicationRequest {
    private String applicationType;
    private boolean isPreApplication;
    GeneralInfo generalInfo;
    AccountInfo accountInfo;
    GuideInfo guideInfo;
    ProductDetail productDetail;
    PaymentDetail paymentDetail;
    ContractDetail contractDetail;

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public boolean isPreApplication() {
        return isPreApplication;
    }

    public void setPreApplication(boolean preApplication) {
        isPreApplication = preApplication;
    }

    public GeneralInfo getGeneralInfo() {
        return generalInfo;
    }

    public void setGeneralInfo(GeneralInfo generalInfo) {
        this.generalInfo = generalInfo;
    }

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public GuideInfo getGuideInfo() {
        return guideInfo;
    }

    public void setGuideInfo(GuideInfo guideInfo) {
        this.guideInfo = guideInfo;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    public PaymentDetail getPaymentDetail() {
        return paymentDetail;
    }

    public void setPaymentDetail(PaymentDetail paymentDetail) {
        this.paymentDetail = paymentDetail;
    }

    public ContractDetail getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(ContractDetail contractDetail) {
        this.contractDetail = contractDetail;
    }
}
