package com.su.enjoy.controller.admin;

import com.su.enjoy.mapper.admin.HotelRepository;
import com.su.enjoy.model.hotel.Hotel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/hotels")
public class AdminHotelController {
    private final HotelRepository hotelRepository;

    public AdminHotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping
    public String index(Model model) {
        List<Hotel> hotels = hotelRepository.findAll();

        model.addAttribute("hotels", hotels);
        return "admin/hotels/index";
    }
}
