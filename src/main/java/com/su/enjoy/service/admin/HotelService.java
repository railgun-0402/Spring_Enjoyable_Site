package com.su.enjoy.service.admin;

import com.su.enjoy.mapper.admin.HotelRepository;
import com.su.enjoy.model.hotel.Hotel;
import com.su.enjoy.model.hotel.HotelEditForm;
import com.su.enjoy.model.hotel.HotelRegisterForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    /**
     * idに紐づいたHotelデータの編集(UPDATE)
     *
     * @return void
     */
    @Transactional
    public void update(HotelEditForm hotelEditForm) {
//        hotelRepository.updateHotelById(hotelEditForm);

        Hotel hotel = hotelRepository.findHotelById(hotelEditForm.getId());

        hotel.setName(hotelEditForm.getName());
        hotel.setImageName(hotelEditForm.getImageName());
        hotel.setDescription(hotelEditForm.getDescription());
        hotel.setPrice(hotelEditForm.getPrice());
        hotel.setCapacity(hotelEditForm.getCapacity());
        hotel.setPostalCode(hotelEditForm.getPostalCode());
        hotel.setAddress(hotelEditForm.getAddress());
        hotel.setPhoneNumber(hotelEditForm.getPhoneNumber());

        hotelRepository.updateHotelById(hotel);
    }

    /**
     * 検索ワードに紐づいたHotelデータをSELECT
     *
     * @return List<Hotel>
     */
    public List<Hotel> search(String word) {
        return hotelRepository.searchHotelByWord(word);
    }
}
