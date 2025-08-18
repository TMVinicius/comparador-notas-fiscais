package br.com.tmvinicius;


import br.com.tmvinicius.model.NotaFiscal;
import br.com.tmvinicius.service.ComparadorService;
import br.com.tmvinicius.util.LeitorExcel;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        LeitorExcel leitor = new LeitorExcel();

        List<NotaFiscal> planilhaBrut = leitor.criar();

        ComparadorService con = new ComparadorService();

        Map duplicados = con.consolidarDuplicidades(planilhaBrut);

        con.imprimirMap(duplicados);


    }
}