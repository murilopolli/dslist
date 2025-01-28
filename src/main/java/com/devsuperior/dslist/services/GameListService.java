package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dtos.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repsitories.GameListRepository;
import com.devsuperior.dslist.repsitories.GameRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;

	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> gameLists = gameListRepository.findAll();
		return gameLists.stream().map(x -> new GameListDTO(x)).toList();
	}

	@Transactional
	public void move(Long listId, int sourceIndex, int targetIndex) {
		List<GameMinProjection> games = gameRepository.searchByList(listId);

		GameMinProjection game = games.remove(sourceIndex);
		games.add(targetIndex, game);

		int min = sourceIndex < targetIndex ? sourceIndex : targetIndex;
		int max = sourceIndex > targetIndex ? sourceIndex : targetIndex;

		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, games.get(i).getId(), i);
		}

	}
}
