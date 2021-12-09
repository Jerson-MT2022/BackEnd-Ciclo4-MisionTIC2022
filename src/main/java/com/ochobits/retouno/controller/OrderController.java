
package com.ochobits.retouno.controller;

import com.ochobits.retouno.model.Order;
import com.ochobits.retouno.service.OrderService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jpere
 */
@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;
 
    @GetMapping("/all")
    public List <Order> listar(){
        return orderService.listar();
    }
 
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create (@RequestBody Order order){
    return orderService.create(order);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update (@RequestBody Order order){
        return orderService.update(order);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete (@PathVariable("id")int id){
        return orderService.delete(id);
    }
    
    @GetMapping("/{id}")
    public Order getOrderById (@PathVariable("id")int id){
        Optional<Order> order = orderService.getOrder(id);
        
        if(order.isPresent())
            return order.get();
        
        return null;
    }
    
    @GetMapping("/zona/{zona}")
    public List<Order> getOrderbyZona (@PathVariable("zona")String zona){
        List<Order> order = orderService.getOrderByZona(zona);
        return order;        
    }
}
