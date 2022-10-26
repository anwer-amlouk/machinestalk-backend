package tn.spring.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import tn.spring.dao.entities.GoRestResponse;
import tn.spring.dao.entities.MachinesTalkUser;
import tn.spring.services.IMachinestalkUserService;

@RestController
@RequestMapping("/api/machinestalk")
@CrossOrigin
public class MachinesTalkUserController {

	@Autowired
	IMachinestalkUserService iMachinestalkUserService;

	@PostMapping("addUsers")
	public ResponseEntity addUsers() {
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		String usersResourceUrl = "https://gorest.co.in/public-api/users";
		Object response = restTemplate.getForEntity(usersResourceUrl, Object.class).getBody();
		GoRestResponse usersList = mapper.convertValue(response, GoRestResponse.class);
		List<MachinesTalkUser> users = Arrays.stream(usersList.data)
				.map(object -> mapper.convertValue(object, MachinesTalkUser.class)).collect(Collectors.toList());

		iMachinestalkUserService.addUsers(users);
		return ResponseEntity.status(HttpStatus.OK).body("Users created");
	}

	@GetMapping("users")
	public ResponseEntity<List<MachinesTalkUser>> getAllUsers() {
		return ResponseEntity.status(HttpStatus.OK).body(iMachinestalkUserService.getAllUsers());
	}
}
