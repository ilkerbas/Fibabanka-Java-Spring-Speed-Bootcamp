package com.ilkerbas.spring.orm.relation.mvc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ilkerbas.spring.orm.relation.entity.Player;
import com.ilkerbas.spring.orm.relation.entity.Team;
import com.ilkerbas.spring.orm.relation.repository.TeamRepository;

@Controller
@RequestMapping("/sports")
public class TeamController {

	@Autowired
	private TeamRepository teamRepository;
	
	@GetMapping("/team/insert")
	@ResponseBody
	public String insertTeam() {
		Team teamA = new Team(0, "ilker team");
		teamA.setPlayerList(new ArrayList<>());
		
		Player player1 = new Player(0, "Cem Karaca", 54.21);
		player1.setTeam(teamA);
		teamA.getPlayerList().add(player1);
		
		Player player2 = new Player(0, "Barış Manço", 76.12);
		player2.setTeam(teamA);
		teamA.getPlayerList().add(player2);
		
		Player player3 = new Player(0, "Fikret Kızılok", 34.55);
		player3.setTeam(teamA);
		teamA.getPlayerList().add(player3);
		
		teamRepository.save(teamA);
		
		return "Sokuldu : " + teamA.getTeamId();
	}
}
