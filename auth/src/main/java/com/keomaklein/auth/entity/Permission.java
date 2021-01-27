package com.keomaklein.auth.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;

import com.keomaklein.auth.data.vo.PermissionVO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="permission")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Permission implements GrantedAuthority, Serializable {
	
	private static final long serialVersionUID = -2257050485373100342L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="description", nullable = false, length = 255)
	private String description;
	
	@Override
	public String getAuthority() {
		return this.description;
	}

	public static Permission create(PermissionVO permissionVO) {
		return new ModelMapper().map(permissionVO, Permission.class);
	}
}
