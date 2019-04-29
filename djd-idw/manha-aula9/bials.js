// Executado no momento de carregamento do HTML
var canvas;
var ctx;
var w, h;
var imgHeroi;
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
function pintarHeroi() { 
    ctx.drawImage(imgHeroi, 0, 0, 80, 90, 400, 200, 160, 180);
}
function loopJogo() { 
	// calcularRegras();
    pintarTela();
    pintarHeroi();
	// capturarEventos();
}
function executar(e) { 
    // Executado quando todos os documentos imagens, css, etc forem carregados
    console.log("Todos os documentos imagens, sons, etc, foram carregados");
    window.setInterval(loopJogo, 10);
}
document.addEventListener("DOMContentLoaded", inicializa);
window.addEventListener("load", executar);