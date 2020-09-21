create table feed (
    timestmp timestamp,
	constraint feed_pk primary key (timestmp)
);
create or replace view feed_vw as select * from feed;
grant select, insert, update, delete on web.feed_vw to 'web_appl'@'localhost';
