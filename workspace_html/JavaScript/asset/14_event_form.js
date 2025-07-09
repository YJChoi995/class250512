window.addEventListener('load', bind);
function bind() {
    document.querySelector('#keyword').addEventListener('focus', ()=>{
        const keyword = document.querySelector('#keyword');
        keyword.style.backgroundColor = 'yellow';
    })

    document.querySelector('#keyword').addEventListener('blur', ()=>{
        const keyword = document.querySelector('#keyword');
        keyword.style.backgroundColor = '';
    })

    document.querySelector('#keyword').addEventListener('input', ()=>{
        const keyword = document.querySelector('#keyword');
        
        const r = parseInt(Math.random() * 256);
        const g = parseInt(Math.random() * 256);
        const b = parseInt(Math.random() * 256);
        const a = Math.random();

        keyword.style.backgroundColor = `rgba(${r},${g},${b},${a})`;
    })

    document.querySelector('#site').addEventListener('change', ()=>{
        const value = document.querySelector('#site').value;
        const form = document.querySelector('#form');

        if(value == 1){
            //naver
            form.setAttribute('action', 'https://search.naver.com/search.naver');
    
            
        } else if(value == 2){
            //google
            form.setAttribute('action', 'https://www.google.com/search');
        }
    })

    document.querySelector('#form').addEventListener('submit', (event)=>{
        // html 태그의 기본(고유) 기능을 막아줌
        // 여기서는 submit 기능을 막음
        event.preventDefault();

        const value = document.querySelector('#keyword').value;
        if(value.length < 2){
            alert('검색어는 두 글자 이상입니다');
        } else {
            // submit
            document.querySelector('#form').submit();
        }
    })

    addEventListener('copy', (event)=>{
        event.preventDefault();
        alert('복사 금지');
    })

    addEventListener('cut', (event)=>{
        event.preventDefault();
        alert('복사 금지');
    })



    /* 피자토핑 문제 풀기 */
    let pizzatopping = document.querySelector('#pizzatopping');
    
    // checkbox의 값들 출력
    let checklist = document.querySelectorAll('.check');
    console.log(checklist);

    let show = document.querySelector('.show');
    let list;

    // checkbox가 check되면 console창에 값 표시
    for(let i=0; i<checklist.length; i++){
        checklist[i].checked = false;

        checklist[i].addEventListener('click', function(){
            if(checklist[i].checked == true){
                console.log(checklist[i].value);
                list += checklist[i].value + ' / '; 
            } 
        })
    }
    
    document.querySelectorAll('#choose').addEventListener('click', function(){
        show.innerHTML += list;
    })



    

   
    

    
    // document.querySelectorAll('.check').addEventListener('click', ()=>{
    //     const value = document.querySelector('.check').value;
    //     console.log(value);
    // })

    // document.querySelector('.checkAll').addEventListener('click', ()=>{
    //     const value = document.querySelector('.checkAll').value;
    //     if(value == '전체_선택'){
    //         console.log(value);
    //     }
        
    // })

}