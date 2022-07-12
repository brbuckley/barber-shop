<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>DAC - UFF - Web BarberShop - Login</title>
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <link href="css/barbershop.css" rel="stylesheet">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">    
</head>

<body class="bg-light align-middle">
    <div class="container pt-1">        
        <div class="row justify-content-center">
            <div class="col-xl-6 col-lg-12 col-md-9">
                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Linha aninhada dentro do corpo do card -->
                        <div class="row">                           
                            <div class="col-lg-12">
                                <div class="p-3">
                                    <div class="text-center">
                                        <img src="img/logo_principal.png" width="200px" height="200px" class="h4 text-gray-900 mb-4"><b><h1>Web BarberShop</h1></b>
                                    </div>
                                    <form class="user" method="post" action="${pageContext.request.contextPath}/AutenticacaoController">                                        
                                        <div class="form-group">
                                            <input type="text" maxlength="11" class="form-control form-control-user"
                                                id="cpf" name="cpf" placeholder="Informe seu email">                                               
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                id="senha" name="senha" onkeyup="validarNomeSenha()" placeholder="Senha">
                                        </div>
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input" id="customCheck">
                                                <label class="custom-control-label" for="customCheck">Lembrar</label>                                                   
                                            </div>
                                        </div>
                                        <button  value="Submit" disabled="true" type="submit" id="btnEntrar" class="btn btn-primary btn-user btn-block">
                                            Entrar
                                        </button>
                                        <hr>                                       
                                    </form>  
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
                                        
        <!-- Footer -->
            <footer class="sticky-footer  bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; DAC - Web BarberShop<br>Desenvolvimento de aplicações Coorporativas - 2022.1</span>
                    </div>
                </div>
            </footer>
        <!-- End of Footer -->
        
    <script>
        //Função que formata o CPF via REGEX
        const cpf = document.querySelector("#cpf");
        cpf.addEventListener("blur", () => {
        let value = cpf.value.replace(/^([\d]{3})([\d]{3})([\d]{3})([\d]{2})$/, "$1.$2.$3-$4");        
        cpf.value = value;
    });
     // Mantem somente numero
    function permiteSoNumeros(evt) {
        var entrada = (evt.which) ? evt.which : evt.keyCode
        if (entrada > 31 && (entrada < 48 || entrada > 57))
            return false;
        return true;
    }
    
    function validarNomeSenha(){        
        if (document.querySelector("#cpf").value != '' && document.querySelector("#senha").value != '') 
            document.querySelector("#btnEntrar").disabled = false;
        else
            document.querySelector("#btnEntrar").disabled = true;
    }   
    </script>

    <!-- Bootstrap principal JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Plugin Core JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Scripts personalizados para todas as pÃ¡ginas -->
    <script src="js/barbershop.js"></script>

</body>
</html>