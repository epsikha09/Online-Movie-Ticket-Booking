package com.mts.service;

import java.util.List;

import com.mts.exception.ScreenNotFoundException;
import com.mts.model.Screen;
import com.mts.model.Theatre;


public interface ScreenService {
	public Screen addScreen(Screen screen, Integer theatreId) throws ScreenNotFoundException;
	public List<Screen> viewScreenList() throws ScreenNotFoundException;
	public Screen updateScreen(Screen s, Integer theatreId);
	public Screen viewScreen(int screenId) throws ScreenNotFoundException;
	public Theatre getTheatre(int screenId) throws ScreenNotFoundException;
}
