package tr.com.turksat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.turksat.entity.Personel;

public interface PersonelRepository extends JpaRepository<Personel, Integer> {

}
