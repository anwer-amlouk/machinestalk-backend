package tn.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.dao.entities.MachinesTalkUser;
import tn.spring.dao.repositories.IMachinesTalkUserRepository;

@Service
public class MachinestalkUserService implements IMachinestalkUserService {

	@Autowired
	IMachinesTalkUserRepository iMachinesTalkUserRepository;

	public void addUsers(List<MachinesTalkUser> machinestalkUsers) {
		machinestalkUsers.forEach(user -> iMachinesTalkUserRepository.save(user));
	}

	public List<MachinesTalkUser> getAllUsers() {
		return iMachinesTalkUserRepository.findAll();
	}

}
