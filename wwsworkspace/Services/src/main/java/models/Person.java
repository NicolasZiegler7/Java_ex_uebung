package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	private int id;
	private String vorname;
	private String nachname;
	private String geburtsdatum;
	private Gehaltsdaten gehaltsdaten;
}
