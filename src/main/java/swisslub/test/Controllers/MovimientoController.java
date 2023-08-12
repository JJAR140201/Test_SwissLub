package swisslub.test.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swisslub.test.DTO.MovimientosDTO;
import swisslub.test.Services.MovimientoService;

import java.util.List;

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
        return new ResponseEntity<>(movimientoList, HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<MovimientosDTO> obtenerMovimientoPorId(@PathVariable int id) {
        MovimientosDTO movimiento = movimientoService.listarPorId(id);
        if (movimiento != null) {
            return ResponseEntity.ok(movimiento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrar(@RequestBody MovimientosDTO entidad) {
        movimientoService.registrar(entidad);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Void> actualizar(@PathVariable int id, @RequestBody MovimientosDTO entidad) {
        MovimientosDTO existingMovimiento = movimientoService.listarPorId(id);
        if (existingMovimiento != null) {
            entidad.setId(id);
            movimientoService.actualizar(entidad);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        MovimientosDTO existingMovimiento = movimientoService.listarPorId(id);
        if (existingMovimiento != null) {
            movimientoService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
