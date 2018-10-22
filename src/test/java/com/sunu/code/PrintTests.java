package com.sunu.code;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by sunu@wemakeprice.com on 2018. 10. 17..
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class PrintTests {

  public int solution(int[] priorities, int location) {
    //0
    //1,1,9,1,1,1
    //1
    int answer =0;
    int count = 0;

    PriorityQueue<Map<Integer,Integer>> pq = new PriorityQueue<Map<Integer,Integer>>();
    Map<Integer,Integer> map = new HashMap<>();

    for (int i = 0; i <priorities.length ; i++) {
      map.put(i,priorities[i]);
    }
    return answer;

  }

  @Test
  public void execute(){
  int[] priorities = {1,1,9,1,1,1};
  int location = 0;
  System.out.println(solution(priorities,location));
  }
}

class Document implements Comparable<Document>{

  private final String id;
  private final int no;

  private Document(String id, int doc){
   this.id = id;
   this.no = doc;
  }

  public static Document EMPTY = new Document("",-1);

  public static Document empty(){return EMPTY;}

  public int getNo() {
    return no;
  }

  public boolean is(Document o){
    return id.equals(o.id) && equals(o);
  }

  @Override
  public boolean equals(Object obj) {
    if( obj instanceof Document){
      Document o = (Document)obj;
      return no == o.no;
    }
    return false;
  }
  public static Comparator<Document> ascWithNo(){
    return Comparator.comparing(Document::getNo);
  }

  @Override
  public int compareTo(Document o) {
    if(equals(o)) return 0;
    return 0 < (no - o.no) ? 1 : -1;
  }

  static class DocumentSeqGenerator {
    private static char charIndexIter;
    private static String charIndexBase;

    public static void initCharIndexIter(){
      charIndexIter = 'A';
      charIndexBase = "";
    }

    public static String nextCharIndex(){
      if( 'Z' < charIndexIter) {
        charIndexIter = 'A';
        charIndexBase += charIndexIter;
      }
      return charIndexBase + (charIndexIter++);
    }

    static{
      initCharIndexIter();
    }
  }

  public static Document of(int doc ){
    return new Document(DocumentSeqGenerator.nextCharIndex(), doc);
  }


  @Override
  public String toString() {
    return String.format("[%3s]%d", id, no);
  }

}