package com.with.second.repository;


import com.with.second.entity.DeliveryEntity;
import com.with.second.entity.OrderEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class DeliveryRepositoryTests {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Test
    public void save(){

        IntStream.rangeClosed(1,100).forEach(i -> {

            OrderEntity orderEntity = OrderEntity.builder()
                    .ono((long) i)
                    .build();

            DeliveryEntity entity = DeliveryEntity.builder()
                    .orderEntity(orderEntity)
                    .status("배송중")
                    .build();

            deliveryRepository.save(entity);
        });
    }


    @Test
    public void read2() {
        Optional<DeliveryEntity> delivery = deliveryRepository.findById(30L);
        DeliveryEntity entity = delivery.get();
        System.out.println(entity);
    }

    @Test
    public void read(){
        List<DeliveryEntity> deliverys = deliveryRepository.findAll();
        for(DeliveryEntity delivery : deliverys) {
            System.out.println(delivery);
        }

    }

}
