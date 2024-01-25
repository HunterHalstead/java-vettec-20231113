package com.skillstorm.observer;

import java.util.LinkedList;
import java.util.List;

public class NewsAgency {
	
	String news;
	
	// List of subscribers
	List<Observer> subscribers = new LinkedList<>();
	
	// subscribe
	public void subscribe(Observer o) {
		subscribers.add(o);
	}
	
	
	// unsubscribe
	public void unsubscribe(Observer o) {
		subscribers.remove(o);
	}
	
	// notify
	public void setNews(String news) {
		this.news = news;
		for (Observer sub : subscribers) {
			System.out.println("Sending update to: " + sub);
			sub.update(this.news);
		}
	}


	@Override
	public String toString() {
		return "NewsAgency [news=" + news + ", subscribers=" + subscribers + "]";
	}
	
}
