$(document).ready(function() {

	$('#usuarioLogin').click(function(){
		$("#userSession").toggleClass("hidden");
	});
	$('#logout').click(function(){
		window.location.href = appRootUrl + "j_spring_security_logout";
	});
	
});