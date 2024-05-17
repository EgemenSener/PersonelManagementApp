package tr.com.turksat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.turksat.dao.PersonelRepository;
import tr.com.turksat.entity.Personel;
import tr.com.turksat.exception.NotFoundException;
import tr.com.turksat.constants.CommonConstants;

import java.util.List;
import java.util.Optional;

@Service
public class PersonelServiceImpl implements PersonelService {

    private final PersonelRepository personelRepository;

    @Autowired
    public PersonelServiceImpl(PersonelRepository thePersonelRepository) {
        personelRepository = thePersonelRepository;
    }

    @Override
    public List<Personel> findAll() {return personelRepository.findAll();}

    @Override
    public Personel findById(int theId) {
        Optional<Personel> result = personelRepository.findById(theId);
        Personel thePersonel;

        if(result.isPresent()) {
            thePersonel = result.get();
        } else {
            throw new NotFoundException("Did not found personel " + theId);
        }
        return thePersonel;
    }

    @Override
    public Personel save(Personel thePersonel) {
        return personelRepository.save(thePersonel);
    }

    @Override
    public void deleteById(int theId) {
        personelRepository.deleteById(theId);
    }
}
