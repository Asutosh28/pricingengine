package dev.zero.pricingengine.model;

/**
 * ProductSpecs - Holds the product specifications
 * @author ppalit
 *
 */
public class ProductSpecs {
	
	private String year;
	private String frameType;
	private String breakType;
	private String seatType;
	private String wheelType;
	private String gearType;
	
	
	public ProductSpecs(String year, String frameType, String seatType, String wheelType,
			String gearType, String breakType ) {
		super();
		this.year = year;
		this.frameType = frameType;
		this.breakType = breakType;
		this.seatType = seatType;
		this.wheelType = wheelType;
		this.gearType = gearType;
	}

	
	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getFrameType() {
		return frameType;
	}
	public void setFrameType(String frameType) {
		this.frameType = frameType;
	}
	public String getBreakType() {
		return breakType;
	}
	public void setBreakType(String breakType) {
		this.breakType = breakType;
	}
	public String getSeatType() {
		return seatType;
	}
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	public String getWheelType() {
		return wheelType;
	}
	public void setWheelType(String wheelType) {
		this.wheelType = wheelType;
	}
	public String getGearType() {
		return gearType;
	}
	public void setGearType(String gearType) {
		this.gearType = gearType;
	}


	@Override
	public String toString() {
		return "ProductSpecs [year=" + year + ", frameType=" + frameType + ", breakType=" + breakType + ", seatType="
				+ seatType + ", wheelType=" + wheelType + ", gearType=" + gearType + "]";
	}
	
}
