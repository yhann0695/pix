package br.com.producer.pix.service;

import br.com.producer.pix.converter.ProducerConverter;
import br.com.producer.pix.exceptions.MensagemException;
import br.com.producer.pix.model.dto.OperacaoBancariaDTO;
import br.com.producer.pix.model.dto.SelectItemDTO;
import br.com.producer.pix.model.enums.OperacaoBancariaEnum;
import br.com.producer.pix.utils.Mensagens;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class ProducerService {

    @Autowired
    private ProducerConverter producerConverter;

    private static final String EX_OPERACOES_BANCARIAS = "OperacoesBancarias";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public OperacaoBancariaDTO salvarMensagem(OperacaoBancariaDTO operacao) {
        try {
            String json = new ObjectMapper().writeValueAsString(operacao);

            rabbitTemplate.convertAndSend(EX_OPERACOES_BANCARIAS, operacao.getOperacaoBancaria().getValue(), json);

        } catch (JsonProcessingException e) {
            throw new MensagemException(Mensagens.MSG_ERRO_ESCRITA_BROKER);
        }
        return operacao;
    }

    @Transactional
    public List<SelectItemDTO> recuperarItens() {
        List<OperacaoBancariaEnum> operacoes = Arrays.asList(OperacaoBancariaEnum.values());
        return producerConverter.OperacaoBancariaSelectItem(operacoes);
    }
}
