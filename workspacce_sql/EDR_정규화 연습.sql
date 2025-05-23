CREATE TABLE game_tag (
	id number(2) NULL,
	name varchar2(50) NOT NULL
);

CREATE TABLE game_developer (
	devnum number NOT NULL,
	developer varchar2(50) NULL,
	dev_nation varchar2(50) NULL,
	dev_est date NULL
);
alter table game_developer modify dev_est number(4);

CREATE TABLE game_tag_relationship (
	game_title varchar2(50) NOT NULL,
	id number(2) NULL
);

CREATE TABLE game (
	game_title varchar2(50) NOT NULL,
	game_price number NULL,
	game_score number(2,1) NULL,
	release number NULL,
	icon varchar2(20) NULL,
	devnum number NOT NULL
);

ALTER TABLE game_tag ADD CONSTRAINT PK_GAME_TAG PRIMARY KEY (id);

ALTER TABLE game_developer ADD CONSTRAINT PK_GAME_DEVELOPER PRIMARY KEY (devnum);

ALTER TABLE game ADD CONSTRAINT PK_GAME PRIMARY KEY (game_title);

ALTER TABLE game_tag_relationship ADD CONSTRAINT FK1
						FOREIGN KEY (game_title) REFERENCES game (game_title);

ALTER TABLE game_tag_relationship ADD CONSTRAINT FK2
						FOREIGN KEY (id) REFERENCES game_tag (id);

ALTER TABLE game ADD CONSTRAINT FK3
						FOREIGN KEY (devnum) REFERENCES game_developer (devnum);
            
                        
desc game_tag;
desc game_developer;
desc game_tag_relationship;
desc game;                       

select * from game_tag;
select * from game_developer;
select * from game_tag_relationship;
select * from game; 
                        
/* 데이터 넣기 */
insert into game_tag (id, name) values (1, '농사');
insert into game_tag (id, name) values (2, '롤플레잉');
insert into game_tag (id, name) values (3, '샌드박스');  
insert into game_tag (id, name) values (4, '시뮬레이션');  
insert into game_tag (id, name) values (5, '아케이드');  
insert into game_tag (id, name) values (6, '음악');  
insert into game_tag (id, name) values (7, '카드');  
insert into game_tag (id, name) values (8, '캐주얼');  
insert into game_tag (id, name) values (9, '판타지');  

insert into game_developer (devnum, developer, dev_nation, dev_est)
       values(1, 'Mojang', '스웨덴', 2009);
insert into game_developer (devnum, developer, dev_nation, dev_est)
       values (2, 'Playstack', '영국', 2016);     
insert into game_developer (devnum, developer, dev_nation, dev_est)
       values (3, 'ConcernedApe', '미국', 2016);   
insert into game_developer (devnum, developer, dev_nation, dev_est)
       values (4, '7th Beat Games', '말레이시아', 2011); 