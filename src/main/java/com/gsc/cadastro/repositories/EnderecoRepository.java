package com.gsc.cadastro.repositories;

import com.gsc.cadastro.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    @Query(value ="SELECT * FROM ENDERECO WHERE pessoa_fk = :id", nativeQuery = true)
    List<Endereco> listToPessoa(Long id);

    @Query(value ="DELETE * FROM ENDERECO WHERE pessoa_fk = :id", nativeQuery = true)
    boolean deleteToPessoa(Long id);
}
