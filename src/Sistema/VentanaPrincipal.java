package Sistema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Map;
import java.util.Random;

public class VentanaPrincipal extends JFrame {
    private GestorAcademico gestor;

    public VentanaPrincipal() {
        gestor = new GestorAcademico();
        setTitle("Gestión Académica");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        inicializarComponentes();
    }

    private void inicializarComponentes() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 1));

        JButton btnRegistrarAlumno = new JButton("Registrar Alumno");
        btnRegistrarAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarAlumno();
            }
        });

        // Botón para mostrar alumnos registrados
        JButton btnMostrarAlumnos = new JButton("Mostrar Alumnos");
        btnMostrarAlumnos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarAlumnos();
            }
        });

        // Botón para inscribirse a cursadas
        JButton btnInscribirseCursada = new JButton("Inscribirse a Cursada");
        btnInscribirseCursada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inscribirseCursada();
            }
        });

        // Botón para consultar inscripciones
        JButton btnConsultarInscripciones = new JButton("Consultar Inscripciones");
        btnConsultarInscripciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarInscripciones();
            }
        });

        // Botón para consultar cronograma
        JButton btnConsultarCronograma = new JButton("Consultar Cronograma");
        btnConsultarCronograma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarCronograma();
            }
        });

        // Botón para consultar notas
        JButton btnConsultarNotas = new JButton("Consultar Notas");
        btnConsultarNotas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarNotas();
            }
        });

        // Botón para consultar materias regulares
        JButton btnConsultarMaterias = new JButton("Consultar Materias Regulares");
        btnConsultarMaterias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarMateriasRegulares();
            }
        });

        // Botón para consultar agenda de clases
        JButton btnConsultarAgenda = new JButton("Consultar Agenda de Clases");
        btnConsultarAgenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarAgendaClases();
            }
        });

        // Botón para salir
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Agregar botones al panel
        panel.add(btnRegistrarAlumno);
        panel.add(btnMostrarAlumnos);
        panel.add(btnInscribirseCursada);
        panel.add(btnConsultarInscripciones);
        panel.add(btnConsultarCronograma);
        panel.add(btnConsultarNotas);
        panel.add(btnConsultarMaterias);
        panel.add(btnConsultarAgenda);
        panel.add(btnSalir);

        // Agregar panel a la ventana
        add(panel);
    }

    private void registrarAlumno() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del alumno:");
        String email = JOptionPane.showInputDialog(this, "Ingrese el email del alumno:");
        if (nombre != null && email != null) {
            Alumno alumno = new Alumno(nombre, email);
            gestor.registrarUsuario(alumno);
            JOptionPane.showMessageDialog(this, "Alumno registrado con éxito.");
        }
    }

    private void mostrarAlumnos() {
        StringBuilder listaAlumnos = new StringBuilder("Alumnos registrados:\n");
        for (Usuario usuario : gestor.getUsuarios()) {
            if (usuario instanceof Alumno) {
                listaAlumnos.append("- ").append(usuario.getNombre()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(this, listaAlumnos.toString());
    }

    private void inscribirseCursada() {
        Usuario usuario = seleccionarAlumno();
        if (usuario instanceof Alumno) {
            String materias = JOptionPane.showInputDialog(this, "Ingrese las materias separadas por comas:");
            if (materias != null && !materias.trim().isEmpty()) {
                ((Alumno) usuario).inscribirseACursada(materias);
                JOptionPane.showMessageDialog(this, "Inscripción realizada con éxito.");
            } else {
                JOptionPane.showMessageDialog(this, "No se ingresaron materias.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se seleccionó un alumno válido.");
        }
    }

    private void consultarInscripciones() {
        Usuario usuario = seleccionarAlumno();
        if (usuario instanceof Alumno) {
            StringBuilder inscripciones = new StringBuilder("Materias inscritas:\n");
            for (Map.Entry<String, LocalDate> entry : ((Alumno) usuario).getMateriasInscritas().entrySet()) {
                inscripciones.append("- ").append(entry.getKey())
                             .append(" (Fecha de inscripción: ").append(entry.getValue()).append(")\n");
            }
            JOptionPane.showMessageDialog(this, inscripciones.toString());
        } else {
            JOptionPane.showMessageDialog(this, "No se seleccionó un alumno válido.");
        }
    }

    private void consultarCronograma() {
        Usuario usuario = seleccionarAlumno();
        if (usuario instanceof Alumno) {
            StringBuilder cronograma = new StringBuilder("Cronograma de evaluaciones:\n");
            for (Map.Entry<String, LocalDate> entry : ((Alumno) usuario).getMateriasInscritas().entrySet()) {
                cronograma.append("- ").append(entry.getKey())
                          .append(": ").append(entry.getValue()).append("\n");
            }
            JOptionPane.showMessageDialog(this, cronograma.toString());
        } else {
            JOptionPane.showMessageDialog(this, "No se seleccionó un alumno válido.");
        }
    }

    private void consultarNotas() {
        Usuario usuario = seleccionarAlumno();
        if (usuario instanceof Alumno) {
            Alumno alumno = (Alumno) usuario;
            Random random = new Random();
            for (String materia : alumno.getMateriasInscritas().keySet()) {
                int nota = random.nextInt(10) + 1; // Generar nota aleatoria entre 1 y 10
                alumno.getNotasMaterias().put(materia, nota);
            }
            StringBuilder notas = new StringBuilder("Notas de evaluaciones:\n");
            for (Map.Entry<String, Integer> entry : alumno.getNotasMaterias().entrySet()) {
                notas.append("- ").append(entry.getKey())
                     .append(": ").append(entry.getValue()).append("\n");
            }
            JOptionPane.showMessageDialog(this, notas.toString());
        } else {
            JOptionPane.showMessageDialog(this, "No se seleccionó un alumno válido.");
        }
    }

    private void consultarMateriasRegulares() {
        Usuario usuario = seleccionarAlumno();
        if (usuario instanceof Alumno) {
            StringBuilder materias = new StringBuilder("Materias regulares:\n");
            for (String materia : ((Alumno) usuario).getMateriasInscritas().keySet()) {
                materias.append("- ").append(materia).append("\n");
            }
            JOptionPane.showMessageDialog(this, materias.toString());
        } else {
            JOptionPane.showMessageDialog(this, "No se seleccionó un alumno válido.");
        }
    }

    private void consultarAgendaClases() {
        Usuario usuario = seleccionarAlumno();
        if (usuario instanceof Alumno) {
            Alumno alumno = (Alumno) usuario;
            Random random = new Random();
            String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
            for (String materia : alumno.getMateriasInscritas().keySet()) {
                String dia = dias[random.nextInt(dias.length)];
                alumno.getDiasCursada().put(materia, dia);
            }
            StringBuilder agenda = new StringBuilder("Agenda de clases:\n");
            for (Map.Entry<String, String> entry : alumno.getDiasCursada().entrySet()) {
                agenda.append("- ").append(entry.getKey())
                      .append(": ").append(entry.getValue()).append("\n");
            }
            JOptionPane.showMessageDialog(this, agenda.toString());
        } else {
            JOptionPane.showMessageDialog(this, "No se seleccionó un alumno válido.");
        }
    }

    private Usuario seleccionarAlumno() {
        String[] nombresAlumnos = gestor.getUsuarios().stream()
                .filter(usuario -> usuario instanceof Alumno)
                .map(Usuario::getNombre)
                .toArray(String[]::new);

        if (nombresAlumnos.length == 0) {
            JOptionPane.showMessageDialog(this, "No hay alumnos registrados.");
            return null;
        }

        String seleccion = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione un alumno:",
                "Seleccionar Alumno",
                JOptionPane.PLAIN_MESSAGE,
                null,
                nombresAlumnos,
                nombresAlumnos[0]
        );

        if (seleccion != null) {
            return gestor.getUsuarios().stream()
                    .filter(usuario -> usuario.getNombre().equalsIgnoreCase(seleccion))
                    .findFirst()
                    .orElse(null);
        }

        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}
