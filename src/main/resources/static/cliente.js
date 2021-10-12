function  consultarRestaurantes() {
	
	$.ajax({
		url: "https://playfood.herokuapp.com/restaurante",
		type: "get",

		success: function(){

			$("#conteudo").text(response);
			
		}
	});
}

$("#botao").click(consultarRestaurantes);