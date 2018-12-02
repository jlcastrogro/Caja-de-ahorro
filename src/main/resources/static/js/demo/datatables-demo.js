// Call the dataTables jQuery plugin
$(document).ready(function() {
	$('#dataTable').DataTable({
		"language" : {
			"decimal" : "",
			"emptyTable" : "No hay datos disponibles en la tabla",
			"info" : "Mostrando _START_ a _END_ d _TOTAL_ entradas",
			"infoEmpty" : "Mostrando 0 a 0 de 0 entradas",
			"infoFiltered" : "(filtrado de _MAX_ entradas totales)",
			"infoPostFix" : "",
			"thousands" : ",",
			"lengthMenu" : "Mostrar _MENU_ entradas",
			"loadingRecords" : "Cargando...",
			"processing" : "Procesando...",
			"search" : "Buscar:",
			"zeroRecords" : "No se encontraron registros coincidentes",
			"paginate" : {
				"first" : "Primero",
				"last" : "Último",
				"next" : "Siguiente",
				"previous" : "Anterior"
			},
			"aria" : {
				"sortAscending" : ": activar para ordener la columna ascendente",
				"sortDescending" : ": activar para ordener la columna descendente"
			}
		}
	});
});
