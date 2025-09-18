package com.rank.SistemaRank.Person;

import com.rank.SistemaRank.Missions.MissionsModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_person")
public class PersonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private int idade;
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissionsModel missions;

    public PersonModel() {
    }

    public PersonModel(String nome,String cpf, String email, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}


