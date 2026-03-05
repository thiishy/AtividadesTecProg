package br.edu.fatecpg.consomeapi.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.fatecpg.consomeapi.model.Banco;
import br.edu.fatecpg.consomeapi.model.Endereco;

public class BancoController {
    public String inserirEndereco(String cep, String rua, String bairro, String localidade, String estado){
        String query = "INSERT INTO tb_endereco (id_endereco, cep_endereco, nm_rua_endereco, nm_bairro_endereco, nm_localidade_endereco, nm_estado_endereco) VALUES (nextval('seq_id_endereco'), ?, ?, ?, ?, ?)";

        try(var conexao = Banco.conectar()){
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, cep);
            stmt.setString(2, rua);
            stmt.setString(3, bairro);
            stmt.setString(4, localidade);
            stmt.setString(5, estado);

            stmt.execute();
            return "Endereço adicionado.";
        } catch (Exception e){
            return e.getMessage();
        }
    }

    public String selecionarEndereco(int id) {
        String query = "SELECT cep_endereco, nm_rua_endereco, nm_bairro_endereco, nm_localidade_endereco, nm_estado_endereco FROM tb_endereco WHERE id_endereco = ?";
        List<Endereco> consultas = new ArrayList<>();
        try (var conexao = Banco.conectar()) {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                consultas.add(new Endereco(rs.getString("cep_endereco"),
                        rs.getString("nm_rua_endereco"),
                        rs.getString("nm_bairro_endereco"),
                        rs.getString("nm_localidade_endereco"),
                        rs.getString("nm_estado_endereco")));
            }
            return consultas.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String selecionarTodosEnderecos() {
        String query = "SELECT cep_endereco, nm_rua_endereco, nm_bairro_endereco, nm_localidade_endereco, nm_estado_endereco FROM tb_endereco";
        List<Endereco> consultas = new ArrayList<>();
        try (var conexao = Banco.conectar()) {
            PreparedStatement stmt = conexao.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                consultas.add(new Endereco(rs.getString("cep_endereco"),
                        rs.getString("nm_rua_endereco"),
                        rs.getString("nm_bairro_endereco"),
                        rs.getString("nm_localidade_endereco"),
                        rs.getString("nm_estado_endereco")));
            }
            return consultas.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
