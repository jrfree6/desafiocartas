package br.com.desafiocartas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiocartas.model.Player;
import br.com.desafiocartas.service.CartasService;

@RestController
@RequestMapping("/api/cartas")
public class CartasController {
	
	@Autowired
	private CartasService cartasService;
	
	@RequestMapping(value = "/deal", method = RequestMethod.GET)
	public ResponseEntity<List<Player>> dealHands(){
		List<Player> players = cartasService.dealHands();
		List<Player> winners = cartasService.determineWinner(players);
		return ResponseEntity.ok(winners);
	}
	

}
