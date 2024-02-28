package com.ABCD.ControleAbastecimento.service;

import com.ABCD.ControleAbastecimento.dto.abastecimento.AbastecimentoRequest;
import com.ABCD.ControleAbastecimento.dto.tanque.TanquePut;
import com.ABCD.ControleAbastecimento.model.Abastecimento;
import com.ABCD.ControleAbastecimento.repository.AbastecimentoRepository;
import com.ABCD.ControleAbastecimento.repository.BombaRepository;
import com.ABCD.ControleAbastecimento.repository.RelatorioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AbastecimentoService {
    private final AbastecimentoRepository abastecimentoRepository;
    private final BombaRepository bombaRepository;
    private final RelatorioService relatorioService;
    private final RelatorioRepository relatorioRepository;
    private final TanqueService tanqueService;

    public List<Abastecimento> listarAbastecimentos(){ return abastecimentoRepository.findAll();}


    @Transactional
    public Abastecimento fazerAbastecimento(AbastecimentoRequest abastecimentoRequest){
        Abastecimento abastecimento = new Abastecimento();

        BeanUtils.copyProperties(abastecimentoRequest, abastecimento);
        var bomba = bombaRepository.findById(abastecimentoRequest.getBomba_id()).get();
        var tanque = bomba.getTanque();

        BigDecimal valorCombustivel = tanque.getCombustivel().getValor();
        BigDecimal valorAbastecido = abastecimentoRequest.getValor();
        BigDecimal litros = valorAbastecido.divide(valorCombustivel, RoundingMode.HALF_UP);

        abastecimento.setBomba(bomba);
        abastecimento.setLitros(litros);
        abastecimento.setImposto(abastecimentoRequest.getValor().multiply(new BigDecimal("0.13")));

        try {
            TanquePut tanquePut = new TanquePut();
            tanquePut.setId(tanque.getId());
            tanquePut.setCombustivel_id(tanque.getCombustivel().getId());
            tanquePut.setCapacidade(tanque.getCapacidade().subtract(litros));

            tanqueService.atualizarTanque(tanquePut);
        } catch (Exception exception) {
            throw new RuntimeException("Não foi possível atualizar o valor do tanque", exception);
        }

        relatorioRepository.save(relatorioService.convertSuppliesToReport(abastecimento));

        return abastecimentoRepository.save(abastecimento);
    }
}
