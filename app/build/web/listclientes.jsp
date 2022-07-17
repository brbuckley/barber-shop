<%@page  language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>DAC - UFF - Web BarberShop - Clientes</title>

    <!-- Fontes personalizados para o template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Estilos personalizados para o template -->
    <link href="css/barbershop.css" rel="stylesheet">

    <!-- Estilos personalizados para esta página -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">    
</head>

<body id="page-top">

    <!-- Container principal da página -->
    <div id="wrapper">

        <!-- Barra de menu lateral -->      
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
            <!-- Barra lateral - Logo Uff -->
           <a class="sidebar-brand d-flex align-items-center justify-content-center" href="home.jsp">
                <div class="sidebar-brand-icon">
                    <img src="img/logo_principal.png" alt="Logo UFF" width="100" height="100">
                </div>
            </a>

            <!-- Divisor -->
            <hr class="sidebar-divider my-0 mt-5">

            <!-- Item em negrito - Painel de controle -->
            <li class="nav-item active">
                <a class="nav-link" href="home.jsp">
                    <i class="fas fa-tasks"></i>
                    <span>Painel de Controle</span></a>
            </li>

            <!-- Divisor -->
            <hr class="sidebar-divider">

        <!-- Menu Admin -->
        <div id="gerenciamentoadmin" style="${adm}">
        <div class="sidebar-heading">
            Área Admin
        </div>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/ServicoController?action=listservicos">
                    <i class="fas fa-sitemap"></i>
                    <span>Serviços</span></a>
            </li>

            <!-- Item de navegação - Funcionalidades do menu colapsado -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>Gerenciar Acessos</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Gerenciamentos</h6>
                        <a class="collapse-item" href="${pageContext.request.contextPath}/ClienteController?action=listcliente">Clientes</a>      
                        <a class="collapse-item" href="${pageContext.request.contextPath}/AdminController?action=listadmin">Administradores</a>   
                       <a class="collapse-item" href="${pageContext.request.contextPath}/BarbeiroController?action=listbarbeiro">Funcionários</a>                                  
                    </div>
                </div>
            </li>
            <!-- Divisor -->
            <hr class="sidebar-divider">
        </div>
                    
            <!-- Cabeçalho -->
            <div id="menuusuario" style="${usu}">
                <div class="sidebar-heading">               
                    <span>Acessar</span>
                </div>            

                <!-- Nav Item - Filas -->
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ContaController?action=listconta&id=${sessionScope.idUsuarioLogado}&session=${sessionScope.usuarioLogado}">
                        <i class="fas fa-file-invoice-dollar"></i>
                        <span>Filas</span></a>
                </li>
                
                 <!-- Nav Item - Dados Pessoais -->
                 <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ContaController?action=listconta&id=${sessionScope.idUsuarioLogado}&session=${sessionScope.usuarioLogado}">
                        <i class="fas fa-file-invoice-dollar"></i>
                        <span>Dados Pessoais</span></a>
                </li>
 
                <!-- Divisor -->
                <hr class="sidebar-divider d-none d-md-block">
            </div> 

           <!-- Botao para recolher menu lateal -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>
        <!-- Fim da barra lateral -->

        <!-- Conteúdo do container -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Conteúdo principal -->
            <div id="content">

                <!-- Barra superior -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Alternância da barra lateral (Barra superior) -->
                    <form class="form-inline">
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>
                    </form>                   

                    <!-- Navegação da barra superior -->
                    <ul class="navbar-nav ml-auto">       
                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Item de navegação - Informações do usuário -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">${sessionScope.usuarioLogado}</span>
                                <img class="img-profile rounded-circle"
                                    src="img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - Informações do usuário -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#perfilModal">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Perfil
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Sair
                                </a>
                            </div>
                        </li>
                    </ul>

                </nav>
                <!-- Fim da barra superior -->

                <!-- Inicio do conteúdo da página -->
                <div class="container-fluid">

                    <div class="row">
                        <div class="col-md-11">
                            <h1 class="h3 mb-2 text-gray-800">Clientes</h1>
                            <p class="mb-4">Área para manuteção de clientes.</p> 
                        </div>                                   
                    </div>

                    <!-- Tabela de serviços -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Área Admin > Clientes</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Nome</th>   
                                              <th>Idade</th>
                                            <th>Email</th>   
                                             <th>Data Nascimento</th>      
                                               <th>Endereço</th>
                                            <th></th> 
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Id</th>
                                            <th>Nome</th>   
                                              <th>Idade</th>
                                            <th>Email</th>       
                                            <th>Data Nascimento</th>       
                                               <th>Endereço</th>                                           
                                            <th></th> 
                                        </tr>
                                    </tfoot>
                                    <tbody>                                       
                                        <c:forEach items="${clientes}" var="cliente">
                                            <tr> 
                                                <td><c:out value="${cliente.id}" /></td>                                                
                                                <td><c:out value="${cliente.name}" /></td>    
                                                <td><c:out value="${cliente.age}" /></td> 
                                                <td><c:out value="${cliente.email}" /></td>   
                                                <td><c:out value="${cliente.birthday}" /></td> 
                                                <td><c:out value="${cliente.address}" /></td> 
                                                <td> 
                                                    <div class="text-center">
                                                        <a href="#" onclick="carregarDadosEdicao('clienteModalLabel', 'edit', 'Cliente', ['idCliente', 'name', 'email'], [ '<c:out value='${cliente.id}'/>', '<c:out value='${cliente.name}'/>', '<c:out value='${cliente.email}'/>'])" data-toggle="modal" data-target="#clienteModal">
                                                                <i class="fas fa-1x fa-edit pr-1"></i>                       
                                                        </a>
                                                        <a href="#" data-toggle="modal" onclick="carregarDadosEdicao('lancamentoLabel', 'delete', 'Cliente', ['id_exclusao'], [ '<c:out value='${cliente.id}'/>'])"   data-target="#exclusaoModal">
                                                                       <i class="fas fa-1x fa-trash-alt"></i>                    
                                                       </a>
                                                    </div>                                                           
                                                </td>                                                  						
                                            </tr>
                                        </c:forEach>                                                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- Fim do conteúdo principal -->

             <!-- Footer -->
            <footer class="sticky-footer  bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; DAC - Web BarberShop<br>Desenvolvimento de aplicações Coorporativas - 2022.1</span>
                    </div>
                </div>
            </footer>
        <!-- End of Footer -->

        </div>
        <!-- Fim do container do conteúdo -->

    </div>
    <!-- Fim do Container principal da página -->

    <!--Botão para rolagem para o topo -->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Modal de Logout-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Sair</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Tem certeza que deseja sair?</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                     <a class="btn btn-primary" href="${pageContext.request.contextPath}/AutenticacaoController?deslogar=sim">Sair</a>
                </div>
            </div>
        </div>
    </div>
    <!--Fim do Modal de Logout -->

    <!-- Modal de criação/edição de clientes -->
    <div class="modal fade" id="clienteModal" tabindex="-1" role="dialog" aria-labelledby="clienteModalLabel"
    aria-hidden="true">
       <div class="modal-dialog" role="document">
           <div class="modal-content">
               <div class="modal-header">
                   <h5 class="modal-title" id="clienteModalLabel">Edição de Clientes</h5>
                   <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                       <span aria-hidden="true">×</span>
                   </button>
               </div>
               <!-- Corpo do modal -->
               <form method="post" action="${pageContext.request.contextPath}/ClienteController?action=salvar">
                    <div class="modal-body">                    
                        <div class="row g-3">
                            <div class="col-md-12">
                              <input  name="idCliente" class="form-control" type="hidden" value="<c:out value="${cliente.id}"/>" id="idCliente"> 
                                <span style="float:left;margin-right: 15px;">
                                    <label for="username">Nome</label>
                                    <input style="" required="required" name="name" type="text" size="30" class="form-control" value="<c:out value="${cliente.name}" />" id="name" required> 
                                </span>
                                <span style="float:left;">
                                    <label for="name">Idade</label>
                                    <input id="age" name="age" size="10" type="text"  class="form-control" value="<c:out value="${cliente.birthday}" />" id="age" required>
                                </span>
                                <span style="float:left;margin-right: 15px;">
                                    <label for="username">Endereço</label>
                                    <input required="required" name="address" type="text" size="30" class="form-control" value="<c:out value="${cliente.address}" />" id="address" required> 
                                </span>
                                <span style="float:left;">
                                    <label for="name">Aniversário</label>
                                    <input id="birthday" name="birthday" size="10" type="text"  class="form-control" value="<c:out value="${cliente.birthday}" />" id="birthday" required>
                                </span>
                                <span>
                                    <label for="validacaoEmail" class="form-label">E-mail</label>
                                    <input  required="required" name="email" type="text" class="form-control" value="<c:out value="${cliente.email}" />" id="email" required> 
                              </span>
                            </div>
                        </div>                    
                    </div>
                    <div class="modal-footer" style="padding-left: 60%">
                        <button class="btn btn-primary"  value="Submit" type="submit">Gravar</button>
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>                   
                    </div> 
               </form>
           </div>
           
       </div>
   </div>
   <!--Fim modal de criação de serviços -->

    <!-- Modal de informações de usuários -->
   <div class="modal fade" id="perfilModal" tabindex="-1" role="dialog" aria-labelledby="perfilModalLabel"
   aria-hidden="true">
      <div class="modal-dialog" role="document">
          <div class="modal-content">
              <div class="modal-header">
                  <h5 class="modal-title" id="usuarioModalLabel">Informações do usuário logado</h5>
                  <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">×</span>
                  </button>
              </div>
              <!-- Corpo do modal -->
              <div class="modal-body">                    
                  <form class="row g-3 needs-validation" novalidate>
                      <div class="col-md-6">
                        <label for="nomeValicacao" class="form-label">Nome</label>
                        <label class="text-primary" for="nomeValicacao">${sessionScope.usuarioLogado}</label>                          
                      </div>
                      <div class="col-md-5">
                        <label class="form-label">Email</label>
                        <label class="text-primary" class="form-label">${cliente.emai}</label>
                      </div>                     
                  </form>             
              </div>
              <div class="modal-footer">
                  <button class="btn btn-primary" type="submit" data-dismiss="modal">Ok</button>                               
              </div>                
          </div>
      </div>
  </div>
  <!--Fim modal de informações do usuario logado -->

  

    <!-- Modal de exclusão -->
        <div class="modal fade" id="exclusaoModal" tabindex="-1" role="dialog" aria-labelledby="exclusaoModalLabel"
        aria-hidden="true">
            <div class="modal-dialog" role="document">

                    <div class="modal-content">    
                        <form method="post" action="${pageContext.request.contextPath}/ClienteController?action=delete">                            
                            <div class="modal-header">
                                <h5 class="modal-title" id="exclusaoModalLabel">Excluir Cliente</h5>
                                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">×</span>
                                </button>
                            </div>
                            <div class="modal-body">Tem certeza que deseja excluir?</div>
                            <input  name="id_exclusao" class="form-control" type="hidden"  value="<c:out value="${cliente.id}"/>" id="id_exclusao">   
                            <div class="modal-footer">
                                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                                <button class="btn btn-primary"  value="Submit" type="submit">Confirmar</button>
                            </div>
                        </form>
                    </div>
            </div>
        </div>
        <!--Fim do Modal de exclusão --> 


    <!-- Javascript principal do bootstrap -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Javascript principal do plugin -->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Script personalizado para todas as páginas -->
    <script src="js/barbershop.js"></script>

    <!-- Plugins externos -->
    <script src="vendor/datatables/jquery.dataTables.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Script do plugin externo -->
    <script src="js/datatables.js"></script>

</body>
</html>
