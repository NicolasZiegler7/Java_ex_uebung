import wwsservices.DataAccessObject;

public class Application {

	public static void main(String[] args) {
		//System.out.println(DatabaseConnector.getInstance().getConnection());
		System.out.println(new DataAccessObject().findAll().getFirst().getGehaltsdaten().getBruttogehalt());
	}
}
