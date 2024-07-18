import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu extends JFrame{
    private JPanel panel1;
    private JButton IRButton;
    private JButton IRButton1;
    private JButton salirButton;
    private JButton IRButton2;
    private JButton IRButton3;

    public menu(){
        setTitle("Menu");
        setSize(400,400);
        setLocationRelativeTo(null);
        setContentPane(panel1);

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login salir = new login();
                salir.setVisible(true);
                dispose();
            }
        });

        IRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrar salir = new registrar();
                salir.setVisible(true);
                dispose();
            }
        });

        IRButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscar b = new buscar();
                b.setVisible(true);
                dispose();
            }
        });

        IRButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizar a = new actualizar();
                a.setVisible(true);
                dispose();
            }
        });

        IRButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminar el = new eliminar();
                el.setVisible(true);
                dispose();

            }
        });





    }

}
