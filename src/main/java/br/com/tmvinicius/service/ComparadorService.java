package br.com.tmvinicius.service;

import br.com.tmvinicius.model.NotaFiscal;
import org.apache.commons.collections4.IteratorUtils;

import java.util.*;
import java.util.stream.Collectors;

public class ComparadorService {

    //Pegas as notas fiscais e compara se possui valores iguais, se sim, consolida em um so valor
    public Map<String, NotaFiscal> consolidarDuplicidades(List<NotaFiscal> planilha) {
        Map<String, NotaFiscal> consolidadas = new HashMap<>();

        for (NotaFiscal nf : planilha) {
            consolidadas.merge(
                    nf.getNumeroNFe(),
                    nf,
                    (nfExistente, nfNova) -> {

                        nfExistente.setValorContabil(
                                nfExistente.getValorContabil() + nfNova.getValorContabil()
                        );
                        nfExistente.setValorICMS(
                                nfExistente.getValorICMS() + nfNova.getValorICMS()
                        );
                        return nfExistente;
                    }
            );
        }

        return consolidadas;
    }

    public void imprimirMap(Map<?, NotaFiscal> planilha) {

        for (Object chave : planilha.keySet()) {
            System.out.println("CHAVE:" + chave + " VALOR:" + planilha.get(chave));

        }
    }


}
