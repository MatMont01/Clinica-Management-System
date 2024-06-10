package grafica;

import com.toedter.calendar.JDateChooser;

import daos.reserva.ReservaDaoImp;

import dto.Tablas.ReservaDto;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class LaminaReserva extends JPanel {


    ArrayList<ReservaDto> tablaReserva;


    //----JLabel----//
    JLabel lblDoctor;
    JLabel lblPaciente;
    JLabel lblObservaciones;
    //----JLabel----//

    //----JTextField----//
    JTextField txtDoctor;
    JTextField txtPaciente;
    JTextField txtObservaciones;

    JTextField txtIdParaActualizar;

    //----JTextField----//


    //----JCalendar----//
    JDateChooser dateCaptura;
    JDateChooser dateReserva;
    //----JCalendar----//


    //---JButton----//
    JButton btnGuardar;

    JButton btnMostrar;

    JButton btnEliminarReserva;

    JButton btnActualizarDatos;


    JButton btnVolver;


    //----JButton----//

    //----tablas----//
    private JTable tabla;
    private DefaultTableModel modelo;
    //----tablas----//

    private ReservaDaoImp dao;

    private GridBagConstraints gc = new GridBagConstraints();

    private String[][] matriz;
    private String titulos[] ;


    public LaminaReserva(ReservaDaoImp dao) {
        Border innerBorder = BorderFactory.createTitledBorder("Reservas");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        this.dao = dao;
        modelo = new DefaultTableModel();
        tabla = new JTable(modelo);
        setLayout(new GridBagLayout());


        agregarComponentes();
        btnMostrarTablaReservaActionListener();
        btnGuardarRegistroDePacienteActionListener();
        btnEliminarReservaActionListener();
        btnActualizarDatosActionListener();



    }

    public void agregarComponentes() {
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0.1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;

        //---campo doctor---//
        lblDoctor = new JLabel("Doctor :");
        add(lblDoctor, gc);
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        txtDoctor = new JTextField(50);
        add(txtDoctor, gc);

        //---campo paciente---//
        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 0;
        gc.gridy = 1;
        lblPaciente = new JLabel("Paciente :");
        add(lblPaciente, gc);
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 1;
        txtPaciente = new JTextField(50);
        add(txtPaciente, gc);
        //---campo observaciones---//
        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 0;
        gc.gridy = 2;
        lblObservaciones = new JLabel("Observaciones :");
        add(lblObservaciones, gc);
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 2;
        txtObservaciones = new JTextField(50);
        add(txtObservaciones, gc);

        //--Campo fecha--//
        gc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gc.gridx = 1;
        gc.gridy = 3;
        dateCaptura = new JDateChooser();


        add(dateCaptura, gc);
        gc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gc.gridx = 1;
        gc.gridy = 4;
        dateReserva = new JDateChooser();


        add(dateReserva, gc);


        gc.fill = GridBagConstraints.NONE;
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
        gc.gridx = 2;
        gc.gridy = 7;
        btnMostrar = new JButton("Mostrar");
        add(btnMostrar, gc);

        //--botonElmininarDatosDeTabla---//
        gc.gridx = 2;
        gc.gridy = 8;
        btnEliminarReserva = new JButton("Eliminar Datos");
        add(btnEliminarReserva, gc);
        //--botonElmininarDatosDeTabla---//

        //--boton Actualizar Datos--//
        gc.gridx = 2;
        gc.gridy = 9;

        btnActualizarDatos = new JButton("Actualizar");

        add(btnActualizarDatos, gc);
        gc.gridx = 2;
        gc.gridy = 10;
        txtIdParaActualizar = new JTextField(10);

        add(txtIdParaActualizar, gc);
        //--boton Actualizar Datos--//



        //--boton Volver--//

        gc.gridx = 1;
        gc.gridy = 7;
        btnVolver = new JButton("Volver");
        add(btnVolver, gc);
        //--boton Volver--//

    }


    public void recorrerDatos() {
        //titulos = new String []{"Id", "Doctor", "Paciente", "Observaciones", "Fecha Captura","Fecha Reserva"};
        titulos = new String []{"Id","fechaCaptura","fechaReserva","Ci Doctor","Nombre Doctor","Nombre Paciente","Ci Paciente","Observaciones"};

            tablaReserva = dao.getAll();



        matriz = new String[tablaReserva.size()][titulos.length];
        for (int i = 0; i < tablaReserva.size(); i++) {
            for (int j = 0; j < titulos.length; j++) {
                switch (j) {
                    case 0:
                        matriz[i][j] = tablaReserva.get(i).getId();
                        break;
                    case 1:
                        matriz[i][j] = tablaReserva.get(i).getFechaCaptura();
                        break;
                    case 2:
                        matriz[i][j] = tablaReserva.get(i).getFechaReserva();
                        break;
                    case 3:
                        matriz[i][j] = tablaReserva.get(i).getCi_doctor();
                        break;
                    case 4:
                        matriz[i][j] = tablaReserva.get(i).getNombreDoctor();
                        break;
                    case 5:
                        matriz[i][j] = tablaReserva.get(i).getNombrePaciente();
                        break;
                    case 6:
                        matriz[i][j] = tablaReserva.get(i).getCi_paciente();
                        break;
                    case 7:
                        matriz[i][j] = tablaReserva.get(i).getObservaciones();
                        break;

                }
            }
        }

        modelo.setDataVector(matriz, titulos);

    }

    public void btnMostrarTablaReservaActionListener() {
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recorrerDatos();
            }
        });
    }



    public void btnGuardarRegistroDePacienteActionListener() {
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = dateCaptura.getDate();
                String format = formatter.format(date1);
                System.out.println(format);

                SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
                Date date2 = dateReserva.getDate();
                String format2 = formatter.format(date2);
                System.out.println(format2);



                dao.registrarReserva(txtDoctor.getText(), txtPaciente.getText(), txtObservaciones.getText(), format,format2);
            }
        });
    }

    public void btnEliminarReservaActionListener() {
        btnEliminarReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tabla.getSelectedRow();

                if (i >= 0) {
                    modelo.removeRow(i);
                    dao.borrarReserva(tablaReserva.get(i).getId());
                } else {
                    System.out.println("Error");
                }
            }

        });
    }

    public void btnActualizarDatosActionListener() {
        btnActualizarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = dateCaptura.getDate();
                String format = formatter.format(date1);

                SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
                Date date2 = dateReserva.getDate();
                String format2 = formatter.format(date2);

                dao.actualizar(txtIdParaActualizar.getText(), txtDoctor.getText(), txtPaciente.getText(), txtObservaciones.getText(), format,format2);
            }
        });
    }



    public JButton getBtnVolver() {
        return btnVolver;
    }
}
