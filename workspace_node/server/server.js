const express = require('express');
const app = express();

const port = 3000;
app.listen(port, function(){
   console.log('서버 켜짐', port) 
});

app.get('/hello', function(req, resp){
    console.log('hello express')
});



function aop (req, resp, next) {
    const before = new Date().getTime()

    next()

    resp.on('finish', function(){           // 응답이 끝났을 때
        const after = new Date().getTime()
        console.log(after - before);
    })
}

function delay (ms) {
    
}