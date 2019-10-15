<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/rh.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/rh.scss" media="screen" />
    <title>Posto Tades</title>
  </head>
  <header>
      <nav class="navbar navbar-light nav-color">
          <a class="navbar-brand" href="${pageContext.request.contextPath}/rh">Postos Tades</a>
      <div class="nav-item text-nowrap">
          <a class="nav-link" href="#">Sair</a>
      </div>
    </nav>
  </header>
  <body>
      <div class="page-title">
          <h1>Editar Funcionário</h1>
      </div>

      <ul class="nav flex-column">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/rh/cadastrar-funcionario">Cadastrar Funcionário</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/rh/pesquisar-funcionario">Pesquisar Funcionário</a>
        </li>
      </ul>
        
        <form method="post" action="${pageContext.request.contextPath}/rh/editar-funcionario" class="needs-validation" novalidate>
            <hidden> </hidden>
            <div class="form-group row">
              <label for="inputNome" class="col-md-1 offset-md-3">Nome*:</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" name="nome" id="inputNome" placeholder="Digite o nome completo" value="${nomeAttr}" required>
                 <div class="invalid-feedback">
                    Digite um nome
                </div>
              </div>
            </div>
            <div class="form-group row">
              <label for="inputEndereco" class="col-md-1 offset-md-3">Endereço*:</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" name="endereco" id="inputEndereco" placeholder="Av/Rua fulano, 234" value="${enderecoAttr}" required>
                <div class="invalid-feedback">
                    Digite um endereço
                </div>
              </div>
            </div>
            
            <div class="form-group row">
              <label for="inputCep" class="col-md-1 offset-md-3">CEP*:</label>
              <div class="col-sm-2">
                <input type="text" class="form-control" name="cep" id="inputCep" placeholder="xxxxx-xxx" value="${cepAttr}" required>
                <div class="invalid-feedback">
                    Digite um CEP
                </div>
              </div>
              
              <label for="inputCpf" class="col-sm-1 col-form-label">CPF*:</label>
              <div class="col-sm-2">
                <input type="text" class="form-control" name="cpf" id="inputCpf" placeholder="xxx.xxx.xxx.xx" value="${cpfAttr}" required>
                <div class="invalid-feedback">
                    Digite um CPF
                </div>
              </div>
            </div>
            
            <div class="form-group row">
              <label for="inputDataNascimento" class="col-md-1 offset-md-3">Data Nasc*:</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" name="dataNascimento" id="inputDataNascimento" placeholder="xx/xx/xxxx" value="${dataNascimentoAttr}" required>
                <div class="invalid-feedback">
                    Digite uma data de nascimento
                </div>
              </div>
            </div>
            
            <div class="form-group row">
                <label class="col-md-1 offset-md-3">Cargo*:</label>
                <div class="form-check-inline">
                    <input class="form-check-input" type="radio" name="cargo" id="back-office" value="back-office" required>
                    <label class="form-check-label" for="inlineRadio1">Back-Office</label>
                    <input class="form-check-input" type="radio" name="cargo" id="rh" value="rh" required>
                    <label class="form-check-label" for="inlineRadio1">Rh</label>
                    <input class="form-check-input" type="radio" name="cargo" id="diretor" value="diretor" required>
                    <label class="form-check-label" for="inlineRadio1">Diretor</label>
                    <input class="form-check-input" type="radio" name="cargo" id="vendedor" value="vendedor"required>
                    <label class="form-check-label" for="inlineRadio1">Vendedor</label>
                    <input class="form-check-input" type="radio" name="cargo" id="gerente-vendas" value="gerente-vendas" required>
                    <label class="form-check-label" for="inlineRadio1">Gerente Vendas</label>
                </div>
            </div>
            
            <div class="form-group row">
                <label for="inputEmail" class="col-md-1 offset-md-3">Filial*:</label>
                <div class="form-check-inline">
                     <c:forEach items="${filiaisAttr}" var="filial">
                         <input class="form-check-input" type="radio" name="filial" id="inlineRadio1" value="${filial}" >
                         <label class="form-check-label" for="inlineRadio1"><c:out value="${filial}" /></label>
                    </c:forEach>
                </div>
            </div>
             
            <div class="form-group row">
              <label for="inputEmail" class="col-md-1 offset-md-3">Email*:</label>
              <div class="col-sm-4">
                <input type="email" class="form-control" name="email" id="inputNome" placeholder="seuemail@email.com" value="${emailAttr}" required>
                <div class="invalid-feedback">
                    Digite um email
                </div>
              </div>
            </div>
            <div class="form-group row">
              <label for="inputSenha" class="col-md-1 offset-md-3">Senha*:</label>
              <div class="col-sm-4">
                <input type="password" class="form-control" name="senha" id="inputSenha" placeholder="Digite a senha do funcionário" value="${senhaAttr}" required>
                <div class="invalid-feedback">
                    Digite uma senha
                </div>
              </div>
            </div>
            <div class="button-group">
                <button class="btn btn-lg btn-success col-md-2 offset-md-4" type="submit">Editar</button>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/rh" class="col-md-2 btn btn-lg btn-danger">Cancelar</a>
            </div>
        </form>
  </body>
  <script>
    (function() {
      'use strict';
      window.addEventListener('load', function() {
        var forms = document.getElementsByClassName('needs-validation');
        var validation = Array.prototype.filter.call(forms, function(form) {
          form.addEventListener('submit', function(event) {
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