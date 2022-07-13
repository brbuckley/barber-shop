package service;

import java.util.List;
import model.Servicos;

public interface IServicoService {
    public List<Servicos> Recuperar();
    public void Salvar(Servicos servico);
    public void Deletar(int id);
}
