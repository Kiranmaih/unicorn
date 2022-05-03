create table Unicorn
(
   unicornId integer not null,
   name varchar(255) not null,
   hairColor varchar(255) not null,
   hornLength integer not null,
   hornColor varchar(255) not null,
   eyeColor varchar(255) not null,
   height integer not null,
   heightUnit varchar(2) not null,
   weight integer not null,
   weightUnit Varchar(2) not null,
   identifiableMarks Varchar(23767),
   primary key(unicornId),
   CONSTRAINT ensure_json CHECK (identifiableMarks IS JSON)
);