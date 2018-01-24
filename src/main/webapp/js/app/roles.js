
function validarCamposRol(){
	if ($("#nombre").val() == ""){
		modal_alert("Debe introducir un nombre para el rol.");	
		return false;
	} 
	else {
		return true;
	}
}

function marcar_desmarcar_ck(idparent,check){
	$('.cpad-'+idparent).each(function(currentElement, index) {
		$(this).prop('checked',check);
		var idPerm = $(this).attr('id');
		idPerm = idPerm.substring(5);
		marcar_desmarcar_ck(idPerm, check);
	});
}

function desmarcar_padres(idperm){
	$('#perm-'+idperm).prop('checked',false);
	var idPermPadre = '';
	if ($('#perm-'+idperm).attr('class')){
		$($('#perm-'+idperm).attr('class').split(' ')).each(function() { 
			if (this.length > 5 && this.substring(0,5) == 'cpad-') {
	        	idPermPadre = this.substring(5);
	        }    
	    });
		desmarcar_padres(idPermPadre);
	}
}

$(document).ready(function() {
	
	//Guardar rol
	$('#guardarRol').click(function(event){
		
		if(validarCamposRol()){
			bootbox.confirm("Confirmación: ¿Desea guardar el rol?", function(result,accion) {
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
	
	//Acciones al clickar en permisos padres (chequear los hijos) 
	//o en los hijos (deschequear los padres)
	$('.checkPerm').click(function(){
		
		var checked = $(this).prop('checked');
		var idPerm = $(this).attr('id');
		idPerm = idPerm.substring(5);
		marcar_desmarcar_ck(idPerm,checked);
		
		if (!checked) {
			var idPermPadre = '';
			if ($(this).attr('class')){
				$($(this).attr('class').split(' ')).each(function() { 
			       	if (this.length > 5 && this.substring(0,5) == 'cpad-') {
			        	idPermPadre = this.substring(5);
			        }    
			    });
				desmarcar_padres(idPermPadre);
			}
		}
	});
	
	//Abrir modal de eliminar rol
	$('.delRol').click(function(event){
		
		var idRol = $(this).attr('id').split('_')[1];
		$('#RolToDelete').val(idRol);
		$('#modalNameRol').html($("#name_"+idRol).html());
		
		$('#myModalConfirmDeleteRol').modal('show');
		
		event.preventDefault();
		event.stopPropagation();
	});
	
	//Eliminar rol
	$('#btnAceptarEliminarRol').click(function(){
		var action = $('#fDelete').attr('action') + $('#RolToDelete').val() + '/';
		$('#fDelete').attr('action',action);
		$('#fDelete').submit();
	});
	
});