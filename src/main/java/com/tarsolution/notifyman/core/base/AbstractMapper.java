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
package com.tarsolution.notifyman.core.base;

import java.util.ArrayList;
import java.util.List;
import com.tarsolution.notifyman.common.share.IAuditFields;
import com.tarsolution.notifyman.common.share.IHasPrimaryKey;
/**
 * 
 * @author FMARSLAN
 *
 */
public abstract class AbstractMapper<T, DTO extends IHasPrimaryKey<T>, ENTITY extends IHasPrimaryKey<T>> {

  
  /**
   * convert dto to entity for specific object
   * 
   * @param  entity transform entity to dto 
   * @return type of DTO
   */
  protected abstract DTO convertToDto(ENTITY entity);

  /**
   * convert dto to entity for specific object
   * 
   * @param dto transform dto to entity  
   * @return type of ENTITY
   */
  protected abstract ENTITY convertToEntity(DTO dto);

  
  /**
   * convert entity to dto for specific object
   * 
   * @param obj object for transform 
   * @return type of DTO
   */
  public DTO toDTO(ENTITY obj) {
    DTO dto = convertToDto(obj);
    dto.setId(obj.getId());
    if (obj instanceof IAuditFields && dto instanceof IAuditFields) {
      ((IAuditFields) dto).setCreatedBy(((IAuditFields) obj).getCreatedBy());
      ((IAuditFields) dto).setCreatedDate(((IAuditFields) obj).getCreatedDate());
      ((IAuditFields) dto).setUpdatedBy(((IAuditFields) obj).getUpdatedBy());
      ((IAuditFields) dto).setUpdatedDate(((IAuditFields) obj).getUpdatedDate());
    }
    return dto;
  }
  
  /**
   * convert dto to entity for specific object
   * 
   * @param obj object for transform 
   * @return type of ENTITY
   */
  public ENTITY toEntity(DTO obj) {
    ENTITY entity = convertToEntity(obj);
    entity.setId(obj.getId());
    if (obj instanceof IAuditFields && entity instanceof IAuditFields) {
      ((IAuditFields) entity).setCreatedBy(((IAuditFields) obj).getCreatedBy());
      ((IAuditFields) entity).setCreatedDate(((IAuditFields) obj).getCreatedDate());
      ((IAuditFields) entity).setUpdatedBy(((IAuditFields) obj).getUpdatedBy());
      ((IAuditFields) entity).setUpdatedDate(((IAuditFields) obj).getUpdatedDate());
    }
    return entity;
  }

  
  /**
   * convert list of ENTITY to list of DTO for specific object
   * 
   * @param list object for transform 
   * @return type of DTO list
   */
  public List<DTO> convertList2Dto(List<ENTITY> list) {
    List<DTO> resultList = new ArrayList<>();
    list.forEach(x -> {
      resultList.add(convertToDto(x));
    });
    return resultList;
  }

  /**
   * convert list of DTO to list of ENTITY for specific object
   * 
   * @param list object for transform 
   * @return type of ENTITY List
   */
  public List<ENTITY> convertList2Entity(List<DTO> list) {
    List<ENTITY> resultList = new ArrayList<>();
    list.forEach(x -> {
      resultList.add(convertToEntity(x));
    });
    return resultList;
  }

}
