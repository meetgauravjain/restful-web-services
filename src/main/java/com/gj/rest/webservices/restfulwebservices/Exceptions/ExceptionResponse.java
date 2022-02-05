package com.gj.rest.webservices.restfulwebservices.Exceptions;

import java.util.Date;

public class ExceptionResponse {
  private Date timeStamp;
  private String message;
  private String details;

  public Date getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(Date timeStamp) {
    this.timeStamp = timeStamp;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public ExceptionResponse(Date timeStamp, String message, String details) {
    this.timeStamp = timeStamp;
    this.message = message;
    this.details = details;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("ExceptionResponse{");
    sb.append("timeStamp=").append(timeStamp);
    sb.append(", message='").append(message).append('\'');
    sb.append(", details='").append(details).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
