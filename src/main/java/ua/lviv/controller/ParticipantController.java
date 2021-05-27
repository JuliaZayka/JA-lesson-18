package ua.lviv.controller;

import javax.servlet.http.HttpServletRequest; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.domain.Participant;
import ua.lviv.service.ParticipantService;

@Controller
public class ParticipantController {

	@Autowired
	private ParticipantService patricipantService;

	@GetMapping("/")
	public String init(HttpServletRequest req) {
		req.setAttribute("part", patricipantService.findAllBooks());
		req.setAttribute("mode", "PART_VIEW");
		return "index";
	}

	@GetMapping("/new")
	public String newParticipant(HttpServletRequest req) {
		req.setAttribute("mode", "PART_CREATE");
		return "index";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Participant participant, HttpServletRequest req) {
		patricipantService.save(participant);
		req.setAttribute("part", patricipantService.findAllBooks());
		req.setAttribute("mode", "PART_VIEW");
		return "index";
	}

	@GetMapping("/update")
	public String update(@RequestParam int id, HttpServletRequest req) {
		req.setAttribute("part", patricipantService.findOne(id));
		req.setAttribute("mode", "PART_EDIT");
		return "index";
	}

	@GetMapping("/delete")
	public String deleteParticipant(@RequestParam int id, HttpServletRequest req) {
		patricipantService.delete(id);
		req.setAttribute("part", patricipantService.findAllBooks());
		req.setAttribute("mode", "PART_VIEW");
		return "index";
	}
}