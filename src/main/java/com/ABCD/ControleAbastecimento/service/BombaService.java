package com.ABCD.ControleAbastecimento.service;

import com.ABCD.ControleAbastecimento.dto.bomba.BombaPut;
import com.ABCD.ControleAbastecimento.dto.bomba.BombaRequest;
import com.ABCD.ControleAbastecimento.model.Bomba;
import com.ABCD.ControleAbastecimento.repository.BombaRepository;
import com.ABCD.ControleAbastecimento.repository.TanqueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BombaService {
    private final BombaRepository bombaRepository;
    private final TanqueRepository tanqueRepository;

    public List<Bomba> listarBombas(){
        return bombaRepository.findAll();
    }

    @Transactional
    public Bomba adicionarBomba(BombaRequest bombaRequest){
        Bomba bomba = new Bomba();

        BeanUtils.copyProperties(bombaRequest, bomba);

        bomba.setTanque(tanqueRepository.findById(bombaRequest.getTanque_id()).get());

        return bombaRepository.save(bomba);
    }

    @Transactional
    public Bomba atualizarBomba(BombaPut bombaPut){
        Bomba bomba = new Bomba();

        BeanUtils.copyProperties(bombaPut, bomba);

        bomba.setTanque(tanqueRepository.findById(bombaPut.getTanque_id()).get());

        return bombaRepository.save(bomba);
    }

    @Transactional
    public Void removerBomba(Long id){
        bombaRepository.deleteById(id);
        return null;
    }
}
