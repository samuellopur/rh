package sl.rh.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import sl.rh.modelo.Empleado;
import sl.rh.servicio.EmpleadoServicio;
import sl.rh.servicio.IEmpleadoServicio;

import java.util.List;

@RestController
@RequestMapping("rh-app") //http://localhost:8080/rh-app/
@CrossOrigin(value = "http://localhost:3000")
public class EmpleadoControlador {
    private static final Logger logger = LoggerFactory.getLogger(EmpleadoControlador.class);

    private final IEmpleadoServicio empleadoServicio;

    public EmpleadoControlador(EmpleadoServicio empleadoServicio) {
        this.empleadoServicio = empleadoServicio;
    }

    @GetMapping("/empleados")
    public List<Empleado> obtenerEmpleados(){
        List<Empleado> empleados = empleadoServicio.listarEmpleados();
        empleados.forEach(empleado -> logger.info(empleado.toString()));
        return empleados;
    }

    @PostMapping("/empleados")
    public Empleado agregarEmpleado(@RequestBody Empleado empleado){
        logger.info("Empleado a agregar: " + empleado);
        return empleadoServicio.guardarEmpleado(empleado);
    }
}
