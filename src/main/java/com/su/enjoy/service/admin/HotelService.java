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
        Hotel hotel = new Hotel();

        hotel.setName(hotelRegisterForm.getName());
        hotel.setDescription(hotelRegisterForm.getDescription());
        hotel.setPrice(hotelRegisterForm.getPrice());
        hotel.setCapacity(hotelRegisterForm.getCapacity());
        hotel.setPostalCode(hotelRegisterForm.getPostalCode());
        hotel.setAddress(hotelRegisterForm.getAddress());
        hotel.setPhoneNumber(hotelRegisterForm.getPhoneNumber());

        hotelRepository.save(hotel);
    }

}
