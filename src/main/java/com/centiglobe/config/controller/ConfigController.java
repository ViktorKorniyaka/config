package com.centiglobe.config.controller;

import com.centiglobe.config.controller.dto.UserConfigDto;
import com.centiglobe.config.controller.dto.UserConfigResponceDto;
import com.centiglobe.config.controller.service.UsersConfigService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/configs")
public class ConfigController {

  private final UsersConfigService usersConfigService;

  public ConfigController(UsersConfigService usersConfigService) {
    this.usersConfigService = usersConfigService;
  }

  @Operation(summary = "Create user config", description = "Returns a user config object with id")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
      @ApiResponse(responseCode = "404", description = "Not found - The product was not found")
  })
  @PostMapping()
  public ResponseEntity<UserConfigResponceDto> createUserConfig(@Valid @RequestBody UserConfigDto userConfigDto) {
    UserConfigResponceDto response = usersConfigService.createUsersConfig(userConfigDto);

    return ResponseEntity.ok(response);
  }

  @Operation(summary = "Update user config", description = "Returns a updated user config object")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
      @ApiResponse(responseCode = "400", description = "Validation error"),
      @ApiResponse(responseCode = "404", description = "Not found - The user config was not found"),
      @ApiResponse(responseCode = "500", description = "Server error")
  })
  @PutMapping("/{id}")
  public ResponseEntity<UserConfigResponceDto> updateUserConfig(@PathVariable Long id, @Valid @RequestBody UserConfigDto userConfigDto/*, Errors errors*/) {
    UserConfigResponceDto response = usersConfigService.updateUsersConfig(id, userConfigDto);


    return ResponseEntity.ok(response);
  }

  @Operation(summary = "Retrieve list of user config", description = "Returns a list of user config objects")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
      @ApiResponse(responseCode = "500", description = "Server error")
  })
  @GetMapping()
  public ResponseEntity<List<UserConfigResponceDto>> getListConfig() {
    List<UserConfigResponceDto> response = usersConfigService.getListConfig();
    return ResponseEntity.ok(response);
  }
}
