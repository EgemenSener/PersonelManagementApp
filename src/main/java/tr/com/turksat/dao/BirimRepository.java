package tr.com.turksat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.turksat.entity.Birim;

public interface BirimRepository extends JpaRepository<Birim, Integer> {
}
