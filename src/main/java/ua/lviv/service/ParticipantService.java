package ua.lviv.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.dao.ParticapantRepo;
import ua.lviv.domain.Participant;


@Service
public class ParticipantService {
	
	@Autowired
	private ParticapantRepo participantRepo;
	
	public List<Participant> findAllBooks() {
		return participantRepo.findAllBooks();
	}

	public Participant findOne(int id) {
		return participantRepo.findOne(id);
	}

	public void save(Participant participant) {
		participantRepo.save(participant);
	}

	public void delete(int id) {
		participantRepo.delete(id);
	}
}
