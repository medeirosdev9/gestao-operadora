package net.weg.gestao_operadora.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.pl.NIP;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plano")
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer id;
    @Column(nullable = false)

    @NonNull
    private String operadora;

    @NonNull
    private String nome;

    @NonNull
    private double quantidade_dados;

    @NonNull
    private double quantidade_dados_bonus;

    @NonNull
    private String beneficios;

    @NonNull
    private double valor;

    @NonNull
    @OneToMany(mappedBy = "plano")
    private List<Cliente> clientes = new ArrayList<>();

    @OneToMany(mappedBy = "plano")
    private List<PlanoServico> planos = new ArrayList<>();

}
