/**
 * I declare that this code was written by me 
 * I will not copy or allow others to copy my code
 * I understand that copying code is considered as plagiarism.
 *
 * Student Name: Lionel Lim Jin Rong
 * Student ID: 20015553
 *
 */
package quiz;

public class Chromebook extends Item {
	private String os;
	
	public Chromebook(String assetTag, String description, String os) {
		super(assetTag, description);
		this.os = os;
	}
	
	public String getOs() {
		return os;
	}
}
