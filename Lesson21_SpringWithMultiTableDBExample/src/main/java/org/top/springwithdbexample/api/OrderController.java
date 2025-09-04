package org.top.springwithdbexample.api;

import org.aspectj.weaver.ast.Or;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.top.springwithdbexample.entity.Order;
import org.top.springwithdbexample.entity.User;
import org.top.springwithdbexample.repository.OrderRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("order")
public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public Order create(@RequestBody OrderCreateData orderCreateData) {
        // заполним данные заказа
        Order order = new Order();
        order.setDescription(orderCreateData.getDescription());
        order.setCreatedAt(new Date());
        // для пользователя заполним только id и установим данного пользователя в заказ
        User orderUser = new User();
        orderUser.setId(orderCreateData.getUserId());
        order.setUser(orderUser);
        // сохранить в БД
        orderRepository.save(order);
        // вернуть созданный заказ
        return order;
    }


    @GetMapping("{id}")
    public Optional<Order> getOrderById(@PathVariable Integer id) {
        return orderRepository.findById(id);
    }

    // Добавить получение всех заказов (вообще всех)
    @GetMapping("all")
    public List<Order> getAll()
    {
        return orderRepository.findAll();
    }

    // Добавить получение заказов за определенный период времени (задавать датами)
    @GetMapping("bytime")
    public List<Order> getByTime(@RequestBody DateRange dateRange) {
        return orderRepository.findAll().stream()
                .filter(order -> order.getCreatedAt() != null &&
                        !order.getCreatedAt().before(dateRange.getStartDate()) &&
                        !order.getCreatedAt().after(dateRange.getEndDate()))
                .collect(Collectors.toList());
    }

    @PostMapping("addpoints")
    public void  setPoints(@RequestParam Long id)
    {
        orderRepository.addDiscountPoints(id);
    }


}
