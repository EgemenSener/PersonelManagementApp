package tr.com.turksat.entity;

import jakarta.persistence.Entity;

@Entity
public class Birim extends BasicEntity{

    private String ad;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }
}
