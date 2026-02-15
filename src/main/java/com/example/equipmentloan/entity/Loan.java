package com.example.equipmentloan.entity;

import java.time.LocalDate;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;

@Entity // このクラスを「JPAのエンティティ（=DBのテーブルと対応するクラス）」として扱う
@Table(name = "loans") // 対応するテーブル名を loans に固定（クラス名Loan→loan等の自動推測に頼らない）
@Getter // Lombok：全フィールドのgetterを自動生成（getId(), getUserId() など）
@NoArgsConstructor // Lombok：引数なしコンストラクタを自動生成（JPAは基本的に引数なしコンストラクタが必要）
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID自動生成戦略をIDENTITYに設定
    private Long id; // 貸出ID（主キー）

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // 多対一のリレーションを定義（多くの貸出が1人の利用者に属する）
    @JoinColumn(name = "user_id",
                nullable = false, // 外部キー列の名前を user_id に固定、null不可
                foreignKey = @ForeignKey(name = "fk_loan_user") // 外部キー制約の名前を fk_loan_user に固定
    )
    private User user; // 利用者（Userエンティティへの参照）

    private LocalDate dueDate; // 返却予定日
}
