/*
 * Copyright (C) 2011 The Best Company in the World
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * https://github.com/fmarslan/notifyman/blob/master/LICENSE
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.tarsolution.notifyman.service.logic;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import com.tarsolution.notifyman.common.response.ResponseDataList;
import com.tarsolution.notifyman.data.entity.Notification;
import com.tarsolution.notifyman.data.repository.NotificationRepository;

/**
 * 
 * @author FMARSLAN includes all logical process for Notification
 *
 */
@Component
@Scope(scopeName = "singleton")
public class NotificationLogic implements Serializable {

  private static final long serialVersionUID = -3484141581844062106L;
  
  @Autowired
  NotificationRepository repository;

  /**
   * @return Get all AppAttribute items
   */
  public ResponseDataList<Notification> page(long userId, Pageable pageable) {
    Page<Notification> result = repository.findAllByUser(userId, pageable);
    return new ResponseDataList<>(result.toList(), HttpStatus.OK).setLimit(result.getSize())
        .setOffset(Long.valueOf(result.getPageable().getOffset()).intValue())
        .setTotalCount(Long.valueOf(result.getTotalElements()).intValue());
  }

}
