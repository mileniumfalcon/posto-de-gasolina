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
          <a class="navbar-brand" href="${pageContext.request.contextPath}/vendedor"><i class="fas fa-gas-pump"></i> Postos Tades</a>
      <div class="nav-item text-nowrap">
          <a class="nav-link" href="${pageContext.request.contextPath}/logout">Sair</a>
      </div>
    </nav>
  </header>
  <body>
      <div class="page-title">
          <h1>Editar Pessoa Juridica</h1>
      </div>
      
      <ul class="nav flex-column" style="float: left;">
        <li class="nav-item">
          <a class="nav-link" href="#">Realizar Venda</a>
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

        <form method="post" action="${pageContext.request.contextPath}/vendedor/editar-juridico" class="needs-validation" novalidate>
            <br>
            <input type="hidden" name="id" value="${idAttr}">
            
            <div class="form-group row">
              <label for="inputNome" class="col-md-1 offset-md-2">Nome*:</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" name="nome" id="inputNome" value="${nomeAttr}" placeholder="Digite o nome completo" required>
                 <div class="invalid-feedback">
                    Digite um nome
                </div>
              </div>
            </div>
            <div class="form-group row">
              <label for="inputEndereco" class="col-md-1 offset-md-2">Endereço*:</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" name="endereco" id="inputEndereco" value="${enderecoAttr}" placeholder="Av/Rua fulano, 234" required>
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
              
              <label for="inputCnpj" class="col-sm-1 col-form-label">CNPJ*:</label>
              <div class="col-sm-2">
                <input type="text" class="form-control" name="cnpj" id="inputCnpj" value="${cnpjAttr}" placeholder="xx.xxx.xxx/xxxx-xx" onkeypress="$(this).mask('00.000.000/0000-00');" required>
                <div class="invalid-feedback">
                    Digite um CPF
                </div>
              </div>
            </div>
            
            <div class="form-group row">
              <label for="inputTelefone" class="col-md-1 offset-md-2">Telefone*:</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" name="telefone" id="inputTelefone" value="${telefoneAttr}" placeholder="(XX)xxxx-xxxx" onkeypress="$(this).mask('(00)0000-0000');" required>
                <div class="invalid-feedback">
                    Digite uma data de nascimento
                </div>
              </div>
            </div>
             
            <div class="form-group row">
              <label for="inputEmail" class="col-md-1 offset-md-2">Email*:</label>
              <div class="col-sm-4">
                <input type="email" class="form-control" name="email" id="inputNome" value="${emailAttr}" placeholder="seuemail@email.com" required>
                <div class="invalid-feedback">
                    Digite um email
                </div>
              </div>
            </div>
            
            <div class="button-group">
                <button class="btn btn-lg btn-success col-md-2 offset-md-2" type="submit">Editar</button>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/vendedor" class="col-md-2 btn btn-lg btn-danger">Cancelar</a>
            </div>
        </form>
  </body>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script
<script src="https://kit.fontawesome.com/1803175e4f.js" crossorigin="anonymous"></script>
</html>

