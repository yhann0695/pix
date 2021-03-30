package br.com.estudo.pix.model;

import br.com.estudo.pix.enums.TipoChave;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_CHAVE")
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Chave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "ID_CHAVE")
    @Getter
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO", length = 25)
    @Getter
    private TipoChave tipo;

    @Column(name = "VALOR")
    @Getter
    private String valor;

    @Column(name = "DATA_HORA_CRIACAO")
    @Getter
    private LocalDateTime dataHoraCriacao;

    public Chave(final TipoChave tipo, final String valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.dataHoraCriacao = LocalDateTime.now();
    }

}
