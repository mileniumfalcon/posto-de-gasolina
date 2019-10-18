<%-- 
    Document   : CadastrarFilial
    Created on : 18/10/2019, 02:31:01
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
                <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" />
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
                                <h1 class="h2">Cadastrar Filial</h1>
                                <div class="btn-toolbar mb-2 mb-md-0">
                                </div>
                            </div>
                            <form method="post" action="${pageContext.request.contextPath}/formulario/salvar" novalidate>
                                <input type="hidden" name="id" value="${idAttr}">
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Nome</label>
                                    <div class="col-sm-10">
                                        <input type="text" value="${nomeAttr}" class="form-control" id="nomefilial" placeholder="Nome da Filial" size="50" maxlength="48" name="nomefilial">
                                    </div>
                                    <br><br><br> <br> <br>
                                    <label class="col-sm-2 col-form-label">Endereço</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="enderecofilial" value="${enderecoAttr}" class="form-control" id="enderecofilial" size="50" maxlength="48" placeholder="Endereço da Filial">
                                    </div>
                                </div>
                                <br><br><br> <br> <br>
                                <select class="custom-select mr-sm-2" id="estadoSelect" name="estadofilial">
                                    <option selected>Estado</option>
                                    <option value="Acre">Acre</option>
                                    <option value="Alagoas">Alagoas</option>
                                    <option value="Amapá">Amapá</option>
                                    <option value="Amazonas">Amazonas</option>
                                    <option value="Bahia">Bahia</option>
                                    <option value="Ceará">Ceará</option>
                                    <option value="Distrito Federal">Distrito Federal</option>
                                    <option value="Espírito Santo">Espírito Santo</option>
                                    <option value="Goiás">Goiás </option>
                                    <option value="Maranhão">Maranhão</option>
                                    <option value="Mato Grosso">Mato Grosso</option>
                                    <option value="Mato Grosso do Su">Mato Grosso do Sul</option>
                                    <option value="Minas Gerais">Minas Gerais</option>
                                    <option value="Pará">Pará</option>
                                    <option value="Paraíba">Paraíba </option>
                                    <option value="Pernambuco">Pernambuco</option>
                                    <option value="Rio de Janeiro">Rio de Janeiro</option>
                                    <option value="Rio Grande do Norte">Rio Grande do Norte</option>
                                    <option value="Rio Grande do Sul">Rio Grande do Sul </option>
                                    <option value="Rondônia">Rondônia</option>
                                    <option value="Roraima">Roraima</option>
                                    <option value="Santa Catarina">Santa Catarina</option>
                                    <option value="São Paulo">São Paulo</option>
                                    <option value="Sergipe">Sergipe</option>
                                    <option value="Tocantins">Tocantins</option>
                          </select>
                                <br><br><br> <br> <br>
                                <button type="submit" class="btn btn-success">Cadastrar</button>
                                <button type="reset" class="btn btn-danger">Cancelar</button>
                            </form>



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