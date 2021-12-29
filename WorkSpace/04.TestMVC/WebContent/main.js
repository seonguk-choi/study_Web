function fnSubmit(){
	if(confirm("도서정보를 입력하시겠습니까?")){
		return true;
	}
	return false;
}

function fnReset(){
	if(confirm("정말 취소하시겠습니까?")){
		return true;
	}
	return false;
}

function fnisbn(){
	if(!equal("XXX-XX-XXXX-XXX-X")){
		confirm("ISBN 형식이 잘못 입력되었습니다.")
		return false;
	}
	return true;
}


