package br.com.producer.pix.converter;

import br.com.producer.pix.model.dto.SelectItemDTO;
import br.com.producer.pix.model.enums.OperacaoBancariaEnum;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProducerConverter {

    public List<SelectItemDTO> OperacaoBancariaSelectItem(List<OperacaoBancariaEnum> operacoes) {
        List<SelectItemDTO> listaAux = new ArrayList<SelectItemDTO>();
        for (OperacaoBancariaEnum operacaoBancaria : operacoes) {
            listaAux.add(new SelectItemDTO(operacaoBancaria.getCodigo(), operacaoBancaria.getDescricao()));
        }
        return listaAux;
    }
}
