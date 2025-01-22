package sl.rh.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sl.rh.modelo.Empleado;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {
}
