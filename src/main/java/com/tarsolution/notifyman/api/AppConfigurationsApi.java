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
package com.tarsolution.notifyman.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tarsolution.notifyman.common.dto.AppAttributesDTO;
import com.tarsolution.notifyman.common.response.ResponseDataList;
import com.tarsolution.notifyman.service.endpoints.AppAttributesService;
/**
 * 
 * @author FMARSLAN
 *
 */
@RestController
@RequestMapping("/api/configurations")
public class AppConfigurationsApi {

  @Autowired
  private AppAttributesService service;

  /**
   * AppAttributes get all app attributes
   * @return list of AppAttributes
   */
  @GetMapping("/attributes")
  public ResponseDataList<AppAttributesDTO> getAttributes() {
    return new ResponseDataList<>(service.findAll(), HttpStatus.OK);
  }

}
