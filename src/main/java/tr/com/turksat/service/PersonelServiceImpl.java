package tr.com.turksat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.turksat.dao.BirimRepository;
import tr.com.turksat.dao.PersonelRepository;
import tr.com.turksat.entity.Birim;
import tr.com.turksat.entity.Personel;
import tr.com.turksat.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class PersonelServiceImpl implements PersonelService {

    private final PersonelRepository personelRepository;
    private final BirimRepository birimRepository;

    @Autowired
    public PersonelServiceImpl(PersonelRepository personelRepository, BirimRepository birimRepository) {
        this.personelRepository = personelRepository;
        this.birimRepository = birimRepository;
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

    public Personel updatePersonel(Integer theId, Personel personelDetails) {
        Optional<Personel> result = personelRepository.findById(theId);
        if (result.isPresent()) {
            Personel personel = result.get();

            if (personelDetails.getAd() != null)
                personel.setAd(personelDetails.getAd());
            if (personelDetails.getSoyad() != null)
                personel.setSoyad(personelDetails.getSoyad());
            if (personelDetails.getTcKimlikNo() != null)
                personel.setTcKimlikNo(personelDetails.getTcKimlikNo());
            if (personelDetails.getDogumTarihi() != null)
                personel.setDogumTarihi(personelDetails.getDogumTarihi());
            if (personelDetails.getKayitTarihi() != null)
                personel.setKayitTarihi(personelDetails.getKayitTarihi());

            Birim birimDetails = personelDetails.getBirim();

            if (birimDetails != null) {
                if (birimDetails.getAd() != null)
                    throw new IllegalArgumentException("Birim adi guncellenemez!");

                if (birimDetails.getId() != null) {
                    if (birimRepository.existsById(birimDetails.getId())) {
                        personel.setBirim(birimDetails);
                    } else {
                        throw new NotFoundException("Birim bulunamadi: " + birimDetails.getId());
                    }
                }
            }

            return personelRepository.save(personel);
        } else {
            throw new NotFoundException("Personel bulunamadi: " + theId);
        }
    }

    @Override
    public Personel save(Personel personel) {
        Birim birim = personel.getBirim();
        if (birim == null || birim.getId() == null) {
            throw new IllegalArgumentException("Birim ID boş olamaz.");
        } else {
            Optional<Birim> existingBirim = birimRepository.findById(birim.getId());
            if (existingBirim.isPresent()) {
                personel.setBirim(existingBirim.get());
            } else {
                throw new NotFoundException("Birim bulunamadi: " + birim.getId());
            }
        }
        return personelRepository.save(personel);
    }

    @Override
    public String deleteById(int theId) {
        Personel tempPersonel = findById(theId);
        if(tempPersonel == null) throw new NotFoundException("Personel doesn't exist " + theId);
        personelRepository.deleteById(theId);
        return "deleted personel id is: " + theId;
    }
}
