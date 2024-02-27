package com.ABCD.ControleAbastecimento.service;

import com.ABCD.ControleAbastecimento.dto.abastecimento.AbastecimentoRequest;
import com.ABCD.ControleAbastecimento.model.Abastecimento;
import com.ABCD.ControleAbastecimento.repository.AbastecimentoRepository;
import com.ABCD.ControleAbastecimento.repository.BombaRepository;
import com.ABCD.ControleAbastecimento.repository.RelatorioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AbastecimentoService {

    @Autowired
    private final AbastecimentoRepository abastecimentoRepository;
    @Autowired
    private final BombaRepository bombaRepository;

    @Autowired
    private final RelatorioService relatorioService;
    @Autowired
    private final RelatorioRepository relatorioRepository;

    public List<Abastecimento> listarAbastecimentos(){ return abastecimentoRepository.findAll();}


    @Transactional
    public Abastecimento fazerAbastecimento(AbastecimentoRequest abastecimentoRequest){
        Abastecimento abastecimento = new Abastecimento();

        BeanUtils.copyProperties(abastecimentoRequest, abastecimento);

        BigDecimal valorCombustivel = bombaRepository.findById(abastecimentoRequest.getBomba_id()).get().getTanque().getCombustivel().getValor();
        BigDecimal valorAbastecido = abastecimentoRequest.getValor();
        BigDecimal litros = valorAbastecido.divide(valorCombustivel, RoundingMode.HALF_UP);

        abastecimento.setBomba(bombaRepository.getReferenceById(abastecimentoRequest.getBomba_id()));
        abastecimento.setLitros(litros);
        abastecimento.setImposto(abastecimentoRequest.getValor().multiply(new BigDecimal("0.13")));

        relatorioRepository.save(relatorioService.convertSuppliesToReport(abastecimento));

        return abastecimentoRepository.save(abastecimento);
    }
}
