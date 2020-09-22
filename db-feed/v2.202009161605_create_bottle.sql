create table bottle (
    timestmp timestamp,
    ordinal integer,
    given integer,
    given_uom nvarchar(255),
    quantity integer,
    quantity_uom nvarchar(255),
    vitamin tinyint(1),
    note nvarchar(255),
	constraint bottle_pk primary key (timestmp,ordinal)
);
create or replace view bottle_vw as select * from bottle;
grant select, insert, update, delete on web.bottle_vw to 'web_appl'@'%';
