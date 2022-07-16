package service;

import java.util.List;
import model.Usuario;

public interface IUsuarioService {
    public List<Usuario> Recuperar(String tipo);
    public void Salvar(Usuario usuario, String tipo);
    public void Deletar(int id);
}
