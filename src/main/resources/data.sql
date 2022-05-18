insert into USER (ID, EMAIL, PASSWORD, ROLE) values (nextval('USER_SEQ'), 'admin', '$2a$10$dZsdQUfAfZVCz7cUhl2uMutgekw8uOYKl6sb54JBKwwyYH/zvNVmC', 'ADMIN');
-- insert into PROFILE(ID, USER_ID, HAS_DISMISSED_COMPLETE_PROFILE_NOTIFICATION) values (nextval('PROFILE_SEQ'), 0, FALSE);
insert into EMPLOYEE (ID, USERNAME) values (nextval('USER_SEQ'), 'Yanis');
insert into EMPLOYEE (ID, USERNAME) values (nextval('USER_SEQ'), 'Sharon');
insert into EMPLOYEE (ID, USERNAME) values (nextval('USER_SEQ'), 'Femke');
insert into EMPLOYEE (ID, USERNAME) values (nextval('USER_SEQ'), 'Anna');

insert into event(id, title, start, finish, description, EMPLOYEE_ID)
values ((nextval('EVENT_SEQ')), 'cursus','2022-05-10 8:00:00', '2022-05-10 12:00:00', 'cursus dans', 1);
insert into event(id, title, start, finish, description, EMPLOYEE_ID)
values ((nextval('EVENT_SEQ')), 'webinar','2022-06-10 9:00:00', '2022-06-10 13:00:00', 'webinar limits academy', 2);
insert into event(id, title, start, finish, description, EMPLOYEE_ID)
values ((nextval('EVENT_SEQ')), 'webinar','2022-08-11 8:00:00', '2022-08-11 12:00:00', 'webinar limits academy', 3);
insert into event(id, title, start, finish, description, EMPLOYEE_ID)
values ((nextval('EVENT_SEQ')), 'meeting dans','2022-05-19 16:00:00', '2022-05-19 18:00:00', 'meeting met Anna voor Dans workshop', 4);
insert into event(id, title, start, finish, description, EMPLOYEE_ID)
values ((nextval('EVENT_SEQ')), 'meeting zang','2022-05-19 9:00:00', '2022-05-19 14:00:00', 'meeting met Yanis voor Dans workshop', 3);
insert into event(id, title, start, finish, description, EMPLOYEE_ID)
values ((nextval('EVENT_SEQ')), 'staking','2022-05-24 8:00:00', '2022-05-24 12:00:00', 'algemene staking', 4);
insert into event(id, title, start, finish, description, EMPLOYEE_ID)
values ((nextval('EVENT_SEQ')), 'lunch','2022-05-28 9:00:00', '2022-05-28 13:00:00', 'lunch met Anna', 3);
insert into event(id, title, start, finish, description, EMPLOYEE_ID)
values ((nextval('EVENT_SEQ')), 'paper','2022-05-28 8:00:00', '2022-05-28 12:00:00', 'paper', 4);
insert into event(id, title, start, finish, description, EMPLOYEE_ID)
values ((nextval('EVENT_SEQ')), 'schooltaak','2022-05-28 7:00:00', '2022-05-28 11:00:00', 'taak design', 3);
insert into event(id, title, start, finish, description, EMPLOYEE_ID)
values ((nextval('EVENT_SEQ')), 'meeting','2022-05-20 8:00:00', '2022-05-20 12:00:00', 'Meeting met Femke', 3);
insert into event(id, title, start, finish, description, EMPLOYEE_ID)
values ((nextval('EVENT_SEQ')), 'meeting','2022-05-28 12:00:00', '2022-05-28 16:00:00', 'Meeting met Sharon', 3);
insert into event(id, title, start, finish, description, EMPLOYEE_ID)
values ((nextval('EVENT_SEQ')), 'meeting','2022-05-28 16:00:00', '2022-05-28 18:00:00', 'Meeting met Yanis', 3);



INSERT INTO COURSE (ID,NAME,TEACHER,DESCRIPTION,SHORTDESCRIPTION,LOCATION,WORKSHOP) VALUES(nextval('COURSE_SEQ'),'Zang','leekracht 1','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum','Lorem ipsum dolor sit amet, consectetur adipiscing elit','Antwerpen',false);
INSERT INTO COURSE (ID,NAME,TEACHER,DESCRIPTION,SHORTDESCRIPTION,LOCATION,WORKSHOP) VALUES(nextval('COURSE_SEQ'),'Acteren','leekracht 2','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum','Lorem ipsum dolor sit amet, consectetur adipiscing elit','Mechelen',false);
INSERT INTO COURSE (ID,NAME,TEACHER,DESCRIPTION,SHORTDESCRIPTION,LOCATION,WORKSHOP) VALUES(nextval('COURSE_SEQ'),'workshop 1','leekracht 3','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum','Lorem ipsum dolor sit amet, consectetur adipiscing elit','Antwerpen',true);
INSERT INTO COURSE (ID,NAME,TEACHER,DESCRIPTION,SHORTDESCRIPTION,LOCATION,WORKSHOP) VALUES(nextval('COURSE_SEQ'),'Dans','leekracht 4','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum','Lorem ipsum dolor sit amet, consectetur adipiscing elit','Mechelen',false);
INSERT INTO COURSE (ID,NAME,TEACHER,DESCRIPTION,SHORTDESCRIPTION,LOCATION,WORKSHOP) VALUES(nextval('COURSE_SEQ'),'Casting technieken','leekracht 5','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum','Lorem ipsum dolor sit amet, consectetur adipiscing elit','Antwerpen',false);
INSERT INTO COURSE (ID,NAME,TEACHER,DESCRIPTION,SHORTDESCRIPTION,LOCATION,WORKSHOP) VALUES(nextval('COURSE_SEQ'),'workshop 2','leekracht 6','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum','Lorem ipsum dolor sit amet, consectetur adipiscing elit','Mechelen',true);
