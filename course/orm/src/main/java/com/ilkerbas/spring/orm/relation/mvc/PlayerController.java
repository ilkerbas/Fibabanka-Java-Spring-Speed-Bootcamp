package com.ilkerbas.spring.orm.relation.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ilkerbas.spring.orm.data.entity.Product;
import com.ilkerbas.spring.orm.relation.entity.Player;
import com.ilkerbas.spring.orm.relation.repository.PlayerRepository;

@Controller
public class PlayerController {

	@Autowired
	private PlayerRepository playerRepository;
	
	@GetMapping("/players/byteam")
	@ResponseBody
	public String getPlayersByTeam() {

		long teamId= 1;
		List<Player> players = playerRepository.findAllByTeamId(teamId);
		
		double totalScore = 0;
		for(Player player: players) {
			System.out.println(player.getPlayerId() + " "
					+ player.getAverageScore());
			totalScore += player.getAverageScore();
		}
		double averageScore = 0;
		if(players.size() >0)
			averageScore = totalScore/players.size();
		return "Ortalama Çentik " + averageScore;
	}
}
