package test2;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("s: ");

        double s = scanner.nextDouble();

        System.out.println("v: ");

        int v = scanner.nextInt();

        String URL = "jdbc.///";

        String username = "..";

        String password = "..";

        ResultSet rs = null;

        PreparedStatement pstmt = null;

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, username,password);

            String sql = "SELECT ... WHERE <= ? and => ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,v);
            pstmt.setDouble(2,s);

            rs = pstmt.executeQuery();

            while (rs.next()){
                String cnp = rs.getString("CNP");
                String nume = rs.getString("NUME");
                int varsta = rs.getInt("VARSTA");
                double salariu = rs.getDouble("SALARIU");

                System.out.println(cnp + nume + varsta + salariu);


            }



        }catch (SQLException e ){
            e.printStackTrace();
        }

    }

}
