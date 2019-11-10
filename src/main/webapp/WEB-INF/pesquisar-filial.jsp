<%-- 
    Document   : pesquisar-filial
    Created on : 22/10/2019, 20:05:13
    Author     : victor.salves5
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <!-- Meta tags ObrigatÃ³rias -->
  <!-- HTML 4 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- HTML5 -->
<meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!-- Style CSS --> 
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" media="screen" />
    <title>Posto Tades</title>
  </head>
  <body>
      
  
    <nav class="navbar navbar-dark fixed-top bg-warning  flex-md-nowrap p-0 shadow">
      <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Postos Tades</a>
          <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
          <a class="nav-link" href="#">Sair</a>
        </li>
      </ul>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-preto sidebar">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <br><br><br><br>
              <li class="nav-item">
                <a class="nav-link linha " href="${pageContext.request.contextPath}/diretor/cadastrar-filial">               
                  Cadastrar filial 
                </a>
                <br><br><br><br><br><br>
              </li>
              <li class="nav-item">
                <a class="nav-link active linha" href="${pageContext.request.contextPath}/diretor/pesquisar-filial">
                 Pesquisar Filial
                </a>
              </li>
              <br><br><br><br><br><br>

<li class="nav-item"><a class="nav-link linha" href="${pageContext.request.contextPath}/diretor/relatorio-filial">
Emitir Relatório
 </a>
</li><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>     
            </ul>
          </div>
        </nav>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
              <br> <br><br><br><br><br><br><br><br><br><br>
            <h1 class="h2">Pesquisar Filial</h1>
            <div class="btn-toolbar mb-2 mb-md-0">
              </div>
          </div><div><br><br><br><br></div>
               <form method="get" action="${pageContext.request.contextPath}/diretor/pesquisar-filial" class="needs-validation" novalidate>
            <div class="form-group row">
                <label for="inputNome" class="col-md-1 offset-md-3">Nome:</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" name="nome" id="nome" placeholder="Digite o nome da filial" required>
                    <div class="invalid-feedback">
                        Digite o nome da filial
                    </div>
                </div>
                <div class="col-sm-4">
                    <button type="submit" class="btn btn-warning mb-2">Pesquisar</button>
                </div>
            </div>
        </form> 
 <c:if test="${naoEncontradoAttr == true}">
            <div class="alert alert-danger">
               Filial não encontrada
            </div>
        </c:if>
           <c:if test="${naoEncontradoAttr == null}">

        </c:if>

         <c:if test="${idfilial != null}">
                 <table class="table-borderless table-sm" style="width: 75%;">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Estado</th>
                        <th scope="col">Endereço</th>
                        <th scope="col">Cep</th>
                        <th scope="col"></th>
                          <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th> <c:out value="${idfilial}"/></th>
                        <td ><c:out value="${nomefilial}"/></td>
                        <td><c:out value="${enderecofilial}"/></td>
                        <td> <c:out value="${estadofilial}"/></td>
                        <td> <c:out value="${cepfilial}"/></td>
                        <td><a data-method="get" href="${pageContext.request.contextPath}/diretor/editar-filial?id=${idfilial}" class="btn btn-warning mb-1" >Editar</a></td>
                        <td><a class="btn  mb-1 btn-warning" data-toggle="modal" data-target="#p${filial.getId()}">Excluir</a></td>   
                    </tr>
                </tbody>
            </table>
                    
                    <!-- Modal de Confirmação de Exclusão-->
                       <div class="modal fade" id="p${filial.getId()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                  <div class="modal-dialog" role="document">
                    <div class="modal-content">
                      <div class="modal-body">
                          Tem certeza que deseja excluir a Filial <c:out value="${filial.getNome()}"/>
                      </div>
                      <div class="modal-footer">
                        <form action="${pageContext.request.contextPath}/diretor/excluir-filial" method="post">
                            <button class="btn btn-success" type="submit" name="id" id="confirmDeleteButton" value="${idfilial}">Confirmar</button>
                        </form>
                        
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                      </div>
                    </div>
                  </div>
                </div> 
             </c:if>
        </main>
    <!-- Principal JavaScript do Bootstrap
    ================================================== -->
    <!-- Foi colocado no final para a pÃ¡gina carregar mais rÃ¡pido -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../assets/js/vendor/popper.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>

   <script>
    (function() {
      'use strict';
      window.addEventListener('load', function() {
        var forms = document.getElementsByClassName('needs-validation');
        var validation = Array.prototype.filter.call(forms, function(form) {
          form.addEventListener('submit', function(event) {
            if (form.checkValidity() === false) {
              event.preventDefault();
              event.stopPropagation();
            }
            form.classList.add('was-validated');
          }, false);
        });
      }, false);
    })();
   </script>
    <script>
      feather.replace();
    </script>


    <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>