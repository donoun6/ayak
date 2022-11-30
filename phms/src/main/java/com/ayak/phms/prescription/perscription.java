package com.ayak.phms.prescription;

public class perscription {
	private long pid;
	private String Ps_Date;
	private String Ps_DrugStore;
	private String Ps_MedicineName;
	private String Ps_Description;
	
	
	public long getPid() {
		return pid;
	}
	public String getPs_Date() {
		return Ps_Date;
	}
	public String getPs_DrugStore() {
		return Ps_DrugStore;
	}
	public String getPs_MedicineName() {
		return Ps_MedicineName;
	}
	public String getPs_Description() {
		return Ps_Description;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public void setPs_Date(String ps_Date) {
		Ps_Date = ps_Date;
	}
	public void setPs_DrugStore(String ps_DrugStore) {
		Ps_DrugStore = ps_DrugStore;
	}
	public void setPs_MedicineName(String ps_MedicineName) {
		Ps_MedicineName = ps_MedicineName;
	}
	public void setPs_Description(String ps_Description) {
		Ps_Description = ps_Description;
	}
	
	
}
