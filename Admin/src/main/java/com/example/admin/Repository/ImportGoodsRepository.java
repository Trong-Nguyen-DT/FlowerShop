package com.example.admin.Repository;

import com.example.admin.Entity.ImportGoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportGoodsRepository extends JpaRepository<ImportGoodsEntity, Long> {
//    List<String> findItemNamesByTerm(String term);
}
