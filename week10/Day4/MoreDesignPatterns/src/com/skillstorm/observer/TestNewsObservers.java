package com.skillstorm.observer;

public class TestNewsObservers {
	
	public static void main(String[] args) {
		NewsAgency theSkillStormNews = new NewsAgency();
		PrintSubscriber ps1 = new PrintSubscriber();
		theSkillStormNews.subscribe(ps1);
		PrintSubscriber ps2 = new PrintSubscriber();
		theSkillStormNews.subscribe(ps2);
		theSkillStormNews.subscribe(new DigitalSubscriber());
		theSkillStormNews.subscribe(new DigitalSubscriber());
		
		theSkillStormNews.setNews("Come see Top notch Java technology presenters at 1pm EST today!");
		
System.out.println("---------------two unsubscribers");
		theSkillStormNews.unsubscribe(ps1);
		theSkillStormNews.unsubscribe(ps2);
		

		theSkillStormNews.setNews("Come see the latest in Blackjack Casino technology Feb 16th!");
	}

}
