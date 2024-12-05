package net.weg.gestao_operadora.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@Table(name = "plano_servico")
public class PlanoServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer id;

    @ManyToOne
    private Plano plano;

    @NonNull
    @ManyToOne
    private ServicoAdicional servico;


}

