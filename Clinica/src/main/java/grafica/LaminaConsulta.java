package grafica;

import com.toedter.calendar.JDateChooser;
import daos.consulta.ConsultaDaoImp;
import daos.reserva.ReservaDaoImp;
import dto.Tablas.ConsultaDto;
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

public class LaminaConsulta extends JPanel {


    ArrayList<ConsultaDto> tablaConsulta;


    //----JLabel----//
    JLabel lblIdReserva;
    JLabel lblDetalleDeConsulta;

    //----JLabel----//

    //----JTextField----//
    JTextField txtIdReserva;

    JTextArea jArea;
    //----JTextField----//

    //---JButton----//
    JButton btnGuardar;

    JButton btnMostrar;

    JButton btnEliminarConsulta;

    JButton btnActualizarDatos;


    JButton btnVolver;
    //---JButton----//

    //----JCalendar----//
    JDateChooser dateConsulta;

    //----JCalendar----//

    //----tablas----//
    private JTable tabla;
    private DefaultTableModel modelo;
    //----tablas----//

    private ConsultaDaoImp dao;

    private GridBagConstraints gc = new GridBagConstraints();

    private String[][] matriz;
    private String titulos[];

    public LaminaConsulta(ConsultaDaoImp dao) {
        Border innerBorder = BorderFactory.createTitledBorder("Registrar Consulta");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        setLayout(new GridBagLayout());

        this.dao = dao;
        modelo = new DefaultTableModel();
        tabla = new JTable(modelo);
        agregarComponentes();

        btnMostrarDatosConsutasPendientesActionListener();
        btnGuardarConsultaActionListener();

    }

    public void agregarComponentes() {
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0.1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;


        lblIdReserva= new JLabel("Id Reserva");
        add(lblIdReserva, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        txtIdReserva = new JTextField(50);
        add(txtIdReserva, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        lblDetalleDeConsulta = new JLabel("Detalle de Consulta");
        add(lblDetalleDeConsulta, gc);


        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        jArea = new JTextArea(5, 50);
        add(jArea, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.fill = GridBagConstraints.BOTH;
        gc.anchor = GridBagConstraints.LINE_END;
        dateConsulta = new JDateChooser();
        add(dateConsulta, gc);

        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.NONE;
        gc.gridx = 1;
        gc.gridy = 3;
        btnGuardar = new JButton("Guardar");
        add(btnGuardar, gc);

        gc.gridx = 1;
        gc.gridy = 3;

        //----tabla----//

        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.BOTH;
        gc.weightx = 2;
        gc.gridx = 1;
        gc.gridy = 4;
        add(new JScrollPane(tabla), gc);
        //----tabla----//


        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 1;
        gc.gridy = 5;
        btnMostrar = new JButton("Consultas/reserva pendiente");
        add(btnMostrar, gc);

      //  gc.gridx = 1;
      //  gc.gridy = 6;
       // btnEliminarConsulta = new JButton("Eliminar Consulta");
      //  add(btnEliminarConsulta, gc);

     //   gc.gridx = 1;
     //   gc.gridy = 7;
    //    btnActualizarDatos = new JButton("Actualizar Datos");

    //    add(btnActualizarDatos, gc);


        gc.gridx = 1;
        gc.gridy = 8;

        btnVolver = new JButton("Volver");
        add(btnVolver, gc);


    }


    public void recorrerDatos() {
        titulos = new String[]{"Id","fecha Captura","fecha reserva","nombre doctor","nombre paciente","detalle consulta"};
        tablaConsulta = dao.getAll();
        matriz = new String[tablaConsulta.size()][titulos.length];
        for (int i = 0; i < tablaConsulta.size(); i++) {
            for (int j = 0; j < titulos.length; j++) {
                switch (j) {
                    case 0:
                        matriz[i][j] = tablaConsulta.get(i).getId();
                        break;
                    case 1:
                        matriz[i][j] = tablaConsulta.get(i).getFechaCaptura();
                        break;
                    case 2:
                      matriz[i][j] = tablaConsulta.get(i).getFechaReserva();
                        break;
                    case 3:
                        matriz[i][j] = tablaConsulta.get(i).getNombreDoctor();
                        break;
                    case 4:
                        matriz[i][j] = tablaConsulta.get(i).getNombrePaciente();
                        break;
                    case 5:
                        matriz[i][j] = tablaConsulta.get(i).getObservaciones();
                        break;

                }
            }
        }

        modelo.setDataVector(matriz, titulos);

    }

    public void limpiar() {
        txtIdReserva.setText("");
        jArea.setText("");
        dateConsulta.setDate(null);
    }

    public void btnMostrarDatosConsutasPendientesActionListener() {
            btnMostrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    recorrerDatos();
                }
            });

    }

    public void btnGuardarConsultaActionListener(){
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = dateConsulta.getDate();
                String format = formatter.format(date1);
                dao.registrarConsulta(Integer.parseInt(txtIdReserva.getText()), jArea.getText(), format);

            }
        });
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }
}










