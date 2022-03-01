package com.mts.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mts.exception.ScreenNotFoundException;
import com.mts.model.Screen;
import com.mts.model.Theatre;
import com.mts.repository.ScreenRepository;
import com.mts.repository.TheatreRepository;


@Service
public class ScreenServiceImpl implements ScreenService {

	@Autowired
	private ScreenRepository screenRepository;
	@Autowired
	private TheatreRepository theatreRepository;

	
	@Override
	public List<Screen> viewScreenList() throws ScreenNotFoundException {
		List<Screen> screen = screenRepository.findAll();
		if (screen.size() == 0)
			throw new ScreenNotFoundException("No screens found");
		return screen;
	}

	
	@Override
	public Screen addScreen(Screen screen, Integer theatreId) throws ScreenNotFoundException {
		Theatre theatre = new Theatre();
		if (theatreId != null) {
			if (screenRepository.existsById(screen.getScreenId())) {
				throw new ScreenNotFoundException("Screen already exists");
			} else {
				theatre = theatreRepository.getOne(theatreId);
				screen.setTheatre(theatre);
			}
			screenRepository.saveAndFlush(screen);
		}
		return screen;
	}
	@Override
	public Screen viewScreen(int screenId) throws ScreenNotFoundException {
		return screenRepository.findById(screenId).get();
		}
	/**
	 * @return updatedScreen
	 */
	@Override
	public Screen updateScreen(Screen screen, Integer theatreId) {
		Theatre theatre = new Theatre();
		if (theatreId != null) {
			theatre = theatreRepository.getOne(theatreId);
			screen.setTheatre(theatre);
		}
		screenRepository.saveAndFlush(screen);
		return screen;
	}

	@Override
	public Theatre getTheatre(int screenId) throws ScreenNotFoundException {
		Screen screen =screenRepository.findById(screenId).get();
		Theatre theatre=screen.getTheatre();
		return theatre;
	}

}
