package com.ayak.phms.store;

public class Store {
	private String DS_Location;
	private String Ds_StoreTel;
	private String Ds_OperatingHours;
	private String Ds_CheckingOperating;
	
	
	public String getDS_Location() {
		return DS_Location;
	}
	public String getDs_OperatingHours() {
		return Ds_OperatingHours;
	}
	public String getDs_CheckingOperating() {
		return Ds_CheckingOperating;
	}
	public void setDS_Location(String dS_Location) {
		DS_Location = dS_Location;
	}
	public void setDs_OperatingHours(String ds_OperatingHours) {
		Ds_OperatingHours = ds_OperatingHours;
	}
	public void setDs_CheckingOperating(String ds_CheckingOperating) {
		Ds_CheckingOperating = ds_CheckingOperating;
	}
	
	public String getDs_StoreTel() {
		return Ds_StoreTel;
	}
	public void setDs_StoreTel(String ds_StoreTel) {
		Ds_StoreTel = ds_StoreTel;
	}
}
