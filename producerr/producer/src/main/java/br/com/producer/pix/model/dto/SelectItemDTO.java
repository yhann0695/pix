package br.com.producer.pix.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SelectItemDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 155769026460548489L;

    private String label;
    private String value;

    public SelectItemDTO() {

    }

    public SelectItemDTO(String value, String label) {
        this.label = label;
        this.value = value;
    }

}

