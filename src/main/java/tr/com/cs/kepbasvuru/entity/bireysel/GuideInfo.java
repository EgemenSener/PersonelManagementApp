package tr.com.cs.kepbasvuru.entity.bireysel;

public class GuideInfo {
    private Boolean searchPermissionInDirectory;
    private Boolean firstNamePerm;
    private Boolean lastNamePerm;
    private Boolean wayOfReceivingServicePerm;
    private Boolean cityPerm;
    private Boolean townPerm;
    private Boolean addressPerm;
    private Boolean phonePerm;

    public Boolean getSearchPermissionInDirectory() {
        return searchPermissionInDirectory;
    }

    public void setSearchPermissionInDirectory(Boolean searchPermissionInDirectory) {
        this.searchPermissionInDirectory = searchPermissionInDirectory;
    }

    public Boolean getFirstNamePerm() {
        return firstNamePerm;
    }

    public void setFirstNamePerm(Boolean firstNamePerm) {
        this.firstNamePerm = firstNamePerm;
    }

    public Boolean getLastNamePerm() {
        return lastNamePerm;
    }

    public void setLastNamePerm(Boolean lastNamePerm) {
        this.lastNamePerm = lastNamePerm;
    }

    public Boolean getWayOfReceivingServicePerm() {
        return wayOfReceivingServicePerm;
    }

    public void setWayOfReceivingServicePerm(Boolean wayOfReceivingServicePerm) {
        this.wayOfReceivingServicePerm = wayOfReceivingServicePerm;
    }

    public Boolean getCityPerm() {
        return cityPerm;
    }

    public void setCityPerm(Boolean cityPerm) {
        this.cityPerm = cityPerm;
    }

    public Boolean getTownPerm() {
        return townPerm;
    }

    public void setTownPerm(Boolean townPerm) {
        this.townPerm = townPerm;
    }

    public Boolean getAddressPerm() {
        return addressPerm;
    }

    public void setAddressPerm(Boolean addressPerm) {
        this.addressPerm = addressPerm;
    }

    public Boolean getPhonePerm() {
        return phonePerm;
    }

    public void setPhonePerm(Boolean phonePerm) {
        this.phonePerm = phonePerm;
    }
}
