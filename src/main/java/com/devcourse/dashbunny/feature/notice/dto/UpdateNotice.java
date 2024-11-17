package com.devcourse.dashbunny.feature.notice.dto;

import com.devcourse.dashbunny.domain.admin.NoticeTarget;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateNotice {
    private String noticeTitle;
    private String noticeContent;
    private NoticeTarget target;
}
