package com.libo.cms.utils;

public class ResultUtils {
private Object data;
private String message;
private boolean status;
public ResultUtils() {
	super();
	// TODO Auto-generated constructor stub
}
public ResultUtils(Object data, String message, boolean status) {
	super();
	this.data = data;
	this.message = message;
	this.status = status;
}
public Object getData() {
	return data;
}
public void setData(Object data) {
	this.data = data;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}
@Override
public String toString() {
	return "ResultUtils [data=" + data + ", message=" + message + ", status=" + status + "]";
}

}
