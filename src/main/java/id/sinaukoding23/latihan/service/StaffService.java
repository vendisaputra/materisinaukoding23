package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Staff;
import id.sinaukoding23.latihan.model.dto.StaffDTO;
import id.sinaukoding23.latihan.model.mapper.StaffMapper;
import id.sinaukoding23.latihan.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class StaffService {
    @Autowired
    private StaffRepository repository;

    @Transactional(readOnly = true)
    public List<StaffDTO> findAll(){
        List<Staff> data = repository.findAllByIsDeleted(false);

        return StaffMapper.INSTANCE.toDtoList(data);
    }

    @Transactional
    public StaffDTO createData(StaffDTO param){
        Staff data = StaffMapper.INSTANCE.dtoToEntity(param);
        data = repository.save(data);

        return StaffMapper.INSTANCE.entityToDto(data);
    }

    @Transactional
    public StaffDTO updateData(StaffDTO param, int id){
        Staff data = repository.findById(id).get();

        Staff paramData = StaffMapper.INSTANCE.dtoToEntity(param);

        if (data != null){
            data.setFirstName(param.getFirstName() != null ? param.getFirstName() : data.getFirstName());
            data.setLastName(param.getLastName() != null ? param.getLastName() : data.getLastName());
            data.setEmail(param.getEmail() != null ? param.getEmail() : data.getEmail());
            data.setPhone(param.getPhone() != null ? param.getPhone() : data.getPhone());
            data.setIsActive(param.getIsActive() != null ? param.getIsActive() : data.getIsActive());
            data.setStore(param.getStore() != null ? paramData.getStore() : data.getStore());
            data.setManager(param.getManager() != null ? paramData.getManager() : data.getManager());
            data.setUpdatedDate(new Date());

            return StaffMapper.INSTANCE.entityToDto(repository.save(data));
        }

        return null;
    }

    @Transactional
    public boolean deleteData(int id){
        Staff data = repository.findById(id).get();

        if (data != null){
            data.setDeleted(true);

            repository.save(data);

            return true;
        }

        return false;
    }
}
