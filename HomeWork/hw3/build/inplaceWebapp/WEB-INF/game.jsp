<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <!--<link rel="stylesheet" type="text/css" href="app.css">-->
    <link href="https://fonts.googleapis.com/css?family=Oswald|Roboto+Condensed" rel="stylesheet">
    <title>Resource Miner</title>
    <style media="screen">
    header{
font-family: 'Oswald', sans-serif;
}
body{
font-family: 'Roboto Condensed', sans-serif;
}
.story-book{
height: 5.5em;
background-color: black;
color: white;
overflow: auto;

}
.manual-generator{
display: flex;
justify-content: center;
}
.auto-generator-list{
display: flex;
width: auto;
justify-content: center;
}
.generator-container{
margin: 1em;
padding-left: 1em;
padding-right: 1em;
padding-bottom: 1em;
border-width: thin;
border-style: solid;
}
.gen-con-bottom-row-info{
padding-top: 5em;
display: flex;
}
#buy_button{
position: relative;
right: 0px;
}
footer{
font-family: 'Oswald', sans-serif;
position: absolute;
bottom: 0px;
}

    </style>
    <script type="text/javascript">
      generators = ${genjson};
      for(i = 0 ; i < generators.length ; i++){
        generators[i].type = 'autonomous';
        generators[i].unlockValue = generators[i].unlockAt;
        generators[i].quantity = 0;
        delete generators[i].unlockAt;
        delete generators[i].id;
      }

      stories = ${storyjson};
      for(i = 0 ; i < stories.length ; i++){
        stories[i].triggeredAt = stories[i].triggerAt;
        stories[i].state = 'hidden';
        delete stories[i].triggerAt;
        delete stories[i].id;
      }

      var backInfo = {}
      backInfo.example = 'Hello custom element';
  		backInfo.counter = 0;
      backInfo.generators = generators;
      backInfo.story = stories;
      console.log(backInfo);

    </script>
  </head>
  <body>
    <header>
      <h1>Resource Miner</h1>
    </header>
    <game-story-book></game-story-book>
    <div class="generators">
      <div class="manual-generator">
        <game-counter></game-counter>
        <game-button></game-button>
      </div>
      <div class="auto-generator-list">
        <game-generator data-id="0"></game-generator>
        <game-generator data-id="1"></game-generator>
        <game-generator data-id="2"></game-generator>
      </div>
    </div>
    <footer>
      <p>Created by: Carlos Larios-solis</p>
    </footer>
    <script type="text/javascript" src="/app.bundle.js"></script>
  </body>
</html>
