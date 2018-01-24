
function validarCamposGrupo(){
	if ($("#nombre").val() == ""){
		modal_alert("Debe introducir un nombre para el grupo.");	
		return false;
	} 
	else {
		return true;
	}
}

$(document).ready(function() {
	
	//Guardar grupo
	$('#guardarGrupo').click(function(event){
		if(validarCamposGrupo()){
			bootbox.confirm("Confirmación: ¿Desea guardar el grupo?", function(result,accion) {
				if (result){
					$('#f1').submit();
				}
	   		});
		}
		event.preventDefault();
		event.stopPropagation();
	});
	
	//Permisos en modo árbol
	if ($('.tree').length>0){
		$('.tree').treegrid();
	}
	
	//Abrir modal de eliminar rol
	$('.delGrupo').click(function(event){
		
		var idGrupo = $(this).attr('id').split('_')[1];
		$('#GrupoToDelete').val(idGrupo);
		$('#modalNameGrupo').html($("#name_"+idGrupo).html());
		
		$('#myModalConfirmDeleteGrupo').modal('show');
		
		event.preventDefault();
		event.stopPropagation();
	});
	
	//Eliminar rol
	$('#btnAceptarEliminarGrupo').click(function(){
		var action = $('#fDelete').attr('action') + $('#GrupoToDelete').val() + '/';
		$('#fDelete').attr('action',action);
		$('#fDelete').submit();
	});
	
});