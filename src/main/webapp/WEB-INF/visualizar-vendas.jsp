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
        <h1>Relatório de Produtos</h1>
    </div>

    <ul class="nav flex-column" style="float: left;">
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/backoffice/cadastrar-produto">Cadastrar Produto</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/backoffice/pesquisar-produto">Pesquisar Produto</a>
      </li>
      <li class="nav-item nav-item-last"">
        <a class="nav-link" href="${pageContext.request.contextPath}/backoffice/visualizar-vendas">Visualizar Vendas    </a>
      </li>
    </ul>
    <br>
    <form method="get" action="${pageContext.request.contextPath}/backoffice/" class="needs-validation" novalidate>
        <br>
        <div class="form-group row">
            <label for="inputDataInicio" class="col-sm-1 offset-md-1">Data Inicio: </label>
            <div class="col-sm-2">
                <input type="text" class="form-control" name="dataInicio" id="dataInicio" placeholder="xx/xx/xxxx" onkeypress="$(this).mask('00/00/0000');" required>
                <div class="invalid-feedback">
                    Digite uma data inicial
                </div>
            </div>

            <label for="inputDataFinal" class="col-sm-1 offset-md-0">Data Final:</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" name="dataFinal" id="dataFinal" placeholder="xx/xx/xxxx" onkeypress="$(this).mask('00/00/0000');" required>
                <div class="invalid-feedback">
                    Digite uma data final
                </div>
            </div>
            
            <label for="inputDataFinal" class="col-sm-1 offset-md-0">Filial:</label>
            <div class="col-sm-2">
                <select class="form-control" name="filial" id="filial" placeholder="Filial">
                    <option value="AC">Teste</option>
                </select>
            </div>
        </div>
        <br><br>
        <div class="button-group">
            <button class="btn btn-primary btn-md mb-2 offset-md-3" type="submit">Mais Vendidos</button>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <td><a data-method="get" href="${pageContext.request.contextPath}/gerente-vendas/relatorios-gerente?data=atual" class="btn btn-primary mb-2" >Menos Vendidos</a></td>
        </div>
    </form>
        
  </body>
  <script src="https://kit.fontawesome.com/1803175e4f.js" crossorigin="anonymous"></script>
</html>