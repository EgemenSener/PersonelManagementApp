package tr.com.turksat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import tr.com.turksat.entity.Personel;
import tr.com.turksat.exception.NotFoundException;
import org.springframework.web.bind.annotation.*;
import tr.com.turksat.service.PersonelService;

import java.util.List;

@RestController
@RequestMapping("/api/personel")
public class PersonelRestController {

    private final PersonelService personelService;

    @Autowired
    public PersonelRestController(PersonelService personelService) {
        this.personelService = personelService;
    }

    @GetMapping()
    public List<Personel> getAllPersonels() {
        return personelService.findAll();
    }

    @GetMapping("/{personelId}")
    public Personel getPersonelById(@PathVariable int personelId) {
        return personelService.findById(personelId);
    }

    @PostMapping()
    public Personel addPersonel(@RequestBody Personel thePersonel) {
        return personelService.save(thePersonel);
    }

    @PutMapping("/{personelId}")
    public Personel updatePersonel(@PathVariable Integer personelId, @RequestBody Personel thePersonel) {
        return personelService.updatePersonel(personelId, thePersonel);
    }

    @DeleteMapping("/{personelId}")
    public String deletePersonel(@PathVariable int personelId) {
        Personel tempPersonel = personelService.findById(personelId);
        if(tempPersonel == null) throw new NotFoundException("Personel doesn't exist " + personelId);
        personelService.deleteById(personelId);
        return "deleted personel id is: " + personelId;
    }
}
