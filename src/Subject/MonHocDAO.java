package Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
 
import Subject.MonHoc;
import ConnectDBxampp.ConnectDB;
 
public class MonHocDAO {
	private Connection connection;
	private ConnectDB connectDB;
	private ResultSet resultSet;
	private Statement statement;
 
	public MonHocDAO() {
		connectDB = new ConnectDB();
	}
	public void insert(String name){
		connection = connectDB.getConnect();
	
		
		
		//select * from imagedatabase where("a7_B_BBI_DARK_Defect_2.bmp")in(select name from imagedatabase ) ";
		
		/*SELECT "a7_B_BBI_DARK_Defect_2.bmp"
		FROM imagedatabase
		WHERE EXISTS
		(SELECT name FROM imagedatabase);                            */
		
		
		
		String sql = "insert into imagedatabase(name) value(?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,name);
			preparedStatement.executeUpdate();
			System.out.println("THÊM THÀNH CÔNG!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//add
	/*public void insert(String name){
		connection = connectDB.getConnect();
		String sql = "insert into imagedatabase(name) value(?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,name);
			preparedStatement.executeUpdate();
			System.out.println("THÊM THÀNH CÔNG!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
 */
	// hiển thị tất cả các môn học
	public ArrayList<MonHoc> findAll() {
		ArrayList<MonHoc> listMH = new ArrayList<>();
		connection = connectDB.getConnect();
		String sql = "select * from imagedatabase order by id DESC";
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				//xu ly ten anh khi show
				String name=resultSet.getString("name");
				int endIndex=name.length();
				int beginIndex=1;
				String new_name = name.substring(beginIndex,endIndex);
				
				MonHoc hoc = new MonHoc(resultSet.getInt("id"),
						new_name);
				listMH.add(hoc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listMH;
	}
}