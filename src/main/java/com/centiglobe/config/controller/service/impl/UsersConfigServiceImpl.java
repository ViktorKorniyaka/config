package com.centiglobe.config.controller.service.impl;

import com.centiglobe.config.controller.dto.UserConfigDto;
import com.centiglobe.config.controller.dto.UserConfigResponceDto;
import com.centiglobe.config.controller.service.UsersConfigService;
import com.centiglobe.config.entity.Status;
import com.centiglobe.config.entity.UsersConfig;
import com.centiglobe.config.repository.UsersConfigRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersConfigServiceImpl implements UsersConfigService {

  private final UsersConfigRepository usersConfigRepository;
  private final ModelMapper modelMapper;

  public UsersConfigServiceImpl(UsersConfigRepository usersConfigRepository, ModelMapper modelMapper) {
    this.usersConfigRepository = usersConfigRepository;
    this.modelMapper = modelMapper;
  }

  @Transactional
  public UserConfigResponceDto createUsersConfig(UserConfigDto userConfigDto){
    UsersConfig usersConfig = modelMapper.map(userConfigDto, UsersConfig.class);
    UsersConfig createdUsersConfig = usersConfigRepository.save(usersConfig);
    return modelMapper.map(createdUsersConfig, UserConfigResponceDto.class);
  }

  @Transactional
  public UserConfigResponceDto updateUsersConfig(Long id, UserConfigDto userConfigDto){
    Optional<UsersConfig> usersConfigOptional = usersConfigRepository.findById(id);
    if(usersConfigOptional.isEmpty()){
      throw new IllegalArgumentException(String.format("Can not found user config with id = %d ", id));
    }
    UsersConfig usersConfig = usersConfigOptional.get();
    putValuesToUsersConfig(usersConfig, userConfigDto);
    usersConfigRepository.save(usersConfig);
    return modelMapper.map(usersConfig, UserConfigResponceDto.class);
  }

  public List<UserConfigResponceDto> getListConfig(){
    List<UsersConfig> usersConfigs = usersConfigRepository.findAll();
    List<UserConfigResponceDto> userConfigResponceDtos = usersConfigs.stream()
        .map(config -> modelMapper.map(config, UserConfigResponceDto.class)).collect(Collectors.toList());
  return userConfigResponceDtos;
  }

  private void putValuesToUsersConfig(UsersConfig usersConfig, UserConfigDto userConfigDto){
    usersConfig.setMaxConnections(userConfigDto.getMaxConnections() != null ? userConfigDto.getMaxConnections() : usersConfig.getMaxConnections());
    usersConfig.setMemberName(userConfigDto.getMemberName() != null ? userConfigDto.getMemberName() : usersConfig.getMemberName());
    usersConfig.setStatus(userConfigDto.getStatus() != null ? Status.forValue(userConfigDto.getStatus()) : usersConfig.getStatus());
  }
}
