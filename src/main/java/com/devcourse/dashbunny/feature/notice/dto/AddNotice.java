package com.devcourse.dashbunny.feature.notice.dto;

import com.devcourse.dashbunny.domain.admin.Notice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddNotice {
    private String noticeTitle;
    private String noticeContent;
    private String target;

    public Notice toEntity(){
        return Notice.builder()
                .noticeTitle(noticeTitle)
                .noticeContent(noticeContent)
                .target(target)
                .viewCount(0L)
                .build();
    }
}
