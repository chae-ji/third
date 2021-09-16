package com.with.second.controller;

import com.with.second.dto.OrderDto;
<<<<<<< HEAD
=======
import com.with.second.entity.OrderEntity;
>>>>>>> 39920db7332b085d01dc02ff6f688e8978e12708
import com.with.second.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/order")
public class OrderController {

    private final OrderService service;

    @PostMapping("/register")
    public HttpStatus register(@RequestBody OrderDto dto){

        log.info("dto : " + dto);

        service.register(dto);

        return HttpStatus.OK;
    }

    @GetMapping("/getList")
    public ResponseEntity<List<OrderDto>> getList(@ModelAttribute("id") String userId){

        log.info("userId : " + userId);

        List<OrderDto> list = service.getList(userId);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("/update")
<<<<<<< HEAD
    public HttpStatus update(Long ono, String status) {

        log.info("omo : " + ono);
=======
    public HttpStatus update(Long ono, String status){

        log.info("ono : " + ono);
>>>>>>> 39920db7332b085d01dc02ff6f688e8978e12708
        log.info("status : " + status);

        service.update(ono, status);

        return HttpStatus.OK;
    }

    @DeleteMapping("/remove")
<<<<<<< HEAD
    public HttpStatus remove(Long ono) {
=======
    public HttpStatus remove(Long ono){
>>>>>>> 39920db7332b085d01dc02ff6f688e8978e12708

        log.info("ono : " + ono);

        service.remove(ono);

        return HttpStatus.OK;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 39920db7332b085d01dc02ff6f688e8978e12708
