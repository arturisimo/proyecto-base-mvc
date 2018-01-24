function validarCamposUsuarioAlta(){
	
	if ($("#nombre").val() == ""){
		modal_alert("Debe introducir un nombre para el usuario.");	
		return false;
	} 
	else if ($("#login").val() == ""){
		modal_alert("Debe introducir un login para el usuario.");	
		return false;
	} 
	else if (!validarEmail($("#email").val())){
		modal_alert("La direcci�n de correo electr�nico es incorrecta");	
		return false;
	} 
	else if ($("#password").val() == ""){
		modal_alert("Debe introducir una contrase�a.");	
		return false;
	} 
	else if ($("#repassword").val()== "") {
		modal_alert("Debe confirmar la contrase�a.");	
		return false;
	} 
	else if ($("#password").val() != $("#repassword").val()){
		modal_alert("La confirmaci�n de la contrase�a no es correcta.");	
		return false;
	} 
	else {
		return true;
	}
}

function validarCamposUsuarioModificar(){
	
	if ($("#nombre").val() == ""){
		modal_alert("Debe introducir un nombre para el usuario.");	
		return false;
	} 
	else if ($("#login").val() == ""){
		modal_alert("Debe introducir un login para el usuario.");	
		return false;
	} 
	else if (!validarEmail($("#email").val())){
		modal_alert("La direcci�n de correo electr�nico es incorrecta");	
		return false;
	} 
	else if ($("#change").is(":checked") && $("#password").val() == ""){
		modal_alert("Debe introducir la contrase�a actual.");	
		return false;
	} 
	else if ($("#change").is(":checked") && $("#newpassword").val() == ""){
		modal_alert("Debe introducir una contrase�a nueva.");	
		return false;
	} 
	else if ($("#change").is(":checked") && $("#repassword").val()== "") {
		modal_alert("Debe confirmar la contrase�a.");	
		return false;
	} 
	else if ($("#change").is(":checked") && $("#newpassword").val() != $("#repassword").val()){
		modal_alert("La confirmaci�n de la contrase�a no es correcta.");	
		return false;
	} 
	else {
		return true;
	}
}

$(document).ready(function() {
	
	//Guardar usuario
	$('#guardarUsuario').click(function(event){
		
		event.preventDefault();
		event.stopPropagation();
		
		if(validarCamposUsuarioAlta()){
			bootbox.confirm("Confirmaci�n: �Desea guardar el usuario?", function(result,accion) {
				if (result){
					$('#f1').submit();
				}
	   		});
		}
	});
	
	//Guardar usuario
	$('#modificarUsuario').click(function(event){
		
		event.preventDefault();
		event.stopPropagation();
		
		if(validarCamposUsuarioModificar()){
			bootbox.confirm("Confirmaci�n: �Desea guardar el usuario?", function(result,accion) {
				if (result){
					$('#f1').submit();
				}
	   		});
		}
	});
	
	//Permisos en modo �rbol
	if ($('.tree').length>0){
		$('.tree').treegrid();
	}
	
	//Change password
	$("#change").change(function(){
		$(".changepass").toggle();
	});
	
	//Abrir modal de eliminar usuario
	$('.delUsuario').click(function(event){
		
		var idUsuario = $(this).attr('id').split('_')[1];
		$('#UsuarioToDelete').val(idUsuario);
		$('#modalNameUsuario').html($("#name_"+idUsuario).html());
		
		$('#myModalConfirmDeleteUsuario').modal('show');
		
		event.preventDefault();
		event.stopPropagation();
	});
	
	//Eliminar usuario
	$('#btnAceptarEliminarUsuario').click(function(){
		var action = $('#fDelete').attr('action') + $('#UsuarioToDelete').val() + '/';
		$('#fDelete').attr('action',action);
		$('#fDelete').submit();
	});
	
	
});