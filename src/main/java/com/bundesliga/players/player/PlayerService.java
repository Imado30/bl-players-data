package com.bundesliga.players.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class PlayerService {
    private static final Logger logger = LoggerFactory.getLogger(PlayerService.class);
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        logger.info("Fetching all players");
        return playerRepository.findAll();
    }

    public List<Player> getPlayersByClub(String clubName) {
        return playerRepository.findAll().stream()
                .filter(player -> clubName.equals(player.getClub()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByName(String name) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayerByOutfitter(String outfitter) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getOutfitter().toLowerCase().contains(outfitter.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByAge(Integer age) {
        return playerRepository.findAll().stream()
                .filter(player -> age.equals(player.getAge()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByPosition(String position) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getPosition().toLowerCase().contains(position.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByNationality(String nationality) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getNationality().toLowerCase().contains(nationality.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByClubAndPosition(String club, String position) {
        return playerRepository.findAll().stream()
                .filter(player -> club.equals(player.getClub()) && position.equals(player.getPosition()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayerByNationalityAndPosition(String nationality, String position) {
        return playerRepository.findAll().stream()
                .filter(player -> nationality.equals(player.getNationality()) && position.equals(player.getPosition()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayerByPrice() {
        return playerRepository.findAll(Sort.by(Sort.Order.desc("price").nullsLast()));
    }


    public Player addPlayer(Player player) {
        playerRepository.save(player);
        return player;
    }

    public Player updatePlayer(Player player) {
        Optional<Player> existingPlayer = playerRepository.findByName(player.getName());

        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(player.getName());
            playerToUpdate.setClub(player.getClub());
            playerToUpdate.setPosition(player.getPosition());
            playerToUpdate.setNationality(player.getNationality());
            playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;                //When player doesn't exist
    }

    @Transactional
    public void deletePlayer(String playerName) {
        playerRepository.deleteByName(playerName);
    }
}
