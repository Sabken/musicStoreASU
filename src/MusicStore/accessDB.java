
package MusicStore;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class accessDB<E,T> {
    private final String connectionURL="jdbc:derby://localhost:1527/music;create=true";
    private String sql;
    private Connection conn;
    private Statement st;
    
    public void insert(E obj) throws SQLException {
       conn = DriverManager.getConnection(connectionURL);
       st = conn.createStatement();
       if(obj instanceof UserAdmin){
        Object [] info = ((UserAdmin) obj).getDBInfo();
        sql = "INSERT INTO ADMIN (ID, FIRSTNAME, LASTNAME,USERNAME, PASSWORD) VALUES "
              + "("+ ((int)info[4]) +",'"+ ((String)info[0]) +"','"+ ((String)info[1]) +"','"+
                ((String)info[2]) +"','"+ ((String)info[3])+"')";
                
       }
       else if(obj instanceof UserCustomer){
            Object [] info=((UserCustomer) obj).getDBInfo();
           
           sql = "INSERT INTO CUSTOMER (SSN, FIRSTNAME, LASTNAME,USERNAME, PASSWORD) VALUES "
             + "("+ ((int)info[4]) +",'"+ ((String)info[0]) +"','"+ ((String)info[1]) +"','"+
                ((String)info[2]) +"','"+ ((String)info[3])+"')";
             
       }
       else if(obj instanceof MusicalItem){
           Object []info=((MusicalItem) obj).getDBInfo();
           sql = "INSERT INTO MUSICITEM (MUSICNAME, CATEGORY, DURATION, DESCRIPTION, RELEASEDATE, QUANTITY,ARTIST,PRICE) VALUES "
              + "('"+ ((String)info[0]) +"','"+ ((String)info[1]) +"','"+ ((String)info[2]) +"','"+
                ((String)info[3]) +"','"+ ((String)info[4])+"',"+ ((int)info[5])+",'"+ ((String)info[6])+"',"+ ((double)info[7])+")";
           
       
       }
       else if(obj instanceof MusicCategory){
          
           sql = "INSERT INTO CATEGORY (CATEGORY) VALUES "
              + "('"+ ((MusicCategory)obj).toString() +"')";
           
       
       }
     
       st.executeUpdate(sql);
       st.close(); 
       conn.close(); 
    }
    public void update(String idValue,String ValueName,Object value) throws SQLException{
       conn = DriverManager.getConnection(connectionURL);
       st = conn.createStatement();
       if(value instanceof Double)
          sql = "UPDATE MISUCITEM SET "+ValueName+" = '"+((double)value)+"' WHERE MUSICNAME = '"+idValue+"'";
       else if(value instanceof Integer)
          sql = "UPDATE MISUCITEM SET "+ValueName+" = '"+((int)value)+"' WHERE MUSICNAME = '"+idValue+"'";
       else
          sql = "UPDATE MISUCITEM SET "+ValueName+" = '"+((String)value)+"' WHERE MUSICNAME = '"+idValue+"'";
       st.executeUpdate(sql);
       st.executeUpdate(sql);
       st.close(); 
       conn.close(); 
        
    }
    public T retrive(String name) throws SQLException{
        conn = DriverManager.getConnection(connectionURL);
         st = conn.createStatement();
         ArrayList<E> objs= new ArrayList<>();
         Set<E> objs2=new HashSet<>();
         Object []info;
        switch (name) {
            case "Admin":
                sql = "SELECT * FROM ADMIN ";
                break;
            case "Customer":
                sql = "SELECT * FROM CUSTOMER ";
                break;
            case "MusicItem":  
                sql = "SELECT * FROM MUSICITEM ";
                break;
            case "Category":  
                 sql = "SELECT * FROM CATEGORY ";
                break;
            default:
                break;
        }
        ResultSet rs=st.executeQuery(sql);
        while(rs.next()){
            switch (name) {
            case "Admin":
                info= new Object[5];
                
                info[0]=rs.getString("FIRSTNAME");
                info[1]=rs.getString("LASTNAME");
                info[2]=rs.getString("USERNAME");
                info[3]=rs.getString("PASSWORD");
                info[4]=rs.getInt("ID");
                
                UserAdmin s=new UserAdmin();
                s.setDBInfo(info);
                objs2.add((E) s);
                break;
            case "Customer":
                info= new Object[5];
                info[0]=rs.getString("FIRSTNAME");
                info[1]=rs.getString("LASTNAME");
                info[2]=rs.getString("USERNAME");
                info[3]=rs.getString("PASSWORD");
                info[4]=rs.getInt("SSN");
                UserCustomer c1=new UserCustomer();
                c1.setDBInfo(info);
                objs2.add((E) c1); 
             
               
                  break;
            case "MusicItem":  
                
                  info=new Object[8];
                  info[0]=rs.getString("MUSICNAME");
                  info[1]=rs.getString("CATEGORY");
                  info[2]=rs.getString("DURATION");
                  info[3]=rs.getString("DESCRIPTION");
                  info[4]=rs.getString("RELEASEDATE");
                  info[5]=rs.getInt("QUANTITY");
                  info[6]=rs.getString("ARTIST");
                  info[7]=rs.getDouble("PRICE");
                  MusicalItem item= new MusicalItem();
                  item.setDBInfo(info);
                  objs.add((E) item);
                break;
            case "Category":  

                    MusicCategory cat = new MusicCategory(rs.getString("CATEGORY"));
                   
                    objs.add((E) cat);
                  break;
            default:
                break;
        }
           
        }
        switch (name) {
            case "Admin":
               return (T) objs2;
            case "Customer":
               return (T) objs2;
            case "MusicItem":  
               return (T) objs;
            case "Category":  
               return (T) objs;
            default:
                break;
        }
         return null;
     
    
        
    }
    public void delete(String name, String value) throws SQLException{
         conn = DriverManager.getConnection(connectionURL);
         st = conn.createStatement();
         String tableName="";
         switch (name) {
            case "MusicItem":
             tableName = "MUSICITEM";
              sql = "DELETE FROM "+ tableName+" WHERE MUSICNAME = '" +value+"'";
            case "Category":  
               tableName = "CATEWGORY";
                sql = "DELETE FROM "+ tableName+" WHERE CATEGORY = '" +value+"'";
            default:
                break;
         }
         st.executeUpdate(sql);
         st.close(); 
         conn.close();
    }
}
