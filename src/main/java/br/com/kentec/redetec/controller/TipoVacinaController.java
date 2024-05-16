package br.com.kentec.redetec.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.redetec.domain.TipoVacina;
import br.com.kentec.redetec.service.TipoVacinaService;

@RestController
@RequestMapping("rede-tecnologia/api/tipoVacina/v1")
public class TipoVacinaController {

    @Autowired
    private TipoVacinaService tvs;

    @GetMapping("/recuperar/{id}")
    public ResponseEntity<Optional<TipoVacina>> listarUm(@PathVariable("id") long id){
        return ResponseEntity.ok(tvs.findById(id));
    }

    @GetMapping("/listarTipoVacina")
    public ResponseEntity<Iterable<TipoVacina>> listarTodos(){
        return ResponseEntity.ok(tvs.findAll());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public TipoVacina gravar(@RequestBody TipoVacina tipoVacina){
        return tvs.save(tipoVacina);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public TipoVacina update(@RequestBody TipoVacina tipoVacina){
        return tvs.update(tipoVacina);
    }

    @PatchMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public TipoVacina delete(@RequestBody String status, @PathVariable("id") long id){
        return tvs.delete(status, id);
    }

}
