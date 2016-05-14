package org.jasr.dashard.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.jasr.dashard.dao.WordDAO;
import org.jasr.dashard.domain.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class WordDAOImpl implements WordDAO {

	public int[] arr = new int[26]; 
	
	
    @Autowired
    private Environment  env;
    @Resource
    private JdbcTemplate template;

	@Override
	public List<Word> list(String letters) {
		// TODO Auto-generated method stub
		return null;
	}

}
