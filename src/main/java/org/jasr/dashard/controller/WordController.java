package org.jasr.dashard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jasr.dashard.dao.WordDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {

	@Autowired
	private WordDAO wordDAO;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<String> list(Integer length, String[] letters) {

		Map<Character, Integer> map = new HashMap<>();
		for (String s : letters) {
		    Character c = s.toLowerCase().charAt(0);
			map.merge(c,1, (k, v) -> v + 1);
		}

		return wordDAO.list(length, map.getOrDefault('a',0), map.getOrDefault('b',0), map.getOrDefault('c',0), map.getOrDefault('d',0), map.getOrDefault('e',0), map.getOrDefault('f',0),
				map.getOrDefault('g',0), map.getOrDefault('h',0), map.getOrDefault('i',0), map.getOrDefault('j',0), map.getOrDefault('k',0), map.getOrDefault('l',0), map.getOrDefault('m',0),
				map.getOrDefault('n',0), map.getOrDefault('o',0), map.getOrDefault('p',0), map.getOrDefault('q',0), map.getOrDefault('r',0), map.getOrDefault('s',0), map.getOrDefault('t',0),
				map.getOrDefault('u',0), map.getOrDefault('v',0), map.getOrDefault('w',0), map.getOrDefault('x',0), map.getOrDefault('y',0), map.getOrDefault('z',0));
	}

}
