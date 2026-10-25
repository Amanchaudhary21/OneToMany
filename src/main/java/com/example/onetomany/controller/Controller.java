package com.example.onetomany.controller;

import com.example.onetomany.entity.Order;
import com.example.onetomany.entity.Person;
import com.example.onetomany.repo.OrderRepository;
import com.example.onetomany.repo.PersonRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    private PersonRepository personRepository;
    public Controller(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    private OrderRepository orderRepository;
    public Controller(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @DeleteMapping("delete/{id}")
    public  void deleteById(Long id){

//        personRepository jpa ko method lai connet gareko xa
        personRepository.deleteById(id);

    }

    @GetMapping("/all")
    public List<Person> findAll(){
        return personRepository.findAll();
    }
    @GetMapping("/person/{id}")
     public Person findById(@PathVariable Long id){
        Optional<Person> personbyId=personRepository.findById(id);
        Person person=personbyId.get();
        System.out.println("my name is"+person.getName()+"and id is "+person.getId());
        return person;
    }

    @GetMapping("/order")
    public List<Order> findAllOrders(){
        return orderRepository.findAll();
    }

    @GetMapping("/order/{id}")
    public Order findOrderById(@PathVariable Long id){
        Optional<Order> orderById=orderRepository.findById(id);
        Order order=orderById.get();
        return order;
    }
}
