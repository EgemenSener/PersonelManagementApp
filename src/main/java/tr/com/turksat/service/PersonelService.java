package tr.com.turksat.service;

import tr.com.turksat.entity.Personel;

import java.util.List;

public interface PersonelService {
    String getProducts(Integer basvuruType);
    List<Personel> findAll();

    Personel findById(int theId);

    Personel save(Personel thePersonel);

    void deleteById(int theId);
}
