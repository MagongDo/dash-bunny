package com.devcourse.lifecycle;

import com.devcourse.annotation.TSID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TSIDListenerTest {

    private TSIDListener Listener;

    @BeforeEach
    void setUp() {
        Listener = new TSIDListener();
    }

    //엔티티 생성 여부 확인
    @Test
    public void setTestEntity() throws NoSuchFieldException, IllegalAccessException {
        //given
        TestEntity testEntity = new TestEntity();
        //when
        Listener.prePersist(testEntity);
        //then
        assertNotNull(testEntity.getId());
    }

    //중복된 것이 없는가
    @Test
    public void unique() throws NoSuchFieldException, IllegalAccessException {

        //중복허용 안함
        Set<String> uniqueId = new HashSet<>();
        List<String> allId = new ArrayList<>();

        //여러개의 객체 생성
        for(int i = 0; i <=1000000; i++){
            TestEntity testEntity = new TestEntity();

            Listener.prePersist(testEntity);

            Field field = testEntity.getClass().getDeclaredField("id");
            field.setAccessible(true); //private 접근 허용
            String id = (String) field.get(testEntity);

            uniqueId.add(id);
            allId.add(id);
        }

        assertEquals(uniqueId.size(), allId.size());

    }

    public static class TestEntity{

        @TSID
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

}