import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class buscar extends JFrame {

    private JPanel panel1;
    private JTextField textField1;
    private JButton buscarButton;
    private JButton volverButton;

    public buscar(){
        setTitle("Buscar");
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu m = new menu();
                m.setVisible(true);
                dispose();
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    busqueda();
                }catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        });

    }

    public void busqueda()throws SQLException {
        int ci = Integer.parseInt(textField1.getText());
        Connection conectamos = connection();
        String sql = "Select * from estudiantes where cedula = ?";
        PreparedStatement pstmt = conectamos.prepareStatement(sql);
        pstmt.setInt(1, ci);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            String cedula = rs.getString("cedula");
            String historial = rs.getString("matricula");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String telefono = rs.getString("telefono");
            String edad = rs.getString("edad");
            String descripcion = rs.getString("observacion");
            JOptionPane.showMessageDialog(null, "| Cedula: " +cedula +" | Matricula: "
                    +historial +" | Nombre: " +nombre+" | Apellido: " +apellido+" | Telefono: " +telefono+" | Edad: "
                    + edad+ " | Observacion: " +descripcion);

        }
        rs.close();
        pstmt.close();
        conectamos.close();
    }
    public Connection connection() throws SQLException {
        String url= "jdbc:mysql://uq8hjuzpshmt1bfb:K64293S3ehmq06AOAwTo@bqju1bddxmktfabkztpa-mysql.services.clever-cloud.com:3306/bqju1bddxmktfabkztpa";
        String user="uq8hjuzpshmt1bfb";
        String password="K64293S3ehmq06AOAwTo";
        return DriverManager.getConnection(url,user,password);


    }

}