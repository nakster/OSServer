
public class Fitness {
	
	private String userName;
	private String mode;
	private String duration;
	
	public Fitness() {
		
	}

	public Fitness(String userName, String mode, String duration) {
		super();
		this.userName = userName;
		this.mode = mode;
		this.duration = duration;
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}



}
