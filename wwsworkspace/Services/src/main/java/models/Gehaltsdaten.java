package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gehaltsdaten {
	private double bruttogehalt;
	private int lohnsteuerklasse;
	private int anzahlKinder;
}
