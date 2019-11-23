<%-- 
    Document   : realizar-venda
    Created on : Nov 9, 2019, 9:36:04 PM
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
        <form method="post" action="${pageContext.request.contextPath}/vendedor/realizar-venda"class="needs-validation col-sm-9" style="width: 1095px height 4px;">


            <div class="table-wrapper-scroll-y my-custom-scrollbar col-sm-">
                <table class="table table-sm-1 offset-md-1" style="width: 35%; margin-top: 65px; float:left;">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Preco</th>
                            <th scope="col">Quantidade</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach items="${produtosAttr}" var="produto">
                            <tr>
                                <td><input type="radio" id="idProduto" name="idProduto" value="${produto.getId()}" ></td>
                                <td id="nomeProduto" name="nomeProduto">${produto.getNome()}</td>
                                <td id="valor" name="valor">${produto.getVlrUnitario()}</td>
                                <td id="qtdProduto" name="qtdProduto">${produto.getQtdProduto()}</td>
                            </tr>  
                        </tbody>
                    </c:forEach>    
                </table>
            </div>
            <div class="col-sm-8" style="position: absolute; margin-left: 100px;">
                <label for="inputQtd" class="col-md-2 offset-md-2">Qtd Item a venda:</label>
                <input type="number" class="col-md-2 offset-md-2" name="qtdItem" id="qtdItem" placeholder="X" required>

                <button class="btn btn-primary"type="submit" >Adicionar</button> 

                <div class="invalid-feedback">
                    Digite uma quantidade
                </div>

            </div>
        </form>


        <!--<form method="post" action="${pageContext.request.contextPath}/vendedor/realizar-venda">
           
        </form> -->

        <table class="table table-sm-1 offset-md-1" style="width: 35%; margin-top: -219px; float:right; margin-right: 70px;">
            <thead>
                <tr>
                    <th scope="col">Nome</th>
                    <th scope="col">Qtd</th>
                    <th scope="col">Total</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${itensAttr}" var="itensVenda">
                    <tr>
                        <td id="nomeItem" name="nomeItem"><c:out value="${itensVenda.getProduto().getNome()}" /></td>
                        <td id="qtdItem" name="qtdItem"><c:out value="${itensVenda.getQuantidade()}" /></td>
                        <td id="totalItem" name="totalItem"><c:out value="${itensVenda.vlrTotalItem()}" /></td>
                    </tr>  
                </tbody>
            </c:forEach> 
        </table>
        <strong><p style="text-align: center; font-size: 20px;">Total do dia: R$ <c:out value="${totalAttr}" /></p></strong>
        <!--?id=${idAttr}-->                   
        <form method="post" action="${pageContext.request.contextPath}/vendedor/venda-finalizada"class="needs-validation col-sm-9" style="width: 1095px height 4px;">

            <button class="btn btn-primary"type="submit" style="float: right; margin-right: 80px;">Finalizar</button> 
        </form>

        <c:if test="${naoPermitidoAttr}">
            <div class="alert alert-danger" >
                Quantidade não permitida!
            </div>
        </c:if>

    </body>
    <script>

        $("#table tr").click(function () {
            $(this).addClass('selected').siblings().removeClass('selected');
            var value = $(this).find('td:first').html();
            alert(value);
        });

        $('.ok').on('click', function (e) {
            alert($("#table tr.selected td:first").html());
        });
    </script>
</html>
