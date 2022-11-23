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
CREATE TABLE "faculties" (
    "id"	INTEGER,
    "name"	TEXT NOT NULL,
    PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE "specialties" (
    "id"	INTEGER,
    "name"	TEXT NOT NULL,
    "faculty_id"	INTEGER,
    FOREIGN KEY("faculty_id") REFERENCES "faculties"("id"),
    PRIMARY KEY("id" AUTOINCREMENT)
);
