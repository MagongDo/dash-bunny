package com.devcourse.dashbunny.feature.notice.dto;

import com.devcourse.dashbunny.domain.admin.Notice;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class NoticeListView {
    private Long noticeId;
    private String noticeTitle;
    private LocalDateTime createdDate;
    private String target;
    private Long viewCount;

    public NoticeListView(Notice notice) {
        this.noticeId = notice.getNoticeId();
        this.noticeTitle = notice.getNoticeTitle();
        this.createdDate = notice.getCreatedDate();
        this.target = notice.getTarget();
        this.viewCount = notice.getViewCount();
    }

}
