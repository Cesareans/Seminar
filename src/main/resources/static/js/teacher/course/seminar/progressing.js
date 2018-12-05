var client = null;
var message;
var socketAddr = "/seminar-socket";
var clientAddr = '/topic/client/';
var serverAddr = "/app/teacher/clbumSeminar/";
var csId;
$(function () {
    message = $("#message");
    csId = $("#main").attr("data-csId");
    serverAddr += csId;
    clientAddr += csId;
    $("#connect").click(function () {
        var socket = new SockJS(socketAddr);
        client = Stomp.over(socket);
        client.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            client.subscribe(clientAddr, function (greeting) {
                message.html(JSON.parse(greeting.body).message);
            });
        });
    });
    $("#disconnect").click(function () {
        if(client!=null){
            client.connect()
        }
        console.log("disconnect");
    });
    $("#send").click(function () {
        client.send(serverAddr, {}, JSON.stringify({'name': $("#toServer").val()}));
    });
});



