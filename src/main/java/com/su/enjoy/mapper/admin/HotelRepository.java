package com.su.enjoy.mapper.admin;

import com.su.enjoy.model.hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import com.su.enjoy.model.hotel.HotelRegisterForm;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    /** Hotelデータ全て取得 */
    List<Hotel> findAll();

    /** Hotelデータをidから取得 */
    Hotel findHotelById(int id);

    /** Hotelデータを編集 */
    void updateHotelById(int id);

    /** Hotelデータをテーブルに登録 */
    void insertHotel(HotelRegisterForm hotel);

    /** idに紐づくHotelデータの削除 */
    void deleteHotelById(int id);

    /** 検索ワードに紐づくHotelデータのSELECT */
    List<Hotel> searchHotelByWord(String word);
}
