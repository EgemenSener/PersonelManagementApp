package tr.com.cs.kepbasvuru.entity.bireysel;

public class AccountInfo {
    private String accountOid;
    private String crmOid;
    private String portalUserName;
    private String accountPreName;
    private String domainName;
    private String kepAddress;
    private String serviceType;

    public String getAccountOid() {
        return accountOid;
    }

    public void setAccountOid(String accountOid) {
        this.accountOid = accountOid;
    }

    public String getPortalUserName() {
        return portalUserName;
    }

    public void setPortalUserName(String portalUserName) {
        this.portalUserName = portalUserName;
    }

    public String getAccountPreName() {
        return accountPreName;
    }

    public void setAccountPreName(String accountPreName) {
        this.accountPreName = accountPreName;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getKepAddress() {
        return kepAddress;
    }

    public void setKepAddress(String kepAddress) {
        this.kepAddress = kepAddress;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getCrmOid() { return crmOid; }

    public void setCrmOid(String crmOid) { this.crmOid = crmOid; }
}
