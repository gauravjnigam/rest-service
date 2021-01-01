package com.gn.restsvc.GnRestSvc.user.model;

import java.time.LocalDate;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("User details")
public class User {
	
	private Integer id;
	@Size(min = 2, message = "name should at least have 2 character!!!")
	@ApiModelProperty("name should at least have 2 character!!!")
	private String name;
	
	@Past(message = "birth date should be in past!!")
	@ApiModelProperty("birth date should be in past!!")
	private LocalDate dob;

}
