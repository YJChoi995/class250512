console.log('Hello, JS');

window.addEventListener('load', init);
// window.onload = init;

function init(){
    const msg = document.getElementById('console');
    console.log(msg);

    bind();
    loginClick();

    const game = document.querySelector('#game');
    console.log(game);
    game.style.left = '10px';
    game.style.top = '10px';
}
function bind(){
    const msg = document.getElementById('console');

    const btn1 = document.querySelector('#btn1');
    // onclick은 변수라서 마지막 값만 저장된다
    btn1.onclick = function() {
        msg.innerHTML += '<br>버튼1 클릭';
    }

    const btn2 = document.querySelector('#btn2');
    // addEventListener는 계속해서 추가하여 사용할 수 있다
    btn2.addEventListener('click', function(){
        msg.innerHTML += '<br>버튼2 클릭';
    })

    document.querySelector('#top').addEventListener('click', function(){
    // document.documentElement.scrollTop = 140;
        // window.scrollTo(
        //     {
        //         top: 0,
        //         behavior: "smooth"
        //     }
        // );
       
        for(let i = document.documentElement.scrollTop; i >= 0 ; i -= 10){
            let time = (200 - i) * 10;
            setTimeout(function(){
                console.log('i :', i, ' time : ', time);
                document.documentElement.scrollTop = i;
            }, time)
        }
    })

    document.querySelector('#id').addEventListener('keyup', function(event){

        if(event.keyCode == 13) {
            console.log('Enter!');
            document.querySelector('#pw').focus();
        }
    })

    document.querySelector('#pw').addEventListener('keyup', function(event){
        if(event.keyCode == 13) {
            document.querySelector('#login').click();
        }
    })

    document.querySelector('body').addEventListener('keydown', function(event){
        console.log(event.keyCode);
        const game = document.querySelector('#game');
        console.log(game.style.left);
        // 왼쪽 방향기
        if(event.keyCode == 37) {
            game.style.left = (parseInt(game.style.left) - 10) + 'px' 
        } else if(event.keyCode == 39) {
            // 오른쪽 방향기
            game.style.left = (parseInt(game.style.left) + 10) + 'px' 
        }
    })

    document.querySelector('#pw').addEventListener('click', btnClick);
    document.querySelector('#pw').removeEventListener('click', btnClick);
}



function btnClick () {
    const msg = document.getElementById('console');
    msg.innerHTML += '<br>btnClick 실행';
}


// 로그인 버튼을 눌렀을 때
// 아이디와 비밀번호가 비어있지 않다면 
//              아이디, 비밀번호 출력
// 하나라도 비어 있다면
//          '아이디는 필수입니다' 또는 '비밀번호는 필수입니다' 출력
function loginClick(){

    const login = document.querySelector('#login');

    login.addEventListener('click', function(){
        const msg = document.getElementById('console');
        const id = document.querySelector('#id').value;
        const pw = document.querySelector('#pw').value;

        if (id == ""){
            msg.innerHTML += '<br>아이디는 필수입니다';
        } else if (pw == ""){
            msg.innerHTML += '<br>비밀번호는 필수입니다'; 
        } else {
            msg.innerHTML += '<br>id: ' + id + ', password: ' + pw;
        }
    })
}


window.addEventListener('resize', function(){
    console.log('resize');
    console.log(window.innerWidth);
})

window.addEventListener('scroll', function(){
    console.log('scroll');
    console.log('scrollTop', this.document.documentElement.scrollTop);
})









