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


    /* 부모-자식요소 전파 */
    // 콜백을 화살표함수로 하면 this는 여전히 window로 유지됨
    document.querySelector('#parent').addEventListener('click', function(event){
        console.log('부모 클릭');

        // event.target : 이벤트가 발생한 DOM을 알려줌
        console.log('event.target : ', event.target);

        // event.currentTarget : 이벤트가 적용된 DOM을 알려줌
        console.log('event.currentTarget : ', event.currentTarget);
    })

    document.querySelector('#child1').addEventListener('click', function(event){
        // 전파 방지
        // 부모로 전달되는 이벤트 중지
        // event.stopPropagation(); 
        console.log('자식1 클릭');
        console.log('event.target : ', event.target);

        // 이벤트 안에서 this는 더이상 window가 아니다
        // js에서 this는 뭔지 알고 있을 때만 사용하자
        console.log(this);

            /* DOM.parentNode : 부모로 이동 */
    console.log('event.target.parentNode : ', event.target.parentNode);
    console.log('event.target.parentNode.parentNode : ', event.target.parentNode.parentNode);
    })

    /* this */
    // this : window 객체를 가지고 있다
    console.log('밖',this);
    console.log('밖',this === window);







    /* 피자토핑 문제 풀기 */
    
    // checkbox의 값들 출력(배열)
    let checklist = document.querySelectorAll('.check');
    console.log('--- checkbox의 값들을 출력 ---');
    console.log(checklist);

    // 값 출력용 show라는 div
    let show = document.querySelector('.show');
    // 값을 저장할 변수
    let save = '';

    // checkbox가 check되면 console창에 값 표시
    for(let i=0; i<checklist.length; i++){
        // 값들이 처음에는 false로 초기화
        checklist[i].checked = false;

        checklist[i].addEventListener('click', function(){
            if(checklist[i].checked == true){
                console.log(checklist[i].value);
                // 선택한 값들을 변수에 저장
                save += checklist[i].value + ' / ';
            } 
        })
    }
    
    // '선택' 버튼을 눌렀을 때 선택한 값들이 출력되게
    document.querySelector('#choose').addEventListener('click', function(){
        show.innerHTML = save;
        save = '';
    })

    // 문제2.'전체 선택' 누르면 값들이 모두 선택되게
    let checkAll = document.querySelector('.checkAll');
    checkAll.checked = false;

    checkAll.addEventListener('click', function(){
        // '전체 선택'이 체크가 '되지 않으면' 선택지들이 모두 비선택으로 
        if(checkAll.checked == false) {
            for(let i=0; i<checklist.length; i++){
                checklist[i].checked = false;
                save += '';
            }
        } // '전체 선택'이 체크되면 선택지들이 모두 선택
        else if(checkAll.checked == true){
            for(let i=0; i<checklist.length; i++){
                checklist[i].checked = true;
                save += checklist[i].value + ' / ';
            }
        }
    })
    
    // 문제 2-2. 전체 선택 후 하나라도 해제되면 '전체 선택'도 해제되게
    // let checklist = document.querySelectorAll('.check');
    for(let i=0; i<checklist.length; i++){
        checklist[i].addEventListener('click', function(){
            // 체크박스가 선택 해제 되었다면
            if(!checklist[i].checked){
                document.querySelector('.checkAll').checked = false;
            } 
            // 체크박스 요소가 모두 선택 되었다면
            // 전체 선택이 해제된 경우에도 모든 요소 선택 시 '전체 선택' 체크
            else if(checklist[i].checked) {
                // 전체 개수와 체크된 개수를 비교해서 
                // 같으면 전체 선택 체크
                let checklist_y = document.querySelectorAll('.check:checked');
                if(checklist.length == checklist_y.length) {
                    document.querySelector('.checkAll').checked = true;
                }
            }
        })
    }
    

}