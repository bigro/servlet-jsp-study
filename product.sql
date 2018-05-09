DROP TABLE IF EXISTS test.product;

CREATE TABLE test.product (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  price INT NOT NULL 
);

INSERT INTO test.product (name, price) VALUES
  ('マグロ', 100),
  ('サーモン', 100),
  ('えび', 100),
  ('いか', 100),
  ('えんがわ', 100),
  ('アナゴ', 100),
  ('たまご', 100),
  ('ホタテ', 100),
  ('赤貝', 100),
  ('つぶ貝', 100),
  ('サラダ軍艦', 150),
  ('ネギトロ軍艦', 150),
  ('ネギトロ巻', 150),
  ('アボカド巻', 150),
  ('とろ', 200),
  ('いくら', 200),
  ('うに', 200);