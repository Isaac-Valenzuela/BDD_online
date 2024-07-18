import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class eliminar extends JFrame {
    private JPanel panel1;
    private JTextField textField1; // Cedula
    private JButton eliminarButton;
    private JButton volverButton;

    public eliminar() {
        setTitle("Eliminar");
        setSize(400, 400);
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

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    eliminarRegistro();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void eliminarRegistro() throws SQLException {
        String cedula = textField1.getText();

        Connection conectamos = connection();
        String sql = "DELETE FROM estudiantes WHERE cedula = ?";
        PreparedStatement pstmt = conectamos.prepareStatement(sql);
        pstmt.setString(1, cedula);

        int rowAffected = pstmt.executeUpdate();
        if (rowAffected > 0) {
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontro un registro con la cedula especificada");
        }
        pstmt.close();
        conectamos.close();
    }

    public Connection connection() throws SQLException {
        String url= "jdbc:mysql://uq8hjuzpshmt1bfb:K64293S3ehmq06AOAwTo@bqju1bddxmktfabkztpa-mysql.services.clever-cloud.com:3306/bqju1bddxmktfabkztpa";
        String user="uq8hjuzpshmt1bfb";
        String password="K64293S3ehmq06AOAwTo";
        return DriverManager.getConnection(url, user, password);
    }

}

