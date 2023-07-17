/**
 * 
 */
{
	/*Hàm Đóng Form*/
	function dongForm() {
		document.getElementById("myForm").style.display = "none";
	}

	/*Hàm Mở Form*/
	function moForm() {
		document.getElementById("myForm").style.display = "block";

		const chatBtn = document.getElementById('chat-button');
		const inputText = document.getElementById('chat-input');

		const chat = [
			'こんにちは！G ショップをご利用頂きありがとうございます。',
			'お名前をご入力ください',
			'お問い合わせ内容を入力してください',
			'ただいま処理しておりますので、しばらくお待ちください。'
			// 'Hello ! Welcome to Web chat !',
			// 'What is your name ?',
			// 'Can i help you ?',
			// 'Please wait a little bit'
		];
		// ロボットの返信の合計回数（最初は0）
		// これを利用して、自分が送信ボタンを押したときの相手の返答を配列から指定する
		let chatCount = 0;

		// 画面への出力
		// valはメッセージ内容，personは誰が話しているか
		function output(val, person) {

			// 一番下までスクロール
			const field = document.getElementById('field');
			field.scroll(0, field.scrollHeight - field.clientHeight);

			const ul = document.getElementById('chat-ul');
			const li = document.createElement('li');
			// このdivにテキストを指定
			const div = document.createElement('div');
			div.textContent = val;

			if (person === 'me') { // 自分
				div.classList.add('chat-right');
				li.classList.add('right');
				ul.appendChild(li);
				li.appendChild(div);
			} else if (person === 'robot') { // 相手
				// ロボットが2個連続で返信してくる時、その間は返信不可にする
				// なぜなら、自分の返信を複数受け取ったことになり、その全てに返信してきてしまうから
				// 例："Hi!〇〇!"を複数など
				// （今回のロボットの連続返信は2個以内とする）
				chatBtn.disabled = true;
				setTimeout(() => {
					chatBtn.disabled = false;
					li.classList.add('left');
					div.classList.add('chat-left');
					ul.appendChild(li);
					li.appendChild(div);
					// ロボットのトークの合計数に1足す
					chatCount++;
				}, 2000);
			}
		}


		// 送信ボタンを押した時の処理
		chatBtn.onclick = (event) => {

			if (!inputText.value) return false;
			// 自分のテキストを送信
			output(inputText.value, 'me');

			setTimeout(() => {
				// 入力内を空欄にする
				// 一瞬の間でvalueを取得し、ロボットの"Hi!〇〇!"の返信に利用
				// 送信ボタンを押した瞬間にvalueを消したら、やまびこに失敗した
				inputText.value = '';
			}, 1);

			//ロボットの送信の合計回数に応じて次の返信を指定
			switch (chatCount) {
				// もしロボットのトーク数が2個の時に送信ボタンが押されたら、
				// 名前のやまびこと、chat配列の2（3個目）が返信
				case 2:
					output('こんにちは！' + inputText.value + ' 様', 'robot');
					setTimeout(() => {
						output(chat[2], 'robot');
					}, 2000);
					break;

				// もしロボットのトーク数が4個の時に送信ボタンが押されたら、
				// chat配列の3（4個目）のランダム番目が返信
				case 4:
					setTimeout(() => {
						output(chat[3], 'robot');
					}, 2000);
					break;

				// それ以降はやまびこ
				default:
					output(inputText.value, 'robot');
					break;
			}
		}

		// 最初に2つロボットから話しかけられる
		output(chat[0], 'robot');

		setTimeout(() => {
			output(chat[1], 'robot');
		}, 2000);
	}
}
