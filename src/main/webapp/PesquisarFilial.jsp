<%-- 
    Document   : PesquisarFilial
    Created on : 18/10/2019, 02:32:27
    Author     : Victor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <!-- Meta tags Obrigatórias -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="caminhocss">
    <title>Posto Tades</title>
</head>

<body>
    <nav class="navbar navbar-dark fixed-top bg-warning  flex-md-nowrap p-0 shadow">
        <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Postos Tades</a>
        <ul class="navbar-nav px-3">
            <li class="nav-item text-nowrap">
                <a class="nav-link" href="#">Sair</a>
            </li>
        </ul>
    </nav>

    <div class="container-fluid">
        <div class="row">
           <nav class="col-md-2 d-none d-md-block bg-dark sidebar">
                            <div class="sidebar-sticky">
                                <ul class="nav flex-column">
                                    <br><br><br><br>
                                    <li class="nav-item">
                                        <a class="nav-link active" href="CadastrarFilial.jsp">Cadastrar filial</a>
                                        <br> <br><br><br><br><br>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="PesquisarFilial.jsp">
                                Pesquisar Filial
                            </a>
                                    </li>
                                    <br><br><br><br><br><br>
                                    <li class="nav-item">
                                        <a class="nav-link" href="EmitirRelatorio.jsp">
                                Emitir Relatório
                            </a>
                                    </li>
                                    <br><br><br><br> <br><br> <br><br><br><br><br><br> <br> <br> <br><br><br><br>
                                </ul>
                            </div>
                        </nav>

            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                <div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
                    <div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                        <div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div>
                    </div>
                    <div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                        <div style="position:absolute;width:200%;height:200%;left:0; top:0"></div>
                    </div>
                </div>

                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    <br><br><br> <br> <br><br> <br><br><br><br><br>
                    <h1 class="h2">Pesquisar Filial</h1>
                    <div class="btn-toolbar mb-2 mb-md-0">
                    </div>
                </div>
                
                
                
                <table class="table" id="tabela">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Nome</th>
                            <th>Estado</th>
                        </tr>
                        <tr>
                    <c:forEach items="${filiaisAttr}" var="filial" >
                            <th>${filial.getNome()}</th>
                            <th>${filial.getEndereco()}</th>
                            <th>${filial.getEstado()}</th>
                         </c:forEach>
                        </tr>
                    </thead>
                </table>


            </main>


            <script>
            </script>
            <!-- Principal JavaScript do Bootstrap -->
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script>
                window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')
            </script>
            <script src="../../assets/js/vendor/popper.min.js"></script>
            <script src="../../dist/js/bootstrap.min.js"></script>
            <script>
                feather.replace()
            </script>
            <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>

</html>