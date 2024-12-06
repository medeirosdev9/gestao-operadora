package net.weg.gestao_operadora.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "servico_adicional")
public class ServicoAdicional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer id;
    @Column(nullable = false)

    @NonNull
    private String descricao;

    @NonNull
    private double custo_mensal;

    @OneToMany(mappedBy = "servico")
    private List<PlanoServico> planos = new ArrayList<>();
}
