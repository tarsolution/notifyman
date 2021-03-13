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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.tarsolution.notifyman.common.share.IHasPrimaryKey;
import com.tarsolution.notifyman.data.entity.enums.NotificationStatusEnum;

/**
 * 
 * @author FMARSLAN
 *
 */
@Entity
@Table(name = "tbl_notification")
public class Notification implements Serializable, IHasPrimaryKey<Integer> {

  private static final long serialVersionUID = 1259269295498572342L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", unique = true, nullable = false)
  private Integer id;

  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @JoinColumn(name = "notification_type_id", nullable = false)
  private NotificationType notificationType;

  @Basic
  @Temporal(TemporalType.DATE)
  @Column(name = "create_time", nullable = false)
  private Date createTime;

  @Basic
  @Temporal(TemporalType.DATE)
  @Column(name = "sent_time", nullable = true)
  private Date sentTime;

  @Basic
  @Temporal(TemporalType.DATE)
  @Column(name = "read_time", nullable = true)
  private Date readTime;


  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false,
      columnDefinition = "enum('PENDING','SENDING','SENT','READ')")
  private NotificationStatusEnum status;

  @Column(name = "description", nullable = true, columnDefinition = "TEXT")
  private String description;

  @Column(name = "content", nullable = true, columnDefinition = "TEXT")
  private String content;

  @Column(name = "subject", nullable = true, length = 1024)
  private String subject;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public NotificationType getNotificationType() {
    return notificationType;
  }

  public void setNotificationType(NotificationType notificationType) {
    this.notificationType = notificationType;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getSentTime() {
    return sentTime;
  }

  public void setSentTime(Date sentTime) {
    this.sentTime = sentTime;
  }

  public Date getReadTime() {
    return readTime;
  }

  public void setReadTime(Date readTime) {
    this.readTime = readTime;
  }

  public NotificationStatusEnum getStatus() {
    return status;
  }

  public void setStatus(NotificationStatusEnum status) {
    this.status = status;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }
  
}
