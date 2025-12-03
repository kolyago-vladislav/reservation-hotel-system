package by.pilipuk;

import by.pilipuk.service.HotelService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelsApiApp {
    public static void main(String[] args) {

        //Проверь как работает и удали этот код, оставь только запуск спринг бута
        HotelService bean = SpringApplication.run(HotelsApiApp.class, args).getBean(HotelService.class);

        System.out.println(bean.findHotelWithRoomTypeCounts());
    }
}