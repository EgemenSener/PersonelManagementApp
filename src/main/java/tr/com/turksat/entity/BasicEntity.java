package tr.com.turksat.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class BasicEntity implements Serializable {
    private static final long serialVersionUID = 4024790547417705L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, length = 40)
    protected Long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date kayitTarihi;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date güncellemeTarihi;

    public Date getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(Date kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }

    public Date getGüncellemeTarihi() {
        return güncellemeTarihi;
    }

    public void setGüncellemeTarihi(Date güncellemeTarihi) {
        this.güncellemeTarihi = güncellemeTarihi;
    }

    @Override
    public String toString() {
        return "BasicEntity{" +
                "id=" + id +
                ", kayitTarihi=" + kayitTarihi +
                ", güncellemeTarihi=" + güncellemeTarihi +
                '}';
    }
}
