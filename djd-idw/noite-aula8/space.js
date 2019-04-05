var canvas;
var ctx;
var sprite_sheet;
var lista_inimigos = [];
var lista_tiros = [];
var lista_tiros_inimigo = [];
var inimigo = {"x":50, "y":50, "w":64, "h":64, "velX": 1, "velY": 0, "frame":[0, 0, 64, 64], "size":[64, 64]};
console.log(inimigo);
var nave = {"x":50, "y":450, "w":128, "h":96, "velX": 0, "velY": 0, "frame":[0, 64, 128, 96], "size":[128, 96]};
var tiro = {"x":50, "y":410, "w":15, "h":48, "velX": 0, "velY": -1, "frame":[279, 15, 13, 33], "size":[15, 48]};
var tiroCoolDown = 0;
var pontos = 10;
var shoot_sound = new Audio();
var explode_sound = new Audio();

function intersectRect(sprite1, sprite2) {
	return !(
		sprite2['x'] > (sprite1['x'] + sprite1['w']) || 
		(sprite2['x'] + sprite2['w'])  < sprite1['x'] || 
		sprite2['y'] > (sprite1['y'] + sprite1['h']) ||
		(sprite2['y'] + sprite2['h']) < sprite1['y']);
}

function documentReady( e ) { 
	canvas = document.getElementById("canvas");
	ctx = canvas.getContext("2d");
	sprite_sheet = new Image();
	sprite_sheet.src="./space_invaders.png";
	shoot_sound.src="./disparo.mp3";
	
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

function calculaColisaoTiro( t, lista_sprites ) { 
	var lista = [];
	for (var i = 0; i < lista_sprites.length; i++) { 
		var enemy = lista_sprites[i];
		if (intersectRect(t, enemy)) { 
			lista.push(i);
		}
	}
	return lista;
}

function calcularRegras() { 
	for (var i = 0; i < lista_inimigos.length; i++) { 
		var enemy = lista_inimigos[i];
		calculaRegraSprite(enemy);
		var aleatorio = Math.floor((Math.random() * 10000));
		if (aleatorio > 70 && aleatorio < 75) { 
			var tiroClone = Object.assign({}, tiro);
			tiroClone["x"] = enemy["x"] + (enemy["w"] / 2);
			tiroClone["y"] = enemy["y"] + enemy["h"];
			tiroClone["velY"] = 1;
			lista_tiros_inimigo.push(tiroClone);
		}
	}
	
	for (var i = 0; i < lista_tiros.length; i++) { 
		var t = lista_tiros[i];
		calculaRegraSprite(t);
		if (t["y"] < 1) { 
			lista_tiros.splice(i, 1);
			break;
		}
		var lista = calculaColisaoTiro(t, lista_inimigos);
		console.log(lista);
		if (lista.length > 0) { 
			var indice_inimigo = lista[0];
			lista_inimigos.splice(indice_inimigo, 1);
			lista_tiros.splice(i, 1);
			pontos += 10;
			break;
			// for (var e = 0; e < lista.length; e++) { 
			//	var indice_inimigo = lista[e];
			//	lista_inimigos.splice(indice_inimigo, 1);
			//}
		}
	}
	
	// Testa o tiro da nave inimiga
	for (i = 0; i < lista_tiros_inimigo.length; i++) { 
		var shoot = lista_tiros_inimigo[i];
		calculaRegraSprite(shoot);
		if (shoot["y"] > 595) { 
			lista_tiros_inimigo.splice(i, 1);
			break;
		}
		
		var lista = calculaColisaoTiro(shoot, [nave]);
		if (lista.length > 0) { 
			lista_tiros_inimigo.splice(i, 1);
			pontos = 0;
			break;
		}		
	}
	
	calculaRegraSprite(nave);
	tiroCoolDown -= 1;
	if (tiroCoolDown < 0) { 
		tiroCoolDown = 0;
	}
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
	for (var i = 0; i < lista_tiros_inimigo.length; i++) { 
		var t = lista_tiros_inimigo[i];
		pintarSprite(t);
	}		
	pintarSprite(nave);
	ctx.font = '48px serif';
	ctx.fillStyle = "#FFFFFF";
	ctx.fillText('Pontos: ' + pontos, 550, 50);
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
		if (e.code == "Space" && tiroCoolDown <= 0) { 
			shoot_sound.play();
			var tiroClone = Object.assign({}, tiro);
			tiroClone["x"] = nave["x"] + (nave["w"] / 2);
			lista_tiros.push(tiroClone);
			tiroCoolDown = 100;
			pontos -= 1;
		} else if (e.code == "KeyA") { 
			nave["velX"] = -1;
		} else if (e.code == "KeyD") { 
			nave["velX"] = 1;			
		} else { 
			console.log(e.code);
		}
})
