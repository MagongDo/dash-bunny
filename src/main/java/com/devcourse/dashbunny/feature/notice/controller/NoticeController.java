package com.devcourse.dashbunny.feature.notice.controller;

import com.devcourse.dashbunny.domain.admin.Notice;
import com.devcourse.dashbunny.feature.notice.dto.AddNotice;
import com.devcourse.dashbunny.feature.notice.dto.NoticeListView;
import com.devcourse.dashbunny.feature.notice.dto.NoticeView;
import com.devcourse.dashbunny.feature.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notice")
public class NoticeController {
    private final NoticeService noticeService;

    //공지사항 등록 api (POST)
    @PostMapping("/admin")
    public ResponseEntity<Notice> addNotice(@RequestParam("request")AddNotice request) {
        Notice saveNotice = noticeService.saveNotice(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveNotice);
    }

    //공지사항 목록 조회 api (GET)
    @GetMapping()
    public ResponseEntity<List<NoticeListView>> getNotices() {
        List<NoticeListView> notices=noticeService.getAllNotices();
        return ResponseEntity.ok().body(notices);
    }

    //특정 공지사항 조회 api (GET)
    @GetMapping("/{noticeId}")
    public ResponseEntity<NoticeView> getNotice(@PathVariable Long noticeId) {
        NoticeView noticeView=noticeService.getNotice(noticeId);
        return ResponseEntity.ok().body(noticeView);
    }

    //공지사항 삭제 api (DELETE)
    @DeleteMapping("/{noticeId}")
    public ResponseEntity<?> deleteNotice(@PathVariable Long noticeId) {
        noticeService.deleteNotice(noticeId);
        Map<String,String> response=new HashMap<>();
        response.put("message","NoticeId: "+noticeId+" deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
