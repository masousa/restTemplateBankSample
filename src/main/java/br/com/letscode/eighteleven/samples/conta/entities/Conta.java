package br.com.letscode.eighteleven.samples.conta.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "conta")
@Data
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String agencia;
    @Column(name = "numero_conta")
    private String numeroConta;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @Column(name = "tipo_conta")
    private TipoConta tipoConta;
}
