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
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import com.tarsolution.notifyman.common.share.IHasPrimaryKey;

/**
 * 
 * @author FMARSLAN
 *
 */
@Entity
@Table(name = "tbl_user_attribute_value")
public class UserAttributesValue implements Serializable, IHasPrimaryKey<Integer> {

  private static final long serialVersionUID = 1492833846384356461L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", unique = true, nullable = false)
  private Integer id;

  @JoinColumn(name = "attribute_id", nullable =false)
  private UserAttribute attribute;
  
  @JoinColumn(name = "user_id", nullable =false)
  private User user;
  
  @Column(name = "attr_value", nullable = true, columnDefinition="TEXT")
  private String value;

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public UserAttribute getAttribute() {
    return attribute;
  }

  public void setAttribute(UserAttribute attribute) {
    this.attribute = attribute;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
 
}
