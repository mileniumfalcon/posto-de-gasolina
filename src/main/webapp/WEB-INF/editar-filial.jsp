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
          <a class="navbar-brand" href="${pageContext.request.contextPath}/diretor"><i class="fas fa-gas-pump"></i> Postos Tades</a>
      <div class="nav-item text-nowrap">
          <a class="nav-link" href="${pageContext.request.contextPath}/logout">Sair</a>
      </div>
    </nav>
  </header>
  <body>
      <div class="page-title">
          <h1>Editar Filial</h1>
      </div>
      <ul class="nav flex-column" style="float: left;">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/diretor/cadastrar-filial">Cadastrar Filial</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/diretor/pesquisar-filial">Pesquisar Filial</a>
        </li>
        <li class="nav-item nav-item-last">
          <a class="nav-link" href="${pageContext.request.contextPath}/diretor/relatorio-filial">Emitir Relatório</a>
        </li>
      </ul>
       <form method="post" action="${pageContext.request.contextPath}/diretor/editar-filial" class="needs-validation" novalidate>
           <input type="hidden" class="form-control" name="id" value="${idAttr}">
           <br>
            <div class="form-group row">
              <label for="inputNome" class="col-md-1 offset-md-2">Nome*:</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" name="nome" id="inputNome" value="${nomeAttr}" placeholder="Digite o nome de uma filial" required>
                 <div class="invalid-feedback">
                  Nome da filial
                </div>
              </div>
            </div>
            <div class="form-group row">
              <label for="inputEndereco" class="col-md-1 offset-md-2">Endereço*:</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" name="endereco" id="inputEndereco" value="${enderecoAttr}" placeholder="Av/Rua fulano, 123" required>
                <div class="invalid-feedback">
                    Digite um endereço
                </div>
              </div>
            </div>            
            <div class="form-group row">
              <label for="inputCep" class="col-md-1 offset-md-2">CEP*:</label>
              <div class="col-sm-2">
                <input type="text" class="form-control" name="cep" id="inputCep" value="${cepAttr}" placeholder="xxxxx-xxx" onkeypress="$(this).mask('00000-000');" required>
                <div class="invalid-feedback">
                    Digite um CEP
                </div>
              </div>         
              <br><br>
                <div class="form-group row">
                  <div class="col-sm-10">
                <select class="form-control" name="estado" id="estado" value="${estadoAttr}">
                  <option selected>Estados</option>
               <option value="AC">Acre</option>
                <option value="AL">Alagoas</option>
                <option value="AP">Amapá</option>
                <option value="AM">Amazonas</option>
                <option value="BA">Bahia</option>
                <option value="CE">Ceará</option>
                <option value="DF">Distrito Federal</option>
                <option value="ES">Espírito Santo</option>
                <option value="GO">Goiás</option>
                <option value="MA">Maranhão</option>
                <option value="MT">Mato Grosso</option>
                <option value="MS">Mato Grosso do Sul</option>
                <option value="MG">Minas Gerais</option>
                <option value="PA">Pará</option>
                <option value="PB">Paraíba</option>
                <option value="PR">Paraná</option>
                <option value="PE">Pernambuco</option>
                <option value="PI">Piauí</option>
                <option value="RJ">Rio de Janeiro</option>
                <option value="RN">Rio Grande do Norte</option>
                <option value="RS">Rio Grande do Sul</option>
                <option value="RO">Rondônia</option>
                <option value="RR">Roraima</option>
                <option value="SC">Santa Catarina</option>
                <option value="SP">São Paulo</option>
                <option value="SE">Sergipe</option>
                <option value="TO">Tocantins</option>
                <option value="EX">Estrangeiro</option>
               </select>
              </div>
            </div>               
             
            </div>
          
            <div class="button-group">
                <button class="btn btn-lg btn-success col-md-2 offset-md-2" type="submit">Editar</button>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/diretor" class="col-md-2 btn btn-lg btn-danger">Cancelar</a>
            </div>
        </form>       
  </body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
<script src="https://kit.fontawesome.com/1803175e4f.js" crossorigin="anonymous"></script>
</html>

