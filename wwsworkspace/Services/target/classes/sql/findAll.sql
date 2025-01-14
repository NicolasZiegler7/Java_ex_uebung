SELECT
    '[' || GROUP_CONCAT(
            JSON_OBJECT(
                    'id', p.ID,
                    'vorname', p.Vorname,
                    'nachname', p.Nachname,
                    'geburtsdatum', p.Geburtsdatum,
                    'gehaltsdaten',
                    CASE
                        WHEN g.Bruttogehalt IS NOT NULL THEN
                            JSON_OBJECT(
                                    'bruttogehalt', g.Bruttogehalt,
                                    'lohnsteuerklasse', g.Lohnsteuerklasse,
                                    'anzahlKinder', g.AnzahlKinder
                            )
                        ELSE
                            'null'
                        END
            )
        , ',') || ']' AS person_array_json
FROM Person p
         LEFT JOIN Gehaltsdaten g ON p.id = g.personid;
