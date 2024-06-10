package grafica;

import daos.persona.PersonaDaoImp;
import dto.Tablas.PersonaDto;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LaminaRegistroPersona extends JPanel {
    ArrayList<PersonaDto> tablaPersona;
    //----Labels----//
    private JLabel lblCi;
    private JLabel lblNombre;
    private JLabel lblApellidoPaterno;
    private JLabel lblApellidoMaterno;
    private JLabel lblTelefono;
    private JLabel lblCorreo;
    //----Labels----//

    //----JtextFields----//
    private JTextField txtCi;
    private JTextField txtNombre;
    private JTextField txtApellidoPaterno;
    private JTextField txtApellidoMaterno;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    //----JtextFields----//

    //----botones----//
    JButton btnGuardar;
    JButton btnMostrarTodosLosDatosPersonales;

    JButton btnEliminarPersona;

    JButton btnActualizarDatos;
    JButton btnVolver;
    //----botones----//

    //----tablas----//
    private JTable tabla;
    private DefaultTableModel modelo;
    //----tablas----//

    private PersonaDaoImp dao;

    private GridBagConstraints gc = new GridBagConstraints();

    private String[][]matriz;
    private String titulos[] = {"Ci", "Nombre", "ApellidoPaterno", "ApellidoMaterno","Telefono","Correo"};

    public LaminaRegistroPersona(PersonaDaoImp dao) {
        Border innerBorder = BorderFactory.createTitledBorder("Datos Personales");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        this.dao = dao;
        modelo = new DefaultTableModel();
        tabla = new JTable(modelo);




        setLayout(new GridBagLayout());
        agregarComponentes();

        //ActionListener
        btnMostrarTablaPersona();
        btnEliminarPersona();
        btnGuardarPersona();
        btnActualizarPersona();
    }



    public void agregarComponentes() {
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0.1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        //Carnet
        gc.anchor = GridBagConstraints.LINE_END;
        lblCi = new JLabel("Carnet :");
        add(lblCi, gc);


        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 0;
        txtCi = new JTextField(50);
        add(txtCi, gc);

        //Nombre
        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 0;
        gc.gridy = 1;
        lblNombre = new JLabel("Nombre :");
        add(lblNombre, gc);

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 1;
        txtNombre = new JTextField(50);
        add(txtNombre, gc);

        //Apellido Paterno
        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 0;
        gc.gridy = 2;
        lblApellidoPaterno = new JLabel("Apellido Paterno:");
        add(lblApellidoPaterno, gc);

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 2;
        txtApellidoPaterno = new JTextField(50);
        add(txtApellidoPaterno, gc);

        //Apellido Materno
        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 0;
        gc.gridy = 3;
        lblApellidoMaterno = new JLabel("Apellido Materno :");
        add(lblApellidoMaterno, gc);
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 3;
        txtApellidoMaterno = new JTextField(50);
        add(txtApellidoMaterno, gc);

        //telefono
        gc.gridx = 0;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_END;
        lblTelefono = new JLabel("Telefono :");
        add(lblTelefono, gc);
        gc.gridx = 1;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_START;
        txtTelefono = new JTextField(50);
        add(txtTelefono, gc);

        //correo
        gc.gridx = 0;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_END;
        lblCorreo = new JLabel("Correo :");
        add(lblCorreo, gc);
        gc.gridx = 1;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_START;
        txtCorreo = new JTextField(50);
        add(txtCorreo, gc);

        //boton Guardar

        gc.gridx = 1;
        gc.gridy = 6;

        btnGuardar = new JButton("Guardar");
        add(btnGuardar, gc);

        //tabla

        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gc.weightx =2;
        gc.gridx = 1;
        gc.gridy = 7;
        add(new JScrollPane(tabla),gc);

        //boton mostrar

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;

        btnMostrarTodosLosDatosPersonales = new JButton("Mostrar");
        gc.gridx = 1;
        gc.gridy = 9;
        add(btnMostrarTodosLosDatosPersonales, gc);


        //boton eliminar datos
        btnEliminarPersona = new JButton("Eliminar Datos");
        gc.gridx = 1;
        gc.gridy = 10;
        add(btnEliminarPersona, gc);

        //boton actualizar
        btnActualizarDatos= new JButton("Actualizar");
        gc.gridx = 1;
        gc.gridy = 11;
        add(btnActualizarDatos, gc);


        //boton volver
        btnVolver= new JButton("Volver");
        gc.gridx = 1;
        gc.gridy = 12;
        add(btnVolver, gc);


    }
    public void btnMostrarTablaPersona(){
     btnMostrarTodosLosDatosPersonales.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             recorrerDatos();
         }
     });
    }
    public void btnGuardarPersona(){
         btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dao.registrarPersona(getTxtCi().getText(),getTxtNombre().getText(),getTxtApellidoPaterno().getText(),getTxtApellidoMaterno().getText(),
                        getTxtTelefono().getText(),getTxtCorreo().getText());
                borrarCampostxt();
            }
        });
    }

    public void btnEliminarPersona(){
        btnEliminarPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tabla.getSelectedRow();

                if (i >= 0) {
                    modelo.removeRow(i);
                    dao.borrarPersona(tablaPersona.get(i).getCi());
                } else {
                    System.out.println("Error");
                }
            }

        });
    }

    public void btnActualizarPersona(){
        btnActualizarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtCi.getText().equals(null )&& !txtNombre.getText().equals(null) && !txtApellidoPaterno.getText().equals(null)&&!txtApellidoMaterno.getText().equals(null)&& !txtTelefono.getText().equals(null)&&!txtCorreo.getText().equals(null)){
                    dao.actualizar(txtCi.getText(),txtNombre.getText(),txtApellidoPaterno.getText(),txtApellidoMaterno.getText(),txtTelefono.getText(),txtCorreo.getText());
                    System.out.println("sasa");
                }else{
                    JOptionPane.showMessageDialog(null,"no se puede actializar");
                }

            }
        });
    }

    public void recorrerDatos(){
        tablaPersona = dao.getAll();

        matriz = new String[tablaPersona.size()][titulos.length];
        for (int i = 0; i < tablaPersona.size(); i++) {
            for (int j = 0; j < titulos.length; j++) {
                switch (j) {
                    case 0:
                        matriz[i][j] = tablaPersona.get(i).getCi();
                        break;
                    case 1:
                        matriz[i][j] = tablaPersona.get(i).getNombre();
                        break;
                    case 2:
                        matriz[i][j] = tablaPersona.get(i).getApellidoPaterno();
                        break;
                    case 3:
                        matriz[i][j] = tablaPersona.get(i).getApellidoMaterno();
                        break;
                    case 4:
                        matriz[i][j] = tablaPersona.get(i).getTelefono();
                        break;
                    case 5:
                        matriz[i][j] = tablaPersona.get(i).getCorreo();
                }
            }
        }

        modelo.setDataVector(matriz, titulos);

    }

    public void borrarCampostxt(){
        getTxtCi().setText("");
        getTxtNombre().setText("");
        getTxtApellidoPaterno().setText("");
        getTxtApellidoMaterno().setText("");
        getTxtTelefono().setText("");
        getTxtCorreo().setText("");
    }

    public JTextField getTxtCi() {
        return txtCi;
    }

    public void setTxtCi(JTextField txtCi) {
        this.txtCi = txtCi;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtApellidoPaterno() {
        return txtApellidoPaterno;
    }

    public void setTxtApellidoPaterno(JTextField txtApellidoPaterno) {
        this.txtApellidoPaterno = txtApellidoPaterno;
    }

    public JTextField getTxtApellidoMaterno() {
        return txtApellidoMaterno;
    }

    public void setTxtApellidoMaterno(JTextField txtApellidoMaterno) {
        this.txtApellidoMaterno = txtApellidoMaterno;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(JTextField txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public JTextField getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(JTextField txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JButton getBtnMostrarTodosLosDatosPersonales() {
        return btnMostrarTodosLosDatosPersonales;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }
}
