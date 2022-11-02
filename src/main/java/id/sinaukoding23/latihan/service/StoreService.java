package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.dto.StoreDTO;
import id.sinaukoding23.latihan.model.Store;
import id.sinaukoding23.latihan.model.mapper.StoreMapper;
import id.sinaukoding23.latihan.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class StoreService {
    @Autowired
    private StoreRepository repository;

    @Transactional(readOnly = true)
    public List<StoreDTO> findAll(){
        List<Store> data = repository.findAllByIsDeleted(false);

        return StoreMapper.INSTANCE.toDtoList(data);
    }

    @Transactional
    public StoreDTO createData(StoreDTO param){
        Store data = StoreMapper.INSTANCE.dtoToEntity(param);
        data = repository.save(data);

        return StoreMapper.INSTANCE.entityToDto(data);
    }

    @Transactional
    public StoreDTO updateData(StoreDTO param, int id){
        Store data = repository.findById(id).get();

        if (data != null){
            data.setStoreName(param.getStoreName() != null ? param.getStoreName() : data.getStoreName());
            data.setUpdatedDate(new Date());

            return StoreMapper.INSTANCE.entityToDto(repository.save(data));
        }

        return null;
    }

    @Transactional
    public boolean deleteData(int id){
        Store data = repository.findById(id).get();

        if (data != null){
            data.setDeleted(true);

            repository.save(data);

            return true;
        }

        return false;
    }
}
