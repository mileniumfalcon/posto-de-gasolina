<%-- 
    Document   : venda-incluir-cliente
    Created on : Nov 7, 2019, 10:41:16 PM
    Author     : Pablo de Oliveira
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.scss" media="screen" />
        <title>Posto Tades</title>
    </head>
    <header>
        <nav class="navbar navbar-light nav-color">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/vendedor"><i class="fas fa-gas-pump"></i> Postos Tades</a>
            <div class="nav-item text-nowrap">
                <a class="nav-link" href="#">Sair</a>
            </div>
        </nav>
    </header>
    <body>
        <div class="page-title">
            <h1>Realizar Venda</h1>
        </div>
       <ul class="nav flex-column" style="float: left;">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/vendedor/venda-incluir-cliente">Realizar Venda</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/vendedor/cadastrar-fisico">Cadastrar Pessoa Física</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/vendedor/cadastrar-juridico">Cadastrar Pessoa Juridica</a>
        </li>
        <li class="nav-item nav-item-last">
          <a class="nav-link" href="${pageContext.request.contextPath}/vendedor/pesquisar-cliente">Pesquisar Cliente</a>
        </li>
      </ul>
        
        <div class="page-title" style="margin-right: 235px;">
            <h4>Incluir cliente na venda?</h4>
        </div>
      
      <form method="get" action="${pageContext.request.contextPath}/vendedor/venda-incluir-cliente" class="needs-validation" novalidate>
            <br>
            <div class="form-group row">
              <label for="inputDoc" class="col-md-1 offset-md-2">CPF/CNPJ:</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" name="documento" id="inputDoc" placeholder="Digite o cpf/cnpj do cliente" required>
                 <div class="invalid-feedback">
                    Digite um CPF ou CNPJ
                </div>
              </div>
              <div class="col-sm-4">
                <button type="submit" class="btn btn-primary mb-2">Pesquisar</button>
                <br><br>
                <a data-method="post" href="${pageContext.request.contextPath}/vendedor/realizar-venda" class="btn btn-primary mb-1" >Não Incluir</a>
              </div>
            </div>
        </form>
                    <c:if test="${naoEncontradoAttr}">
                <div class="alert alert-danger">
                    Cliente não encontrado
                </div>
            </c:if>
            
            <c:if test="${nomeAttr != null}">
                <table class="table table-sm offset-md-2" style="width: 75%;">
                    <thead>
                      <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Nome/Razão Social</th>
                        <th scope="col">CPF/CNPJ</th>
                        <th scope="col"> </th>
                        
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <th scope="row"><c:out value="${idAttr}"/></th>
                        <td ><c:out value="${nomeAttr}"/></td>
                        <td> <c:out value="${documentoAttr}"/></td>
                        <c:choose>
                            <c:when test="${fn:length(documentoAttr) == 14}">
                                <td><a data-method="get" href="${pageContext.request.contextPath}/vendedor/realizar-venda?id=${idAttr}" class="btn btn-primary mb-1" >Incluir</a></td>
                            </c:when>
                            <c:otherwise>
                                <td><a data-method="get" href="${pageContext.request.contextPath}/vendedor/realizar-venda?id=${idAttr}" class="btn btn-primary mb-1" >Incluir</a></td>
                            </c:otherwise>
                        </c:choose>
                       </tr>
                    </tbody>
                  </table>
          </c:if>


           <!-- <c:if test="${naoEncontradoAttr}">
                <div class="alert alert-danger">
                    Cliente não encontrado
                </div>
            </c:if> -->
            
    </body>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
    <script src="https://kit.fontawesome.com/1803175e4f.js" crossorigin="anonymous"></script>
</html>
