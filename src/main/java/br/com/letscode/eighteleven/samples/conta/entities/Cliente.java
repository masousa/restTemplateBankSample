package br.com.letscode.eighteleven.samples.conta.entities;

import lombok.Data;
import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;

}
