package com.collection.list.music.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.collection.list.music.vo.Music;

/**
 * Music Manager Class
 * MusicManager has a Music
 *
 */
public class MusicManager {
	private List<Music> musicList;
	
	public MusicManager() {
		musicList = new ArrayList<>();
		musicList.add(new Music("내가","도끼"));
		musicList.add(new Music("Easy On Me","Adele"));
		musicList.add(new Music("Die For You","The Weeknd"));
		
	}
	//1
	public List<Music> selectList(){
		return this.musicList;
	}
	//2
	public void addList(Music music) {
		musicList.add(music);
	}
	//3
	public void addAtZero(Music music) {
		musicList.add(0, music);
	}
	//4
	public boolean removeMusic(String title) {
		Music music = null;
		for(int i = 0; i < musicList.size(); i++) {
			music = musicList.get(i);
			if(music.getTitle().equals(title)){
				musicList.remove(i);
				return true;
			}
		}
		return false;
	}
	//5
	public boolean replaceMusic(Music oldMusic, Music newMusic) {
		Music music = null;
		for(int i = 0; i < musicList.size(); i++) {
			music = musicList.get(i);
			if(oldMusic.getTitle().equals(music.getTitle())
					&& oldMusic.getSinger().equals(music.getSinger())){
				musicList.remove(i);
				musicList.add(i, newMusic);
				return true;
			} 
		}
		return false;
	}
	//6
	public List<Music> searchMusicByTitle(String title){
		List<Music> searchMusic = new ArrayList<>();
		Music music = null;
		for(int i = 0; i < musicList.size(); i++) {
			music = musicList.get(i);
			if(music.getTitle().contains(title)) {
				searchMusic.add(music);
			}
		}
		if(searchMusic.isEmpty()) {
			System.out.println("검색결과가 없습니다.");
		}
		else{
			for(Music m : searchMusic) {
				System.out.println(m);
			}
		}
		return searchMusic;
	}
	//7
	public List<Music> searchMusicBySinger(String singer){
		List<Music> searchMusic = new ArrayList<>();
		Music music = null;
		for(int i = 0; i < musicList.size(); i++) {
			music = musicList.get(i);
			if(music.getSinger().contains(singer)) {
				searchMusic.add(music);
			}
		}
		if(searchMusic.isEmpty()) {
			System.out.println("검색결과가 없습니다.");
		}
		else{
			for(Music m : searchMusic) {
				System.out.println(m);
			}
		}
		return searchMusic;
	}
	
	//8
	public List<Music> orderBy(Comparator<Music> c){
		Collections.sort(musicList, c);
		return musicList;
	}
	
}
