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
      <a class="navbar-brand" href="${pageContext.request.contextPath}/gerente-vendas"><i class="fas fa-gas-pump"></i> Postos Tades</a>
      <div class="nav-item text-nowrap">
          <a class="nav-link" href="${pageContext.request.contextPath}/logout">Sair</a>
      </div>
    </nav>
  </header>
  <body>
      <div class="page-title">
          <h1>Detalhes Venda <c:out value="${vendaAttr.getId()}" /></h1>
      </div>
      <ul class="nav flex-column" style="float: left;">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/gerente-vendas/pesquisar-vendas">Pesquisar Vendas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/gerente-vendas/emitir-relatorio">Emitir Relatórios</a>
        </li>
        <li class="nav-item nav-item-last">
          <a class="nav-link" href="${pageContext.request.contextPath}/gerente-vendas/nivel-combustivel">Nível de Combustível</a>
        </li>
      </ul>
        <br>
        <strong><h3 style="text-align: center; margin-right: 100px;">Cliente</h3></strong>
        <c:choose>
            <c:when test="${vendaAttr.getCliente() == null}">
                <table class="table table-sm offset-md-2" style="width: 75%;">
                <tbody>
                    <tr>
                        <td style="text-align: center;">Não Identificado</td>
                     </tr>  
                </tbody>
            </table>
            </c:when>
            <c:otherwise>
                <table class="table table-sm offset-md-2" style="width: 75%;">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Endereço</th>
                        <th>CPF/CNPJ</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><c:out value="${vendaAttr.getCliente().getNome()}"/></td>
                        <td><c:out value="${vendaAttr.getCliente().getEmail()}"/></td>
                        <td><c:out value="${vendaAttr.getCliente().getEndereco()}"/></td>
                        <td><c:out value="${vendaAttr.getCliente().getDocumento()}"/></td>
                    </tr>  
                </tbody>
            </table>
            </c:otherwise>
        </c:choose>
        <br>
        <strong><h3 style="text-align: center; margin-right: 100px;">Itens</h3></strong>
        <table class="table table-sm offset-md-2" style="width: 75%;">
                <thead>
                    <tr>
                        <th>Produto</th>
                        <th>Preço</th>
                        <th>Quantidade</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${vendaAttr.getItens()}" var="item">
                    <tr>
                     
                        <td><c:out value="${item.getProduto().getNome()}"/></td>
                        <td>R$ <c:out value="${item.getProduto().getVlrUnitario()}"/></td>
                        <td> <c:out value="${item.getQuantidade()}"/></td>
                     </tr>                  
               </c:forEach>
               </tbody>
            </table>
        
        <br>
        <hr>
        <strong><p style="text-align: center; font-size: 40px;">Total Venda: R$<c:out value="${vendaAttr.getValorTotal()}" /></p></strong>
        <hr>
  </body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
<script src="https://kit.fontawesome.com/1803175e4f.js" crossorigin="anonymous"></script>
</html>
