package com.centiglobe.config.controller.service;

import com.centiglobe.config.controller.dto.UserConfigDto;
import com.centiglobe.config.controller.dto.UserConfigResponceDto;
import com.centiglobe.config.entity.Status;
import com.centiglobe.config.entity.UsersConfig;
import com.centiglobe.config.repository.UsersConfigRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface UsersConfigService {


  UserConfigResponceDto createUsersConfig(UserConfigDto userConfigDto);

  UserConfigResponceDto updateUsersConfig(Long id, UserConfigDto userConfigDto);

  List<UserConfigResponceDto> getListConfig();

}
