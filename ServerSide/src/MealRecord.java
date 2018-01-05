
public class MealRecord {
	private String userName;
	private String mealType;
	private String desc;
	
	public MealRecord() {
		
	}

	public MealRecord(String userName, String mealType, String desc) {
		super();
		this.userName = userName;
		this.mealType = mealType;
		this.desc = desc;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
