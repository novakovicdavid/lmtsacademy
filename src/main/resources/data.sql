insert into USER (ID, EMAIL, PASSWORD, ROLE) values (nextval('USER_SEQ'), 'admin', '$2a$10$dZsdQUfAfZVCz7cUhl2uMutgekw8uOYKl6sb54JBKwwyYH/zvNVmC', 'ADMIN');
-- insert into PROFILE(ID, USER_ID, HAS_DISMISSED_COMPLETE_PROFILE_NOTIFICATION) values (nextval('PROFILE_SEQ'), 0, FALSE);

insert into Afspraak (ID, DATUM, START_UUR, EIND_UUR, NAAM, VAKGEBIED, OPMERKING)
values ((nextval('AFSPRAAK_SEQ')), '2021-09-3', 16, 17, 'test', 'Dans', 'blaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa');
insert into Afspraak (ID, DATUM, START_UUR, EIND_UUR, NAAM, VAKGEBIED, OPMERKING)
values ((nextval('AFSPRAAK_SEQ')), '2021-09-3', 16, 17, 'test', 'Dans', 'blaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa');
insert into Afspraak (ID, DATUM, START_UUR, EIND_UUR, NAAM, VAKGEBIED, OPMERKING)
values ((nextval('AFSPRAAK_SEQ')), '2021-09-3', 16, 17, 'test', 'Dans', 'blaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa');
insert into Afspraak (ID, DATUM, START_UUR, EIND_UUR, NAAM, VAKGEBIED, OPMERKING)
values ((nextval('AFSPRAAK_SEQ')), '2021-09-3', 16, 17, 'test', 'Dans', 'blaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa');
insert into Afspraak (ID, DATUM, START_UUR, EIND_UUR, NAAM, VAKGEBIED, OPMERKING)
values ((nextval('AFSPRAAK_SEQ')), '2021-09-3', 16, 17, 'test', 'Dans', 'blaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa');






insert into event(id, title, start, finish, description)
values ((nextval('EVENT_SEQ')), 'event1','2022-05-10 2:00:00', '2022-05-11 3:00:00', 'description1');
insert into event(id, title, start, finish, description)
values ((nextval('EVENT_SEQ')), 'event2','2022-06-10 2:00:00', '2022-06-11 3:00:00', 'description1');
insert into event(id, title, start, finish, description)
values ((nextval('EVENT_SEQ')), 'event3','2022-05-10 2:00:00', '2022-05-11 3:00:00', 'description1');
insert into event(id, title, start, finish, description)
values ((nextval('EVENT_SEQ')), 'event4','2022-05-12 2:00:00', '2022-05-13 3:00:00', 'description1');

-- insert into event(id, title, start, finish, description) values (2, 'event2', '2022-05-10 2:00:00', '2022-05-11 3:00:00', 'description2');
-- insert into event(id, title, start, finish, description) values (3, 'event3', '2022-05-12 5:00:00', '2022-05-13 6:00:00', 'description3');
-- insert into event(id, title, start, finish, description) values (4, 'event4', '2022-05-15 1:00:00', '2022-05-17 5:00:00', 'description4');


INSERT INTO COURSE (ID,NAME,DESCRIPTION,SHORTDESCRIPTION,LOCATION,WORKSHOP) VALUES(nextval('COURSE_SEQ'),'Zang','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum','Lorem ipsum dolor sit amet, consectetur adipiscing elit','Antwerpen',false);
INSERT INTO COURSE (ID,NAME,DESCRIPTION,SHORTDESCRIPTION,LOCATION,WORKSHOP) VALUES(nextval('COURSE_SEQ'),'Acteren','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum','Lorem ipsum dolor sit amet, consectetur adipiscing elit','Mechelen',false);
INSERT INTO COURSE (ID,NAME,DESCRIPTION,SHORTDESCRIPTION,LOCATION,WORKSHOP) VALUES(nextval('COURSE_SEQ'),'workshop 1','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum','Lorem ipsum dolor sit amet, consectetur adipiscing elit','Antwerpen',true);
INSERT INTO COURSE (ID,NAME,DESCRIPTION,SHORTDESCRIPTION,LOCATION,WORKSHOP) VALUES(nextval('COURSE_SEQ'),'Dans','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum','Lorem ipsum dolor sit amet, consectetur adipiscing elit','Mechelen',false);
INSERT INTO COURSE (ID,NAME,DESCRIPTION,SHORTDESCRIPTION,LOCATION,WORKSHOP) VALUES(nextval('COURSE_SEQ'),'Casting technieken','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum','Lorem ipsum dolor sit amet, consectetur adipiscing elit','Antwerpen',false);
INSERT INTO COURSE (ID,NAME,DESCRIPTION,SHORTDESCRIPTION,LOCATION,WORKSHOP) VALUES(nextval('COURSE_SEQ'),'workshop 2','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum','Lorem ipsum dolor sit amet, consectetur adipiscing elit','Mechelen',true);

INSERT INTO TEACHER (ID,NAME,BIO,EXPERIENCE) VALUES(nextval('TEACHER_SEQ'),'KAREN BOONS','Hallo ik ben Karen, ik ben 32 jaar en werk al 5 jaar bij "Creative Spirits". Ik ben de choreograaf die niets liever doet dan mijn passie voor dansen over te brengen aan beginners.','10 jaar modern ballet, 6 jaar hiphop ');
INSERT INTO TEACHER (ID,NAME,BIO,EXPERIENCE) VALUES(nextval('TEACHER_SEQ'),'JOEP DE KLEINE','Hallo ik ben Bob, ik ben 27 jaar en werk reeds 3 jaar bij "Creative Spirits". Ik ben de zanginstructeur en help soms ook mee als assistent bij de danscursussen die wij ook aanbieden. Zingen voor een publiek is niet voor iedereen weggelegt maar ik doe er alles aan om de beste zanger in je boven te halen','Master aan de Dutch National Opera Acedemy,2 jaar hiphop en 6 jaar in een band ');
INSERT INTO TEACHER (ID,NAME,BIO,EXPERIENCE) VALUES(nextval('TEACHER_SEQ'),'KAREL BERG','Hallo ik ben Karel, ik ben 41 jaar en werk al 5 jaar bij "Screen Masters". Acteren zat al van jongs af aan in mijn interessepakket en daarom speelde ik bij elk schooltoneel mee. Later ben ik dan ook verder gaan studeren in die richting','Ik heb de academische bachelor- en masteropleiding in het Drama met afstudeerrichting Acteren ');


insert into TEACHER_COURSES (TEACHER_ID,COURSES_ID) values (1,0);

insert into TEACHER_COURSES (TEACHER_ID,COURSES_ID) values (0,3);
insert into TEACHER_COURSES (TEACHER_ID,COURSES_ID) values (1,3);

insert into TEACHER_COURSES (TEACHER_ID,COURSES_ID) values (2,1);
insert into TEACHER_COURSES (TEACHER_ID,COURSES_ID) values (2,4);

