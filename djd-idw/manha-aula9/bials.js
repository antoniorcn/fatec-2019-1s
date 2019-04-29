// Executado no momento de carregamento do HTML
var canvas;
var ctx;
var w, h;
var imgHeroi;
var heroi_x = 100, heroi_y = 10;
var gravidade = 9.8;
var heroi_vel_y = 0;
var heroi_forca_y = 0;
console.log("Javascript bial.js carregado");
var cenario1 = [   
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
];
function inicializa(e) { 
    // Executado quando o HTML foi totalmente carregado
    console.log("Conteudo do documento HTML foi carregado");
    canvas = document.getElementById("game");
    ctx = canvas.getContext("2d");
    w = 800 / 16;
    h = 600/ 16;
	imgHeroi = new Image();
	imgHeroi.src = "./hero_spritesheet.png";
}
function pintarTela() { 
    ctx.clearRect(0, 0, 800, 600);
    for (var lin = 0; lin < 16; lin++) {
        for(var col = 0; col < 16; col++) { 
            if (cenario1[lin][col] == 1) {
                var x = col * w;
                var y = lin * h;
                ctx.fillRect(x, y, w, h);
            }
        }
    }
}
function calcularRegras() { 
    heroi_forca_y = heroi_forca_y + 1;
    if (heroi_forca_y > 0) { 
        heroi_forca_y = 0;
    }
    var col = Math.floor(heroi_x / w);
    var lin = Math.floor((heroi_y + h) / h) + 1;
    console.log("Heroi: " + heroi_x + ", " + heroi_y + " Forca:" + heroi_forca_y);
    heroi_y = heroi_y + heroi_forca_y;
    if (cenario1[lin][col] == 0) { 
        heroi_vel_y += gravidade / 100;
        heroi_y = heroi_y + heroi_vel_y;
    }
}
function pintarHeroi() { 
    ctx.drawImage(imgHeroi, 0, 0, 80, 90, heroi_x, heroi_y, 80, 90);
}
function loopJogo() { 
	calcularRegras();
    pintarTela();
    pintarHeroi();
	// capturarEventos();
}
function capturarEventos(e) { 
    console.log(e);
    if (e.code == "Space") { 
        heroi_forca_y = -30;
    }
}
function executar(e) { 
    // Executado quando todos os documentos imagens, css, etc forem carregados
    console.log("Todos os documentos imagens, sons, etc, foram carregados");
    window.setInterval(loopJogo, 10);
}
document.addEventListener("DOMContentLoaded", inicializa);
window.addEventListener("load", executar);
window.addEventListener("keydown", capturarEventos);