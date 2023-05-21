package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;
import pl.coderslab.service.PersonDetailsService;

@RestController
public class PersonDetailsController {
    private PersonDetailsService personDetailsService;

    public PersonDetailsController(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }


    @PostMapping("/persondetails")
    void save(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String streetNumber, @RequestParam String street, @RequestParam String city){
        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName(firstName);
        personDetails.setLastName(lastName);
        personDetails.setStreetNumber(streetNumber);
        personDetails.setStreet(street);
        personDetails.setCity(city);
        personDetailsService.save(personDetails);
    }
    @GetMapping("/persondetails/{id}")
    public PersonDetails read(@PathVariable Long id){
        PersonDetails personDetails = new PersonDetails();
        personDetails = personDetailsService.findById(id);
        return personDetails;
    }
    @PostMapping("/persondetails/update")
    public void update(@RequestParam Long id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String streetNumber, @RequestParam String street, @RequestParam String city){
        PersonDetails personDetails = new PersonDetails();
        personDetails = personDetailsService.findById(id);
        personDetails.setFirstName(firstName);
        personDetails.setLastName(lastName);
        personDetails.setStreetNumber(streetNumber);
        personDetails.setStreet(street);
        personDetails.setCity(city);
        personDetailsService.update(personDetails);
    }
    @PostMapping("/persondetails/delete")
    public void delete(@RequestParam Long id){
        personDetailsService.deleteById(id);
    }

}
