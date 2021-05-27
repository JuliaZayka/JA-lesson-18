package ua.lviv.dao;

import java.util.ArrayList; 
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import ua.lviv.domain.Level;
import ua.lviv.domain.Participant;



@Repository
public class ParticapantRepo {

	private List<Participant> part = new ArrayList<>();

	@PostConstruct
	public void init() {
		Participant part1 = new Participant();
		part1.setId(1);
		part1.setName("Name1");
		part1.setEmail("email-1");
		part1.setLevel(Level.L1);
		part1.setPrimarySkill("PrimarySkill1");
		
		Participant part2 = new Participant();
		part2.setId(2);
		part2.setName("Name2");
		part2.setEmail("email-2");
		part2.setLevel(Level.L2);
		part2.setPrimarySkill("PrimarySkill2");

		Participant part3 = new Participant();
		part3.setId(3);
		part3.setName("Name3");
		part3.setEmail("email-3");
		part3.setLevel(Level.L3);
		part3.setPrimarySkill("PrimarySkill3");
		
		Participant part4 = new Participant();
		part4.setId(4);
		part4.setName("Name4");
		part4.setEmail("email-4");
		part4.setLevel(Level.L4);
		part4.setPrimarySkill("PrimarySkill4");
		
		Participant part5 = new Participant();
		part5.setId(5);
		part5.setName("Name5");
		part5.setEmail("email-5");
		part5.setLevel(Level.L5);
		part5.setPrimarySkill("PrimarySkill5");
		
		part.add(part1);
		part.add(part2);
		part.add(part3);
		part.add(part4);
		part.add(part5);
		
	}

	public List<Participant> findAllBooks() {
		return part;
	}

	public Participant findOne(int id) {
		return part.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
	}

	public void save(Participant participant) {
		Participant partToUpdate = null;

		if (participant.getId() != null) {
			partToUpdate = findOne(participant.getId());
			int partIndex = part.indexOf(partToUpdate);
			partToUpdate.setName(participant.getName());
			partToUpdate.setEmail(participant.getEmail());
			part.set(partIndex, partToUpdate);
		} else {
			// save
			participant.setId(part.size()+1);
			part.add(participant);
		}
	}

	public void delete(int id) {
		Iterator<Participant> iter = part.iterator();
		while (iter.hasNext()) {
			if (iter.next().getId() == id) {
				iter.remove();
			}
		}
	}

}