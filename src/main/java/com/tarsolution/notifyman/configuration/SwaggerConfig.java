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
package com.tarsolution.notifyman.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

/**
 * 
 * @author FMARSLAN
 *
 */
@Configuration
public class SwaggerConfig {

  public static String HEADER_TOKEN_NAME="notifyman_token";
  
  @Value("${app.swagger.title}")
  private String title;

  @Value("${app.swagger.description}")
  private String description;

  @Value("${app.swagger.version}")
  private String version;
  
  @Value("${app.swagger.token_description}")
  private String token_description;
  
  @Value("${app.swagger.contact.name}")
  private String contactName;
  
  @Value("${app.swagger.contact.email}")
  private String contactEmail;
  
  @Value("${app.swagger.contact.url}")
  private String contactURL;

  @Value("${app.token.prefix}")
  private String tokenPrefix;

  @Value("${app.token.headerName}")
  private String headerName;
  
  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .components(new Components()
            .addSecuritySchemes("Token", new SecurityScheme()
                .type(SecurityScheme.Type.HTTP).scheme(tokenPrefix)
                .bearerFormat("JWT")
                .description(token_description)))
        .info(new Info()
            .version(version)
            .contact(new Contact()
                .email(contactEmail)
                .name(contactName))
            .description(description)
            .title(title));


  }

}
