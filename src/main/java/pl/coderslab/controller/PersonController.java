package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Person;
import pl.coderslab.service.PersonService;
//@RestController
@Controller
public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping
    String showAddForm(){
        return "person/form";
    }

    @PostMapping(path = "/form")
  //  @PostMapping("/person")
    @ResponseBody
//    String save(@RequestParam String login, @RequestParam String password, @RequestParam String email){
            String save(Person p){
        Person person = p;
//        Person person = new Person();
//        person.setLogin(login);
//        person.setPassword(password);
//        person.setEmail(email);
        personService.save(person);
        return  person.toString();
    }

    @GetMapping("/person/{id}")
    public Person read(@PathVariable Long id){
        Person person = new Person();
        person = personService.findById(id);
        return person;
    }
    @PostMapping("/person/update")
    public void update(@RequestParam Long id, @RequestParam String login, @RequestParam String password, @RequestParam String email){
        Person person = new Person();
        person = personService.findById(id);
        person.setLogin(login);
        person.setPassword(password);
        person.setEmail(email);
        personService.update(person);
    }
    @PostMapping("/person/delete")
    public void delete(@RequestParam Long id){
        personService.deleteById(id);
    }

}
