package net.weg.gestao_operadora.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Scanner;

@Entity
@Data
@NoArgsConstructor
@Table(name = "contrato")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer id;
    @Column (nullable = false)
    @NonNull
    private String data_inicio;
    @NonNull
    private String data_fim;
    @NonNull
    @ManyToOne
    private Plano plano;



}
