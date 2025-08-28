/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package style.tracker;

/**
 *
 * @author Dinesh
 */
import java.sql.*;
public class StyleTracker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            String sql = "select * from styles";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/styleTracker", "root", "Dinesh@12345");
            Statement stm = con.createStatement();
            ResultSet result = stm.executeQuery(sql);
            
            while(result.next()){
                String styleNo = result.getString("styleNo");
                String fabricCode = result.getString("fabricCode");
                double fabricConsumption = result.getDouble("fabricConsumption");
                String styleDescription = result.getString("styleDescription");
                Date productionCutDate = result.getDate("productionCutDate");
                Date delivery = result.getDate("delivery");
                
                System.out.println(styleNo + "\t" + fabricCode + "\t" + fabricConsumption + "\t"  + styleDescription + "\t" + productionCutDate + "\t" + delivery);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found...");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
