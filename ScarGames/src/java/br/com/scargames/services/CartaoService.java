package br.com.scargames.services;

import br.com.scargames.dao.CartaoDao;
import br.com.scargames.domain.Cartao;
import br.com.scargames.domain.Cartao;
import br.com.scargames.util.HashMaker;
import java.util.List;

public class CartaoService {
    
    private CartaoDao cartaoDao = new CartaoDao();
    
    public List<Cartao> listar(){
        return cartaoDao.listar();
    }
  
    public Cartao consultar(Integer id){
        return cartaoDao.consultar(id);
    }
   
    public Boolean inserir(Cartao cartao){
        return cartaoDao.inserir(cartao);
    }
    public Boolean alterar(Cartao cartao){
       return cartaoDao.alterar(cartao);
    }
    
    public Boolean excluir(Cartao cartao){
        return cartaoDao.excluir(cartao);
    }
    
}
