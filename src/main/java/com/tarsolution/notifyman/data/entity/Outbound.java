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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import com.tarsolution.notifyman.common.share.IHasPrimaryKey;
import com.tarsolution.notifyman.data.entity.enums.OutboundStatusEnum;

/**
 * 
 * @author FMARSLAN
 *
 */
@Entity
@Table(name = "tbl_outbound")
public class Outbound implements Serializable, IHasPrimaryKey<Integer> {

  private static final long serialVersionUID = 2843787403460771009L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", unique = true, nullable = false)
  private Integer id;

  @Column(name = "settings", nullable = true)
  private String settings;
  
  @JoinColumn(name = "user_id", nullable =false)
  private User user;
  
  @Column(name = "code", unique = true, nullable = false, length = 128)
  private String code;
  
  @Column(name = "is_active", nullable = false)
  private boolean active;
  
  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false, columnDefinition = "enum('ACTIVE','PASSIVE','ERROR')")
  private OutboundStatusEnum status;

  @JoinColumn(name = "template_id", nullable =false)
  private Template template;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSettings() {
    return settings;
  }

  public void setSettings(String settings) {
    this.settings = settings;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public OutboundStatusEnum getStatus() {
    return status;
  }

  public void setStatus(OutboundStatusEnum status) {
    this.status = status;
  }

  public Template getTemplate() {
    return template;
  }

  public void setTemplate(Template template) {
    this.template = template;
  }
  
  
}
