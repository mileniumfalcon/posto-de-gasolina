<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/rh.css" media="screen" />
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
          <h1>Cadastrar Funcionário</h1>
      </div>

      <ul class="nav flex-column">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/rh/cadastrar-funcionario">Cadastrar Funcionário</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/rh/pesquisar-funcionario">Pesquisar Funcionário</a>
        </li>
      </ul>
        
        <form>
            <div class="form-group row">
              <label for="inputNome" class="col-md-1 offset-md-3">Nome*:</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" id="inputNome" placeholder="Digite o nome completo">
              </div>
            </div>
            <div class="form-group row">
              <label for="inputEndereco" class="col-md-1 offset-md-3">Endereço*:</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" id="inputEndereco" placeholder="Av/Rua fulano, 234">
              </div>
            </div>
            
            <div class="form-group row">
              <label for="inputCep" class="col-md-1 offset-md-3">CEP*:</label>
              <div class="col-sm-2">
                <input type="text" class="form-control" id="inputCep" placeholder="xxxxx-xxx">
              </div>
              
              <label for="inputCpf" class="col-sm-1 col-form-label">CPF*:</label>
              <div class="col-sm-2">
                <input type="text" class="form-control" id="inputCpf" placeholder="xxx.xxx.xxx.xx">
              </div>
            </div>
            
            <div class="form-group row">
              <label for="inputDataNascimento" class="col-md-1 offset-md-3">Data Nascimento*:</label>
              <div class="col-sm-2">
                <input type="text" class="form-control" id="inputDataNascimento" placeholder="xx/xx/xxxx">
              </div>
              
              <label for="inputCpf" class="col-sm-1 col-form-label">Dpto*:</label>
              <div class="col-sm-2">
                <select class="form-control" id="exampleFormControlSelect1">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
              </div>
            </div>
            
            <div class="form-group row">
              <label for="inputEmail" class="col-md-1 offset-md-3">Email*:</label>
              <div class="col-sm-4">
                <input type="email" class="form-control" id="inputNome" placeholder="seuemail@email.com">
              </div>
            </div>
            <div class="form-group row">
              <label for="inputEndereco" class="col-md-1 offset-md-3">Senha*:</label>
              <div class="col-sm-4">
                <input type="password" class="form-control" id="inputEndereco" placeholder="Digite a senha do funcionário">
              </div>
            </div>

            <button class="btn btn-lg btn-success col-md-1 offset-md-5" type="submit">Cadastrar</button>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/rh" class="col-md-1 btn btn-lg btn-danger">Cancelar</a>
        </form>
  </body>
</html>
