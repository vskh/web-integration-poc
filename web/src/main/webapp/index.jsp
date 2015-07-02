<html>
<head>
    <title>Web</title>
    <style>
        h1 { text-align: center; }
        .io-area {
            border: 1px black solid;
            width: 900px;
            height: 200px;
            margin: 0 auto;
            display: block;
        }
        #send {
            display: block;
            margin: 0 auto;
        }
    </style>
    <script src="http://cdn.jsdelivr.net/sockjs/1.0.0/sockjs.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        var sock = new SockJS('http://localhost:8080/web/api/ws');
        sock.onopen = function() {
            console.log('open');
        };
        sock.onmessage = function(e) {
            document.getElementById('output-area').innerHTML += '<br/>' + e.data;
        };
        sock.onclose = function() {
            console.log('close');
        };

        function sendMessage() {
            sock.send(document.getElementById('input-area').value);
            document.getElementById('input-area').value = '';
        }
    </script>
</head>
<body>
<h1>Echo WS server</h1>

<div>
    <textarea id="input-area" class="io-area"></textarea>
    <div id="output-area" class="io-area"></div>
    <button id="send" onclick="sendMessage()">Send</button>
</div>
</body>
</html>
