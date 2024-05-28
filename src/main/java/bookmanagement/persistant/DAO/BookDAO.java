package bookmanagement.persistant.DAO;

import java.sql.*;
import java.util.*;

import org.springframework.stereotype.Service;

import bookmanagement.persistant.DTO.*;

@Service("bookDAO")
public class BookDAO {
  public static Connection con=null;
  static {
    con=MyConnection.getConnection();
  }
  public int insertBook(BookRequestDTO book) {
	  int result=0;
    String sql="INSERT INTO book (name, author, price) VALUES (?, ?, ?)";
    try {
      PreparedStatement ps=con.prepareStatement(sql);
      ps.setString(1,book.getName());
      ps.setString(2,book.getAuthor());
      ps.setDouble(3,book.getPrice());
      result=ps.executeUpdate();
      
    }catch(SQLException e) {
      System.out.println("Insert error"+e);
    }
    return result;
  }
  public int updateBook(BookRequestDTO book) {
	  int result=0;
    String sql="UPDATE book set name=?,author=?,price=? where id=?";
    try {
      PreparedStatement ps=con.prepareStatement(sql);
      ps.setString(1,book.getName());
      ps.setString(2,book.getAuthor());
      ps.setDouble(3,book.getPrice());
      ps.setInt(4,book.getId());
      result=ps.executeUpdate();
      System.out.println("update successful id : "+book.getAuthor());
      
    }catch(SQLException e) {
      System.out.println("Insert error"+e);
    }
    return result;
  }
  public int deleteBook(int id) {
	  int result=0;
    String sql="Delete from book where id=?";
    try {
      PreparedStatement ps=con.prepareStatement(sql);
      
      ps.setInt(1,id);
     result= ps.executeUpdate();
      
    }catch(SQLException e) {
      System.out.println("Delete error"+e);
    }
    return result;
  }
  public BookResponseDTO getBookByID(int id) {
    BookResponseDTO responseBook=new BookResponseDTO();
    String sql="select * from book where id=?";
    try {
      PreparedStatement ps=con.prepareStatement(sql);
      
      ps.setInt(1,id);
      ResultSet rs=ps.executeQuery();
      while(rs.next()) {
        responseBook.setId(rs.getInt("id"));
        responseBook.setAuthor(rs.getString("author"));
        responseBook.setName(rs.getString("name"));
        responseBook.setPrice(rs.getDouble("price"));
      }
      
    }catch(SQLException e) {
      System.out.println("Insert error"+e);
    }
    return responseBook;
  }
  public ArrayList<BookResponseDTO> getAllBooks() {
    ArrayList<BookResponseDTO> list=new ArrayList<BookResponseDTO>();
    String sql="select * from book";
    try {
      PreparedStatement ps=con.prepareStatement(sql);
      ResultSet rs=ps.executeQuery();
      
      while(rs.next()) {
        BookResponseDTO responseBook=new BookResponseDTO();
        responseBook.setId(rs.getInt("id"));
        responseBook.setAuthor(rs.getString("Author"));
        responseBook.setName(rs.getString("Name"));
        responseBook.setPrice(rs.getDouble("Price"));
        list.add(responseBook);
      }
      
    }catch(SQLException e) {
      System.out.println("Insert error"+e);
    }
    return list;
  }
}