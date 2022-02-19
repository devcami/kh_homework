package com.api.member.run;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import com.api.member.model.vo.Member;

public class Run {

	public static void main(String[] args) {
		String data = "1,김연아,165,47,19900905|2,양세형,167,60,19850818|3,김래원,182,80,19810319";
		StringTokenizer st = new StringTokenizer(data, "|");
		
		Member[] member = new Member[st.countTokens()];
		
		for(int i = 0; st.hasMoreTokens() ; i++) { 
			String str = st.nextToken();
			String[] token = str.split(",");
			
			Member m = new Member();
			m.setMemberNo(Integer.parseInt(token[0]));
			m.setMemberName(token[1]);
			m.setHeight(Integer.parseInt(token[2]));
			m.setWeight(Integer.parseInt(token[3]));
			
			int year = Integer.parseInt(token[4].substring(0, 4));
			int month = Integer.parseInt(token[4].substring(4, 6));
			int day = Integer.parseInt(token[4].substring(6, 8));
			
			m.setBirth(new GregorianCalendar(year, month, day));
			member[i] = m;
			
		}
		for(int i = 0; i < member.length; i++) {
			Member m = member[i];
			System.out.println(m.information());
		}
		
		
	}

}
