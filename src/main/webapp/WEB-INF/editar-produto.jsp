<%-- 
    Document   : editar-produto
    Created on : 18/10/2019, 19:56:31
    Author     : pablo.osantana
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
            <a class="navbar-brand" href="${pageContext.request.contextPath}/backoffice/backoffice">Postos Tades</a>
            <div class="nav-item text-nowrap">
                <a class="nav-link" href="#">Sair</a>
            </div>
        </nav>
    </header>
    <body>
        <div class="page-title">
            <h1>Editar Produto</h1>
        </div>

        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/backoffice/cadastrar-produto">Cadastrar Produto</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/backoffice/pesquisar-produto">Pesquisar Produto</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Visualizar Vendas</a>
            </li>
        </ul>

        <form method="post" action="${pageContext.request.contextPath}/backoffice/editar-produto" class="needs-validation" novalidate>
            <input type="hidden" name="id" value="${idAttr}">
            
            <input type="hidden" name="id" value="${idAttr}">
            <div class="form-group row">
                <label for="inputNome" class="col-md-1 offset-md-3">Nome*:</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" name="nome" id="inputNome" value="${nomeAttr}" placeholder="Digite o nome do Produto" required>
                    <div class="invalid-feedback">
                        Digite um nome
                    </div>
                </div>
            </div>
           <div class="form-group row">
                <label for="inputTipo" class="col-md-1 offset-md-3">Tipo*:</label>
                <div class="col-sm-4">
                    <select name="tipo" id="tipo" class="form-control">
                        <option selected>Outros</option>
                        <option>Combustivel</option>
                        <option>Acessórios</option>
                        <option>Óleo</option>
                    </select>
                    <div class="invalid-feedback">
                        Selecione um tipo
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label for="inputPreco" class="col-md-1 offset-md-3">Preço*:</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" name="preco" id="inputPreco" value="${precoAttr}" placeholder="9,99" pattern="[0-9]+([,\.][0-9]+)?" min="0" step="any" required>
                    <div class="invalid-feedback">
                        Digite um Preço
                    </div>
                </div>

                <label for="inputQtd" class="col-sm-1 col-form-label">Quantidade*:</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" name="quantidade" value="${qntAttr}" id="inputQtd" placeholder="12,5 para litros ou 15 para unidade" pattern="[0-9]+([,\.][0-9]+)?" min="0" step="any" required>
                    <div class="invalid-feedback">
                        Digite uma quantidade
                    </div>
                </div>
            </div>

            <div class="form-group row">
                <label for="inputEmail" class="col-md-1 offset-md-3">Filial*:</label>
                <div class="form-check-inline">
                     <c:forEach items="${filiaisAttr}" var="filial">
                         <input class="form-check-input" type="radio" name="filial" id="${filial}" value="${filial}" required>
                         <label class="form-check-label" for="filial"><c:out value="${filial}" /></label>
                    </c:forEach>
                </div>
            </div>
                    
            <div class="button-group">
                <button class="btn btn-lg btn-success col-md-2 offset-md-4" type="submit">Confirmar</button>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/backoffice/backoffice" class="col-md-2 btn btn-lg btn-danger">Cancelar</a>
            </div>
        </form>
        <div style="margin-top: -500px; width: 203px; height: 640px; background-color: black;"></div>
    </body>
    <script>
        (function () {
            'use strict';
            window.addEventListener('load', function () {
                var forms = document.getElementsByClassName('needs-validation');
                var validation = Array.prototype.filter.call(forms, function (form) {
                    form.addEventListener('submit', function (event) {
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
</html>