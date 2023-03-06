package com.ll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class Apptests {
    //유틸테스트 시작
    @Test
    @DisplayName("스캐너에_키보드가_아닌_문자열을_입력으로_설정")
    public void t1(){
        Scanner sc =TestUtil.genScanner("안녕");

        String cmd =sc.nextLine().trim();
        assertThat(cmd).isEqualTo("안녕");

    }
    @Test
    @DisplayName("출력을_모니터에_하지_않고_문자열로_얻기")
    public void t2() {
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        System.out.print("안녕");

        String rs = output.toString();

        TestUtil.clearSetOutToByteArray(output);

        assertThat(rs).isEqualTo("안녕");
    }
    //테스트유팅 테스트 끝
    //앱 테스트 시작
    @Test
    @DisplayName("프로그램 시작시 타이틀 출력 그리고 종료")
    public void t3() {
        String rs = AppTestRunner.run("");


        assertThat(rs)
                .contains("== 명언 앱 ==")
                .contains("명령)")
                .contains("프로그램이 종료되었습니다.")
                .doesNotContain("올바르지 않은 명령입니다.");
    }
    @Test
    @DisplayName("잘못 명령어 입력 처리")
    public void t4() {
        String rs = AppTestRunner.run("");


        assertThat(rs)
                .contains("올바르지 않은 명령입니다.");
//앱 테스트 끝
    }

}
