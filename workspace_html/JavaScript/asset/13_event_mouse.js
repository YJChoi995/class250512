let view;
window.onload = function() {
    view = document.querySelector("#view");

    const cursor = document.querySelector('#cursor');
    cursor.style.top = '-1000px';
    cursor.style.left = '-1000px';
    
    bind();
    
}
function bind() {
    view.innerHTML = '안녕?<br>';

    document.querySelector("#mouse").addEventListener('mousedown', function(event){
        view.innerHTML += 'mousedown 발생<br>';
        
        console.log(event);
        // offset : DOM의 좌상단 기준
        // page : scroll에 관계 없이 문서 좌상단 기준
        // client : 지금 보이는 화면 좌상단 기준
        view.innerHTML = `
            event.offsetX : ${event.offsetX} event.offsetY : ${event.offsetY}<br>
            event.pageX : ${event.pageX} event.pageY : ${event.pageY}<br>
            event.clientX : ${event.clientX} event.clientY : ${event.clientY}<br>
            ${view.innerHTML}
        `;
    })

    document.querySelector("#mouse").addEventListener('mouseup', function(){
        view.innerHTML += 'mouseup 발생<br>';
    })

    document.querySelector("#mouse").addEventListener('mousemove', function(){
        // 확인완료. 복잡스러우니 주석처리
        // view.innerHTML += 'mousemove 발생<br>';
    })

    document.querySelector("#mouse").addEventListener('mouseover', function(){
        view.innerHTML += 'mouseover 발생<br>';
        document.querySelector("#mouse").style.backgroundColor  = 'yellow';
    })

    document.querySelector("#mouse").addEventListener('mouseenter', function(){
        // view.innerHTML += 'mouseenter 발생<br>';
    })

    document.querySelector("#mouse").addEventListener('mouseout', function(){
        // view.innerHTML += 'mouseout 발생<br>';
        document.querySelector("#mouse").style.backgroundColor  = 'white';
    })

    document.querySelector('body').addEventListener('mousemove', function(event){
        const cursor = document.querySelector('#cursor');

        cursor.style.top = event.pageY+1 + 'px';
        cursor.style.left = event.pageX+1 + 'px';

    })

    /* 챗지피티 답 */
    // const drag = document.querySelector('#drag');
    // let isDragging = false;
    // let offsetX = 0;
    // let offsetY = 0;

    // drag.addEventListener('mousedown', function(event){
    //     isDragging = true;
    //     offsetX = event.offsetX;
    //     offsetY = event.offsetY;
    //     drag.style.backgroundColor  = 'yellow';

    // })

    // document.addEventListener('mousemove', function(event){
    //     if (isDragging) {
    //         drag.style.left = (event.pageX - offsetX) + 'px';
    //         drag.style.top = (event.pageY - offsetY) + 'px';
    //     }
    // })

    //  document.addEventListener('mouseup', function() {
    //     if (isDragging) {
    //         isDragging = false;
    //         drag.style.backgroundColor = 'white';
    //     }
    // });

    let dragOn = false; 
    const drag = document.querySelector('#drag');
    let mouseX = 0;
    let mouseY = 0;

    document.querySelector('#drag').addEventListener('mousedown', function(event){
        drag.style.backgroundColor = 'red';
        dragOn = true;
        mouseX = event.offsetX;
        mouseY = event.offsetY;
    })

    document.querySelector('#drag').addEventListener('mousemove', function(event){
        if(dragOn) {
            drag.style.left = (event.pageX - mouseX) + 'px';
            drag.style.top = (event.pageY - mouseY) + 'px';
        } 
    })


    document.querySelector('#drag').addEventListener('mouseup', function(){
        if(dragOn) {
            dragOn = false;
            drag.style.backgroundColor = 'white';
        }
    })






}
