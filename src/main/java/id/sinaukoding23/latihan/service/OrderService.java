package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Order;
import id.sinaukoding23.latihan.model.OrderItem;
import id.sinaukoding23.latihan.model.dto.OrderDTO;
import id.sinaukoding23.latihan.model.enums.StatusOrder;
import id.sinaukoding23.latihan.model.mapper.OrderMapper;
import id.sinaukoding23.latihan.repository.OrderItemRepository;
import id.sinaukoding23.latihan.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private StocksService stocksService;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        List<Order> data = repository.findAllByIsDeleted(false);

        return OrderMapper.INSTANCE.toDtoList(data);
    }

    @Transactional
    public OrderDTO createData(OrderDTO param){
        Order data = OrderMapper.INSTANCE.dtoToEntity(param);
        data = repository.save(data);

        return OrderMapper.INSTANCE.entityToDto(data);
    }

    @Transactional
    public OrderDTO updateData(OrderDTO param, int id){
        Order data = repository.findById(id).get();

        if (data != null){

            data.setUpdatedDate(new Date());

            return OrderMapper.INSTANCE.entityToDto(repository.save(data));
        }

        return null;
    }

    @Transactional
    public boolean deleteData(int id){
        Order data = repository.findById(id).get();

        if (data != null){
            data.setDeleted(true);

            repository.save(data);

            return true;
        }

        return false;
    }

    @Transactional
    public OrderDTO updateOrderStatus(OrderDTO param, Integer id){
        Order ref = repository.findById(id).get();

        if (ref != null){
            ref.setStatusOrder(param.getStatusOrder() != null ? param.getStatusOrder() : ref.getStatusOrder());

            ref = repository.save(ref);

            if (ref.getStatusOrder().equals(StatusOrder.PAYMENT)) {
                List<OrderItem> orderItem = orderItemRepository.findByOrder_OrderId(ref.getOrderId());

                for (OrderItem item : orderItem) {
                    stocksService.updateStock(item.getProduct().getProductId(), item.getQuantity());
                }
            }
        }

        return OrderMapper.INSTANCE.entityToDto(ref);
    }
    
}
