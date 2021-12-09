package com.ochobits.retouno.repository;

import com.ochobits.retouno.repository.crud.OrderCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.ochobits.retouno.model.Order;
import org.springframework.data.mongodb.core.MongoOperations;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.stereotype.Repository;
/**
 *
 * @author jpere
 */

@Repository
public class OrderRepository {
    @Autowired
    private OrderCrudRepository orderCrudRepository;
    
    @Autowired
    private MongoOperations mongoOperations;

    public List<Order> listar() {
        return (List<Order>) orderCrudRepository.findAll();
    }
    
    public Optional<Order> getOrder(int id) {
        return orderCrudRepository.findById(id);
    }

    public Order create(Order order) {
        return orderCrudRepository.save(order);
    }

    public void update(Order order) {
        orderCrudRepository.save(order);
    }

   
    public void delete(Order order) {
        orderCrudRepository.delete(order);
    }

    public List<Order> getOrderByZona(String zona) {
        return mongoOperations.find( query(where("salesMan.zone").is(zona)), Order.class);
    }
}
