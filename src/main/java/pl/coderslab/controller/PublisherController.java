package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.PublisherService;

import java.util.List;

@RestController
public class PublisherController {

    private PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }
    @PostMapping("/publisher")
    void save(@RequestParam String name){
        Publisher publisher = new Publisher();
        publisher.setName(name);

        publisherService.save(publisher);
    }
    @GetMapping("/publisher/{id}")
    public Publisher read(@PathVariable Long id){
        Publisher publisher = new Publisher();
        publisher = publisherService.findById(id);
        return publisher;
    }
    @PostMapping("/publisher/update")
    public void update(@RequestParam Long id, @RequestParam String name){
        Publisher publisher = new Publisher();
        publisher = publisherService.findById(id);
        publisher.setName(name);
        publisherService.update(publisher);
    }
    @GetMapping("/publisher/delete/{id}")
    public void delete(@PathVariable Long id){
        publisherService.deleteById(id);
    }

    //pobieranie wszystkich:
    @GetMapping(path = "/publishers", produces = "text/plain;charset=utf-8")
    String findAll() {

        final List<Publisher> publisherList = publisherService.findAll();

        return publisherList.toString();
    }
}
