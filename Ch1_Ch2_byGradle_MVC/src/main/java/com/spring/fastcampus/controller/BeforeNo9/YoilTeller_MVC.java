package com.spring.fastcampus.controller.BeforeNo9;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

//연월일을 입력시 요일을 알려주는 프로그램


public class YoilTeller_MVC {
    //1. 입력 - 이전
//    public static void main(String[] args) {
//        String year = args[0];
//        String month = args[1];
//        String day = args[2];
//
//        int yyyy = Integer.parseInt(year);
//        int mm = Integer.parseInt(month);
//        int dd = Integer.parseInt(day);

    //2. 입력의 분리 - MVC Pattern
//    @RequestMapping("/getYoil")
//    public void main(String year, String month, String day, HttpServletResponse response) throws IOException {
//        int yyyy = Integer.parseInt(year);
//        int mm = Integer.parseInt(month);
//        int dd = Integer.parseInt(day);

    //2-1. 또 다른 방법
    @RequestMapping("/getYoil")
    public void main(int yyyy, int mm, int dd, HttpServletResponse response)
            throws IOException {


        //2.작업
        Calendar cal = Calendar.getInstance();
        cal.set(yyyy, mm - 1, dd);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        //1.일요일, 2.월요일...
        char yoil = " 일월화수목금토".charAt(dayOfWeek);
        //3.출력
        System.out.println(yyyy + "년 " + mm + "월 " + dd + "일은 ");
        System.out.println(yoil + "요일입니다.");
    }
}
