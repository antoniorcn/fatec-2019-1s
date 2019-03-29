var canvas;
var ctx;
var sprite_sheet;
var lista_inimigos = [];
var lista_tiros = [];
var inimigo = {"x":50, "y":50, "velX": 1, "velY": 0, "frame":[0, 0, 64, 64], "size":[64, 64]};
console.log(inimigo);
var nave = {"x":50, "y":450, "velX": 0, "velY": 0, "frame":[0, 64, 128, 96], "size":[128, 96]};
var tiro = {"x":50, "y":410, "velX": 0, "velY": -1, "frame":[256, 0, 64, 64], "size":[64, 64]};
function documentReady( e ) { 
	canvas = document.getElementById("canvas");
	ctx = canvas.getContext("2d");
	sprite_sheet = new Image();
	sprite_sheet.src="./space_invaders.png";
	for (var i = 0; i < 10; i++) { 
		var inimigo2 = Object.assign({}, inimigo);
		inimigo2["x"] = 50 * i;
		lista_inimigos.push(inimigo2);
	}
	console.log("Lista de Inimigos");
	console.log(lista_inimigos);
}
function documentFullLoad( e ) { 
	console.log("Documento HTML esta pronto");	
}
function calculaRegraSprite( sprite ) { 
	sprite["x"] = sprite["x"] + sprite["velX"];
	if (sprite["x"] > 800) { 
		sprite["velX"] = -1;
	} else if (sprite["x"] < 0) { 
		sprite["velX"] = 1;
	}
	sprite["y"] = sprite["y"] + sprite["velY"];
	if (sprite["y"] > 800) { 
		sprite["velY"] = -1;
	} else if (sprite["y"] < 0) { 
		sprite["velY"] = 1;
	}
}
function calcularRegras() { 
	for (var i = 0; i < lista_inimigos.length; i++) { 
		var enemy = lista_inimigos[i];
		calculaRegraSprite(enemy);
	}
	
	for (var i = 0; i < lista_tiros.length; i++) { 
		var t = lista_tiros[i];
		calculaRegraSprite(t);
	}
	calculaRegraSprite(nave);
}
function capturarEventos() { 
}
function pintarSprite( sprite ) { 
	ctx.drawImage(sprite_sheet, sprite["frame"][0], sprite["frame"][1], 
								sprite["frame"][2], sprite["frame"][3], 
								sprite["x"], sprite["y"], sprite["size"][0], sprite["size"][1]);
}
function pintar() { 
	ctx.fillStyle = "#000000";
	ctx.fillRect(0, 0, 800, 600);
	for (var i = 0; i < lista_inimigos.length; i++) { 
		var enemy = lista_inimigos[i];
		pintarSprite(enemy);
	}
	for (var i = 0; i < lista_tiros.length; i++) { 
		var t = lista_tiros[i];
		pintarSprite(t);
	}	
	pintarSprite(nave);
}
function loopJogo() { 
	calcularRegras();
	pintar();
	capturarEventos();
}
console.log("Script Space executado");
document.addEventListener("DOMContentLoaded", documentReady);
console.log("Todos os elementos do HTML foram carregados");
window.addEventListener("load", documentFullLoad);
window.setInterval(loopJogo, 10);

window.addEventListener("keydown", function(e) {
		if (e.code == "Space") { 
			var tiroClone = Object.assign({}, tiro);
			lista_tiros.push(tiroClone);
		}
})
