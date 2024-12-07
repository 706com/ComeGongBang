package com.synergy.backend.domain.member.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import com.synergy.backend.global.security.CustomUserDetails;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;

    @Mock
    private CustomUserDetails customUserDetails;

    public MemberServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("정상 로그인 정보 일 경우, 해당 회원의 idx 도출")
    void isLogined_true() throws BaseException {
        // given
        Long expectedUserId = 1L;
        when(customUserDetails.getIdx()).thenReturn(expectedUserId);

        // when
        Long actualUserId = memberService.isLogined(customUserDetails);

        // then
        assertEquals(expectedUserId, actualUserId);
    }

    @Test
    @DisplayName("로그인 정보가 없을 경우, NEED TO LOGIN 예외 발생")
    void isLogined_false() {
        // given
        customUserDetails = null;

        // when & then
        BaseException exception = assertThrows(BaseException.class,
                () -> memberService.isLogined(customUserDetails));
        assertEquals(BaseResponseStatus.NEED_TO_LOGIN, exception.getStatus());
    }
}
