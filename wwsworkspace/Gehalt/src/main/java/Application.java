import models.Person;
import wwsservices.DataAccessObject;

import java.util.ArrayList;
import java.util.List;

public class Application {
	public static void main(String[] args) {
		List<Person> personList = new DataAccessObject().findAll();

		double summeGehaelter = 0.0;
		for (int i = 0; i < personList.size(); i++) {
			summeGehaelter += personList.get(i).getGehaltsdaten().getBruttogehalt();
		}
		System.out.println(summeGehaelter);

		summeGehaelter = 0.0;
		for (Person element : personList) {
			summeGehaelter += element.getGehaltsdaten().getBruttogehalt();
		}

		System.out.println(summeGehaelter);

		summeGehaelter = personList
				.stream()
				.mapToDouble(person -> person.getGehaltsdaten().getBruttogehalt())
				.sum();
		System.out.println(summeGehaelter);

		List<Person> newList = personList.stream().filter(person -> "Lustig".equals(person.getNachname())).toList();
	}
}
