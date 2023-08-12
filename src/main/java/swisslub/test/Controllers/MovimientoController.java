package swisslub.test.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swisslub.test.DTO.MovimientosDTO;
import swisslub.test.Services.MovimientoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movimiento")
public class MovimientoController {

    private final MovimientoService movimientoService;

    @Autowired
    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MovimientosDTO>> listarTodos() {
        List<MovimientosDTO> movimientoList = movimientoService.listarTodos();
        return ResponseEntity.ok(movimientoList);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<MovimientosDTO> obtenerMovimientoPorId(@PathVariable int id) {
        Optional<MovimientosDTO> movimiento = Optional.ofNullable(movimientoService.listarPorId(id));
        return movimiento.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrar(@RequestBody MovimientosDTO entidad) {
        movimientoService.registrar(entidad);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Object> actualizar(@PathVariable int id, @RequestBody MovimientosDTO entidad) {
        Optional<MovimientosDTO> existingMovimiento = Optional.ofNullable(movimientoService.listarPorId(id));
        return existingMovimiento.map(mov -> {
            entidad.setId(id);
            movimientoService.actualizar(entidad);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable int id) {
        Optional<MovimientosDTO> existingMovimiento = Optional.ofNullable(movimientoService.listarPorId(id));
        return existingMovimiento.map(mov -> {
            movimientoService.eliminar(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
