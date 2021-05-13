package quiz;

public class Item {
	private String assetTag;
	private String description;
	private String dueDate;
	private boolean isAvailable;
	
	public Item(String assetTag, String description) {
		this.assetTag = assetTag;
		this.description = description;
	}
	
	public String getAssetTag() {
		return assetTag;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getDueDate() {
		String a = "";
		if(dueDate == null) {
			 a = "";
		}
		else {
			 a = dueDate;
		}
		return a;
	}
	
	public boolean getIsAvailable() {
		return isAvailable;
	}
	
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}
