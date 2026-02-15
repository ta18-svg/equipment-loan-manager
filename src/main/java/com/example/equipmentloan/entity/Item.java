package com.example.equipmentloan.entity;

import com.example.equipmentloan.enumtype.ItemCategory;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;

@Entity // このクラスを「JPAのエンティティ（=DBのテーブルと対応するクラス）」として扱う
@Table(name = "items") // 対応するテーブル名を items に固定（クラス名Item→item等の自動推測に頼らない）  
@Getter // Lombok：全フィールドのgetterを自動生成（getId(), getName() など）
@NoArgsConstructor // Lombok：引数なしコンストラクタを自動生成（JPAは基本的に引数なしコンストラクタが必要）
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID自動生成戦略をIDENTITYに設定
    private Long id; // 備品ID（主キー）

    private String name; // 備品名

    @Enumerated(EnumType.STRING)
    private ItemCategory category; // 備品カテゴリ（Enum）

    private Integer stock; // 在庫数

}
