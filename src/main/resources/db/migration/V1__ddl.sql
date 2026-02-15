-- users: ログインユーザー（認証・権限）を管理するテーブル
CREATE TABLE users (
    -- 主キー: アプリ内部のユーザーID（自動採番の連番）
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    -- ログインに使用するユーザー名（重複禁止にする）
    username VARCHAR(100) NOT NULL UNIQUE,
    -- パスワードのハッシュ値（平文は保存しない）
    password VARCHAR(255) NOT NULL,
    -- 権限（例: ADMIN / USER など）
    -- role:列名（ユーザーの権限/役割を入れる）
    role VARCHAR(20) NOT NULL
);

-- items: 備品（在庫）マスタ
CREATE TABLE items (
    -- 主キー: 備品ID（自動採番）
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    -- 備品名
    name VARCHAR(200) NOT NULL,
    -- カテゴリ
    -- まずは文字列で保持し、必要なら将来マスタ化/ENUM化を検討
    category VARCHAR(50) NOT NULL,
    -- 在庫数（現時点の利用可能数量）
    stock INT NOT NULL
);

-- loans: 貸出ヘッダ（1回の貸出を表す）
-- 誰が借りたか / いつまでか / 状態（返却済み等）
CREATE TABLE loans (
    -- 主キー: 貸出ID（自動採番）
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    -- 借りたユーザーのID（usersテーブルの外部キー）
    user_id BIGINT NOT NULL,
    -- 返却期限（日付のみで十分なため DATE）
    due_date DATE NOT NULL,
    -- 外部キー: loans.user_id は users.id に存在する値のみ許可
    CONSTRAINT fk_loans_user FOREIGN KEY (user_id) REFERENCES users(id)
);

-- loan_items: 貸出明細（どの備品を何個借りたか）
CREATE TABLE loan_items (
    -- 主キー: 明細ID（自動採番）
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    -- 親の貸出ID（loans.idへの参照）
    loan_id BIGINT NOT NULL,
    -- 借りた備品ID（items.idへの参照）
    item_id BIGINT NOT NULL,
    -- 借りた数量
    quantity INT NOT NULL,
    -- 外部キー: 明細は必ず存在する貸出（loans）に紐づく
    CONSTRAINT fk_loan_items_loan FOREIGN KEY (loan_id) REFERENCES loans(id),
    -- 外部キー: 明細は必ず存在する備品（items）に紐づく
    CONSTRAINT fk_loan_items_item FOREIGN KEY (item_id) REFERENCES items(id)
);