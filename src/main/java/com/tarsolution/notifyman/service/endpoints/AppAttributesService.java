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
package com.tarsolution.notifyman.service.endpoints;

import java.io.Serializable;
import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tarsolution.notifyman.common.dto.AppAttributesDTO;
import com.tarsolution.notifyman.service.logic.AppAttributesLogic;
import com.tarsolution.notifyman.service.mapper.AppAttributesModelMapper;

/**
 * 
 * @author FMARSLAN AppAttributes Service Interface of AppAttribute
 * 
 */
@Service
@Transactional
public class AppAttributesService implements Serializable {

  private static final long serialVersionUID = 4848255166728780975L;

  private static final Logger LOG = LoggerFactory.getLogger(AppAttributesService.class);

  @Autowired
  private AppAttributesLogic logic;
  private final AppAttributesModelMapper mapper = new AppAttributesModelMapper();

  /**
   * @return AppAttributesDTO AppAttributes Find all app atributes items
   * 
   */
  public List<AppAttributesDTO> findAll() {
    LOG.debug("AppAttributesService request start for findAll method");
    List<AppAttributesDTO> dtoList = mapper.convertList2Dto(logic.findAll());
    return dtoList;
  }
}
