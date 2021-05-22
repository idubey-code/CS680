package edu.umb.cs680.hw13;

public class DJIAEvent {

	private float djia;

	public float getDjia() {
		return djia;
	}
	
	public DJIAEvent(float djia) {
		this.djia = djia;
	}
	
	public static void main(String[] args) {
		System.out.println("DJIAEvent run successfully");
	}
}
