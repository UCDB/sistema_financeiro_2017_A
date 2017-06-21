let xhttp = new XMLHttpRequest();

let path_principal = "";

function acessa_modulo(caminho){
    xhttp.onreadystatechange = function() { document.getElementById("conteudo_menu").innerHTML = this.responseText; };
    xhttp.open("GET", "./conteudo/"+caminho+"/index.html", true);
    xhttp.send();
    $(".menu_superior").removeClass("active");
	document.getElementById(caminho).setAttribute("class", "active");
    path_principal = caminho;
    carregar_tabela_principal();
}

function acessa_sub_modulo(caminho){
    xhttp.onreadystatechange = function() { document.getElementById("conteudo_submenu").innerHTML = this.responseText; };
    xhttp.open("GET", "./conteudo/"+path_principal+"/"+caminho+".html", true);
    xhttp.send();
}

function carregar_tabela_principal(){
	//alert('Carregar Tabela com Dados de '+path_principal);
}

var objeto = new function(){
	this.create = function(){
		let nome_razao	= document.getElementById("nome_razao").value;
		let endereco 	= document.getElementById("endereco").value;
		let telefone 	= document.getElementById("telefone").value;
		let email 		= document.getElementById("email").value;
		let cpf_cnpj	= document.getElementById("cpf_cnpj").value;
		let rg_ie 		= document.getElementById("rg_ie").value;
		let cep 		= document.getElementById("cep").value;
		let contato 	= document.getElementById("contato").value;
		let info_add 	= document.getElementById("info_add").value;

		if( nome_razao != '' && endereco != '' && telefone != '' && email != '' && cpf_cnpj != '' && rg_ie != '' && cep != '' && contato != '' && info_add != '' ){
			xhttp.open("POST", "/sistema_financeiro_2017_A/"+path_principal, true);
			xhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xhttp.send("nome="+nome_razao+"&endereco="+endereco+"&telefone="+telefone+"&email="+email+"&cpf="+cpf_cnpj+"&rg="+rg_ie+"&cep="+cep+"&contato="+contato+"&info_add="+info_add);

			alert(path_principal+" cadastrado com sucesso!"); // retorno ao usuário
			acessa_modulo(path_principal); // volta pra index principal do modulo ativo
		}else{
			alert("Para prosseguir é obrigatório preencher todos os campos!");
		}
	}

	this.update = function(identificador){
		alert('update: '+identificador);
		acessa_sub_modulo('update');
		/*
		// busca por ID
		// vars abaixo recebem retorno em jSon e preenchem campos com dados

		let nome_razao	= document.getElementById("nome_razao").value;
		let endereco 	= document.getElementById("endereco").value;
		let telefone 	= document.getElementById("telefone").value;
		let email 		= document.getElementById("email").value;
		let cpf_cnpj	= document.getElementById("cpf_cnpj").value;
		let rg_ie 		= document.getElementById("rg_ie").value;
		let cep 		= document.getElementById("cep").value;
		let contato 	= document.getElementById("contato").value;
		let info_add 	= document.getElementById("info_add").value;

		xhttp.open("PUT", "/sistema_financeiro_2017_A/"+path_principal, true);
		xhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhttp.send("nome="+nome_razao+"&endereco="+endereco+"&telefone="+telefone+"&email="+email+"&cpf="+cpf_cnpj+"&rg="+rg_ie+"&cep="+cep+"&contato="+contato+"&info_add="+info_add);
		*/
	}

	this.remove = function(identificador){
		alert("ID: " + identificador);
		if(confirm("Deseja realmente remover esse "+path_principal)){
			xhttp.open("DELETE", "/sistema_financeiro_2017_A/"+path_principal+"?id="+identificador, true);
			xhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xhttp.send("id="+identificador)
			alert(path_principal+" removido com sucesso!"); // retorno ao usuário
			acessa_modulo(path_principal); // volta pra index principal do modulo ativo
		}
	}
}