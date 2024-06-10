package grafica;

import daos.doctor.DoctorDaoImp;
import daos.paciente.PacienteDaoImp;
import dto.Tablas.DoctorDto;
import dto.Tablas.PacienteDto;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LaminaRegistroDoctor extends JPanel {
    private ArrayList<DoctorDto> tablaDoctor;

    JComboBox jBoxEspecialidad;

    //---JLabels y checkbox---//
    private JLabel lblCiDoctor;
    private JLabel lblMatriculaDocotor;
    private JLabel lblTarifaConsulta;
    //---JLabels y checkbox---//

    //---JTextField---//
    JTextField txtCiDoctor;
    JTextField txtMatriculaDoctor;
    JTextField txtTarifaDoctor;
    //---JTextField---//

    //---JButton--//
    JButton btnGuardar;

    JButton btnMostrar;

    JButton btnEliminarDoctor;

    JButton btnActualizarDatos;

    JButton btnVolver;

    JButton btnConsultasAtendidas;

    //---JButton--//

    //----tablas----//
    private JTable tabla;
    private DefaultTableModel modelo;
    //----tablas----//


    private DoctorDaoImp dao;
    private GridBagConstraints gc = new GridBagConstraints();
    private String[][] matriz;



    public LaminaRegistroDoctor(DoctorDaoImp dao) {
        Border innerBorder = BorderFactory.createTitledBorder("Registrar Doctor");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        this.dao = dao;
        modelo = new DefaultTableModel();
        tabla = new JTable(modelo);

        setLayout(new GridBagLayout());
        agregarComponentes();
        btnMostrarTablaDoctorActionListener();
        btnGuardarRegistroDePacienteActionListener();
        btnEliminarDoctorActionListener();
        btnActualizarDatosActionListener();
        btnVerConsultasAtendidasActionListener();

    }

    public void agregarComponentes() {
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0.1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;


        //----Carnet----//
        gc.anchor = GridBagConstraints.LINE_END;
        lblCiDoctor = new JLabel("Ci :");
        add(lblCiDoctor, gc);
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 0;
        txtCiDoctor = new JTextField(50);
        add(txtCiDoctor , gc);
        //----Carnet----//


        //----Matricula Doctor----//
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        lblMatriculaDocotor = new JLabel("Matricula :");
        add(lblMatriculaDocotor , gc);
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 1;
        txtMatriculaDoctor = new JTextField(50);
        add(txtMatriculaDoctor , gc);
        //----Matricula Doctor----//

        //----TarifaConsulta----//
        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 0;
        gc.gridy = 2;
        lblTarifaConsulta = new JLabel("Costo Consulta :");
        add(lblTarifaConsulta, gc);
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 2;
        txtTarifaDoctor = new JTextField(50);
        add(txtTarifaDoctor , gc);

        //----TarifaConsulta----//

        //JComboBox especialidad//


        gc.gridx = 1;
        gc.gridy = 3;
        jBoxEspecialidad = new JComboBox();

        jBoxEspecialidad.addItem("Medicina Interna");
        jBoxEspecialidad.addItem("Pediatria");
        jBoxEspecialidad.addItem("Ginecologia");
        jBoxEspecialidad.addItem("Oftalmologia");
        jBoxEspecialidad.addItem("Otorrinolaringologia");
        jBoxEspecialidad.addItem("Neurologia");
        jBoxEspecialidad.addItem("Cardiologia");
        jBoxEspecialidad.addItem("Urologia");
        jBoxEspecialidad.addItem("Dermatologia");
        jBoxEspecialidad.addItem("Cirugia");
        add(jBoxEspecialidad, gc);


        //----botonGuardar----//
        gc.gridx = 1;
        gc.gridy = 4;
        btnGuardar = new JButton("Guardar");
        add(btnGuardar, gc);
        //----botonGuardar----//

        //----tabla----//

        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gc.weightx = 2;
        gc.gridx = 1;
        gc.gridy = 5;
        add(new JScrollPane(tabla), gc);
        //----tabla----//

        //----botonMostrar----//
        gc.fill = GridBagConstraints.NONE;
        gc.weightx = 0.1;
        gc.gridx = 1;
        gc.gridy = 6;
        btnMostrar = new JButton("Mostrar");
        add(btnMostrar, gc);

        //--botonElmininarDatosDeTabla---//
        gc.gridx = 1;
        gc.gridy = 7;
        btnEliminarDoctor = new JButton("Eliminar Datos");
        add(btnEliminarDoctor ,gc);
        //--botonElmininarDatosDeTabla---//

        //--boton Actualizar Datos--//
        gc.gridx = 1;
        gc.gridy = 8;
        btnActualizarDatos = new JButton("Actualizar");
        add(btnActualizarDatos,gc);
        //--boton Actualizar Datos--//

        //--boton Volver--//
        gc.gridx = 1;
        gc.gridy = 9;
        btnVolver = new JButton("Volver");
        add(btnVolver,gc);
        //--boton Volver--//

        gc.gridx = 1;
        gc.gridy = 10;
        btnConsultasAtendidas = new JButton("Ver Consultas Atendidas");
        add(btnConsultasAtendidas,gc);

        }


    public void recorrerDatos(int numero) {
        if (numero==1){
            tablaDoctor = dao.getAll();
             String titulos[] = {"ci", "Nombre Doctor", "Costo Consulta", "Matricula","Especialidad"};

            matriz = new String[tablaDoctor.size()][titulos.length];
            for (int i = 0; i < tablaDoctor.size(); i++) {
                for (int j = 0; j < titulos.length; j++) {
                    switch (j) {
                        case 0:
                            matriz[i][j] = tablaDoctor.get(i).getCiDoctor();
                            break;
                        case 1:
                            matriz[i][j] = tablaDoctor.get(i).getNombreDoctor();
                            break;
                        case 2:
                            matriz[i][j] = tablaDoctor.get(i).getCostoConsultaDoctor()+"";
                            break;
                        case 3:
                            matriz[i][j] = tablaDoctor.get(i).getMatriculaDoctor();
                            break;
                        case 4:
                            matriz[i][j] = tablaDoctor.get(i).getEspecialidad();
                            break;

                    }
                }
            }

            modelo.setDataVector(matriz, titulos);
        }

        if (numero == 2){
            tablaDoctor = dao.getAllConsultas();
            String titulos[] = {"Nombre Doctor", "Nombre Paciente", "Total Cobrado por paciente"};

            matriz = new String[tablaDoctor.size()][titulos.length];
            for (int i = 0; i < tablaDoctor.size(); i++) {
                for (int j = 0; j < titulos.length; j++) {
                    switch (j) {
                        case 0:
                            matriz[i][j] = tablaDoctor.get(i).getNombreDoctor();
                            break;
                        case 1:
                            matriz[i][j] = tablaDoctor.get(i).getNombrePaciente();
                            break;
                        case 2:
                            matriz[i][j] = tablaDoctor.get(i).getTotalCobrado();
                            break;
                    }
                }
            }

            modelo.setDataVector(matriz, titulos);
        }


    }

    public void btnMostrarTablaDoctorActionListener() {
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recorrerDatos(1);
            }
        });
    }

    public void btnActualizarDatosActionListener(){
        btnActualizarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dao.actualizar(txtCiDoctor.getText(),txtMatriculaDoctor.getText(),Integer.parseInt(txtTarifaDoctor.getText()));
            }
        });
    }

    public void btnGuardarRegistroDePacienteActionListener(){
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jBoxEspecialidad.getSelectedItem().equals("Medicina Interna")){
                    dao.registrarDoctor(txtCiDoctor.getText(),txtMatriculaDoctor.getText(),Integer.parseInt(txtTarifaDoctor.getText()),1+"");
                }
                if (jBoxEspecialidad.getSelectedItem().equals("Pediatria")){
                    dao.registrarDoctor(txtCiDoctor.getText(),txtMatriculaDoctor.getText(),Integer.parseInt(txtTarifaDoctor.getText()),2+"");
                }
                if (jBoxEspecialidad.getSelectedItem().equals("Ginecologia")){
                    dao.registrarDoctor(txtCiDoctor.getText(),txtMatriculaDoctor.getText(),Integer.parseInt(txtTarifaDoctor.getText()),3+"");
                }
                if (jBoxEspecialidad.getSelectedItem().equals("Oftalmologia")){
                    dao.registrarDoctor(txtCiDoctor.getText(),txtMatriculaDoctor.getText(),Integer.parseInt(txtTarifaDoctor.getText()),4+"");
                }
                if (jBoxEspecialidad.getSelectedItem().equals("Otorrinolaringologia")){
                    dao.registrarDoctor(txtCiDoctor.getText(),txtMatriculaDoctor.getText(),Integer.parseInt(txtTarifaDoctor.getText()),5+"");
                }
                if (jBoxEspecialidad.getSelectedItem().equals("Cardiologia")){
                    dao.registrarDoctor(txtCiDoctor.getText(),txtMatriculaDoctor.getText(),Integer.parseInt(txtTarifaDoctor.getText()),6+"");
                }
                if (jBoxEspecialidad.getSelectedItem().equals("Neurologia")){
                    dao.registrarDoctor(txtCiDoctor.getText(),txtMatriculaDoctor.getText(),Integer.parseInt(txtTarifaDoctor.getText()),7+"");
                }
                if (jBoxEspecialidad.getSelectedItem().equals("Urologia")){
                    dao.registrarDoctor(txtCiDoctor.getText(),txtMatriculaDoctor.getText(),Integer.parseInt(txtTarifaDoctor.getText()),8+"");
                }
                if (jBoxEspecialidad.getSelectedItem().equals("Dermatologia")){
                    dao.registrarDoctor(txtCiDoctor.getText(),txtMatriculaDoctor.getText(),Integer.parseInt(txtTarifaDoctor.getText()),9+"");
                }
                if (jBoxEspecialidad.getSelectedItem().equals("Cirugia")){
                    dao.registrarDoctor(txtCiDoctor.getText(),txtMatriculaDoctor.getText(),Integer.parseInt(txtTarifaDoctor.getText()),10+"");
                }




               // dao.registrarDoctor(txtCiDoctor.getText(),txtMatriculaDoctor.getText(),Integer.parseInt(txtTarifaDoctor.getText()),jBoxEspecialidad.getSelectedItem().toString());
            }
        });
    }

    public void btnEliminarDoctorActionListener(){
        btnEliminarDoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tabla.getSelectedRow();

                if (i >= 0) {
                    modelo.removeRow(i);
                    dao.borrardoctor(tablaDoctor.get(i).getCiDoctor());
                } else {
                    System.out.println("Error");
                }
            }

        });
    }



    public void btnVerConsultasAtendidasActionListener(){
        btnConsultasAtendidas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recorrerDatos(2);
            }
        });
    }


    public JButton getBtnVolver() {
        return btnVolver;
    }
}
