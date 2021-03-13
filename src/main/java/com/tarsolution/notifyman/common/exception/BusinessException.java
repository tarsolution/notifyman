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
package com.tarsolution.notifyman.common.exception;
/**
 * 
 * @author FMARSLAN
 *
 */
public class BusinessException extends RuntimeException {
  private static final long serialVersionUID = -5015013313890326751L;

  private String code;

  protected BusinessException() {
    this(null, ExceptionConstant.GENERIC_EXCEPTION_CODE);
  }

  public BusinessException(
      String message, String code) {
    super(message);
    this.code = code;
  }

  public BusinessException(
      String message) {
    this(message, ExceptionConstant.GENERIC_EXCEPTION_CODE);
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
