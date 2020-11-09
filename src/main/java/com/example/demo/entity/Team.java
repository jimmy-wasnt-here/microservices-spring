package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Team {
	@Id
	@GeneratedValue
	Long id;
	String name, location, mascot;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "teamId")
	List<Player> players;

	public Team() {
	}

	public Team(String name, String location, String mascot, List<Player> players) {
		super();
		this.name = name;
		this.location = location;
		this.mascot = mascot;
		this.players = players;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMascot() {
		return mascot;
	}

	public void setMascot(String mascot) {
		this.mascot = mascot;
	}

	public List<Player> getPlayers() {
		if (players == null) this.players = new ArrayList<>();
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

}
