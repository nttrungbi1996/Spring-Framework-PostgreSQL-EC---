-- 各種テーブル削除
DROP VIEW IF EXISTS v_enquiries;
DROP VIEW IF EXISTS v_order_details;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS order_details;
DROP TABLE IF EXISTS enquiries;
DROP TABLE IF EXISTS enquiries_category;
-- カテゴリーテーブル
CREATE TABLE categories
(
   id SERIAL PRIMARY KEY,
   name TEXT,
   image TEXT
);
-- 商品テーブル
CREATE TABLE items
(
   id SERIAL PRIMARY KEY,
   category_id INTEGER,
   image TEXT,
   name TEXT,
   price INTEGER,
   cmt INTEGER
);
-- 顧客テーブル
CREATE TABLE customers
(
   id SERIAL PRIMARY KEY,
   name TEXT,
   address TEXT,
   tel TEXT,
   email TEXT,
   password TEXT
);
-- 注文テーブル
CREATE TABLE orders
(
   id SERIAL PRIMARY KEY,
   customer_id INTEGER,
   ordered_on DATE,
   total_price INTEGER
);
-- 注文明細テーブル
CREATE TABLE order_details
(
   id SERIAL PRIMARY KEY,
   order_id INTEGER,
   item_id INTEGER,
   quantity INTEGER
);
-- 注文明細ビュー
CREATE VIEW v_order_details AS
(
   SELECT
      d.id,
      d.order_id,
      d.item_id,
      d.quantity,
      i.name,
      i.price
   FROM
      order_details d
   JOIN items i ON d.item_id = i.id
);
-- 問い合わせのテーブル
CREATE TABLE enquiries
(
   id SERIAL PRIMARY KEY,
   customer_id TEXT,
   enquiries_category_id INTEGER,
   details TEXT
);
-- 問い合わせの種類のテーブル
CREATE TABLE enquiries_category
(
   id SERIAL PRIMARY KEY,
   name TEXT
);
-- 問い合わせビュー
CREATE VIEW v_enquiries AS
(
   SELECT
      e.id,
      e.customer_id,
      ec.name,
      e.details
   FROM
      enquiries e
   JOIN enquiries_category ec ON ec.id = e.enquiries_category_id
);