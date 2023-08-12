package swisslub.test.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swisslub.test.DTO.MovimientoDetalle;
import swisslub.test.Repository.MovimientosDetallesReposiroty;
import swisslub.test.Services.MovimientoDetalleService;

import java.util.List;

@Service
public class MovimientoDetalleServiceImpl implements MovimientoDetalleService {

    @Autowired
    private MovimientosDetallesReposiroty repo;
    @Override
    public List<MovimientoDetalle> listarTodos() {
        return repo.findAll();
    }

    @Override
    public MovimientoDetalle listarPorId(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void registrar(MovimientoDetalle entidad) {
        repo.save(entidad);
    }

    @Override
    public void actualizar(MovimientoDetalle entidad) {
        repo.save(entidad);
    }

    @Override
    public void eliminar(int id) {
        repo.deleteById(id);
    }
}
