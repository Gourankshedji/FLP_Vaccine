package com.cg.flp.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Available {
	@Id
	@GeneratedValue
private int availableId;
private LocalDate availableDate;
private LocalDateTime availableTime;
public Available() {
	super();
}
public Available(LocalDate availableDate, LocalDateTime availableTime) {
	super();
	this.availableDate = availableDate;
	this.availableTime = availableTime;
}
public Available(int availableId, LocalDate availableDate, LocalDateTime availableTime) {
	super();
	this.availableId = availableId;
	this.availableDate = availableDate;
	this.availableTime = availableTime;
}
public int getAvailableId() {
	return availableId;
}
public void setAvailableId(int availableId) {
	this.availableId = availableId;
}
public LocalDate getAvailableDate() {
	return availableDate;
}
public void setAvailableDate(LocalDate availableDate) {
	this.availableDate = availableDate;
}
public LocalDateTime getAvailableTime() {
	return availableTime;
}
public void setAvailableTime(LocalDateTime availableTime) {
	this.availableTime = availableTime;
}
@Override
public String toString() {
	return "Available [availableId=" + availableId + ", availableDate=" + availableDate + ", availableTime="
			+ availableTime + "]";
}


}
