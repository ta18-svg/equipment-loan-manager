package com.example.equipmentloan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // このクラスを「JPAのエンティティ（=DBのテーブルと対応するクラス）」として扱う
@Table(name = "loan_items") // 対応するテーブル名を loan_items に固定（クラス名LoanItem→loan_item等の自動推測に頼らない）   
@Getter // Lombok：全フィールドのgetterを自動生成
@NoArgsConstructor // Lombok：引数なしコンストラクタを自動生成（JPAは基本的に引数なしコンストラクタが必要）
public class LoanItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID自動生成戦略をIDENTITYに設定
    private Long id; // 貸出アイテムID（主キー）

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan; // 貸出（Loanエンティティへの参照）

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item; // 備品（Itemエンティティへの参照）

    private Integer quantity; // 貸出数量
}
