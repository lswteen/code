package com.sunu.code;

import java.util.Stack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by sunu@wemakeprice.com on 2018. 10. 16..
 *
 * 여러 개의 쇠막대기를 레이저로 절단하려고 합니다. 효율적인 작업을 위해서 쇠막대기를 아래에서 위로 겹쳐 놓고,
 * 레이저를 위에서 수직으로 발사하여 쇠막대기들을 자릅니다. 쇠막대기와 레이저의 배치는 다음 조건을 만족합니다.
 *
 * - 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있습니다.
 * - 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되, 끝점은 겹치지 않도록 놓습니다.
 * - 각 쇠막대기를 자르는 레이저는 적어도 하나 존재합니다.
 * - 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않습니다.
 *
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
