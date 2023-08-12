package swisslub.test.Services;

import java.util.List;

public interface CrudService<T> {
    public List<T> listarTodos();

    public T listarPorId(int id);

    public void registrar(T entidad);

    public void actualizar(T entidad);

    public void eliminar(int id);
}
