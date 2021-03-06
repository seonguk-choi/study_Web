package com.hanul.study;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;
import net.htmlparser.jericho.Source;

public class HtmlParser {
	//Parser(구문분석) : 문장을 구성하는 어휘(Tokken)를 분석하여, 일련의 패턴을 찾아 데이터를 읽어오는 행위
	//사용 예 : 서버측에서 데이터(JSON, xml)를 제공하지 않을 경우, 구문분석을 통하야 강제로 데이터를 가져온다.
	//동작원리 : 웹브라우저에 출력되는 모든 내용은 반드시 태그로 감싸져 있다.
	//			 시작태그와 마감태그 사이의 텍스트(데이터)를 모두 갖고온다.
	
	public static void main(String[] args) {
		try {
			String addr = "https://sum.su.or.kr:8888/bible/today";
			URL url = new URL(addr);
			Source source = new Source(url); //html 원본소스를 가져온다.
			//System.out.println(source);
			List<Element> list = source.getAllElements(HTMLElementName.DIV); //원본소스에서 div 태만 가져온다.
			//System.out.println("List의 개수" + list.size());
			
			String html1 = null; //날짜(date)
			String html2 = null; //제목(subject)
			String html3 = null; //부제목(sub)
			String html4 = null; //내용(content)
			
			for(int i =0 ; i < list.size() ; i++) {
				String data = list.get(i).getContent().toString();
				//System.out.println(data);
				
				if(data.contains("id=\"dailybible_info\">")) {
					html1 = data;
					//System.out.println(html1);
				}
				if(data.contains("id=\"bible_text\">")) {
					html2 = data;
				}
				if(data.contains("id=\"bible_text\">")) {
					html2 = data;
				}
				if(data.contains("id=\"bibleinfo_box\">")) {
					html3 = data;
				}
				if(data.contains("id=\"body_list\">")) {
					html4 = data;
				}
			}//for
			
			//System.out.println(html1);
			//System.out.println(html2);
			int beginIndex = html1.indexOf("id=\"dailybible_info\">");
			String date = html1.substring(beginIndex +21);
			int endIndex = date.indexOf("</div>");
			date = date.substring(0, endIndex);
			System.out.println("날짜 : " + date.trim());
			
			beginIndex = html2.indexOf("id=\"bible_text\">");
			String subject = html2.substring(beginIndex +16);
			endIndex = subject.indexOf("</div>");
			subject = subject.substring(0, endIndex);
			System.out.println("제목 : " + subject.trim());
			
			beginIndex = html3.indexOf("id=\"bibleinfo_box\">");
			String sub = html3.substring(beginIndex + 19);
			endIndex = sub.indexOf("</div>");
			sub = sub.substring(0, endIndex);
			System.out.println(sub.trim());
			
			beginIndex = html4.indexOf("id=\"body_list\">");
			String content = html4.substring(beginIndex + 15);
			endIndex = content.indexOf("</ul>");
			content = content.substring(0, endIndex);
			//System.out.println(content.trim());
			//split(); -> 특정값을 기준으로 주어진 데이터를 분할한다(쪼갠다) ▶ 결과는 배열로 받는다.
			//String str = "가@나@다";
			//String[] sp = str.split("@");
			//sp.length : 3
			//sp[0] : 가
			//sp[1] : 나
			//sp[2] : 다
			String[] sp = content.split("</li>");
			//System.out.println(Arrays.toString(sp));
			
			for (int i = 0; i < sp.length-1; i++) {
				beginIndex = sp[i].indexOf("class=\"num\">");
				String num = sp[i].substring(beginIndex +12);
				endIndex = num.indexOf("</div>");
				num = num.substring(0, endIndex);
				
				beginIndex = sp[i].indexOf("class=\"info\">");
				String info = sp[i].substring(beginIndex +13);
				endIndex = info.indexOf("</div>");
				info = info.substring(0, endIndex);
				System.out.println(num + " : " + info );				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main()
}//class
