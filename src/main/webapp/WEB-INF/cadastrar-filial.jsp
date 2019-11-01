<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt-br">
  <head>

  <!-- HTML 4 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- HTML5 -->
<meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
       <!-- Style CSS --> 
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" media="screen" />
    <title>Posto Tades</title>
  </head>
  <body>
      
  
    <nav class="navbar navbar-dark fixed-top bg-warning  flex-md-nowrap p-0 shadow">
      <a class="navbar-brand col-sm-3 col-md-2 mr-0 " href="#">Postos Tades</a>
          <ul class="navbar-nav px-3 ">
        <li class="nav-item text-nowrap">
          <a class="nav-link " href="#">Sair</a>
        </li>
      </ul>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-preto sidebar">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <br><br><br><br>
              <li class="nav-item ">
                <a class="nav-link active linha " href="${pageContext.request.contextPath}/diretor/cadastrar-filial">               
                  Cadastrar filial 
                </a>
                <br><br><br><br><br><br>
              </li>
              <li class="nav-item">
                <a class="nav-link linha" href="${pageContext.request.contextPath}/diretor/pesquisar-filial">
                 Pesquisar Filial
                </a>
              </li>
              <br><br><br><br><br><br>

<li class="nav-item"><a class="nav-link linha" href="${pageContext.request.contextPath}/diretor/relatorio-filial">
Emitir Relatório
 </a>
</li><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>     
            </ul>
          </div>
        </nav>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
              <br> <br><br><br><br><br><br><br><br><br><br>
            <h1 class="h2">Cadastrar Filial</h1>
            <div class="btn-toolbar mb-2 mb-md-0">
              </div>
          </div><div><br><br><br><br></div>
         <form method="post" action="${pageContext.request.contextPath}/diretor/cadastrar-filial" class="needs-validation" novalidate>
            <div class="form-group row" style="margin-top: -100px;">
              <label for="inputNome" class="col-md-1 offset-md-3">Nome*:</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" name="nome" id="inputNome" placeholder="Digite o nome de uma filial" required>
                 <div class="invalid-feedback">
                    Digite o nome da filial
                </div>
              </div>
            </div>
            <div class="form-group row">
              <label for="inputEndereco" class="col-md-1 offset-md-3">Endereço*:</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" name="endereco" id="inputEndereco" placeholder="Av/Rua fulano, 123" required>
                <div class="invalid-feedback">
                    Digite um endereço
                </div>
              </div>
            </div>            
            <div class="form-group row">
              <label for="inputCep" class="col-md-1 offset-md-3">CEP*:</label>
              <div class="col-sm-2">
                <input type="text" class="form-control" name="cep" id="inputCep" placeholder="xxxxx-xxx" onkeypress="$(this).mask('00000-000');" required>
                <div class="invalid-feedback">
                    Digite um CEP
                </div>
              </div>         
              <br><br>
                <div class="form-group row">
                  <div class="col-sm-10">
                <select class="form-control" name="estado" id="estado">
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
                <button class="btn btn-lg btn-success col-md-2 offset-md-4" type="submit">Cadastrar</button>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/diretor" class="col-md-2 btn btn-lg btn-danger">Cancelar</a>
            </div>
        </form>       
        </main>
     
    <!-- Script Principal da Pagina================================================== -->    
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
   <!-- Principal JavaScript do Bootstrap================================================== -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../assets/js/vendor/popper.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>

</html>