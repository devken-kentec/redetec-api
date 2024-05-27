package br.com.kentec.redetec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.redetec.domain.TipoVacina;
import br.com.kentec.redetec.repository.TipoVacinaRepository;

@Service
public class TipoVacinaService {

    @Autowired
    private TipoVacinaRepository tvr;

    public Optional<TipoVacina> findById(Long id){
        return tvr.findById(id);
    }

    public Iterable<TipoVacina> findAll(){
        return tvr.findAll();
    }

    public TipoVacina save(TipoVacina tipoVacina){
        return tvr.save(tipoVacina);
    }

    public TipoVacina update(TipoVacina tipoVacina){
        Optional<TipoVacina> _tipoVacina = tvr.findById(tipoVacina.getId());
        if (_tipoVacina.isPresent()) {
            _tipoVacina.get().setId(tipoVacina.getId());
            _tipoVacina.get().setDescricao(tipoVacina.getDescricao());
            _tipoVacina.get().setValor(tipoVacina.getValor());
            _tipoVacina.get().setStatus(tipoVacina.getStatus());            
        }
        return tvr.save(_tipoVacina.get());
    }

    public TipoVacina delete(String status, long id){
        System.out.println(status + " - " + id);
        Optional<TipoVacina> tipoVacina = tvr.findById(id);
        if (tipoVacina.isPresent()) {
            tipoVacina.get().setStatus(status);
        }
        return tvr.save(tipoVacina.get());
    }

}
