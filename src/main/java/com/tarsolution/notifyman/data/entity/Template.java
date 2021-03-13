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
package com.tarsolution.notifyman.data.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.tarsolution.notifyman.common.share.IHasPrimaryKey;

/**
 * 
 * @author FMARSLAN
 *
 */
@Entity
@Table(name = "tbl_template")
public class Template implements Serializable, IHasPrimaryKey<Integer> {

  private static final long serialVersionUID = 1580395353893956438L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", unique = true, nullable = false)
  private Integer id;

  @Column(name = "code", unique = true, nullable = false, length = 16)
  private String code;
  
  @Column(name = "template", nullable = false, columnDefinition="TEXT")
  private String template;


  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public String getTemplate() {
    return template;
  }
  
  public void setTemplate(String template) {
    this.template = template;
  }
  
  public String getCode() {
    return code;
  }
  
  public void setCode(String code) {
    this.code = code;
  }

}
