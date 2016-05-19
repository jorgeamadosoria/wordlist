package org.jasr.dashard.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jasr.dashard.dao.WordDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.client.util.Strings;

@RestController
public class WordController {

    @Autowired
    private WordDAO wordDAO;

    int get(Character c, Map<Character, Integer> map) {
        if (map.containsKey(c))
            return map.get(c);
        return 0;
    }

    private boolean val(String letter) {
        return (!Strings.isNullOrEmpty(letter) && letter.length() == 1 && !Character.isLetter(letter.charAt(0)));
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public List<String> list(Integer length, String letters0, String letters1, String letters2, String letters3, String letters4,
            String letters5, String letters6, String letters7, String letters8, String letters9, String letters10,
            String letters11) {

        if (!val(letters1) || !val(letters2) || !val(letters3) || !val(letters4) || !val(letters5) || !val(letters6) || !val(letters7)
                || !val(letters8) || !val(letters9) || !val(letters10) || !val(letters11))
            return Collections.emptyList();

        String[] letters = { letters0, letters1, letters2, letters3, letters4, letters5, letters6, letters7, letters8, letters9,
                letters10, letters11 };
        Map<Character, Integer> map = new HashMap<>();
        for (String s : letters) {
            Character c = s.toLowerCase().charAt(0);
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        return wordDAO.list(length, get('a', map), get('b', map), get('c', map), get('d', map), get('e', map), get('f', map),
                get('g', map), get('h', map), get('i', map), get('j', map), get('k', map), get('l', map), get('m', map),
                get('n', map), get('o', map), get('p', map), get('q', map), get('r', map), get('s', map), get('t', map),
                get('u', map), get('v', map), get('w', map), get('x', map), get('y', map), get('z', map));
    }

}
