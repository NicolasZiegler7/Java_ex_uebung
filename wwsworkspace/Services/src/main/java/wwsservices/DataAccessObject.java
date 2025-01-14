package wwsservices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import models.Person;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class DataAccessObject {

	public List<Person> findAll() {
		DatabaseConnector connector = DatabaseConnector.getInstance();

		String sql = "";
		try {
			 sql = Files.readString(Paths.get(getClass().getResource("/sql/findAll.sql").toURI()));
			// Further processing of jsonArray
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (!sql.isEmpty()) {
			try (Connection connection = connector.getConnection();
			     PreparedStatement statement = connection.prepareStatement(sql);
			     ResultSet resultSet = statement.executeQuery()) {

				String jsonArray = "";
				while (resultSet.next()) {
					jsonArray = resultSet.getString("person_array_json");
				}

				if (!jsonArray.isEmpty()) {
					ObjectMapper objectMapper = new ObjectMapper();
					return objectMapper.readValue(jsonArray, new TypeReference<List<Person>>() {});
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				throw new RuntimeException(e);
			} catch (JsonProcessingException e) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}
}
