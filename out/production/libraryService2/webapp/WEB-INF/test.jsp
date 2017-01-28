<%@page session="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset = "utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Uzytkownicy - Admin</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>

</head>

<body>
<nav class = "navbar navbar-inverse navbar-fixed-top">
    <div class = "container-fluid">
        <div class = "navbar-header">
            <a class = "navbar-brand" href = "#">Biblioteka</a>
        </div>
        <ul class = "nav navbar-nav">
            <li class = "active"><a href = "#">Home</a></li>
            <li><a href = "#">Page 1</a></li>
            <li><a href = "#">Page 2</a></li>
            <li><a href = "#">Page 3</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </ul>
    </div>
</nav>

<div class = "container-fluid" style = "margin-top:50px">
    <div class = "row">
        <div class = "col-sm-3 col-md-2 sidebar">
            <ul class = "nav nav-sidebar">
                <li class = "active"><a href = "#">Overview</a></li>
                <li><a href = "#">Czytelnicy <span class="sr-only">(current)</span></a></li>
                <li><a href = "#">Bibliotekarze</a></li>
                <li><a href = "#">Nowy czytelnik</a></li>
                <li><a href = "#">Nowy bibliotekarz</a></li>
            </ul>
        </div>

        <div class = "col-sm-9 col-sm-3 col-md-9 col-md-offset-0 main">
            <div class = "page-header">
                <h1>Biblioteka</h1>
            </div>

            <h3 class = "sub-header">Użytkownicy</h3>
            <br>

            <div id = "show-data"></div>

        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function(){
       $.getJSON('/users/all',function (data) {
           var items = data.items.map(function (item) {
               return item.key + ': ' + item.value;
           });

           showData.empty();

           if (items.length) {
               var content = '<li>' + items.join('</li><li>') + '</li>';
               var list = $('<ul />').html(content);
               showData.append(list);
           }
       });
    });
</script>

</body>
</html>

