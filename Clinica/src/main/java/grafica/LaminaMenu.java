package grafica;

import conectar.Conexion;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class LaminaMenu extends JPanel {
    private String file = "BackGroundMenu.jpg";
    private JButton btnDatosPersonales;
    private JButton btnReservas;
    private JButton btnPacientes;
    private JButton btnDoctores;
    private JButton btnFamiliar;
    private JButton btnConsulta;
    private JButton btnIngreso;
    private JButton btnCirugia;
    private GridBagConstraints gc = new GridBagConstraints();

    public LaminaMenu() {
        setLayout(new GridBagLayout());
        agregarBotones();





    }
    public Dimension getPreferredSize() {
        return new Dimension(800, 800);
    }

    public void paintComponent(Graphics g){
        try {
            BufferedImage image = ImageIO.read(new File(file));
            g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        } catch (Exception e) {
        }
        repaint();
    }

    public void agregarBotones(){

        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;



        btnDatosPersonales = new JButton("Datos Personal");
        gc.anchor = GridBagConstraints.LINE_END;
        btnDatosPersonales.setPreferredSize(new Dimension(140,50));
        btnDatosPersonales.setBackground(new Color(1, 62, 111, 65));
        btnDatosPersonales.setFont(new Font("Arial", Font.BOLD, 14));
        btnDatosPersonales.setForeground(new Color(0xC8E0DB1F, true));
        add(btnDatosPersonales,gc);


        gc.gridx = 1;
        gc.gridy = 0;
       // gc.insets = new Insets(0,50,0,0);

       // gc.anchor = GridBagConstraints.LINE_START;
        btnPacientes = new JButton("Paciente");
        btnPacientes.setPreferredSize(new Dimension(140,50));
        gc.insets = new Insets(0,0,0,15);
        btnPacientes.setBackground(new Color(1, 62, 111, 65));
        btnPacientes.setFont(new Font("Arial", Font.BOLD, 14));
        btnPacientes.setForeground(new Color(0xC8E0DB1F, true));
        add(btnPacientes,gc);

        gc.gridx = 2;
        gc.gridy = 0;
        gc.insets = new Insets(0,0,0,0);

        btnDoctores = new JButton("Doctor");
        gc.insets = new Insets(0,0,0,15);
        btnDoctores.setPreferredSize(new Dimension(140,50));
        btnDoctores.setBackground(new Color(1, 62, 111, 65));
        btnDoctores.setFont(new Font("Arial", Font.BOLD, 14));
        btnDoctores.setForeground(new Color(0xC8E0DB1F, true));
        add(btnDoctores,gc);


        gc.gridx = 3;
        gc.gridy = 0;

        btnFamiliar = new JButton("Familiar");
        btnFamiliar.setPreferredSize(new Dimension(140,50));
        btnFamiliar.setBackground(new Color(1, 62, 111, 65));
        btnFamiliar.setFont(new Font("Arial", Font.BOLD, 14));
        btnFamiliar.setForeground(new Color(0xC8E0DB1F, true));
        add(btnFamiliar,gc);


        gc.gridx = 4;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,25);
        btnReservas = new JButton("Reserva");
        btnReservas.setPreferredSize(new Dimension(140,50));
        btnReservas.setBackground(new Color(1, 62, 111, 65));
        btnReservas.setFont(new Font("Arial", Font.BOLD, 14));
        btnReservas.setForeground(new Color(0xC8E0DB1F, true));
        add(btnReservas,gc);


        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 0;
        gc.gridy = 1;
        gc.insets = new Insets(0,15,0,0);
        btnConsulta = new JButton("Consulta");
        btnConsulta.setPreferredSize(new Dimension(140,50));
        btnConsulta.setBackground(new Color(1, 62, 111, 65));
        btnConsulta.setFont(new Font("Arial", Font.BOLD, 14));
        btnConsulta.setForeground(new Color(0xC8E0DB1F, true));
        add(btnConsulta,gc);

       // gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 1;
        btnIngreso = new JButton("Ingreso");
        btnIngreso.setPreferredSize(new Dimension(140,50));
        btnIngreso.setBackground(new Color(1, 62, 111, 65));
        btnIngreso.setFont(new Font("Arial", Font.BOLD, 14));
        btnIngreso.setForeground(new Color(0xC8E0DB1F, true));
        add(btnIngreso,gc);

       // gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 2;
        gc.gridy = 1;
        btnCirugia = new JButton("Ciruguia");
        btnCirugia.setPreferredSize(new Dimension(140,50));
        btnCirugia.setBackground(new Color(1, 62, 111, 65));
        btnCirugia.setFont(new Font("Arial", Font.BOLD, 14));
        btnCirugia.setForeground(new Color(0xC8E0DB1F, true));
        add(btnCirugia,gc);


    }

    public JButton getBtnDatosPersonales() {
        return btnDatosPersonales;
    }

    public JButton getBtnReservas() {
        return btnReservas;
    }

    public JButton getBtnPacientes() {
        return btnPacientes;
    }

    public JButton getBtnDoctores() {
        return btnDoctores;
    }

    public JButton getBtnFamiliar() {
        return btnFamiliar;
    }

    public JButton getBtnConsulta() {
        return btnConsulta;
    }

    public JButton getBtnIngreso() {
        return btnIngreso;
    }

    public JButton getBtnCirugia() {
        return btnCirugia;
    }
}
