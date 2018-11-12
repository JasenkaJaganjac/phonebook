package phonebook.app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMySQL {

	// vrijednosti koje smo izabrali prilikom instalacije MySQL Servera
	private static final String USERNAME = "root";
	private static final String PASSWORD = "admin";
	// localhost//imeBazeNaKojuSeSpajamo
	private static final String CONN_STRING = "jdbc:mysql://localhost/phonebook?useSSL=false&serverTimezone=UTC";
	// error? dodati na kraj stringa ?useSSL=false&serverTimezone=UTC

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
	
		// uvijek izabrati java.sql.Connection zbog portabilnosti
		Connection connection = null;

		try {
			// spoji se na bazu
			connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			System.out.println("Spojeni YEAH!");
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			// zatvori konekciju
			if (connection != null) {
				connection.close();
			}
		}
	}
}