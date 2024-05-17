package tr.com.turksat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import tr.com.turksat.entity.Personel;
import tr.com.turksat.exception.NotFoundException;
import org.springframework.web.bind.annotation.*;
import tr.com.turksat.service.PersonelService;

import java.util.List;

@RestController
@RequestMapping("/personel")
public class PersonelRestController {

    private final PersonelService personelService;

    @Autowired
    public PersonelRestController(PersonelService personelService) {
        this.personelService = personelService;
    }

    @GetMapping()
    public List<Personel> getPersonels() {
        return personelService.findAll();
    }

    @PostMapping()
    public Personel addPersonel(@RequestBody Personel thePersonel) {
        return personelService.save(thePersonel);
    }

    @PutMapping()
    public Personel updatePersonel(@RequestBody Personel thePersonel) {
        return personelService.save(thePersonel);
    }

    @DeleteMapping("/{personelId}") //parametre gondermek icin
    public String deletePersonel(@PathVariable int personelId) {
        Personel tempPersonel = personelService.findById(personelId);
        if(tempPersonel == null) throw new NotFoundException("Personel doesn't exist " + personelId);
        personelService.deleteById(personelId);
        return "deleted personel id is: " + personelId;
    }
}
