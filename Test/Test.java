import static org.junit.Assert.*;

import java.sql.SQLException;

public class Test {

	@org.junit.Test
	public void test() throws SQLException {
		
		DBUtility.DBUtility.runQuery("update customers c set c.streetaddress='166 Sharpstead Lane' where c.customerid='4065'");
	}

}
