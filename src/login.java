import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login  extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton INICIARSESIONButton;

    public login(){
        setTitle("Login");
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);

        INICIARSESIONButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    verficar();
                }catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        });

    }

    public void verficar() throws SQLException{
        String user = textField1.getText();
        String pass = textField2.getText();

        Connection conectamos = connection();
        String query="SELECT * FROM CLAVE WHERE nombre = ? AND clave=?";
        PreparedStatement pstmt = conectamos.prepareStatement(query);
        pstmt.setString(1, user);
        pstmt.setString(2, pass);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()){
            menu m = new menu();
            m.setVisible(true);
            dispose();

        }

    }
    public Connection connection() throws SQLException {
        String url= "jdbc:mysql://uq8hjuzpshmt1bfb:K64293S3ehmq06AOAwTo@bqju1bddxmktfabkztpa-mysql.services.clever-cloud.com:3306/bqju1bddxmktfabkztpa";
        String user="uq8hjuzpshmt1bfb";
        String password="K64293S3ehmq06AOAwTo";
        return DriverManager.getConnection(url,user,password);
    }
}





