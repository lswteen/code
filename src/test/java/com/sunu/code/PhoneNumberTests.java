package com.sunu.code;

import java.util.HashMap;
import java.util.HashSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by sunu@wemakeprice.com on 2018. 10. 4..
 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 *
 * 구조대 : 119
 * 박준영 : 97 674 223
 * 지영석 : 11 9552 4421
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
 * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를
 * 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoneNumberTests {

  public boolean solution(String[] phone_book) {
    boolean answer = true;
    String diff = "";
    for (int i = 0; i <phone_book.length ; i++) {
      diff = phone_book[i];
      for (int j = 0; j <phone_book.length ; j++) {
        if(i != j){
          System.out.println("B : "+phone_book[j]+" diff : "+diff);
          if(diff.contains(phone_book[j])){
            answer = false;
            break;
          }
        }
      }
    }
    return answer;
  }

  @Test
  public void execute(){
    //["113", "12340", "123440", "12345", "98346"]
    String[] phone_book ={"113","12340","123440","12345","98346"};
    System.out.println(solution(phone_book));
  }
}
