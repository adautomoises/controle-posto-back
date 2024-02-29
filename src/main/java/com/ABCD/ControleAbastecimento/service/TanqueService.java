package com.ABCD.ControleAbastecimento.service;

import com.ABCD.ControleAbastecimento.dto.tanque.TanquePut;
import com.ABCD.ControleAbastecimento.dto.tanque.TanqueRequest;
import com.ABCD.ControleAbastecimento.model.Tanque;
import com.ABCD.ControleAbastecimento.repository.CombustivelRepository;
import com.ABCD.ControleAbastecimento.repository.TanqueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TanqueService {
    private final TanqueRepository tanqueRepository;
    private final CombustivelRepository combustivelRepository;

    public List<Tanque> listarTanques(){
        return tanqueRepository.findAll();
    }

    @Transactional
    public Tanque adicionarTanque(TanqueRequest tanqueRequest){
        Tanque tanque = new Tanque();

        BeanUtils.copyProperties(tanqueRequest, tanque);

        tanque.setCombustivel(combustivelRepository.findById(tanqueRequest.getCombustivel_id()).get());;

        return tanqueRepository.save(tanque);
    }

    @Transactional
    public Tanque atualizarTanque(TanquePut tanquePut){
        Tanque tanque = new Tanque();

        BeanUtils.copyProperties(tanquePut, tanque);

        tanque.setCombustivel(combustivelRepository.findById(tanquePut.getCombustivel_id()).get());;

        return tanqueRepository.save(tanque);
    }

    @Transactional
    public Void removerTanque(Long id){
        tanqueRepository.deleteById(id);
        return null;
    }
}
