<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <!--<link rel="stylesheet" type="text/css" href="../app.css">-->
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
    <h1>Incremental Game Framework</h1>
    <nav>
      <a href="admin-info.html">Game Infomation</a> |
      <a href="admin-generators.html">Generators</a> |
      <a href="admin-events.html">Events</a>
    </nav>

    <div id="wrap">
      <div class="add-event">
        <form method="POST">
          <label for="event-name">Event Name</label></br>
          <input id="event-name" name="eventname" type="text" placeholder="Grandma"></br>
          <label for="event-description">Event Description</label></br>
          <input id="event-description" name="eventdescription" type="text" placeholder="Lorem ..."></br>
          <label for="trigger-at">Trigger At</label></br>
          <input id="trigger-at" name="triggerat" type="text" placeholder="10"></br>
          <button id="add-edit-button">{Add|Edit}</button>
        </form>
      </div>
      <div class="event-table">
        <table>
          <thead>
            <tr>
              <th>Name</th>
              <th>Description</th>
              <th>Trigger At</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${e}" var="ev">
              <tr>
                <td>${ev.getName()}</td>
                <td>${ev.getDescription()}</td>
                <td>${ev.getTriggerAt()}</td>
                <td>
                  <a href="../admin/events/edit?id=${ev.getId()}">Edit</a>|<a href="../admin/events/delete?id=${ev.getId()}">Delete</a>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>

  </body>
</html>
