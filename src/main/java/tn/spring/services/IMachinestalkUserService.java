package tn.spring.services;

import java.util.List;


import tn.spring.dao.entities.MachinesTalkUser;

public interface IMachinestalkUserService {
	
	public void addUsers(List<MachinesTalkUser> machinestalkUsers);
	public List<MachinesTalkUser> getAllUsers();

}
