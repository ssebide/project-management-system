package com.ssebide.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ssebide.modal.Project;
import com.ssebide.modal.User;

public class ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByOwner(User user);

    List<Project> findByNameContainingAndTeamContaining(String partialName, User user);

    @Query("SELECT P From Project p join p.team t where t = :user")
    List<Project> findProjectByTeam(@Param("user") User user);

    List<Project> findByTeamContainingOrOwner(User user, User owner);

}
