package com.devcourse.dashbunny.feature.notice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateNotice {
    private String noticeTitle;
    private String noticeContent;
    private String target;
}
