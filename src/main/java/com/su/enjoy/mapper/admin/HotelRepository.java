package com.su.enjoy.mapper.admin;

import com.su.enjoy.model.hotel.Hotel;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface HotelRepository {
    List<Hotel> findAll();
}
