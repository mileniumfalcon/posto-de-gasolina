<%-- 
    Document   : product-register
    Created on : 11/10/2019, 20:24:13
    Author     : pablo.osantana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <title>Postos Tades - Painel BackOffice</title>
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
                            <br>
                            <br>
                            <br>
                            <br>

                            <li class="nav-item">
                                <a class="nav-link active" href="#">

                                    Cadastrar filial 
                                </a>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>

                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">

                                    Pesquisar Filial
                                </a>
                            </li>
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>

                            <li class="nav-item">
                                <a class="nav-link" href="#">

                                    Emitir Relatório
                                </a>
                            </li>
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>

                            <br>
                            <br>
                            <br>
                            <br>





                        </ul>
                    </div>
                </nav>








                <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <h1 class="h2">Cadastrar Produto</h1>
                        <div class="btn-toolbar mb-2 mb-md-0">

                        </div>
                    </div>

                    <h1>Dados cadastrais</h1>
                    <form action="cadastrar.jsp" method="POST">
                        <label>
                            Nome:</label><input name="name" id="name" type="text" size="50" maxlength="48" style="font-family: Verdana; color: gray; font-size: 14px;" placeholder="Nome do Produto">
                        <br>
                        <br>   <label>
                            Tipo: </label><select name="tpProduct" id="tpProduct" >
                            <option selected>Outros...</option>
                            <option>Combustivel</option>
                            <option>Acessórios</option>
                            <option>Óleo</option>
                        </select>
                        <br>
                        <br>   
                        <label>Preço</label><input name="price" id="price" type="text" size="25" maxlength="10" placeholder="0.00"> 
                        <label>Quantidade: </label><input name="quantity" id="quantity" type="text" size="25" maxlength="10" placeholder="0.0">
                        <br>
                        <br>
                        <label>Filial:</label>
                        <input type="checkbox" value="São Paulo" name="Filiais" id="Filiais"/>São Paulo
                        <input type="checkbox" value="Minas Gerais" name="Filiais" id="Filiais"/>Minas Gerais                      
                        <input type="checkbox" value="Bahia" name="Filiais" id="Filiais"/>Bahia
                        <input type="checkbox" value="Porto Alegre" name="filiais" id="Filiais"/>Porto Alegre
                        <br><br> <input type="submit" value="Cancelar"><br><br> 
                        <input type="submit" value="Cadastrar"><br><br>
                    </form>


                </main>
                <!-- Principal JavaScript do Bootstrap
                ================================================== -->
                <!-- Foi colocado no final para a página carregar mais rápido -->
                <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
                <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
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
