package com.bundesliga.players.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    //Beispiel URL: /player?club=Bayern&position=Goalkeeper
    @GetMapping
    public List<Player> getPlayers(
            //@RequestParam(required = false) => Parameter optional. Methode kann aufgerufen werden ohne das Parameter in URL angegeben werden muss.
            @RequestParam(required = false) String club,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String nationality,
            @RequestParam(required = false) String agent,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String outfitter) {
        if (club != null && position != null) {
            return playerService.getPlayersByClubAndPosition(club, position);
        }

        else if (outfitter != null) {
            return playerService.getPlayerByOutfitter(outfitter);
        }

        else if (nationality != null && position != null) {
            return playerService.getPlayerByNationalityAndPosition(nationality, position);
        }

        else if (agent != null) {
            return playerService.getPlayersByAgent(agent);
        }

        else if (club != null) {
            return playerService.getPlayersByClub(club);
        }

        else if (name != null) {
            return playerService.getPlayersByName(name);
        }

        else if (position != null) {
            return playerService.getPlayersByPosition(position);
        }

        else if (nationality != null) {
            return playerService.getPlayersByNationality(nationality);
        }

        else if (age != null) {
            return playerService.getPlayersByAge(age);
        }

        else {
            return playerService.getAllPlayers();
        }
    }

    @GetMapping(path = "/price")
    public List<Player> getMaxPrice() {
        return playerService.getPlayerByPrice();
    }

    @GetMapping(path = "/height")
    public List<Player> getPlayerHeight() {
        return playerService.OrderPlayerHeight();
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player createdPlayer = playerService.addPlayer(player);
        //HTTP-Antwortstatus(201 CREATED), zusammen mit neu erstellten Spielerobjekt als JSON im Body der Antwort zu senden
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        Player updatedPlayer = playerService.updatePlayer(player);

        if (updatedPlayer != null) {
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        }

        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName) {
        playerService.deletePlayer(playerName);
        return new ResponseEntity<>("Player deleted Successfully", HttpStatus.OK);
    }
}
