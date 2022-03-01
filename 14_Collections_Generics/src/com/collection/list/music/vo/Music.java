package com.collection.list.music.vo;

/**
 * VO Class
 *
 */
public class Music implements Comparable<Music>{
	private String title;
	private String singer;
	
	public Music() {
		super();
	}
	public Music(String title, String singer) {
		super();
		this.title = title;
		this.singer = singer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	@Override
	public String toString() {
		return "Music [title=" + title + ", singer=" + singer + "]";
	}
	@Override
	public int compareTo(Music o) {
		return this.title.compareTo(o.title);
	}
	
	
	
	
	
}
