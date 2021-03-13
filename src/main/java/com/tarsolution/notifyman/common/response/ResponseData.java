/*
 * Copyright (C) 2011 The Best Company in the World
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * https://github.com/fmarslan/notifyman/blob/master/LICENSE
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tarsolution.notifyman.common.response;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
/**
 * 
 * @author FMARSLAN
 *
 */
public class ResponseData<T> extends ResponseEntity<T> {

  private List<String> message = new ArrayList<>();
  private Long responseTimes;
  private Exception exception;
  private String exceptionCode;

  public ResponseData(HttpStatus status) {
    super(status);
  }

  public ResponseData(T body, HttpStatus status) {
    super(body, status);
  }

  public ResponseData(
      MultiValueMap<String, String> headers,
      HttpStatus status) {
    super(headers, status);
  }

  public ResponseData(T body,
      MultiValueMap<String, String> headers,
      HttpStatus status) {
    super(body, headers, status);
  }

  public List<String> getMessage() {
    return message;
  }

  public ResponseData<T> addMessage(String message) {
    this.message.add(message);
    return this;
  }

  public Long getResponseTimes() {
    return responseTimes;
  }

  public ResponseData<T> setResponseTimes(Long responseTimes) {
    this.responseTimes = responseTimes;
    return this;
  }

  public Exception getException() {
    return exception;
  }

  public ResponseData<T> setException(Exception exception) {
    this.exception = exception;
    return this;
  }

  public String getExceptionCode() {
    return exceptionCode;
  }

  public ResponseData<T> setExceptionCode(String exceptionCode) {
    this.exceptionCode = exceptionCode;
    return this;
  }
}
