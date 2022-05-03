
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

-- Will need to add uploader id and such later

insert into USER (ID, USERNAME, PASSWORD, ROLE) values (nextval('USER_SEQ'), 'admin', '$2a$10$dZsdQUfAfZVCz7cUhl2uMutgekw8uOYKl6sb54JBKwwyYH/zvNVmC', 'ADMIN');

INSERT INTO COURSE (ID,NAME,TEACHER,DESCRIPTION,SHORTDESCRIPTION) VALUES(1,'cursus1','leekracht1','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum','Lorem ipsum dolor sit amet, consectetur adipiscing elit');
INSERT INTO COURSE (ID,NAME,TEACHER,DESCRIPTION,SHORTDESCRIPTION) VALUES(2,'cursus2','leekracht2','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum','dolor sit amet, consectetur adipiscing elit');


insert into event(id, title, start, finish, description) values (1, 'event1', '2015-01-01 1:00:00', '2015-01-01 2:00:00', 'description1');
insert into event(id, title, start, finish, description) values (2, 'event2', '2015-01-02 2:00:00', '2015-01-02 3:00:00', 'description1');
insert into event(id, title, start, finish, description) values (3, 'event3', '2015-01-03 1:00:00', '2015-01-03 2:00:00', 'description1');
insert into event(id, title, start, finish, description) values (4, 'event4', '2015-01-04 1:00:00', '2015-01-04 2:00:00', 'description1');

