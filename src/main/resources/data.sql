
INSERT INTO categories(name, image) VALUES('本', 'category01.jpg');
INSERT INTO categories(name, image) VALUES('DVD', 'category02.jpg');
INSERT INTO categories(name, image) VALUES('ゲーム', 'category03.jpg');
INSERT INTO categories(name, image) VALUES('エネルギードリンク', 'category04.jpg');
INSERT INTO categories(name, image) VALUES('文房具', 'category05.jpg');
INSERT INTO categories(name, image) VALUES('ファッション', 'category06.jpg');
INSERT INTO categories(name, image) VALUES('化粧品', 'category07.jpg');

INSERT INTO items(category_id, image, name, price, cmt) VALUES(1, 'bock01.jpg', 'Javaの基本', 2500, 10);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(1, 'bock02.jpg', '料理BOOK!', 1200, 0);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(1, 'bock03.jpg', 'じゃんけんの必勝法', 6200, 4);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(1, 'bock04.jpg', '時間の上手な使い方', 1650, 5);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(1, 'bock05.jpg', '結ぶ菊　上絵師律の似面絵帖 ', 980, 140);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(1, 'bock06.jpg', '火怨 上 北の燿星アテルイ', 1050, 34);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(1, 'bock07.jpg', '月神 (角川文庫)', 800, 9);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(1, 'bock08.jpg', '木挽町のあだ討ち', 1200, 5);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(1, 'bock09.jpg', '浅き夢みし　吉原裏同心', 850, 19);

INSERT INTO items(category_id, image, name, price, cmt) VALUES(2, 'dvd01.jpg', '水の生物 DVDつき', 2000, 46);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(2, 'dvd02.jpg', '昆虫2 DVDつき: 地球編', 1000, 52);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(2, 'dvd03.jpg', '湘南爆走族 COMPLETE DVD', 1800, 10);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(2, 'dvd04.jpg', 'ＤＶＤ　日本むかしばなし', 1900, 23);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(2, 'dvd05.jpg', '歌舞伎特選DVDコレクション全国版', 2500, 20);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(2, 'dvd06.jpg', 'JR全路線DVDコレクション 45号 ', 5000, 10);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(2, 'dvd07.jpg', 'メタルヒーローDVDコレクション 6号', 3000, 10);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(2, 'dvd08.jpg', '【DVD】もう悩まない!やさしい鍼を打つためのDVD', 4000, 45);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(2, 'dvd09.jpg', '西遊記DVDコレクション 20号 ', 8000, 78);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(2, 'dvd10.jpg', 'DVD付 たった12単語でわかる 英語のきもち', 6800, 89);

INSERT INTO items(category_id, image, name, price, cmt) VALUES(3, 'game01.jpg', 'パズルゲーム', 780, 89);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(3, 'game02.jpg', 'Xbox Series X Diablo 4 同梱版', 3400, 32);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(3, 'game03.jpg', 'Xbox Series S​', 2200, 23);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(3, 'game04.jpg', 'ボードゲーム・ブロードウェイ', 3500, 43);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(3, 'game05.jpg', 'ボードゲーム総選挙２０２３', 3500, 45);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(3, 'game06.jpg', 'ゲームメカニクス大全 ボードゲームに学ぶ「おもしろさ」の仕掛け', 3500, 45);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(3, 'game07.jpg', '100％ムックシリーズ　ゲーム完璧バイブル Vol.2 (１００％ムックシリーズ)', 380, 23);


INSERT INTO items(category_id, image, name, price, cmt) VALUES(4, 'drink01.jpg', '伊藤園 ビタミンパワーGO スーパーBBB', 350, 56);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(4, 'drink02.jpg', 'アサヒ飲料 モンスターエナジー ゼロシュガー', 200, 45);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(4, 'drink03.jpg', 'レッドブル エナジードリンク', 250, 100);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(4, 'drink04.jpg', 'アサヒ飲料 モンスターエナジ', 250, 150);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(4, 'drink05.jpg', 'サバイバー エナジードリンク', 200, 230);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(4, 'drink06.jpg', 'アサヒ飲料 モンスターエナジー M3 ワンウェイびん', 250, 560);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(4, 'drink07.jpg', 'コカ・コーラ リアルゴールド', 200, 560);

INSERT INTO items(category_id, image, name, price, cmt) VALUES(5, 'office01.jpg', '定規', 200, 56);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(5, 'office02.jpg', 'ハンドスピナー型カッター', 750, 213);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(5, 'office03.jpg', '爆落ち君消しゴム', 2000, 21);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(5, 'office04.jpg', 'バインダー A4', 400, 10);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(5, 'office05.jpg', '分度器', 80, 23);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(5, 'office06.jpg', '計算機', 1000, 231);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(5, 'office07.jpg', '筆箱', 600, 10);

INSERT INTO items(category_id, image, name, price, cmt) VALUES(6, 'fashion01.jpg', '鬼殺隊制服', 5000, 10);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(6, 'fashion02.jpg', '悟空なりきりセット', 1300, 10);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(6, 'fashion03.jpg', 'スニーカー', 3500, 23);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(6, 'fashion04.jpg', 'ローファー', 5000, 12130);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(6, 'fashion05.jpg', 'フレッシャーズスーツセット', 60000, 10);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(6, 'fashion06.jpg', 'ライオンが破ったダメージジーンズ', 99800, 10);

INSERT INTO items(category_id, image, name, price, cmt) VALUES(7, 'cosmetics01.jpg', 'リップ', 1000, 10);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(7, 'cosmetics02.jpg', 'マスカラ', 1100, 23);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(7, 'cosmetics03.jpg', 'ファンデーション', 1200, 1540);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(7, 'cosmetics04.jpg', 'マニキュア3本セット', 2100, 10);
INSERT INTO items(category_id, image, name, price, cmt) VALUES(7, 'cosmetics05.jpg', '潤うハトムギ化粧水', 1000, 34);

-- 注文で発生するテストデータの追加
INSERT INTO customers(name, address, tel, email, password) VALUES('田中太郎', '東京', '090-1111-1111', 'tanaka@gmail.com', 'himitu');
INSERT INTO orders(customer_id, ordered_on, total_price) VALUES(1, '2020-04-10', 5980);
INSERT INTO order_details(order_id, item_id, quantity) VALUES(1, 1, 2);
INSERT INTO order_details(order_id, item_id, quantity) VALUES(1, 2, 1);

INSERT INTO customers(name, address, tel, email, password) VALUES('鈴木一郎', '大阪', '090-2222-2222', 'suzuki@gmail.com', 'himitu');
INSERT INTO orders(customer_id, ordered_on, total_price) VALUES(2, '2020-04-11', 2500);
INSERT INTO order_details(order_id, item_id, quantity) VALUES(2, 1, 1);

INSERT INTO customers(name, address, tel, email, password) VALUES('NTT', '東京', '090-1111-1111', 'ntt@gmail.com', 'ntt');

INSERT INTO enquiries_category(name) VALUES('要望');
INSERT INTO enquiries_category(name) VALUES('返品');
INSERT INTO enquiries_category(name) VALUES('質問');
INSERT INTO enquiries_category(name) VALUES('他の');

INSERT INTO enquiries(customer_id, enquiries_category_id, details) VALUES(1,3,'エンジニア募集していますか');
INSERT INTO enquiries(customer_id, enquiries_category_id, details) VALUES(1,1,'新商品販売要望');
INSERT INTO enquiries(customer_id, enquiries_category_id, details) VALUES(1,2,'購入した物が傷つけるんで返品したい');
INSERT INTO enquiries(customer_id, enquiries_category_id, details) VALUES(2,4,'おはようございます！');
INSERT INTO enquiries(customer_id, enquiries_category_id, details) VALUES(2,3,'いつかキャンペーン開始');


