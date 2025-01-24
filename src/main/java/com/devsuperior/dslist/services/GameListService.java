package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dtos.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repsitories.GameListRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;

	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> gameLists = gameListRepository.findAll();
		return gameLists.stream().map(x -> new GameListDTO(x)).toList();
	}

}
