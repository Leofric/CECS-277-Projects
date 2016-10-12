package edu.project.four;

public class MeasurableString extends Measurable<String> {

	private String data;
	
	public MeasurableString(String string){
		data = string;
	}
	
	public String toString(){
		return data;
	}
	
	public double getMeasure(){
		return (double)data.length();
	}
	
}