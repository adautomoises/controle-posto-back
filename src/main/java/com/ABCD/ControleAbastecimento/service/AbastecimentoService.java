package com.ABCD.ControleAbastecimento.service;

import com.ABCD.ControleAbastecimento.dto.abastecimento.AbastecimentoRequest;
import com.ABCD.ControleAbastecimento.model.Abastecimento;
import com.ABCD.ControleAbastecimento.repository.AbastecimentoRepository;
import com.ABCD.ControleAbastecimento.repository.BombaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AbastecimentoService {
    private final AbastecimentoRepository abastecimentoRepository;
    private final BombaRepository bombaRepository;

    public List<Abastecimento> listarAbastecimentos(){ return abastecimentoRepository.findAll();}


    @Transactional
    public Abastecimento fazerAbastecimento(AbastecimentoRequest abastecimentoRequest){
        Abastecimento abastecimento = new Abastecimento();

        BeanUtils.copyProperties(abastecimentoRequest, abastecimento);

        abastecimento.setImposto(abastecimentoRequest.getValor().multiply(new BigDecimal("0.13")));
        abastecimento.setTanque(bombaRepository.findById(abastecimentoRequest.getBomba_id()).get().getTanque());

        return abastecimentoRepository.save(abastecimento);
    }
}
