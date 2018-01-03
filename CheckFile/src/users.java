import java.io.Serializable;

public class users implements Serializable{
	
	private String name;
	private String some2;
	
	public users() {
		
	}
	public users(String some, String some2) {
		super();
		this.name = some;
		this.some2 = some2;
	}
	public String getNmae() {
		return name;
	}
	public void setName(String some) {
		this.name = some;
	}
	public String getSome2() {
		return some2;
	}
	public void setSome2(String some2) {
		this.some2 = some2;
	}
	
	
}
