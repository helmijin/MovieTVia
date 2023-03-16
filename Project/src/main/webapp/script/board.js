function boardCheck() {
	if (document.frm.title.value.length == 0) {
		alert("제목을 입력하세요.");
		return false;
	}
	return true;
}
function open_win(url, name) {
	window.open(url, name, "width=500, height=230");
}
function passCheck() {
	if (document.frm.pwd.value.length == 0) {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	if(documemt.frm.pwd.value != documemt.frm.userpwd.value){
	alert("비밀번호가 맞지 않습니다.");
	return false;
	}
	return true;
}