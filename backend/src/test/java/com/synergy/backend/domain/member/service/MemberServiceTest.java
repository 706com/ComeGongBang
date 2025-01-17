package com.synergy.backend.domain.member.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.synergy.backend.domain.grade.model.entity.Grade;
import com.synergy.backend.domain.grade.repository.GradeRepository;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.model.request.MemberSignupReq;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import com.synergy.backend.global.security.CustomUserDetails;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;
    @Mock
    private CustomUserDetails customUserDetails;
    @Mock
    private MemberRepository memberRepository;
    @Mock
    private GradeRepository gradeRepository;
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @BeforeEach
    void setUp() {
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

    @Test
    @DisplayName("정상 회원가입 정보가 들어왔을 시 성공 값 반환")
    void signup_success() {
        // given
        MemberSignupReq memberSignupReq = new MemberSignupReq("test@example.com", "testNickname");

        Grade grade = Grade.builder()
                .idx(1L)
                .name("Test Grade")
                .defaultPercent(10)
                .gradeRange(5)
                .recurPercent(5)
                .recurNum(1)
                .upgradePercent(10)
                .upgradeNum(2)
                .imageUrl("testImageUrl")
                .conditionMin(0)
                .conditionMax(100)
                .build();

        Member member = Member.builder()
                .email(memberSignupReq.getEmail())
                .password("encodedPassword")
                .nickname(memberSignupReq.getNickname())
                .profileImageUrl("testProfileImageUrl")
                .grade(grade)
                .build();

        when(gradeRepository.findById(1L)).thenReturn(Optional.of(grade));

        when(gradeRepository.findById(1L)).thenReturn(Optional.of(grade));
        when(bCryptPasswordEncoder.encode(memberSignupReq.getPassword())).thenReturn("encodedPassword");
        when(memberRepository.save(any(Member.class))).thenReturn(member);

        // when
        String result = memberService.signup(memberSignupReq);

        // then
        assertEquals("회원 저장 성공", result);
        verify(gradeRepository, times(1)).findById(1L);
        verify(memberRepository, times(1)).save(any(Member.class));
    }
}
