package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Player;
import com.example.demo.entity.Team;
import com.example.demo.repository.TeamRepository;

@SpringBootApplication
public class MicroservicesApplication {

	@Autowired TeamRepository teamRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MicroservicesApplication.class, args);
		
	}
	
	@PostConstruct
	private void init() {
		List<Team> teams = new ArrayList<>();
		
		Team team1 = new Team ("Equipo del bien", "Barcelona", "Puchdemont", null);
		Team team2 = new Team("Equipo del mal", "Madrid", "Mariano", null);
		
		//System.out.print("Team 2 id: " + team2.getId().toString());
		List<Player> teamPlayers1 = new ArrayList<>();
		teamPlayers1.add(new Player("Junqueras, Oriol", "Vice"));
		teamPlayers1.add(new Player("Rufián, Gabriel", "Postu"));
		
		team1.setPlayers(teamPlayers1);
		
		List<Player> teamPlayers2 = new ArrayList<>();
		teamPlayers2.add(new Player("Rato, Rodrigo", "Tesorero"));
		teamPlayers2.add(new Player("Terstsh, Herman", "Periodista"));
		
		team2.setPlayers(teamPlayers2);
		
		teams.add(team1);
		teams.add(team2);
		
		teamRepository.saveAll(teams);
	}

}
