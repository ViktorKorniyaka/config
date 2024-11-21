-- if we need to create own table by sql
create table USERS_CONFIG_EXAMPLE(
                      ID int not null AUTO_INCREMENT,
                      MEMBER_NAME varchar(100) not null,
                      MAX_CONNECTIONS int,
                      STATUS varchar(100) not null,
                      PRIMARY KEY ( ID )
);

