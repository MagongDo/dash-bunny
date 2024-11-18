package com.devcourse.dashbunny.feature.admin.store.controller;

import com.devcourse.dashbunny.domain.owner.StoreManagement;
import com.devcourse.dashbunny.feature.admin.store.dto.StoreCreateDTO;
import com.devcourse.dashbunny.feature.admin.store.dto.StoreListView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/store")
public class StoreRequestController {

    @PostMapping("create")
    public ResponseEntity<String> createStore(@RequestBody StoreCreateDTO storeCreatDTO){
        StoreManagement storeManagement = storeCreatDTO.toEntity();
        return ResponseEntity.ok("가게 생성 승인 요청을 성공했습니다."+ storeManagement);
    }

//    @GetMapping()
//    public ResponseEntity<StoreListView> getStore(){
//
//    }

    //승인
//    @PutMapping()
//
//    //거절
//    @PutMapping
}
