package com.sunu.code;

import java.util.Stack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by sunu@wemakeprice.com on 2018. 10. 16..
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class IronrodTests {

  public int solution(String arrangement){
    String[] strArray = arrangement.split("");
    Stack<String> st = new Stack<>();
    int result  = 0;
    for (int i = 0; i <strArray.length ; i++) { //문자열만큼 LOOP
//      System.out.println("i : "+strArray[i]);
      if(strArray[i].equals("(")){        //시작문자열이라면
      //  System.out.println("st : "+strArray[i]);
        st.push(strArray[i]);             //stack push
      //  System.out.println(st.toString());
      }else{
        st.pop();                         //stack pop
        if(strArray[i-1].equals("(") ) {  //이전문자열이 (라면 레이저로 간주하여 현재 stack카운터 합산
          result +=st.size();
        }else{
          result++;                       //레이저가 아니라면 플러스
        }
      }
    }
    return result;
  }

  @Test
  public void execute(){
    String arrangement = "()(((()())(())()))(())";
    System.out.println("Iron Rod Count : " + solution(arrangement));

  }

}
