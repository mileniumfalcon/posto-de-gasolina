<%-- 
    Document   : venda-incluir-cliente
    Created on : Nov 7, 2019, 10:41:16 PM
    Author     : Pablo de Oliveira
--%>


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
            <a class="navbar-brand" href="${pageContext.request.contextPath}/vendedor">Postos Tades</a>
            <div class="nav-item text-nowrap">
                <a class="nav-link" href="#">Sair</a>
            </div>
        </nav>
    </header>
    <body>
        <div class="page-title">
            <h1>Realizar Venda</h1>
        </div>
        <div class="page-title" style="padding-top: 10px;; margin-right: 50px; margin-left: 50px">
            <h4>Incluir cliente na venda?</h4>
        </div>
       <ul class="nav flex-column" style="float: left;">
        <li class="nav-item">
          <a class="nav-link" href="vendedor/vendas">Realizar Venda</a>
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
      
        <form method="get" action="${pageContext.request.contextPath}/vendedor/pesquisa-de-cliente" class="needs-validation" novalidate>
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
                <a data-method="get" href="${pageContext.request.contextPath}/vendedor/#?id=${idAttr}" class="btn btn-primary mb-1" >Incluir</a>
                <br>
                <br>
                 <a data-method="get" href="${pageContext.request.contextPath}/vendedor/#?id=${idAttr}" class="btn btn-primary mb-1" >Não Incluir</a>
              </div>
            </div>
        </form>

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
</html>
