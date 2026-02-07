# Equipment Loan Manager（備品貸出管理）

Java 21 / Spring Boot 3.3 / Spring Security / Thymeleaf / MySQL / Docker Compose / Flyway を用いた
**備品貸出管理（オフィス備品レンタル）練習用システム**です。

- アクセス: http://localhost:8089
- DB: MySQL 8系（DB名: equip_loan / user: appuser / pass: passw0rd）
- Flyway:
  - V1: DDL
  - V2: seed
  - V3: 拡張下地（Loan.last_extended_at / LoanItem.returned_quantity）

---

## 機能

### ユーザー管理（DB）
- users テーブルにユーザーを保持
- BCryptでパスワード照合
- ROLE_ADMIN / ROLE_USER

### 備品（Item）
- name / category(enum) / stock
- category は Enum（将来 Category マスタへ移行可能）

### 貸出（Loan + LoanItem）
- 貸出単位はユーザー
- dueDate は LocalDate
- デフォルトは **7日後**
- 期限切れを強調表示

### 返却
- **全返却のみ**
- 将来一部返却の拡張下地をV3で用意

### 在庫管理（重要）
- 在庫更新は **InventoryService に完全集約**
- 在庫不足時は貸出不可
- 貸出確定で減算 / 全返却で加算
- 将来 `@Version` 導入予定（現段階は未導入）

---

## 起動方法（Docker Compose）

### 1) BCryptハッシュの準備（必須）
Flyway V2 の seed は **平文パスワードを入れません**。
そのため、以下のどちらかで BCrypt を生成して、`V2__seed.sql` の `REPLACE_WITH...` を置換してください。

- 既存の `BCryptPasswordEncoder` を使った小さな main を作る
- もしくは Spring Boot 起動後に一時的に生成する

対象ユーザー:
- admin / admin1234
- user / user1234

### 2) 起動
```bash
docker compose up -d --build
```
