package swisslub.test.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swisslub.test.DTO.MovimientosDTO;
import swisslub.test.Repository.MovimientoRopository;
import swisslub.test.Services.MovimientoService;

import java.util.List;

@Service
public class MovimientoServiceImpl implements MovimientoService {
    @Autowired
    private MovimientoRopository repo;
    @Override
    public List<MovimientosDTO> listarTodos() {
        return repo.findAll();
    }

    @Override
    public MovimientosDTO listarPorId(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void registrar(MovimientosDTO entidad) {
        repo.save(entidad);
    }

    @Override
    public void actualizar(MovimientosDTO entidad) {
        repo.save(entidad);
    }

    @Override
    public void eliminar(int id) {
        repo.deleteById(id);
    }
}
