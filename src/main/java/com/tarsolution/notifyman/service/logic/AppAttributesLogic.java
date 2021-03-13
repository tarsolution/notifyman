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
package com.tarsolution.notifyman.service.logic;

import java.io.Serializable;
import java.util.List;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.tarsolution.notifyman.data.entity.AppAttributes;
import com.tarsolution.notifyman.data.repository.AppAttributesRepository;

/**
 * 
 * @author FMARSLAN
 * includes all logical process for AppAttributes
 *
 */
@Component
@Scope(scopeName = "singleton")
public class AppAttributesLogic implements Serializable {
  private static final long serialVersionUID = -7407201155439530857L;

  @Autowired
  AppAttributesRepository repository;

  /**
   * @return Get all AppAttribute items
   */
  public List<AppAttributes> findAll() {
    return IterableUtils.toList(repository.findAll());
  }

}
