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
package com.tarsolution.notifyman.service.mapper;

import com.tarsolution.notifyman.common.dto.AppAttributesDTO;
import com.tarsolution.notifyman.core.base.AbstractMapper;
import com.tarsolution.notifyman.data.entity.AppAttributes;

/**
 *
 * @author FMARSLAN
 * AppAttributes Object mapper for AppAttributes
 * 
 */
public class AppAttributesModelMapper
    extends AbstractMapper<Integer, AppAttributesDTO, AppAttributes> {

  /**
   * AppAttributes AppAttributes entity convert to AppAttributesDTO object
   * @param entity object for transform
   * @return type of AppAttributesDTO
   */
  protected AppAttributesDTO convertToDto(AppAttributes entity) {
    AppAttributesDTO dto = new AppAttributesDTO();
    dto.setCode(entity.getCode());
    dto.setValue(entity.getValue());
    dto.setDescription(entity.getDescription());
    return dto;
  }

  /**
   * AppAttributes AppAttributesDTO object convert to AppAttributes entity
   * @param dto object for transform
   * @return type of AppAttributes
   */
  protected AppAttributes convertToEntity(AppAttributesDTO dto) {
    AppAttributes entity = new AppAttributes();
    entity.setCode(dto.getCode());
    entity.setValue(dto.getValue());
    entity.setDescription(dto.getDescription());
    return entity;
  }

}
