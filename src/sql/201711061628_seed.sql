use warasibe;

INSERT INTO account(login_id, login_password, nickname, mail)
VALUES (
"hoge", "hoge", "hoge", "hoge@hoge"),(
"foo", "foo", "foo", "foo@foo"),(
"baa", "baa", "baa", "baa@baa"),(
"afo", "afo", "afo", "afo@afo"),(
"fool", "fool", "fool", "fool@fool"),(
"taro", "taro", "taro", "taro@taro");

INSERT INTO commodity(
name, detail, category_id, color, age, height, width, depth, size_unit, sell_user_id)
VALUES (
'ゼロから始めるプログラミング', '未経験から誰でもプログラミングができるようになる一冊です。汚れは少ないです。',
1, "白", 0.5, 20, 15, 5, "cm", 1),(
'嵐 ライブDVD 2015','嵐のライブDVDです。表面に傷はなくきれいです。',
2, "黒", 2, 20, 30, 3,"cm",2),(
'COD WW2 PS4', 'COD最新作です。プレマスになり飽きたのでいらなくなりました。',
3, "黒", 0, 20,30,3,"cm",3),(
'冷蔵庫','購入してから二年経過しています。引っ越しにあたりいらなくなりました。',
4, "白", 2, 150,50,60,"cm",4),(
'リカちゃん人形', '購入したものの使わなかったため未開封です。',
5, "白", 5, 30,10,10,"cm",5),(
'フリマで100円で買ったトレーナー','暖かくしっかりした素材なのでまだまだ使えると思います。サイズ表記が適当ですがLサイズです。',
6, "赤", 0, 20,20,20,"cm",6),(
'バスケットボール 6号', '高校でバスケをやろうと思い購入したがサイズが違ったためいらなくなった。',
7,"黒", 0, 25,25,25,"cm",4),(
'藁 一本','サイト名に合わせて藁一本から始めようと思います。家をください。',
8,"黄", 1, 30,1,1,"cm",6);

INSERT INTO wish_info(user_id, commodity_id) VALUES (1,3),(1,5),(2,4),(2,1),(3,2),(4,5);
