package grafica;

import com.toedter.calendar.JDateChooser;
import daos.cirugia.CirugiaDaoImp;
import daos.consulta.ConsultaDaoImp;
import daos.doctor.DoctorDaoImp;
import daos.familiar.FamiliarDaoImp;
import daos.ingreso.IngresoDaoImp;
import daos.paciente.PacienteDaoImp;
import daos.persona.PersonaDaoImp;
import daos.reserva.ReservaDao;
import daos.reserva.ReservaDaoImp;
import dto.Tablas.FamiliarDto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {

    //-----Jpanel-----//
    private LaminaContenedora laminaContenedora;
    private LaminaMenu laminaMenu;
    private LaminaRegistroPersona laminaRegistroPersona;
    private LaminaRegistroPaciente laminaRegistroPaciente;
    private LaminaRegistroDoctor laminaRegistroDoctor;
    private LaminaRegistroFamiliar laminaRegistroFamiliar;
    private LaminaReserva laminaReserva;

    private LaminaConsulta laminaConsulta;
    private LaminaIngreso laminaIngreso;
    private LaminaCirugia laminaCirugia;


    //-----JPanel-----//


    //-----Daos-----//
    private PersonaDaoImp dao;
    private PacienteDaoImp daoPaciente;
    private DoctorDaoImp daoDoctor;
    private FamiliarDaoImp daoFamiliar;
    private ReservaDaoImp daoReserva;
    private ConsultaDaoImp daoConsulta;
    private IngresoDaoImp daoIngreso;
    private CirugiaDaoImp daoCirugia;

    //-----Daos-----//

    public Ventana() {


        init();
        laminaMenu.getBtnDatosPersonales().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLaminaRegistroPersona();
            }
        });
        laminaMenu.getBtnPacientes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLaminaRegistroPaciente();
            }
        });
        laminaMenu.getBtnDoctores().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLaminaRegistroDoctor();
            }
        });
        laminaMenu.getBtnFamiliar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLaminaRegistroFamiliar();
            }
        });
        laminaMenu.getBtnReservas().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLaminaReservas();
            }
        });
        laminaMenu.getBtnConsulta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLaminaConsulta();
            }
        });
        laminaMenu.getBtnIngreso().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLaminaIngreso();
            }
        });
        laminaMenu.getBtnCirugia().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLaminaCirugia();
            }
        });


        btnVolverDePersonas();
        btnVolverPacientes();
        btnVolverDoctor();
        btnVolverFamiliar();
        btnVolverReserva();
        btnVolverConsulta();
        btnVolverIngreso();
        btnVolverCirugia();


    }

    public void init() {
        dao = new PersonaDaoImp();
        daoPaciente = new PacienteDaoImp();
        daoDoctor = new DoctorDaoImp();
        daoFamiliar = new FamiliarDaoImp();
        daoReserva = new ReservaDaoImp();
        daoConsulta = new ConsultaDaoImp();
        daoIngreso = new IngresoDaoImp();
        daoCirugia = new CirugiaDaoImp();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        agregarPaneles();
        agregarLaminasAContenedora();
        laminaContenedora.card.show(laminaContenedora, "1");

        add(laminaContenedora);
        setVisible(true);
        this.pack();
    }

    public void agregarPaneles() {
        laminaContenedora = new LaminaContenedora();
        laminaMenu = new LaminaMenu();
        laminaRegistroPersona = new LaminaRegistroPersona(dao);
        laminaRegistroPaciente = new LaminaRegistroPaciente(daoPaciente);
        laminaRegistroDoctor = new LaminaRegistroDoctor(daoDoctor);
        laminaRegistroFamiliar = new LaminaRegistroFamiliar(daoFamiliar);
        laminaReserva = new LaminaReserva(daoReserva);
        laminaConsulta = new LaminaConsulta(daoConsulta);
        laminaIngreso = new LaminaIngreso(daoIngreso);
        laminaCirugia = new LaminaCirugia(daoCirugia);

    }

    public void agregarLaminasAContenedora() {
        laminaContenedora.add(laminaMenu, "1");
        laminaContenedora.add(laminaRegistroPersona, "2");
        laminaContenedora.add(laminaRegistroPaciente, "3");
        laminaContenedora.add(laminaRegistroDoctor, "4");
        laminaContenedora.add(laminaRegistroFamiliar, "5");
        laminaContenedora.add(laminaReserva, "6");
        laminaContenedora.add(laminaConsulta, "7");
        laminaContenedora.add(laminaIngreso, "8");
        laminaContenedora.add(laminaCirugia, "9");


    }

    public void mostrarLaminaRegistroPersona() {
        laminaContenedora.card.show(laminaContenedora, "2");
    }

    public void mostrarLaminaRegistroPaciente() {
        laminaContenedora.card.show(laminaContenedora, "3");
    }

    public void mostrarLaminaRegistroDoctor() {
        laminaContenedora.card.show(laminaContenedora, "4");
    }

    public void mostrarLaminaRegistroFamiliar() {
        laminaContenedora.card.show(laminaContenedora, "5");
    }

    public void mostrarLaminaReservas() {
        laminaContenedora.card.show(laminaContenedora, "6");
    }

    public void mostrarLaminaConsulta() {
        laminaContenedora.card.show(laminaContenedora, "7");
    }

    public void mostrarLaminaIngreso() {
        laminaContenedora.card.show(laminaContenedora, "8");
    }

    public void mostrarLaminaCirugia() {
        laminaContenedora.card.show(laminaContenedora, "9");
    }

    public void btnVolverDePersonas() {
        laminaRegistroPersona.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                laminaContenedora.card.show(laminaContenedora, "1");
            }
        });
    }

    public void btnVolverPacientes() {
        laminaRegistroPaciente.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                laminaContenedora.card.show(laminaContenedora, "1");
            }
        });
    }

    public void btnVolverDoctor() {
        laminaRegistroDoctor.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                laminaContenedora.card.show(laminaContenedora, "1");
            }
        });
    }

    public void btnVolverFamiliar() {
        laminaRegistroFamiliar.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                laminaContenedora.card.show(laminaContenedora, "1");
            }
        });
    }

    public void btnVolverReserva() {
        laminaReserva.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                laminaContenedora.card.show(laminaContenedora, "1");
            }
        });
    }

    public void btnVolverConsulta() {
        laminaConsulta.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                laminaContenedora.card.show(laminaContenedora, "1");
            }
        });
    }

    public void btnVolverIngreso() {
        laminaIngreso.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                laminaContenedora.card.show(laminaContenedora, "1");
            }
        });
    }

    public void btnVolverCirugia() {
        laminaCirugia.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                laminaContenedora.card.show(laminaContenedora, "1");
            }
        });
    }


}
