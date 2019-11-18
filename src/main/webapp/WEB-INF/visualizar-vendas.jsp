<%-- 
    Document   : visualizar-vendas
    Created on : Nov 17, 2019, 6:22:32 PM
    Author     : Pablo de Oliveira
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <a class="navbar-brand"><i class="fas fa-gas-pump"></i> Postos Tades</a>
            <div class="nav-item text-nowrap">
                <a class="nav-link" href="${pageContext.request.contextPath}/logout">Sair</a>
            </div>
        </nav>
    </header>
    <body>
        <div class="page-title">
            <h1>Painel BackOffice</h1>
        </div>

        <ul class="nav flex-column" style="float: left;">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/backoffice/cadastrar-produto">Cadastrar Produto</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/backoffice/pesquisar-produto">Pesquisar Produto</a>
            </li>
            <li class="nav-item nav-item-last"">
                <a class="nav-link" href="#">Visualizar Vendas    </a>
            </li>
        </ul>

        <div class="form-group row">
            <label for="inputDataInicio" class="col-md-1 offset-md-2">Data Inicio*:</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" name="dataInicio" id="inputDataInicio" placeholder="xx/xx/xxxx" onkeypress="$(this).mask('00/00/0000');" required>
                <div class="invalid-feedback">
                    Digite uma data inicio
                </div>
            </div>
            <label for="inputDataFim" class="col-md-1 offset-md-2">Data Fim*:</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" name="dataFim" id="inputDataFim" placeholder="xx/xx/xxxx" onkeypress="$(this).mask('00/00/0000');" required>
                <div class="invalid-feedback">
                    Digite uma data fim
                </div>
            </div>
        </div>

    </body>
    <script src="https://kit.fontawesome.com/1803175e4f.js" crossorigin="anonymous"></script>
</html>