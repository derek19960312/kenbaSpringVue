
-- 刪除資料
SET SQL_SAFE_UPDATES=0;
DELETE FROM recipe_ingredient;
DELETE FROM recipe;
DELETE FROM ingredient;
SET SQL_SAFE_UPDATES=1;

-- reset increment
SET FOREIGN_KEY_CHECKS = 0; -- 關閉外鍵限制
TRUNCATE TABLE recipe_ingredient;
TRUNCATE TABLE recipe;
TRUNCATE TABLE ingredient;
SET FOREIGN_KEY_CHECKS = 1; -- 開啟外鍵限制

INSERT INTO ingredient (name, unit) VALUES ('雞蛋','顆');
INSERT INTO ingredient (name, unit) VALUES ('油','g');
INSERT INTO ingredient (name, unit) VALUES ('麵粉','g');
INSERT INTO ingredient (name, unit) VALUES ('糖','g');
INSERT INTO ingredient (name, unit) VALUES ('抹茶粉','g');
INSERT INTO ingredient (name, unit) VALUES ('奶油','g');
INSERT INTO ingredient (name, unit) VALUES ('鮮奶油','g');

INSERT INTO recipe (name, count) VALUES ('蘋果派','30');
INSERT INTO recipe (name, count) VALUES ('戚風蛋糕','500');
INSERT INTO recipe (name, count) VALUES ('黑森林蛋糕','1000');


INSERT INTO recipe_ingredient (ingredient_id, recipe_id, ri_count, ri_price) VALUES('1','1','2','16');
INSERT INTO recipe_ingredient (ingredient_id, recipe_id, ri_count, ri_price) VALUES('3','1','200','50');
INSERT INTO recipe_ingredient (ingredient_id, recipe_id, ri_count, ri_price) VALUES('1','2','2','16');
INSERT INTO recipe_ingredient (ingredient_id, recipe_id, ri_count, ri_price) VALUES('2','2','50','100');
INSERT INTO recipe_ingredient (ingredient_id, recipe_id, ri_count, ri_price) VALUES('1','3','2','16');
INSERT INTO recipe_ingredient (ingredient_id, recipe_id, ri_count, ri_price) VALUES('7','3','100','30');