package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.CongTrinh;

public class CongTrinh_DAO {
	public ArrayList<CongTrinh> getAllCongTrinh() {
		ArrayList<CongTrinh> dsCT = new ArrayList<CongTrinh>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnect();

			String sql = "SELECT * FROM tbl_CongTrinh;";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String maCongTrinh = resultSet.getString(1);
				String tenCongTrinh = resultSet.getString(2);
				String diaDiem = resultSet.getString(3);
				String ngayCapPhep = resultSet.getString(4);
				String ngayKhoiCong = resultSet.getString(5);
				String ngayHoanThanh = resultSet.getString(6);
				boolean trangThai = resultSet.getBoolean(7);
				CongTrinh congTrinh = new CongTrinh(maCongTrinh, tenCongTrinh, diaDiem, ngayCapPhep, ngayKhoiCong,
						ngayHoanThanh, trangThai);
				dsCT.add(congTrinh);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsCT;
	}

	public ArrayList<CongTrinh> getCongTrinhTheoMaCT(String id) throws SQLException {
		ArrayList<CongTrinh> dsCT = new ArrayList<CongTrinh>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM tbl_CongTrinh WHERE [maCongTrinh] = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String maCongTrinh = resultSet.getString(1);
				String tenCongTrinh = resultSet.getString(2);
				String diaDiem = resultSet.getString(3);
				String ngayCapPhep = resultSet.getString(4);
				String ngayKhoiCong = resultSet.getString(5);
				String ngayHoanThanh = resultSet.getString(6);
				boolean trangThai = resultSet.getBoolean(7);
				CongTrinh congTrinh = new CongTrinh(maCongTrinh, tenCongTrinh, diaDiem, ngayCapPhep, ngayKhoiCong,
						ngayHoanThanh, trangThai);
				dsCT.add(congTrinh);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return dsCT;
	}
	
	public ArrayList<CongTrinh> getCongTrinhTheoTenCT(String id) throws SQLException {
		ArrayList<CongTrinh> dsCT = new ArrayList<CongTrinh>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM tbl_CongTrinh WHERE [tenCongTrinh] LIKE ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, "%" + id + "%");

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String maCongTrinh = resultSet.getString(1);
				String tenCongTrinh = resultSet.getString(2);
				String diaDiem = resultSet.getString(3);
				String ngayCapPhep = resultSet.getString(4);
				String ngayKhoiCong = resultSet.getString(5);
				String ngayHoanThanh = resultSet.getString(6);
				boolean trangThai = resultSet.getBoolean(7);
				CongTrinh congTrinh = new CongTrinh(maCongTrinh, tenCongTrinh, diaDiem, ngayCapPhep, ngayKhoiCong,
						ngayHoanThanh, trangThai);
				dsCT.add(congTrinh);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return dsCT;
	}
	
	public ArrayList<CongTrinh> getCongTrinhTheoY(String id) throws SQLException {
		ArrayList<CongTrinh> dsCT = new ArrayList<CongTrinh>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM tbl_CongTrinh WHERE YEAR(ngayKhoiCong)=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String maCongTrinh = resultSet.getString(1);
				String tenCongTrinh = resultSet.getString(2);
				String diaDiem = resultSet.getString(3);
				String ngayCapPhep = resultSet.getString(4);
				String ngayKhoiCong = resultSet.getString(5);
				String ngayHoanThanh = resultSet.getString(6);
				boolean trangThai = resultSet.getBoolean(7);
				CongTrinh congTrinh = new CongTrinh(maCongTrinh, tenCongTrinh, diaDiem, ngayCapPhep, ngayKhoiCong,
						ngayHoanThanh, trangThai);
				dsCT.add(congTrinh);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return dsCT;
	}

	public boolean addCongTrinh(CongTrinh congTrinh) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("INSERT INTO " + " tbl_CongTrinh VALUES(?, ?, ?, ?, ?, ?)");
			statement.setString(1, congTrinh.getMaCongTrinh());
			statement.setString(2, congTrinh.getTenCongTrinh());
			statement.setString(3, congTrinh.getDiaDiem());
			statement.setString(4, congTrinh.getNgayCapPhep());
			statement.setString(5, congTrinh.getNgayKhoiCong());
			statement.setString(6, congTrinh.getNgayHoanThanh());
			statement.setBoolean(7, congTrinh.isTrangThai());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean updateCongTrinh(CongTrinh congTrinh) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("UPDATE tbl_CongTrinh SET [tenCongTrinh]=?,[diaDiem]=?,[ngayCapPhep]=?,"
					+ "[ngayKhoiCong]=?,[ngayHoanThanh]=?,[trangThai]=? WHERE maCongTrinh=?");
			statement.setString(1, congTrinh.getTenCongTrinh());
			statement.setString(2, congTrinh.getDiaDiem());
			statement.setString(3, congTrinh.getNgayCapPhep());
			statement.setString(4, congTrinh.getNgayKhoiCong());
			statement.setString(5, congTrinh.getNgayHoanThanh());
			statement.setBoolean(6, congTrinh.isTrangThai());
			statement.setString(7, congTrinh.getMaCongTrinh());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		con.close();
		return n > 0;
	}

	public boolean deleteCongTrinh(String id) throws SQLException {
//		ArrayList<CongTrinh> dsCT = new ArrayList<CongTrinh>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		int n = 0;
		try {
			String sql = "DELETE FROM tbl_CongTrinh WHERE [maCongTrinh] = ?;";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			n = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		con.close();
		return n > 0;
	}

}
