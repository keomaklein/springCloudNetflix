package com.keomaklein.auth.data.vo;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.keomaklein.auth.entity.User;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonPropertyOrder({"id","description"})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserVO extends RepresentationModel<UserVO> implements Serializable {
	
	private static final long serialVersionUID = -9024780791330935634L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("username")
	private String username;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("accountNonExpired")
	private Boolean accountNonExpired;

	@JsonProperty("accountNonLocked")
	private Boolean accountNonLocked;

	@JsonProperty("credentialsNonExpired")
	private Boolean credentialsNonExpired;

	@JsonProperty("eneable")
	private Boolean eneable;
	
	public static UserVO create(User user) {
		return new ModelMapper().map(user, UserVO.class);
	}
}
