package tn.spring.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.spring.dao.entities.MachinesTalkUser;

@Repository
public interface IMachinesTalkUserRepository extends JpaRepository<MachinesTalkUser, Integer> {

}
