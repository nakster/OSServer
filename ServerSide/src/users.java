import java.io.Serializable;

public class users implements Serializable{
	
	// Variables
	private String name;
	private String address;
	private String ppsNumber;
	private String age;
	private String weight;
	private String height;
	private String username;
	private String password;

	//empty constructor 
	public users() {
		
	}
	//constructor 
	public users(String name, String address, String ppsNumber, String age, String weight, String height, String username,
			String password) {
		super();
		this.name = name;
		this.address = address;
		this.ppsNumber = ppsNumber;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.username = username;
		this.password = password;
	}
	
	//getters and setters 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPpsNumber() {
		return ppsNumber;
	}
	public void setPpsNumber(String ppsNumber) {
		this.ppsNumber = ppsNumber;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
