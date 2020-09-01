create table feed(
    timestmp timestamp,
    given integer,
    given_uom nvarchar(255),
    quantity integer,
    quantity_uom nvarchar(255),
    vitamin tinyint(1),
    note nvarchar(255),
	constraint timestmp_pk primary key (timestmp)
);
