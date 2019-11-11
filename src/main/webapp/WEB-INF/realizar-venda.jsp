<%-- 
    Document   : realizar-venda
    Created on : Nov 9, 2019, 9:36:04 PM
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
            <a class="navbar-brand">Postos Tades</a>
            <div class="nav-item text-nowrap">
                <a class="nav-link" href="#">Sair</a>
            </div>
        </nav>
    </header>
    <body>
        <div class="page-title">
            <h1>Painel Vendas</h1>
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

        <table class="table table-sm offset-md-2" style="width: 35%; margin-top: 70px;">
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Preco</th>
                    <th scope="col">Quantidade</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${produtosAttr}" var="produto">
                    <tr>
                        <th> <c:out value="${produto.getId()}"/></th>
                        <td ><c:out value="${produto.getNome()}"/></td>
                        <td><c:out value="${produto.getVlrUnitario()}"/></td>
                        <td> <c:out value="${produto.getQtdProduto()}"/></td>
                    </tr>  
                </tbody>
            </c:forEach>    
        </table>
    </body>
</html>
