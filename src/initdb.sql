drop schema if exists dat109_oblig1 cascade;
create schema dat109_oblig1;

set search_path to dat109_oblig1;

create table board(
  square INTEGER primary key,
  wormhole Integer references board
  );

create table player(
  first_name varchar(30) primary key,
  place integer references board,
  piece varchar(30)
);

ALTER TABLE board ALTER COLUMN wormhole DROP NOT NULL;