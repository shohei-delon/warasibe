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
8,"黄", 1, 30,1,1,"cm",6),(
'ネックレス', '最近つけなくなったので出品します。どこで買ったかは忘れました。',
6 , "白", 1, 20, 0.1, 0.1, "cm", 2),(
'ノート10冊','何も書いていないノートです。タブレットを買い必要性がなくなったので誰か交換してください。' ,
1,'青', 0, 20, 10, 1, "cm", 4),(
'iphone充電器', 'アンドロイドに乗り換えたため不要になりました。そんなに使ってないのできれいです。',
4, "白", 0.5, 3, 3, 10, "cm", 1),(
'星の王子さま','買って一度読んだのですが、内容がよくわからなたので皆さんにも読んでほしいです。',
1, '青', 1, 10, 10, 3, "cm", 3),(
'ナイキの靴','大会用に買って本番で一度使ったのですが、自分の好みでないので誰か使ってください。',
6, '黒', 0.1, 0, 0, 27, "cm", 5),(
'ロジクールのマウス','新しくマウスを買っていらなくなりました。有線です。',
4 ,'黒', 0.5, 3, 3, 20, "cm", 6),(
'キーボード','パソコンの付属品でついてきたやつです。使いたいやつが他にあったので不要になりました。',
4 ,'白', 0, 15, 40, 3, "cm", 1),(
'レインボーシックスシージ R6S PS4','そろそろWW2を始めたいと思いました。誰か交換しませんか。',
3 ,'青', 2, 15, 15, 2, "cm", 2),(
'手作りフェルト人形（熊）','暇な時間に作ってみました。気に入っていただけたら交換お願いします。',
5 ,'黄', 0, 10, 5, 5, "cm", 3),(
'HDMIケーブル','なぜか一本余ってしまいました。',
4 ,'黒', 0, 1, 2, 30, "cm", 4),(
'引きこもりでも旅がしたい vol.2','脱歌い手を今年の目標にしたので交換に出します。',
2 ,'白', 2, 10, 10, 2, "cm", 5),(
'ピアス','配送ミスで違うものが届いたので誰か使いませんか。未開封です。',
8 ,'赤', 0, 3, 3, 1, "cm", 6),(
'革財布','きれいに使っていたので汚れはあまりないです。',
7 ,'黒', 2, 5, 15, 3, "cm", 1),(
'アディダスのパーカー','お揃いで買ったのですが別れたのでいらないです。不幸が詰まっているがもしれませんがどうぞ。。。',
6 ,'青', 1.5, 30, 30, 5, "cm", 2),(
'卓球ラケット用ラバー','いつも買うやつと違うのを買ってしまったので誰かもらってください。',
7 ,'赤', 0, 15, 15, 2, "cm", 3),(
'エレキギター','初心者用のギターです。始めようと思ったのですが挫折しました。',
4 ,'黒', 1, 20, 100, 10, "cm", 4),(
'コンポ','初心者用のコンポです。エレキギターと一緒に買ったのですが諦めました。',
4 ,'黒', 1, 15, 15, 15, "cm",4),(
'女の子用古着10着','5才児用の服です。もう着れないのでどうぞ。',
6 ,'赤', 1, 20, 20, 2, "cm", 5),(
'フィットネスバイク（室内用）','家で自転車をこげるやつです。一時期ハマっていたのですが飽きてしまいました。',
7 ,'黒', 1, 1, 1.5, 0.7, "m", 6),(
'子供用スキー板','息子とよく言ってたのですが大きくなり行かなくなりました。',
7 ,'白', 2, 100, 10, 1, "cm", 1),(
'ワンダーコア','個人的に実感できなかったので誰か使ってください。',
7 ,'黒', 0.5, 0.8, 0.8, 0.8, "m", 2);

INSERT INTO wish_info(applied_user_id, have_commodity_id, have_user_id, applied_commodity_id) VALUES (1,1,3,3),(1,1,5,5),(2,2,4,4),(2,2,1,1),(3,3,2,2),(4,4,5,5);