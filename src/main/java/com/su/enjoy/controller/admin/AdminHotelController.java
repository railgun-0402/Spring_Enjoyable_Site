package com.su.enjoy.controller.admin;

import com.su.enjoy.mapper.admin.HotelRepository;
import com.su.enjoy.model.hotel.Hotel;
import com.su.enjoy.model.hotel.HotelRegisterForm;
import com.su.enjoy.service.admin.HotelService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin/hotels")
public class AdminHotelController {
    private final HotelRepository hotelRepository;
    private final HotelService hotelService;

    public AdminHotelController(HotelRepository hotelRepository, HotelService hotelService) {
        this.hotelRepository = hotelRepository;
        this.hotelService = hotelService;
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

    /**
     * 旅館施設の新規登録
     *
     * @return int 画面に返却するHTTPステータスコード
     */
    @PostMapping("/register")
    public int register(@Validated @RequestParam HotelRegisterForm params, BindingResult bindingResult) {
        try {
            // バリデーションエラーの場合は400エラー
            if (bindingResult.hasErrors()) {
                return 400;
            }
            // 受け取った値をDBに登録
            hotelService.create(params);

            return 200;
        } catch (Exception e) {
            // 何らかのエラーが発生した場合は、500エラー
            return 500;
        }
    }
}
