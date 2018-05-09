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
    <h1>Editing Event</h1>
    <div id="wrap">
      <form class="add-event"  method="post">
        <label for="eventname">Event Name</label><br>
        <input type="text" name="eventname" placeholder="${ev.getName()}"><br>
        <label for="eventdescription">Event Description</label><br>
        <input type="text" name="eventdescription" placeholder="${ev.getDescription()}"><br>
        <label for="triggerat">Trigger At</label><br>
        <input type="text" name="triggerat" placeholder="${ev.getTriggerAt()}"><br>
        <button>Confirm</button>
      </form>
    </div>
  </body>
</html>
