package com.centiglobe.config.controller.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.centiglobe.config.controller.dto.UserConfigDto;
import com.centiglobe.config.controller.dto.UserConfigResponceDto;
import com.centiglobe.config.controller.service.impl.UsersConfigServiceImpl;
import com.centiglobe.config.entity.Status;
import com.centiglobe.config.entity.UsersConfig;
import com.centiglobe.config.repository.UsersConfigRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
class UsersConfigServiceTest {

  public static final String MEMBER_NAME = "name";
  public static final int MAX_CONNECTIONS = 32;
  public static final long ID = 1L;
  public static final Status STATUS = Status.ACTIVE;

  @Mock
  private UsersConfigRepository usersConfigRepository;

  private UsersConfigServiceImpl usersConfigService;

  @BeforeEach
  public void init() {
    MockitoAnnotations.openMocks(this);
    usersConfigService = new UsersConfigServiceImpl(usersConfigRepository, new ModelMapper());
  }

  /**
   * Simple test for create user config
   */
  @Test
  public void createUserConfig() {
    UserConfigDto userConfigDto = UserConfigDto.builder().memberName(MEMBER_NAME).maxConnections(MAX_CONNECTIONS).status(STATUS.getValue()).build();
    UsersConfig usersConfig = UsersConfig.builder().id(ID).memberName(MEMBER_NAME).status(STATUS).maxConnections(MAX_CONNECTIONS).build();
    when(usersConfigRepository.save(any(UsersConfig.class))).thenReturn(usersConfig);

    UserConfigResponceDto created = usersConfigService.createUsersConfig(userConfigDto);

    Assertions.assertEquals(ID, created.getId());
    Assertions.assertEquals(MEMBER_NAME, created.getMemberName());
    Assertions.assertEquals(MAX_CONNECTIONS, created.getMaxConnections());
    Assertions.assertEquals(Status.ACTIVE, created.getStatus());
  }

}