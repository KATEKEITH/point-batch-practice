package com.practice.multipoint.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.practice.multicore.repository.PointRepository;

@ExtendWith(MockitoExtension.class)
public class PointServiceTest {

    @InjectMocks
    private PointServiceTest pointServiceTest;

    @Mock
    private PointRepository pointRepository;

    @Test
    public void 실패_포인트가_적립되지_않는다() {
        // given
        // TODO

        // when

        // then
    }

    @Test
    public void 성공_포인트가_적립된다() {
        // given
        // TODO 주문을 완료하면 금액의 10%가 적립된다.

        // when

        // then
        // TODO 만료일이 null이 아니
    }

    @Test
    public void 실패_포인트가_적립취소_되지_않는다() {
        // given

        // when

        // then
    }

    @Test
    public void 성공_포인트가_적립취소_된다() {
        // given
        // TODO 주문을 완료하면 금액의 10%가 적립된다.

        // when

        // then
        // TODO 만료일이 null이 아니
    }

    @Test
    public void 실패_포인트가_차감되지_않는다() {
        // given
        // TODO

        // when

        // then
    }

    @Test
    public void 성공_포인트가_차감된다() {
        // given

        // when

        // then
    }

}
