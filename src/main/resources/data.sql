-- Futók létrehozása
INSERT INTO futo (nev, eletkor, nem) VALUES
                                         ('Kovács János', 25, 'férfi'),
                                         ('Nagy Éva', 30, 'nő'),
                                         ('Kiss Péter', 28, 'férfi'),
                                         ('Szabó Anna', 35, 'nő');

-- Versenyek létrehozása
INSERT INTO verseny (nev, tavolsag) VALUES
                                        ('Tavaszi Félmaraton', 21.0),
                                        ('Nyári 10km', 10.0);

-- Eredmények létrehozása
INSERT INTO eredmeny (futo_id, verseny_id, ido_eredmeny) VALUES
                                                             (1, 1, 95),  -- Kovács János - Félmaraton
                                                             (2, 1, 98),  -- Nagy Éva - Félmaraton
                                                             (3, 1, 92),  -- Kiss Péter - Félmaraton
                                                             (1, 2, 45),  -- Kovács János - 10km
                                                             (2, 2, 48),  -- Nagy Éva - 10km
                                                             (4, 2, 50);  -- Szabó Anna - 10km
