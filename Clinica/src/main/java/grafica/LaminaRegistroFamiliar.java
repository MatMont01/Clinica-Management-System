package grafica;

import daos.doctor.DoctorDaoImp;
import daos.familiar.FamiliarDao;
import daos.familiar.FamiliarDaoImp;
import dto.Tablas.DoctorDto;
import dto.Tablas.FamiliarDto;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LaminaRegistroFamiliar extends JPanel {
    private ArrayList<FamiliarDto> tablaFamiliar;

    //---JLabels//
    private JLabel lblCiFamiliar;
    private JLabel lblParentescoFamiliar;

    //---JLabels //

    //---JTextField---//
    private JTextField txtCiFamiliar;
    private JTextField txtParentescoFamiliar;

    //---JTextField---//

    //---JButton--//
    JButton btnGuardar;

    JButton btnMostrar;

    JButton btnEliminarFamiliar;

    JButton btnActualizarDatos;

    JButton btnVolver;

    //---JButton--//

    //----tablas----//
    private JTable tabla;
    private DefaultTableModel modelo;
    //----tablas----//


    private FamiliarDaoImp dao;
    private GridBagConstraints gc = new GridBagConstraints();
    private String[][] matriz;
    private String titulos[] = {"ci Paciente", "Nombre Paciente","ci Familiar", "Nombre Familiar", "Parentesco"};

    public LaminaRegistroFamiliar(FamiliarDaoImp dao) {
        Border innerBorder = BorderFactory.createTitledBorder("Registrar Familiar");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        this.dao = dao;
        modelo = new DefaultTableModel();
        tabla = new JTable(modelo);

        setLayout(new GridBagLayout());
        agregarComponentes();

        btnMostrarTablaFamiliarActionListener();
        btnGuardarRegistroDeFamiliarActionListener();
        btnEliminarFamiliarActionListener();
        btnActualizarDatosActionListener();
    }


   public void agregarComponentes(){
       gc.gridx = 0;
       gc.gridy = 0;
       gc.weightx = 0.1;
       gc.weighty = 1;
       gc.fill = GridBagConstraints.NONE;

       //----Carnet----//
       gc.anchor = GridBagConstraints.LINE_END;
       lblCiFamiliar = new JLabel("Ci :");
       add(lblCiFamiliar, gc);
       gc.anchor = GridBagConstraints.LINE_START;
       gc.gridx = 1;
       gc.gridy = 0;
       txtCiFamiliar = new JTextField(50);
       add(txtCiFamiliar , gc);
       //----Carnet----//


       //----Parentesco Familiar----//
       gc.gridx = 0;
       gc.gridy = 1;
       gc.anchor = GridBagConstraints.LINE_END;
       lblParentescoFamiliar = new JLabel("Parentesco :");
       add( lblParentescoFamiliar , gc);
       gc.anchor = GridBagConstraints.LINE_START;
       gc.gridx = 1;
       gc.gridy = 1;
       txtParentescoFamiliar = new JTextField(50);
       add(txtParentescoFamiliar , gc);
       //----Parentesco Familiar----//
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
       btnEliminarFamiliar = new JButton("Eliminar Datos");
       add(btnEliminarFamiliar,gc);
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

    /**
     * Toma los datos de la base de datos y los pone en una tabla.
     */
    public void recorrerDatos() {
        tablaFamiliar = dao.getAll();

        matriz = new String[tablaFamiliar.size()][titulos.length];
        for (int i = 0; i < tablaFamiliar.size(); i++) {
            for (int j = 0; j < titulos.length; j++) {
                switch (j) {
                    case 0:
                        matriz[i][j] = tablaFamiliar.get(i).getCiPaciente();
                        break;
                    case 1:
                        matriz[i][j] = tablaFamiliar.get(i).getNombrePaciente();
                        break;
                    case 2:
                        matriz[i][j] = tablaFamiliar.get(i).getCiFamiliar();
                        break;
                    case 3:
                        matriz[i][j] = tablaFamiliar.get(i).getNombreFamiliar();
                        break;
                    case 4:
                        matriz[i][j] = tablaFamiliar.get(i).getParentesco();
                        break;
                }
            }
        }

        modelo.setDataVector(matriz, titulos);

    }
    public void btnMostrarTablaFamiliarActionListener() {
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recorrerDatos();
            }
        });
    }

    public void btnGuardarRegistroDeFamiliarActionListener(){
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dao.registrarFamiliar(txtCiFamiliar.getText(),txtParentescoFamiliar.getText());
            }
        });
    }

    public void btnEliminarFamiliarActionListener(){
        btnEliminarFamiliar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tabla.getSelectedRow();

                if (i >= 0) {
                    modelo.removeRow(i);
                    dao.borrarFamiliar(tablaFamiliar.get(i).getCi());
                } else {
                    System.out.println("Error");
                }
            }

        });
    }

    public void btnActualizarDatosActionListener(){
        btnActualizarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dao.actualizar(txtCiFamiliar.getText(),txtParentescoFamiliar.getText());
            }
        });
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }


}
