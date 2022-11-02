package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.OrderItem;
import id.sinaukoding23.latihan.model.dto.OrderDTO;
import id.sinaukoding23.latihan.model.dto.OrderItemDTO;
import id.sinaukoding23.latihan.model.mapper.OrderItemMapper;
import id.sinaukoding23.latihan.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository repository;

    @Transactional(readOnly = true)
    public List<OrderItemDTO> findAll(){
        List<OrderItem> data = repository.findAllByIsDeleted(false);

        return OrderItemMapper.INSTANCE.toDtoList(data);
    }

    @Transactional
    public OrderItemDTO createData(OrderItemDTO param){
        OrderItem data = OrderItemMapper.INSTANCE.dtoToEntity(param);
        data = repository.save(data);

        return OrderItemMapper.INSTANCE.entityToDto(data);
    }

    @Transactional
    public OrderItemDTO updateData(OrderItemDTO param, int id){
        OrderItem data = repository.findById(id).get();

        if (data != null){

            data.setUpdatedDate(new Date());

            return OrderItemMapper.INSTANCE.entityToDto(repository.save(data));
        }

        return null;
    }

    @Transactional
    public boolean deleteData(int id){
        OrderItem data = repository.findById(id).get();

        if (data != null){
            data.setDeleted(true);

            repository.save(data);

            return true;
        }

        return false;
    }

}
