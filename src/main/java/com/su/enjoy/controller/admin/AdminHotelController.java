package com.su.enjoy.controller.admin;

import com.su.enjoy.mapper.admin.HotelRepository;
import com.su.enjoy.model.hotel.Hotel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/hotels")
public class AdminHotelController {
    private final HotelRepository hotelRepository;

    public AdminHotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    /**
     * 旅館施設の管理画面Top
     *
     * @return List<Hotel>
     */
    @GetMapping
    public List<Hotel> index() {
        // TODO: Controllerからrepositoryにアクセスしたくない
        return hotelRepository.findAll();
    }

    /**
     * 旅館施設の詳細画面
     *
     * @return Hotel
     */
    @GetMapping("/detail/{id}")
    public Hotel detail(@PathVariable("id") int id) {
        return hotelRepository.findHotelById(id);
    }
}
