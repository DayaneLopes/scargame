package br.com.scargames.services;

import br.com.scargames.dao.BandeiraDao;
import br.com.scargames.domain.Bandeira;
import br.com.scargames.domain.Usuario;
import br.com.scargames.util.HashMaker;
import java.util.List;

public class BandeiraService {
    
    private BandeiraDao bandeiraDao = new BandeiraDao();
    
    public List<Bandeira> listar(){
        return bandeiraDao.listar();
    }
  
    public Bandeira consultar(Integer id){
        return bandeiraDao.consultar(id);
    }
   
    public Boolean inserir(Bandeira bandeira){
        return bandeiraDao.inserir(bandeira);
    }
    public Boolean alterar(Bandeira bandeira){
       return bandeiraDao.alterar(bandeira);
    }
    
    public Boolean excluir(Bandeira bandeira){
        return bandeiraDao.excluir(bandeira);
    }
    
}





