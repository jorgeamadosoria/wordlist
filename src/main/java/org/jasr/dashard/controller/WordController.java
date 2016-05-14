package org.jasr.dashard.controller;

import java.util.HashSet;
import java.util.List;

import org.jasr.dashard.dao.WordDAO;
import org.jasr.dashard.domain.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {

	@Autowired
	private WordDAO wordDAO;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Word> list(Integer length,String letters) {
		// TODO Auto-generated method stub
		return null;
	}

}
