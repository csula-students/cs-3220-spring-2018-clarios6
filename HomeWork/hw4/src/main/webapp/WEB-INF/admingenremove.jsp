<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../app.css">
    <title>Incremental Game</title>
    <style media="screen">
    body{
      background-color: #7FFF00;
    }

    #wrap{
      float: left;
    }
    .add-event{
      float: left;
    }
    .event-table{
      float: right;
      text-align: left;
      padding-left: 100px;
    }

    th, td{
      border: 1px solid #00FFFF;
      padding: 10px;
    }
    </style>
  </head>
  <body>
    <form class="button" action="../generators">
      <input type="submit" value="Return to Generators">
    </form>
  </body>
</html>
