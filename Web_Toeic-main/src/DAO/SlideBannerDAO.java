package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BEAN.SlideBannerBEAN;

public class SlideBannerDAO {
	public static List<SlideBannerBEAN> ShowBanner(Connection conn){
		List<SlideBannerBEAN> list =new ArrayList<SlideBannerBEAN>();
		String sql = "select * from slidebanner";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString("slidebanner_name");
				String content = rs.getString("slidebanner_content");
				String image = rs.getString("slidebanner_image");
				SlideBannerBEAN a = new SlideBannerBEAN(name, content, image);
				list.add(a);
			}
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
}
