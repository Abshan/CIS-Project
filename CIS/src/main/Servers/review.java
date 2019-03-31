package main.Servers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class review {

	public static int orderNo;
	private int taste;
	private int plating;
	private int portion;
	private int serveTime;
	private int waitingStaff;
	private int cleanliness;
	private int lighting;
	private int comfort;
	private String opinion;
	private String Message;
	private String Date;

	public review(int taste, int plating, int portion, int serveTime, int waitingStaff, int cleanliness, int lighting,
			int comfort, String opinion, String message, String date) {

		super();
		this.taste = taste;
		this.plating = plating;
		this.portion = portion;
		this.serveTime = serveTime;
		this.waitingStaff = waitingStaff;
		this.cleanliness = cleanliness;
		this.lighting = lighting;
		this.comfort = comfort;
		this.opinion = opinion;
		Message = message;
		Date = date;
	}

	public int getTaste() {
		return taste;
	}

	public void setTaste(int taste) {
		this.taste = taste;
	}

	public int getPlating() {
		return plating;
	}

	public void setPlating(int plating) {
		this.plating = plating;
	}

	public int getPortion() {
		return portion;
	}

	public void setPortion(int portion) {
		this.portion = portion;
	}

	public int getServeTime() {
		return serveTime;
	}

	public void setServeTime(int serveTime) {
		this.serveTime = serveTime;
	}

	public int getWaitingStaff() {
		return waitingStaff;
	}

	public void setWaitingStaff(int waitingStaff) {
		this.waitingStaff = waitingStaff;
	}

	public int getCleanliness() {
		return cleanliness;
	}

	public void setCleanliness(int cleanliness) {
		this.cleanliness = cleanliness;
	}

	public int getLighting() {
		return lighting;
	}

	public void setLighting(int lighting) {
		this.lighting = lighting;
	}

	public int getComfort() {
		return comfort;
	}

	public void setComfort(int comfort) {
		this.comfort = comfort;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public static String getTodaysDate() {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String Day = df.format(now);
		return Day;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

}
