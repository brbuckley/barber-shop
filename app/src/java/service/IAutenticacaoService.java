package service;

import model.Usuario;

public interface IAutenticacaoService {
    public Usuario Logar(String email, String senha);   
}
