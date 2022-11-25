CREATE TABLE "faculties" (
    "id"	INTEGER,
    "name"	TEXT NOT NULL,
    PRIMARY KEY("id" AUTOINCREMENT)
);
INSERT INTO "main"."faculties"
("name")
VALUES ('Факультет информатики');
INSERT INTO "main"."faculties"
("name")
VALUES ('Факультет электроники и приборостроения');
CREATE TABLE "specialties" (
    "id"	INTEGER,
    "name"	TEXT NOT NULL,
    "faculty_id"	INTEGER,
    FOREIGN KEY("faculty_id") REFERENCES "faculties"("id"),
    PRIMARY KEY("id" AUTOINCREMENT)
);
INSERT INTO "main"."specialties"
("name", "faculty_id")
VALUES ('Прикладная математика и информатика', 1);
INSERT INTO "main"."specialties"
("name", "faculty_id")
VALUES ('Информатика и вычислительная техника', 1);
INSERT INTO "main"."specialties"
("name", "faculty_id")
VALUES ('Наноэлектроника', 2);
CREATE TABLE "students" (
    "id"	INTEGER,
    "name"	TEXT NOT NULL,
    "phone"	TEXT NOT NULL,
    "address"	INTEGER NOT NULL,
    "year"	INTEGER NOT NULL,
    "specialty_id"	INTEGER NOT NULL,
    FOREIGN KEY("specialty_id") REFERENCES "specialties"("id"),
    PRIMARY KEY("id" AUTOINCREMENT)
);
INSERT INTO "main"."students"
("name", "phone", "address", "year", "specialty_id")
VALUES ('Иванов Артем Андреевич', '89009003456', 'Самарская, 190', 2020, 1);
INSERT INTO "main"."students"
("name", "phone", "address", "year", "specialty_id")
VALUES ('Воеводина Полина Александровна', '89341803236', 'Революционная, 46', 2020, 3);
INSERT INTO "main"."students"
("name", "phone", "address", "year", "specialty_id")
VALUES ('Серафимович Дмитрий Владимирович', '89895607431', 'Самарская, 190', 2019, 1);
INSERT INTO "main"."students"
("name", "phone", "address", "year", "specialty_id")
VALUES ('Коробкин Артем Юрьевич', '89179034509', 'Московское ш., 34', 2020, 1);
INSERT INTO "main"."students"
("name", "phone", "address", "year", "specialty_id")
VALUES ('Погорелов Вадим Артемович', '89567889346', 'Ленинградская, 3', 2019, 2);
