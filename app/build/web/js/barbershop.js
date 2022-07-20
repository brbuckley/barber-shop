(function($) {
  "use strict"; 
  // Alterna para a barra de navegação lateral
  $("#sidebarToggle, #sidebarToggleTop").on('click', function(e) {
    $("body").toggleClass("sidebar-toggled");
    $(".sidebar").toggleClass("toggled");
    if ($(".sidebar").hasClass("toggled")) {
      $('.sidebar .collapse').collapse('hide');
    };
  });

  // Fecha qualquer menu quando a janela está abaixo de 768px  
  $(window).resize(function() {
    if ($(window).width() < 768) {
      $('.sidebar .collapse').collapse('hide');
    };
    
    // Fecha qualquer menu quando a janela está abaixo de 480px  
    if ($(window).width() < 480 && !$(".sidebar").hasClass("toggled")) {
      $("body").addClass("sidebar-toggled");
      $(".sidebar").addClass("toggled");
      $('.sidebar .collapse').collapse('hide');
    };
  });

  // Impedir que o wrapper de conteúdo role quando a navegação lateral fixa parou sobre
  $('body.fixed-nav .sidebar').on('mousewheel DOMMouseScroll wheel', function(e) {
    if ($(window).width() > 768) {
      var e0 = e.originalEvent,
        delta = e0.wheelDelta || -e0.detail;
      this.scrollTop += (delta < 0 ? 1 : -1) * 30;
      e.preventDefault();
    }
  });

  // Exibe o botão de rolagem para cima
  $(document).on('scroll', function() {
    var scrollDistance = $(this).scrollTop();
    if (scrollDistance > 100) {
      $('.scroll-to-top').fadeIn();
    } else {
      $('.scroll-to-top').fadeOut();
    }
  });

  //Rolagem para cima usando jQyert  
  $(document).on('click', 'a.scroll-to-top', function(e) {
    var $anchor = $(this);
    $('html, body').stop().animate({
      scrollTop: ($($anchor.attr('href')).offset().top)
    }, 1000, 'easeInOutExpo');
    e.preventDefault();
  });

})(jQuery);

$('#dataTable').on('click', 'tbody tr', function(event) {
  $(this).addClass('highlight').siblings().removeClass('highlight');
});

// Alterna o modal de inclusão quando ocorre edição do registro
var alternarOperacaoNovoOuEdicao = function(event, op, descricao) { 
  
  var elemento = document.getElementById(event);
  if (op === 'edit') {    
    elemento.innerHTML = "Editar " + descricao;
  } else {
    elemento.innerHTML = "Adicionar " + descricao;    
  }
}

function alternaFila(url){
    debugger
   ckb = $("#filaAtiva").is(':checked');
   url +=('&ativo='+ ckb);
  $.ajax({ url: url });    
  setTimeout(function(){
      location.reload(true); 
    }, 500);    
}


function carregarDadosEdicao(event, op, descricao, listParams, listValores) { 
   
   for (var i = 0; i < listParams.length; i++) {
       if (event == 'usuarioModalLabel' && i == 4)
           document.getElementById(listParams[i]).checked = listValores[i] == 'S' ? true : false
       else if (listParams[i] == "operacao"){
            if (listValores[i] == "C"){
                document.getElementById("credito").checked = true; 
            }
            else
                document.getElementById("debito").checked = true; 
        }
        else
             document.getElementById(listParams[i]).value =  listValores[i]; //(op == 'edit' || op == 'delete') ? listValores[i] : '';   
     }
    alternarOperacaoNovoOuEdicao(event, op, descricao);  
}

// Função que só permite números no CPF
function permiteSoNumeros(evt) {  
  var entrada = (evt.which) ? evt.which : evt.keyCode
  if (entrada > 31 && (entrada < 48 || entrada > 57))
      return false;
  return true;
}

//Função que formata o CPF via REGEX
function formatarCPF(evt){  
  var elemento = document.getElementById(evt);
  if (elemento.value.length === 11) {
    const cpf = document.querySelector('#' + evt);    
    let value = cpf.value.replace(/^([\d]{3})([\d]{3})([\d]{3})([\d]{2})$/, "$1.$2.$3-$4");        
    cpf.value = value;  
  } 
}

function recuperarServicosSelecionados(url) {
    var options = document.getElementById('servicosSelecionados').selectedOptions;
    var servicos = Array.from(options).map(({ value }) => value);
    var fila = document.getElementById("filaSelect").value;
    
    url+="&fila=" + fila + "&servicos=" + servicos;
    
    $.ajax({ url: url, type: "POST" });    
    setTimeout(function(){
      location.reload(true); 
    }, 1000);    
    
}

function charmarProximo(url) {
    debugger
    $.ajax({ url: url, type: "POST" });    
    setTimeout(function(){
      location.reload(true); 
    }, 1000);    
    
}