package com.su.enjoy.service.admin;

import com.su.enjoy.mapper.admin.HotelRepository;
import com.su.enjoy.model.hotel.Hotel;
import com.su.enjoy.model.hotel.HotelRegisterForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Transactional
    public void create(HotelRegisterForm hotelRegisterForm) {
        hotelRepository.insertHotel(hotelRegisterForm);
    }

}
