package br.com.estudo.pix.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SplittableRandom;


@Entity
@Table(name = "TB_CONTA")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Conta implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "ID_CONTA")
    private Long id;

    @Column(name = "NUMERO")
    @Getter
    private String numero;

    @Column(name = "SALDO")
    @Getter
    private BigDecimal saldo;

    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JoinColumn(name = "ID_CONTA")
    private List<Chave> chaves = new ArrayList<>();

    public Conta() {
        this.numero = String.valueOf(new SplittableRandom().nextInt(9999999)) + String.valueOf(new SplittableRandom().nextInt(9));
        this.saldo = BigDecimal.ZERO;
    }

    public List<Chave> getChaves() {
        return Collections.unmodifiableList(chaves);
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

}