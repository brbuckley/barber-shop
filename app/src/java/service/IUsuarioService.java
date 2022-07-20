package service;

import java.util.List;
import model.Administrador;
import model.Funcionario;
import model.Cliente;
import model.Usuario;

public interface IUsuarioService {
    public Cliente RecuperarClientePorId(int id);
    public List<Cliente> RecuperarCliente();
    public List<Administrador> RecuperarAdmin();
    public List<Funcionario> RecuperarFuncionario();
    public void Salvar(Usuario usuario, String tipo);
    public void Deletar(int id, String tipo);
}
