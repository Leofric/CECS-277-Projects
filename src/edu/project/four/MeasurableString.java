package edu.project.four;

public class MeasurableString<T> extends Measurable implements Comparable{

	private final String data;
	
	public MeasurableString(String string){
		data = string;
	}
	
	public String toString(){
		return data;
	}
	
	public double getMeasure(){
		return (double)data.length();
	}
	
	public int compareTo(Object object){
		int returned;
		if (data.length() > ((MeasurableString) object).getMeasure()){
			returned = 1;
		}
		else if (data.length() < ((MeasurableString) object).getMeasure()){
			returned = -1;
		}
		else returned = 0;
		return returned;
	}
}