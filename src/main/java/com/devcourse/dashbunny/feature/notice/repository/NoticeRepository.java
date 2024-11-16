package com.devcourse.dashbunny.feature.notice.repository;

import com.devcourse.dashbunny.domain.admin.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
