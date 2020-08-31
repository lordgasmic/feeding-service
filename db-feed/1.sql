create table feed(
    timestmp timestamp,
    given integer,
    givenUom nvarchar(255),
    quantity integer,
    quantityUom nvarchar(255),
    vitamin tinyint(1),
    note nvarchar(255),
	constraint timestmp_pk primary key (timestmp)
);
