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
values ((nextval('EVENT_SEQ')), 'event3','2022-05-11 2:00:00', '2022-05-12 3:00:00', 'description1');
insert into event(id, title, start, finish, description)
values ((nextval('EVENT_SEQ')), 'event4','2022-05-12 2:00:00', '2022-05-13 3:00:00', 'description1');

-- insert into event(id, title, start, finish, description) values (2, 'event2', '2022-05-10 2:00:00', '2022-05-11 3:00:00', 'description2');
-- insert into event(id, title, start, finish, description) values (3, 'event3', '2022-05-12 5:00:00', '2022-05-13 6:00:00', 'description3');
-- insert into event(id, title, start, finish, description) values (4, 'event4', '2022-05-15 1:00:00', '2022-05-17 5:00:00', 'description4');


INSERT INTO COURSE (ID,NAME,TEACHER,DESCRIPTION,SHORTDESCRIPTION,LOCATION,WORKSHOP) VALUES(nextval('COURSE_SEQ'),'cursus 1','leekracht 1','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum','Lorem ipsum dolor sit amet, consectetur adipiscing elit','Antwerpen',false);
INSERT INTO COURSE (ID,NAME,TEACHER,DESCRIPTION,SHORTDESCRIPTION,LOCATION,WORKSHOP) VALUES(nextval('COURSE_SEQ'),'cursus 2','leekracht 2','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum','Lorem ipsum dolor sit amet, consectetur adipiscing elit','Mechelen',false);
INSERT INTO COURSE (ID,NAME,TEACHER,DESCRIPTION,SHORTDESCRIPTION,LOCATION,WORKSHOP) VALUES(nextval('COURSE_SEQ'),'workshop 1','leekracht 3','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum','Lorem ipsum dolor sit amet, consectetur adipiscing elit','Antwerpen',true);
INSERT INTO COURSE (ID,NAME,TEACHER,DESCRIPTION,SHORTDESCRIPTION,LOCATION,WORKSHOP) VALUES(nextval('COURSE_SEQ'),'cursus 4','leekracht 4','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum','Lorem ipsum dolor sit amet, consectetur adipiscing elit','Mechelen',false);
INSERT INTO COURSE (ID,NAME,TEACHER,DESCRIPTION,SHORTDESCRIPTION,LOCATION,WORKSHOP) VALUES(nextval('COURSE_SEQ'),'cursus 5','leekracht 5','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum','Lorem ipsum dolor sit amet, consectetur adipiscing elit','Antwerpen',false);
INSERT INTO COURSE (ID,NAME,TEACHER,DESCRIPTION,SHORTDESCRIPTION,LOCATION,WORKSHOP) VALUES(nextval('COURSE_SEQ'),'workshop 2','leekracht 6','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum','Lorem ipsum dolor sit amet, consectetur adipiscing elit','Mechelen',true);
INSERT INTO COURSE (ID,NAME,TEACHER,DESCRIPTION,SHORTDESCRIPTION,LOCATION,WORKSHOP) VALUES(nextval('COURSE_SEQ'),'cursus 7','leekracht 7','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum','Lorem ipsum dolor sit amet, consectetur adipiscing elit','Antwerpen',false);
INSERT INTO COURSE (ID,NAME,TEACHER,DESCRIPTION,SHORTDESCRIPTION,LOCATION,WORKSHOP) VALUES(nextval('COURSE_SEQ'),'cursus 8','leekracht 8','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum','Lorem ipsum dolor sit amet, consectetur adipiscing elit','Mechelen',false);
INSERT INTO COURSE (ID,NAME,TEACHER,DESCRIPTION,SHORTDESCRIPTION,LOCATION,WORKSHOP) VALUES(nextval('COURSE_SEQ'),'workshop 3','leekracht 9','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum','Lorem ipsum dolor sit amet, consectetur adipiscing elit','Antwerpen',true);