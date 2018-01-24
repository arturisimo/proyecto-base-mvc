function modal_alert(texto){ 
	bootbox.alert(texto,
		function() {});
}

function esExtensionImagen(nameFile){
	var extension = "";
	var extCorrecta = false;
	if (nameFile != null && nameFile != ""){
		extension = nameFile.substring(nameFile.lastIndexOf('.') + 1).toLowerCase();
		if (extension == "gif" || extension == "png" || extension == "bmp"	|| extension == "jpeg" || extension == "jpg"){
			extCorrecta = true;
		}else{
			extCorrecta = false;
		}
	}
	return extCorrecta;
}

function validarEmail(email) {
   expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
   return expr.test(email);
}

