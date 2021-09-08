package com.sales.management.Controller;

import com.sales.management.BaseResponse.BaseResponse;
import com.sales.management.BaseResponse.baseresp;
import com.sales.management.DTO.OrderDTO;
import com.sales.management.DTO.UserDTO;
import com.sales.management.Model.Order;
import com.sales.management.Model.Sparepartstype;
import com.sales.management.Model.User;
import com.sales.management.ServiceImpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private OrderServiceImpl orderserviceimpl;

    @PostMapping("/add")
    public baseresp<Order> addorder(@Valid @RequestBody OrderDTO orderDTO) {
        baseresp<Order> base=null;
        base=baseresp.<Order>builder().Data(orderserviceimpl.addOrder(orderDTO)).build();
        return base ;
    }

    @PutMapping("/update")
    public baseresp<Optional<Order>> updateorder(@Valid @RequestBody OrderDTO orderDTO) {
        baseresp<Optional<Order>> base=null;
        base=baseresp.<Optional<Order>>builder().Data(orderserviceimpl.updateOrder(orderDTO)).build();
        return base ;
    }

   @GetMapping("/getall")
    public baseresp<List<Order>> listall(){
        baseresp<List<Order>> base=null;
        base =baseresp.<List<Order>>builder().Data(orderserviceimpl.getAllOrder()).build();
        return base;
    }

    @PutMapping("/delete")
    public baseresp<Optional<Order>> deletesoft(@RequestBody OrderDTO orderDTO) {
        baseresp<Optional<Order>> base=null;
        base=baseresp.<Optional<Order>>builder().Data(orderserviceimpl.deleteOrder(orderDTO)).build();
        return base ;
    }


}
