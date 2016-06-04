package org.jasr.wordlist.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.jasr.wordlist.dao.WordDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class WordDAOImpl implements WordDAO {

	@Autowired
	private Environment env;
	@Resource
	private JdbcTemplate template;

	@Override
	public List<String> list(int length, int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k,
			int l, int m, int n, int o, int p, int q, int r, int s, int t, int u, int v, int w, int x, int y, int z) {
		return template.queryForList("select word from words where length = ? and (a <= ? and b <= ? and c <= ? and d <= ? and e <= ? and f <= ? and g <= ? and h <= ? and i <= ? and j <= ? and k <= ? and l <= ? and m <= ? and n <= ? and o <= ? and p <= ? and q <= ? and r <= ? and s <= ? and t <= ? and u <= ? and v <= ? and w <= ? and x <= ? and y <= ? and z <= ?) order by word",
				new Object[] { length,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z}, String.class);
	}

}









