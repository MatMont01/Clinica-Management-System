package grafica;

import daos.paciente.PacienteDaoImp;
import dto.Tablas.PacienteDto;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LaminaRegistroPaciente extends JPanel {
    private ArrayList<PacienteDto> tablaPaciente;

    //---JLabels y checkbox---//
    private JLabel lblCiPaciente;
    private JLabel lblNombreAseguradoraPaciente;
    private JCheckBox checkAlergiasPaciente;
    private JCheckBox checkEsParticularPaciente;
    private JLabel numeroSeguroPaciente;
    //---JLabels y checkbox---//

    //---JTextField---//
    JTextField txtCiPaciente;
    JTextField txtNombreAseguradoraPaciente;

    JTextField txtNumeroDeseguroPaciente;
    //---JTextField---//

    //---JButton--//
    JButton btnGuardar;
    JButton btnMostrar;

    JButton btnEliminarPaciente;

    JButton btnActualizarDatos;

    JButton btnVolver;

    //---JButton--//

    //----tablas----//
    private JTable tabla;
    private DefaultTableModel modelo;
    //----tablas----//


    private PacienteDaoImp dao;
    private GridBagConstraints gc = new GridBagConstraints();
    private String[][] matriz;
    private String titulos[] = {"ci", "nombreAseguradora", "esParticular", "esAlergico", "numeroSeguro"};

    public LaminaRegistroPaciente(PacienteDaoImp dao) {
        Border innerBorder = BorderFactory.createTitledBorder("Registrar Paciente");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        this.dao = dao;

        modelo = new DefaultTableModel();
        tabla = new JTable(modelo);

        setLayout(new GridBagLayout());
        agregarComponentes();
        btnMostrarTablaPacienteActionListener();
        btnGuardarRegistroDePacienteActionListener();
        btnEliminarPacienteActionListener();
        btnActualizarDatosActionListener();


    }

    public void agregarComponentes() {
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0.1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;


        //----Carnet----//
        gc.anchor = GridBagConstraints.LINE_END;
        lblCiPaciente = new JLabel("Ci :");
        add(lblCiPaciente, gc);
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 0;
        txtCiPaciente = new JTextField(50);
        add(txtCiPaciente, gc);
        //----Carnet----//


        //----NombreDeAseguradora----//
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        lblNombreAseguradoraPaciente = new JLabel("Asegruradora :");
        add(lblNombreAseguradoraPaciente, gc);
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 1;
        txtNombreAseguradoraPaciente = new JTextField(50);
        add(txtNombreAseguradoraPaciente, gc);
        //----NombreDeAseguradora----//

        //----EsParticilarCheckBox----//
        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 0;
        gc.gridy = 2;
        checkEsParticularPaciente = new JCheckBox("EsParticular");
        add(checkEsParticularPaciente, gc);
        //----EsParticilarCheckBox----//

        //----EsAlergicoCheckBox----//
        gc.gridx = 0;
        gc.gridy = 3;
        checkAlergiasPaciente = new JCheckBox("EsAlergico");
        add(checkAlergiasPaciente, gc);
        //----EsAlergicoCheckBox----//

        //----NumeroDeSeguro----//
        gc.anchor = GridBagConstraints.LINE_END;

        gc.gridx = 0;
        gc.gridy = 4;
        lblNombreAseguradoraPaciente = new JLabel("Num Asegurado :");
        add(lblNombreAseguradoraPaciente, gc);
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 4;
        txtNumeroDeseguroPaciente = new JTextField(50);
        add(txtNumeroDeseguroPaciente, gc);

        //----NumeroDeSeguro----//

        //----botonGuardar----//
        gc.gridx = 1;
        gc.gridy = 5;
        btnGuardar = new JButton("Guardar");
        add(btnGuardar, gc);
        //----botonGuardar----//

        //----tabla----//

        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gc.weightx = 2;
        gc.gridx = 1;
        gc.gridy = 6;
        add(new JScrollPane(tabla), gc);
        //----tabla----//

        //----botonMostrar----//
        gc.fill = GridBagConstraints.NONE;
        gc.weightx = 0.1;
        gc.gridx = 1;
        gc.gridy = 7;
        btnMostrar = new JButton("Mostrar");
        add(btnMostrar, gc);

        //--botonElmininarDatosDeTabla---//
        gc.gridx = 1;
        gc.gridy = 8;
        btnEliminarPaciente = new JButton("Eliminar Datos");
        add(btnEliminarPaciente,gc);
        //--botonElmininarDatosDeTabla---//

        //--boton Actualizar Datos--//
        gc.gridx = 1;
        gc.gridy = 9;
        btnActualizarDatos = new JButton("Actualizar");
        add(btnActualizarDatos,gc);
        //--boton Actualizar Datos--//

        //--boton Volver--//
        gc.gridx = 1;
        gc.gridy = 10;
        btnVolver = new JButton("Volver");
        add(btnVolver,gc);
        //--boton Volver--//

    }

    public void recorrerDatos() {
        tablaPaciente = dao.getAll();

        matriz = new String[tablaPaciente.size()][titulos.length];
        for (int i = 0; i < tablaPaciente.size(); i++) {
            for (int j = 0; j < titulos.length; j++) {
                switch (j) {
                    case 0:
                        matriz[i][j] = tablaPaciente.get(i).getCiPaciente();
                        break;
                    case 1:
                        matriz[i][j] = tablaPaciente.get(i).getNombreAseguradoraPaciente();
                        break;
                    case 2:
                        matriz[i][j] = tablaPaciente.get(i).isEsParticular() + "";
                        break;
                    case 3:
                        matriz[i][j] = tablaPaciente.get(i).isEsAlergico() + "";
                        break;
                    case 4:
                        matriz[i][j] = tablaPaciente.get(i).getNumeroSeguro();
                        break;
                }
            }
        }

        modelo.setDataVector(matriz, titulos);

    }

    public void btnMostrarTablaPacienteActionListener() {
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recorrerDatos();
            }
        });
    }

    public void btnGuardarRegistroDePacienteActionListener(){
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dao.registrarPaciete(txtCiPaciente.getText(),txtNombreAseguradoraPaciente.getText(),checkEsParticularPaciente.isSelected(), checkAlergiasPaciente.isSelected(), txtNumeroDeseguroPaciente.getText());
            }
        });
    }


    public void btnActualizarDatosActionListener(){
        btnActualizarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dao.actualizar(txtCiPaciente.getText(),txtNombreAseguradoraPaciente.getText(),checkEsParticularPaciente.isSelected(), checkAlergiasPaciente.isSelected(),txtNumeroDeseguroPaciente.getText());
            }
        });
    }

    public void btnEliminarPacienteActionListener(){
        btnEliminarPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tabla.getSelectedRow();

                if (i >= 0) {
                    modelo.removeRow(i);
                    dao.borrarPaciente(tablaPaciente.get(i).getCiPaciente());
                } else {
                    System.out.println("Error");
                }
            }

        });
    }




    public JLabel getLblCiPaciente() {
        return lblCiPaciente;
    }

    public JLabel getLblAseguradoraPaciente() {
        return lblNombreAseguradoraPaciente;
    }

    public JCheckBox getCheckAlergiasPaciente() {
        return checkAlergiasPaciente;
    }

    public JCheckBox getCheckEsParticularPaciente() {
        return checkEsParticularPaciente;
    }

    public JLabel getNumeroSeguroPaciente() {
        return numeroSeguroPaciente;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnMostrar() {
        return btnMostrar;
    }

    public JButton getBtnEliminarPaciente() {
        return btnEliminarPaciente;
    }

    public JButton getBtnActualizarDatos() {
        return btnActualizarDatos;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }
}
