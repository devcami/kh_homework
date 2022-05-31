package com.kh.ajax.celeb.manager;

import java.util.ArrayList;
import java.util.List;

import com.kh.ajax.celeb.dto.Celeb;
import com.kh.ajax.celeb.dto.CelebType;

/**
 * singletone 프로그램 운영 중 단 하나의 객체만 사용
 *	- 생성자를 private으로 : 외부에서는 객체 생성 불가능
 *	- CelebManager 객체를 계속 재사용 : List를 일관적으로 관리하기 위해서
 */
public class CelebManager {
	private static CelebManager instance;
	private List<Celeb> celebList = new ArrayList<>();
	
	/**
	 * 외부에서는 객체 생성 불가능한 private 생성자
	 */
	private CelebManager() {
		celebList.add(new Celeb(1,"daft punk", CelebType.SINGER, "daftpunk.jpg"));
		celebList.add(new Celeb(2,"hwang", CelebType.COMEDIAN, "hwang.jpg"));
		celebList.add(new Celeb(3,"박보검", CelebType.ACTOR, "parkBogum.jpg"));
		celebList.add(new Celeb(4,"유재석", CelebType.ENTERTAINER, "유재석.jpg"));
		celebList.add(new Celeb(5,"강승윤", CelebType.SINGER, "yoon.jpeg"));
	}
	
	public static CelebManager getInstance() {
		if(instance == null)
			instance = new CelebManager();
		return instance;
	}

	public List<Celeb> getCelebList() {
		return celebList;
	}
	
}
