package id.sinaukoding23.latihan.controller;

import id.sinaukoding23.latihan.common.RestResult;
import id.sinaukoding23.latihan.model.dto.StaffDTO;
import id.sinaukoding23.latihan.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController {
    @Autowired
    private StaffService service;

    @GetMapping("/find-all")
    public RestResult getAllData(){
        List<StaffDTO> data = service.findAll();

        return new RestResult(data, data.size() == 0 ? "Data tidak ditemukan" : "Menampilkan data", data.size(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public RestResult createDate(@RequestBody StaffDTO param){
        StaffDTO data = service.createData(param);

        if (data != null){
            return new RestResult(data, "Data Berhasil disimpan", HttpStatus.OK);
        }

        return new RestResult("Data gagal disimpan", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public RestResult updateData(@RequestBody StaffDTO param,
                                 @RequestParam(name = "id") int id){
        StaffDTO data = service.updateData(param, id);

        if (data != null){
            return new RestResult(data, "Data Berhasil diupdate", HttpStatus.OK);
        }

        return new RestResult("Data gagal diupdate", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{id}")
    public RestResult deleteData(@PathVariable int id){
        if (service.deleteData(id)){
            return new RestResult("Delete Sukses", HttpStatus.OK);
        }

        return new RestResult("Delete Gagal", HttpStatus.BAD_REQUEST);
    }
}
