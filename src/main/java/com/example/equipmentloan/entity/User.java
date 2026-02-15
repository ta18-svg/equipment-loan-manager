package com.example.equipmentloan.entity;

import com.example.equipmentloan.enumtype.RoleType;

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
@Table(name = "users") // 対応するテーブル名を users に固定（クラス名User→user等の自動推測に頼らない）
@Getter // Lombok：全フィールドのgetterを自動生成（getId(), getUsername() など）
@NoArgsConstructor // Lombok：引数なしコンストラクタを自動生成（JPAは基本的に引数なしコンストラクタが必要）
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID自動生成戦略をIDENTITYに設定
    // 主キーの採番方法：DBのAUTO_INCREMENTに任せる（MySQLの id BIGINT AUTO_INCREMENT と整合）
    private Long id; // ユーザーID（主キー）
    // users.username に対応（このままだとカラム制約が未指定なので、実務では @Column(nullable=false, length=100, unique=true) 等を付けるとDDLと揃えやすい）
    private String username;
    // users.password に対応（パスワードは平文ではなくBCryptなどの「ハッシュ文字列」を保存する想定）
    private String password;

    // role（enum）をDBに保存する方法：enum名を文字列で保存する（例："ROLE_ADMIN"）
    // ※ ORDINAL(数字)だと並び替えで事故るので、実務ではSTRINGが基本推奨
    @Enumerated(EnumType.STRING)
    // users.role に対応（DDLが role VARCHAR(20) NOT NULL なら、ROLE_ADMIN/ROLE_USER のような文字列が入る）
    private RoleType role;
}
