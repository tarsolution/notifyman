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
package com.tarsolution.notifyman.core.filters;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.tarsolution.notifyman.common.exception.BusinessException;
import com.tarsolution.notifyman.common.response.ResponseData;

/**
 * 
 * @author FMARSLAN
 *
 */
@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    if (ex instanceof BusinessException) {
      return new ResponseData<>(HttpStatus.INTERNAL_SERVER_ERROR)
          .setExceptionCode(((BusinessException) ex).getCode()).addMessage(ex.getMessage());
    }
    return new ResponseData<Object>(HttpStatus.INTERNAL_SERVER_ERROR).addMessage(ex.getMessage());
  }

}
