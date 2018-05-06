<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/app.css">
    <title>Incremental Game</title>
  </head>
  <body>
    <h1>Incremental Game Framework</h1>
    <nav>
      <a href="admin-info.html">Game Infomation</a> |
      <a href="../admin/generators">Generators</a> |
      <a href="../admin/events">Events</a>
    </nav>

    <div id="wrap">
      <div class="add-event">
        <form method="POST">
          <label for="generatorname">Generator Name</label></br>
          <input id="generatorname" name="generatorname" type="text" placeholder="Grandma"></br>
          <label for="generatorrate">Generator Rate</label></br>
          <input id="generatorrate" name="generatorrate" type="text" placeholder="0.5"></br>
          <label for="basecost">Base Cost</label></br>
          <input id="basecost" name="basecost" type="text" placeholder="10"></br>
          <label for="unlockat">Unlock At</label></br>
          <input id="unlockat" name="unlockat" type="text" placeholder="Unlock At"></br>
          <label for="description">Description</label></br>
          <input id="description" name="description" type="text" placeholder="Text"></br>
          <button id="addeditbutton">{Add|Edit}</button>
        </form>
      </div>
      <div class="event-table">
        <table>
          <thead>
            <tr>
              <th>Name</th>
              <th>Rate</th>
              <th>Cost</th>
              <th>Unlock At</th>
              <th>Actions<th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${g}" var="gen">
              <tr>
                <td>${gen.getName()}</td>
                <td>${gen.getRate()}</td>
                <td>${gen.getBaseCost()}</td>
                <td>${gen.getUnlockAt()}</td>
                <td> <a href="#">Edit</a> | <a href="../admin/generator/delete?id=${gen.getId()}">Delete</a></td>
              </td>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </body>
</html>
