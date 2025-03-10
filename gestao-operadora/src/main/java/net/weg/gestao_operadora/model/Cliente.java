package net.weg.gestao_operadora.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer id;
    @Column (nullable = false)
    @NonNull
    private String nome;
    @NonNull
    private String email;
    @NonNull
    private String telefone;
    @ManyToOne
    private Plano plano;
}
