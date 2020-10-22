package com.cos.jwt.config.jwt;

interface JwtProps {
	//public static final 생락되어있음
	String secret="비밀키";
	String auth="Bearer ";
	String header="Authorization";
}
