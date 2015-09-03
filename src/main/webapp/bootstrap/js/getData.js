	
function formProcessing(form)
	{
		
	if(form.userName.value == 0 || form.userPw.value == 0) {
		alert("Lietotāja vārds vai parole nevar būt tūkši! Lūdzu mēģiniet vēl reizi.\n");
	}
	else {
		
		userName = "jpd\\" + form.userName.value.trim();
		userPw = CryptoJS.MD5(form.userPw.value.trim());
		alert(userName + "\n" + userPw );
		// readFile();
	}
}
/*
function readFile()
{
    /*$.get('./script/allusers.txt', function(data) {
        alert(data);
    }, "text");
	alert("OK! Reading file!");
} */