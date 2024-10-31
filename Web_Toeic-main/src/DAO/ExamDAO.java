package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import BEAN.Exam;
import BEAN.Exam_info;
import DB.DBConnection;

public class ExamDAO {
	public static boolean UploadFile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		String test = "";
//		ServletContext context = request.getServletContext();
//		response.setContentType("text/html; charset=UTF-8");
//
//		final String Address = "C:\\Users\\lamqu\\eclipse-workspace\\FinalProject\\WebContent\\FileUpload";
//		// final String Address = "F://";
//		final int MaxMemorySize = 1024 * 1024 * 3; // 3MB
//		final int MaxRequestSize = 1024 * 1024 * 50; // 50 MB
//
//		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//
//		if (!isMultipart) {
//			test = "failed";
//			return test;
//		}
//
//		DiskFileItemFactory factory = new DiskFileItemFactory();
//
//		// Set factory constraints
//		factory.setSizeThreshold(MaxMemorySize);
//
//		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
//
//		// Create a new file upload handler
//		ServletFileUpload upload = new ServletFileUpload(factory);
//
//		// Set overall request size constraint
//		upload.setSizeMax(MaxRequestSize);
//
//		try {
//			// Parse the request
//			List<FileItem> items = upload.parseRequest(request);
//
//			// Process the uploaded items
//			Iterator<FileItem> iter = items.iterator();
//
//			while (iter.hasNext()) {
//				FileItem item = iter.next();
//
//				if (!item.isFormField()) {
//					String fileName = item.getName();
//					test = fileName;
//					// pathFile: vị trí mà chúng ta muốn upload file vào
//					// gửi cho server
//
//					String pathFile = Address + File.separator + fileName;
//
//					File uploadedFile = new File(pathFile);
//
//					boolean kt = uploadedFile.exists();
//
//					try {
//
//						if (kt == true) {
//
//							test = "failed";
//						} else {
//							item.write(uploadedFile);
//							test = fileName;
//						}
//
//					} catch (Exception e) {
//
//						test = e.getMessage();
//					}
//				} else {
//					test = "failed";
//				}
//			}
//
//		} catch (FileUploadException e) {
//			test = "failed";
//			return test;
//		}
//
//		return test;

		String test = "";
		ServletContext context = request.getServletContext();
		response.setContentType("text/html; charset=UTF-8");

		final String Address = "C:\\Users\\lamqu\\eclipse-workspace\\FinalProject\\WebContent\\FileUpload";
		final int MaxMemorySize = 1024 * 1024 * 3; // 3MB final int MaxRequestSize = 1024 * 1024 * 50; // 50 MB

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (!isMultipart) {

			request.setAttribute("mess", "Chua nhap file!");

		}
		DiskFileItemFactory factory = new DiskFileItemFactory();

		factory.setSizeThreshold(1024 * 1024 * 5);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(1024 * 1024 * 50);

		try {
			List<FileItem> items = upload.parseRequest(request);

			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();

				if (!item.isFormField()) {
					String filename = item.getName();
					String pathfile = Address + File.separator + filename;
					File uploadFile = new File(pathfile);
					item.write(uploadFile);
				} else {
					request.setAttribute("mess1", "Sorry this Servlet only handles file upload request");
					return false;
				}

			}

		} catch (FileUploadException e) {
			request.setAttribute("mess1", e.getMessage());
			return false;
		} catch (Exception e) {
			request.setAttribute("mess1", e.getMessage());
			return false;
		}
		return false;
	}

	public static boolean InsertExam(Connection conn, String title, String id) {
		String sql = "insert into exam_info(exam_id,exam_title) values(?,?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			int k = Integer.parseInt(id);
			ptmt.setInt(1, k);
			ptmt.setString(2, title);

			int kt = ptmt.executeUpdate();
			if (kt != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public static boolean ImportExcel(HttpServletRequest request, HttpServletResponse response,int id)
			throws ServletException, IOException {
		InputStream inp;
		int check=0;
		Connection conn = new DBConnection().CreateConn();
		List<Exam> list = new ArrayList<Exam>();
		try {
			inp = new FileInputStream(
					"C:\\\\Users\\\\lamqu\\\\eclipse-workspace\\\\FinalProject\\\\WebContent\\\\FileUpload\\Exam.xls");
			HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(inp));

			Sheet sheet = (Sheet) wb.getSheetAt(0);


			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				int exam_id=-1, group_question = -1, part = -1, questionnumber = -1;
				String image = "", audio = "", question = "", anwser1 = "", anwser2 = "", anwser3 = "", anwser4 = "",
						correct_anwser = "";
				Row row = sheet.getRow(i);

				
				if (row.getCell(0) != null) {
					exam_id = (int) row.getCell(0).getNumericCellValue();
				}

				if (row.getCell(1) != null) {
					group_question = (int) row.getCell(1).getNumericCellValue();
				}

				if (row.getCell(2) != null) {
					part = (int) row.getCell(2).getNumericCellValue();
				}

				if (row.getCell(3) != null) {
					questionnumber = (int) row.getCell(3).getNumericCellValue();
				}

				if (row.getCell(4) != null) {
					image = row.getCell(4).getStringCellValue().toString();
				}
				if (row.getCell(5) != null) {
					audio = row.getCell(5).getStringCellValue().toString();
				}

				if (row.getCell(6) != null) {
					question = row.getCell(6).getStringCellValue().toString();
				}
				if (row.getCell(7) != null) {
					anwser1 = row.getCell(7).getStringCellValue().toString();
				}
				if (row.getCell(8) != null) {
					anwser2 = row.getCell(8).getStringCellValue().toString();
				}
				if (row.getCell(9) != null) {
					anwser3 = row.getCell(9).getStringCellValue().toString();
				}
				if (row.getCell(10) != null) {
					anwser4 = row.getCell(10).getStringCellValue().toString();
				}

				if (row.getCell(11) != null) {
					correct_anwser = row.getCell(11).getStringCellValue().toString();
				}
				Exam a = new Exam(exam_id, group_question, part, questionnumber, image, audio, question, anwser1,
						anwser2, anwser3, anwser4, correct_anwser);
				if(exam_id==id) {
					list.add(a);
					check++;
				}
				
			}
			if(check==200) {
				InsertDataFromExel(list);
				return true;
			}else {
				String k = String.valueOf(id);
				ExamDAO.deleteExam(k);
				return false;
			}
			

		} catch (FileNotFoundException e) {
			
			request.setAttribute("message", e.getMessage());
			return false;
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			return false;
		}

	}

	public static void InsertDataFromExel(List<Exam> list) {
		Connection conn = DBConnection.CreateConn();
		String sql = "insert into exam(exam_id,group_question,part,questionnumber,image,audio,question,anwser1,anwser2,anwser3,anwser4,correct_anwser) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			for (Exam a : list) {

				ptmt.setInt(1, a.getExam_id());
				ptmt.setInt(2, a.getGroup_question());
				ptmt.setInt(3, a.getPart());
				ptmt.setInt(4, a.getQuestionnumber());
				ptmt.setString(5, a.getImage());
				ptmt.setString(6, a.getAudio());
				ptmt.setString(7, a.getQuestion());
				ptmt.setString(8, a.getAnwser1());
				ptmt.setString(9, a.getAnwser2());
				ptmt.setString(10, a.getAnwser3());
				ptmt.setString(11, a.getAnwser4());
				ptmt.setString(12, a.getCorrect_anwser());
				ptmt.executeUpdate();
			}

			ptmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<Exam_info> getListExam() {
		List<Exam_info> list = new ArrayList<Exam_info>();
		Connection conn = DBConnection.CreateConn();
		String sql = "SELECT * FROM exam_info;";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				Exam_info a = new Exam_info(rs.getInt("exam_id"), rs.getString("exam_title"),
						rs.getString("exam_time"));
				if (Check200(rs.getInt("exam_id")) == 200) {
					a.setCheck(true);
				} else {
					a.setCheck(false);
				}
				list.add(a);
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public static int CoutPage() {
		Connection conn = DBConnection.CreateConn();
		int k = 0;
		String sql = "SELECT count(*) FROM finalweb.exam_info;";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();

			while (rs.next()) {
				k = rs.getInt(1);
			}
			conn.close();
			return k;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return k;
	}

	public static List<Exam_info> GetListExam4(int start, int count) {
		List<Exam_info> list = new ArrayList<Exam_info>();
		Connection conn = DBConnection.CreateConn();
		String sql = "select * from exam_info order by exam_id desc limit " + (start - 1) + ", " + count;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				Exam_info a = new Exam_info(rs.getInt("exam_id"), rs.getString("exam_title"),
						rs.getString("exam_time"));
				list.add(a);
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public static int Check200(int id) {
		Connection conn = DBConnection.CreateConn();
		int k = 0;
		String sql = "SELECT count(*) FROM finalweb.exam where exam_id=" + id;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();

			while (rs.next()) {
				k = rs.getInt(1);
			}
			conn.close();
			return k;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return k;
	}

	public static List<Exam> getExam(int id) {
		List<Exam> listExam = new ArrayList<Exam>();
		Connection conn = DBConnection.CreateConn();
		String sql = "select * from exam where exam_id=" + id;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				int exam_id = rs.getInt("exam_id");
				int group_question = rs.getInt("group_question");
				int part = rs.getInt("part");
				int questionnumber = rs.getInt("questionnumber");
				String image = rs.getString("image");
				String audio = rs.getString("audio");
				String question = rs.getString("question");
				String anwser1 = rs.getString("anwser1");
				String anwser2 = rs.getString("anwser2");
				String anwser3 = rs.getString("anwser3");
				String anwser4 = rs.getString("anwser4");
				String correct_anwser = rs.getString("correct_anwser");
				Exam a = new Exam(exam_id, group_question, part, questionnumber, image, audio, question, anwser1,
						anwser2, anwser3, anwser4, correct_anwser);
				listExam.add(a);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listExam;
	}

	public static boolean saveResult(int exam_id, int result_score, String member_user) {
		String sql = "insert into result(member_username,result_score,exam_id) values(?,?,?)";
		Connection conn = DBConnection.CreateConn();
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, member_user);
			ptmt.setInt(2, result_score);
			ptmt.setInt(3, exam_id);
			int kt = ptmt.executeUpdate();
			if (kt != 0) {
				return true;
			} else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public static boolean deleteQuestion(String id) {
		Connection conn = DBConnection.CreateConn();
		String sql = "delete from finalweb.exam where exam_id=" + id;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			int kt = ptmt.executeUpdate();
			if (kt != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean deleteExam(String id) {
		Connection conn = DBConnection.CreateConn();
		String sql = "delete from finalweb.exam_info where exam_id=" + id;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			int kt = ptmt.executeUpdate();
			if (kt != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	public static boolean UploadMultiFile(HttpServletRequest request, HttpServletResponse response) {
		String test = "";
		ServletContext context = request.getServletContext();
		response.setContentType("text/html; charset=UTF-8");

		final String Address = "C:\\Users\\lamqu\\eclipse-workspace\\FinalProject\\WebContent\\FileUpload";
		final int MaxMemorySize = 1024 * 1024 * 3; // 3MB final int MaxRequestSize = 1024 * 1024 * 50; // 50 MB
		if(ServletFileUpload.isMultipartContent(request))
		{
			try
			{
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				for(FileItem item : multiparts)
				{
					if(!item.isFormField())
					{
						String name = new File(item.getName()).getName();
						item.write(new File(Address + File.separator + name));
					}
				}
				request.setAttribute("message", "File uploaded successfully.");
				return true;
			}
			catch(Exception ex)
			{
				request.setAttribute("message", "File upload failed due to : " + ex);
			}
		}
		else
		{
			request.setAttribute("message", "Sorry this servlet only handles file upload request.");
			return false;
		}
		
		return false;
	}
}
