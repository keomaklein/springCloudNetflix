package com.keomaklein.auth.data.vo;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.keomaklein.auth.entity.Permission;

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
public class PermissionVO extends RepresentationModel<PermissionVO> implements Serializable {
	
	private static final long serialVersionUID = -9024780791330935634L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("description")
	private String description;
	
	public static PermissionVO create(Permission permission) {
		return new ModelMapper().map(permission, PermissionVO.class);
	}
}
