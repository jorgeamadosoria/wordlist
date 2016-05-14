package org.jasr.dashard.dao;

import java.util.List;

import org.jasr.dashard.domain.Word;

public interface WordDAO {

    public List<Word> list(String letters);

}
