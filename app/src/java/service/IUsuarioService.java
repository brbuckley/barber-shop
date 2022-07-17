package service;

import java.util.List;
import model.Administrador;
import model.Barbeiro;
import model.Cliente;
import model.Usuario;

public interface IUsuarioService {
    public List<Cliente> RecuperarCliente();
    public List<Administrador> RecuperarAdmin();
    public List<Barbeiro> RecuperarBarbeiro();
    public void Salvar(Usuario usuario, String tipo);
    public void Deletar(int id, String tipo);
}
