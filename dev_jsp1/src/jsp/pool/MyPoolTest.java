package jsp.pool;

import javax.activation.DataSource;
import javax.naming.InitialContext;

public class MyPoolTest {

	public static void main(String[] args) {
		try {
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/dbPool");
			System.out.print(ds);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
