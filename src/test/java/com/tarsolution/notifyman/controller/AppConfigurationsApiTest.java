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
package com.tarsolution.notifyman.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.tarsolution.notifyman.api.AppConfigurationsApi;
import com.tarsolution.notifyman.common.dto.AppAttributesDTO;
import com.tarsolution.notifyman.common.response.ResponseDataList;
import com.tarsolution.notifyman.service.endpoints.AppAttributesService;

/**
 * 
 * @author FMARSLAN
 *
 */
@ExtendWith(MockitoExtension.class)
class AppAttributesControllerTest {
  
  @InjectMocks
  AppConfigurationsApi appConfigurationsApi;

  @Mock
  AppAttributesService AppAttributesService;

  @Test
  public void getProductsList() throws Throwable {
    MockHttpServletRequest request = new MockHttpServletRequest();
    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    ResponseDataList<AppAttributesDTO> responseEntity = appConfigurationsApi.getAttributes();
    assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
  }
}
