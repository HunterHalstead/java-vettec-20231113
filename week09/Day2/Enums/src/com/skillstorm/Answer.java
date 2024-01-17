package com.skillstorm;

public enum Answer {
	YES("!") {
		@Override
		public void hesitate() {
			System.out.println("...");
		}
	},
	NO(".") {
		@Override
		public void hesitate() {
			System.out.println(".......");
		}
		
		@Override
		public String repeat() {
			return this.name() + " " + this.name() +  " " + this.name();
		}
	};
	
	private String emphasis;
	/* default */ private Answer(String emphasis) {
		this.emphasis = emphasis;
	}
	
	public String getEmphasis() {
		return emphasis;
	}
	
	public abstract void hesitate();
	
	public String repeat() {
		return this.name() + " " + this.name();
	}
}

interface Stuffy {
	void doStuff();
}
enum Response /* extends Answer */ implements Stuffy {
	GOOD,
	OKAY,
	BAD;

	@Override
	public void doStuff() {
		System.out.println("Stuff");
	}
	
}
