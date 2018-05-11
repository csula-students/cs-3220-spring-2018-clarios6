<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
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
    <h1>Editing Generator</h1>
    <div id="wrap">
      <div class="add-event">
        <form method="POST">
          <label for="generatorname">Generator Name</label></br>
          <input id="generatorname" name="generatorname" type="text" placeholder="${gen.getName()}"></br>
          <label for="generatorrate">Generator Rate</label></br>
          <input id="generatorrate" name="generatorrate" type="text" placeholder="${gen.getRate()}"></br>
          <label for="basecost">Base Cost</label></br>
          <input id="basecost" name="basecost" type="text" placeholder="${gen.getBaseCost()}"></br>
          <label for="unlockat">Unlock At</label></br>
          <input id="unlockat" name="unlockat" type="text" placeholder="${gen.getUnlockAt}"></br>
          <label for="description">Description</label></br>
          <input id="description" name="description" type="text" placeholder="${gen.getDescription()}"></br>
          <button id="addeditbutton">{Edit}</button>
        </form>
      </div>
  </body>
</html>
