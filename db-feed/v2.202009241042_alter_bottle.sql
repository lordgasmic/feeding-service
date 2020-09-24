ALTER TABLE bottle ADD COLUMN probiotic tinyint(1) NOT NULL DEFAULT 0;
ALTER TABLE bottle ADD COLUMN gas tinyint(1) NOT NULL DEFAULT 0;
create or replace view bottle_vw as select * from bottle;
