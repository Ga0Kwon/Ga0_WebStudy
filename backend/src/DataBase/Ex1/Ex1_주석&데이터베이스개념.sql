# 한줄 주석
-- 한줄 주석 (-- 하고 한칸 띄우기)
/*여러 줄 주석*/

/*
	데이터베이스 : 데이터[자료], 베이스[모임]
		- 자료들의 모임
	- 종류
		1. 계층형 데이터 베이스 : 상하관계가 있는 데이터 베이스[트리형] 
        2. 네트워크형 데이터 베이스 : 서로 연결된 데이터 베이스[양방향 형태] 
        3. * 관계형 데이터 베이스 : 행과 열로 구성된 테이블간의 관계 
        4. NoSQL 데이터 베이스 : key-value 값으로 구성된 데이터 베이스 
        
	- DBMS : 데이터 베이스 관리 시스템
		Oracle, MySQL, MSSQL, MariaDB, access
        
	- DBA : 데이터 베이스 관리자
		DB개발자 
        
		DB[DBserver] <------------------ DBMS <------------------- DBA
		- DB가 설치된 PC               	- DB관리 시스템        	  - SQL[질의어]
		- 데이터를 저장          			- DB 서버에 점속
 		- 메모리[16진수]        			- 표준 SQL 사용
        
	예)
		DBA["표 만들어줘"] --------> DBMS ["표 만들어줘"를 기계어로 바꾸고] ---------> DB [표 만들기 성공]
									메모리1 메모리2								메모리1
									메모리3 메모리4								메모리2
																			메모리3
                                                                            메모리4
	=> 컴퓨터는 표를 모르기 때문[그냥 주소,주소 값을 가짐] -> 표로 만드는 것은 DBMS
*/