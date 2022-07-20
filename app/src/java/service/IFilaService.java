package service;

import java.util.List;
import model.Fila;

public interface IFilaService {
    public List<Fila> ObterFilas();  
    public Fila ObterFila(int id);  
    public void AlteraStatusFila(int id, String status);
    int ObterFilaDoBarbeiro(int id);
}
