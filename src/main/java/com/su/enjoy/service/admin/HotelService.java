package com.su.enjoy.service.admin;

import com.su.enjoy.mapper.admin.HotelRepository;
import com.su.enjoy.model.hotel.HotelRegisterForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    /**
     * Hotelデータの追加(INSERT)
     */
    @Transactional
    public void create(HotelRegisterForm hotelRegisterForm) {
        hotelRepository.insertHotel(hotelRegisterForm);
    }

    /**
     * idに紐づいたHotelデータの削除(DELETE)
     */
    @Transactional
    public void delete(int id) {
        hotelRepository.deleteHotelById(id);
    }

}
