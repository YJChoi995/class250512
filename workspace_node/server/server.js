const express = require('express');
const app = express();

const port = 3000;
app.listen(port, function(){
   console.log('서버 켜짐', port) 
});

app.get('/hello', function(req, resp){
    console.log('hello express')
});