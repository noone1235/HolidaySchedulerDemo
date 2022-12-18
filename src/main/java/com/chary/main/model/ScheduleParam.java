package com.chary.main.model;

public class ScheduleParam {
	
	private String uuId;
	private String taskName;
	private String cronTime;
	//private List<List<String>> holidays;
	
	
	public String getTaskName() {
		return taskName;
	}
	public String getUuId() {
		return uuId;
	}
	public void setUuId(String uuId) {
		this.uuId = uuId;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getCronTime() {
		return cronTime;
	}
	public void setCronTime(String cronTime) {
		this.cronTime = cronTime;
	}
	
 
	
}
