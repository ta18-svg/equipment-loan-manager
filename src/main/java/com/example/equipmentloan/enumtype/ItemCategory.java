package com.example.equipmentloan.enumtype;


/**
 * 備品カテゴリ（Enum）
 * 将来 Category マスタテーブルに移行可能なように、DBは文字列保持にする。
 */
//enum は “決まった選択肢だけを扱うための型”
public enum ItemCategory {
    PC,
    MONITOR,
    KEYBOARD,
    MOUSE,
    HEADSET,
    CABLE,
    ADAPTER,
    STATIONARY,
    OTHER   
}
