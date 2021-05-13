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

public class Camcorder extends Item {
	private int opticalZoom;
	public Camcorder(String assetTag, String description, int opticalZoom) {
		super(assetTag, description);
		this.opticalZoom = opticalZoom;
	}
	
	public int getOpticalZoom() {
		return opticalZoom;
	}
}
