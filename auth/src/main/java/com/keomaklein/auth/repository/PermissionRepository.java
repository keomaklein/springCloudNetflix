package com.keomaklein.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.keomaklein.auth.entity.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

	@Query("select p from Permission p where p.description =: description")
	Permission findByPermission(@Param("description") String description);
}
