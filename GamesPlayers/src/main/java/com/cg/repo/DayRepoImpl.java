package com.cg.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cg.beans.Day;
import com.cg.beans.Game;

import com.cg.exception.DuplicateObjectException;

public class DayRepoImpl implements DayRepo{

	List<Day> days ;
	
	
	
	public DayRepoImpl(List<Day> days) {
		super();
		this.days = days;
	}


	public Day save(Day day) throws DuplicateObjectException {
		if(day == null)
			throw new NullPointerException();
		if(day.getName()==null)
			throw new NullPointerException();
		
		if(days.contains(day))
			throw new DuplicateObjectException("day present");
		
		days.add(day);
		
		return day;
	}

	
	/*public Day findByPlayerName(String playerName) {
		// TODO Auto-generated method stub
		return null;
	}*/

	
	public List<Day> findByGamesName(String gameName) {
		if(gameName == null)
			throw new NullPointerException();
		List<Day> d1 = new ArrayList<Day>();
		
		for(Day d:days) {
			
			Set<Game> games=d.getGames();
			
			for(Game g:games) {
				
				String sname=g.getName();						
				
				if(sname==gameName)
				{
					
					d1.add(d);
				}
			}
		}
		
		return d1;
	}


	public Day findByName(String name) {
		if(name == null)
			throw new NullPointerException();
				
		for(Day g:days) {
				
				if(g.getName()==name)
				return g;
		}
		
		
		return null;
	}
	
	

}
