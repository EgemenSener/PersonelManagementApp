package tr.com.turksat.entity;

import jakarta.persistence.*;

@Entity
@Table(name="personel")
public class Personel extends BasicEntity {

    private String ad;

    private String soyad;

    private String tcKimlikNo;

    private String dogumTarihi;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTcKimlikNo() {
        return tcKimlikNo;
    }

    public void setTcKimlikNo(String tcKimlikNo) {
        this.tcKimlikNo = tcKimlikNo;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    @Override
    public String toString() {
        return "Personel{" +
                "ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", tcKimlikNo='" + tcKimlikNo + '\'' +
                ", dogumTarihi='" + dogumTarihi + '\'' +
                ", id=" + id +
                '}';
    }
}
