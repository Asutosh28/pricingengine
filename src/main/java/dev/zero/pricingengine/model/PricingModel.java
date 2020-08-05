package dev.zero.pricingengine.model;

import java.util.List;

public class PricingModel {
	String year;
	List<Structure> frames;
	List<Structure> seats;
	List<Structure> wheels;
	List<Structure> gears;
	List<Structure> breaks;
	public PricingModel(String year, List<Structure> frames, List<Structure> seats, List<Structure> wheels,
			List<Structure> gears, List<Structure> breaks) {
		super();
		this.year = year;
		this.frames = frames;
		this.seats = seats;
		this.wheels = wheels;
		this.gears = gears;
		this.breaks = breaks;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public List<Structure> getFrames() {
		return frames;
	}
	public void setFrames(List<Structure> frames) {
		this.frames = frames;
	}
	public List<Structure> getSeats() {
		return seats;
	}
	public void setSeats(List<Structure> seats) {
		this.seats = seats;
	}
	public List<Structure> getWheels() {
		return wheels;
	}
	public void setWheels(List<Structure> wheels) {
		this.wheels = wheels;
	}
	public List<Structure> getGears() {
		return gears;
	}
	public void setGears(List<Structure> gears) {
		this.gears = gears;
	}
	public List<Structure> getBreaks() {
		return breaks;
	}
	public void setBreaks(List<Structure> breaks) {
		this.breaks = breaks;
	}
	@Override
	public String toString() {
		return "PricingModel [year=" + year + ", frames=" + frames + ", seats=" + seats + ", wheels=" + wheels
				+ ", gears=" + gears + ", breaks=" + breaks + "]";
	}
	
}
