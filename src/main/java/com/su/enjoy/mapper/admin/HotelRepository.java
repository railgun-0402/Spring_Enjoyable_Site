package com.su.enjoy.mapper.admin;

import com.su.enjoy.model.hotel.Hotel;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface HotelRepository {
    /** Hotelデータ全て取得 */
    List<Hotel> findAll();

    /** Hotelデータをidから取得 */
    Hotel findHotelById(int id);

    /** Hotelデータをテーブルに登録 */
    void save(Hotel hotel);
}
