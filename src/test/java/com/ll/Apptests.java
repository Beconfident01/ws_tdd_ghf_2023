package com.ll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class Apptests {
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

}
