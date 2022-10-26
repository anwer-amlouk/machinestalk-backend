package tn.spring.dao.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class MachinesTalkUser implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String email;

	@Enumerated(EnumType.STRING)
	Gender gender;

	@Enumerated(EnumType.STRING)
	Status status;

}
