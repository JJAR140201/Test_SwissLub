package swisslub.test.Controllers;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swisslub.test.DTO.MovimientoDetalle;
import swisslub.test.Services.MovimientoDetalleService;

import java.util.List;

@RestController
@RequestMapping("/movimiento-detalle")
public class MovimientoDetalleController {

    private final MovimientoDetalleService movimientoDetalleService;

    @Autowired
    public MovimientoDetalleController(MovimientoDetalleService movimientoDetalleService) {
        this.movimientoDetalleService = movimientoDetalleService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MovimientoDetalle>> listarTodos() {
        List<MovimientoDetalle> movimientoDetalleList = movimientoDetalleService.listarTodos();
        return new ResponseEntity<>(movimientoDetalleList, HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<MovimientoDetalle> listarPorId(@PathVariable int id) {
        MovimientoDetalle movimientoDetalle = movimientoDetalleService.listarPorId(id);
        if (movimientoDetalle != null) {
            return new ResponseEntity<>(movimientoDetalle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrar(@RequestBody MovimientoDetalle entidad) {
        movimientoDetalleService.registrar(entidad);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Void> actualizar(@PathVariable int id, @RequestBody MovimientoDetalle entidad) {
        if (entidad.id != id) {
            return ResponseEntity.badRequest().build(); // El ID en la URL y en la entidad no coinciden
        }

        MovimientoDetalle existingMovimientoDetalle = movimientoDetalleService.listarPorId(id);
        if (existingMovimientoDetalle != null) {
            movimientoDetalleService.actualizar(entidad);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
