window.addEventListener('load', function(){
    init();
    bind();
});
function init() {}
function bind() {

    /* 문제 1+2 */
    // 문제 1. 주문정보의 '신청' 버튼을 누르면 input의 글씨 출력

    document.querySelector('#orderbtn').addEventListener('click',function(){
        let orderResult1 = document.querySelector('#orderResult1');
        let input1 = document.querySelectorAll('.input1');
    
        orderResult1.innerHTML = '<strong>주문 정보</strong><br>이름 : ' + input1[0].value 
                                + '<br>주소 : ' + input1[1].value
                                + '<br>연락처 : ' + input1[2].value + '<br>';
    })

    // 문제 2. 배송정보의 '주문 정보와 같음'를 체크하면 주문정보의 input 값 가져오기
    document.querySelector('.sameCustomer').addEventListener('change', function() {
        let input1 = document.querySelectorAll('.input1');
        let input2 = document.querySelectorAll('.input2');

        for(let i=0; i<input1.length; i++){
            if(document.querySelector('.sameCustomer').checked){
                input2[i].value = input1[i].value;
            } else {
                input2[i].value = '';
            }
        }
    })
    document.querySelector('#packagebtn').addEventListener('click',function(){
        let orderResult2 = document.querySelector('#orderResult2');
        let input2 = document.querySelectorAll('.input2');
        
        orderResult2.innerHTML = '<strong>주문 정보</strong><br>이름 : ' + input2[0].value 
                                 + '<br>주소 : ' + input2[1].value
                                 + '<br>연락처 : ' + input2[2].value + '<br>';
    })

    
    /* 문제 3. 메뉴 선택시 특이하게 보이게 */
    let menu = document.querySelectorAll('.menu');

    for(let i=0; i<menu.length; i++){
        menu[i].addEventListener('click', function(){
            menu[i].style.color = 'blue';
            menu[i].style.textDecoration = 'underline';
        })

        menu[i].addEventListener('mouseleave', function(){
            menu[i].style.color = '';
            menu[i].style.textDecoration = '';
        })
    }
    

    /* 문제 4. 이미지 크게 + 변경 */
    let mini = document.querySelectorAll('.mini');
    let imgView = document.querySelectorAll('.imgView');
    let cnt = 0;

    for(let i=0; i<mini.length; i++){
        mini[i].addEventListener('mouseover', function(){
            mini[i].style.border = 'lpx solid blue';
            imgView[i].style.display = 'block'; 
            cnt++;
            imgView[i].style.zIndex = cnt;
        })
    }


    /* 문제 5. 피자 주문 시스템: 사이즈, 토핑, 도우 선택한 정보 한 번에 표시 */
    // 주문 버튼 변수
    let pizzaOrderbtn = document.querySelector('#pizzaOrderbtn')
    
    // 선택값 출력용 div의 변수
    let pizzaOrdered = document.querySelector('#pizzaOrdered');
    
    let size = document.querySelector('input[name="pizzaSize"]:checked');
    let topping = document.querySelectorAll('.topping');
    let dough = document.getElementsByName('dough');
    
    // 값을 저장할 변수
    let save = '';

    // '주문'버튼을 누르면 실행
    pizzaOrderbtn.addEventListener('click', function(){
        // 사이즈를 선택한 값을 표시
        if(size){
            console.log(size.value);
            // 선택한 값들을 변수에 저장
            save += '사이즈 : ' + size.value + '<br>';
        }
    
        // 토핑이 check되면 console창에 값 표시
        for(let i=0; i<topping.length; i++){
            if(topping[i].checked == true){
                console.log(topping[i].value);
                // 선택한 값들을 변수에 저장
                save += topping[i].value + ' / ';
            }
        }

        // 도우를 선택한 값을 표시
        console.log(dough[0].value);
        save += '<br>도우 종류 : ' + dough[0].value;
        
        // 주문 정보에 모든 값 표시
        pizzaOrdered.innerHTML = save;
    }) 
    
    
    /* 문제 6.  */

    // 작성한 '할 일' 
    const todo = document.querySelector('#todo');
    // '추가' 버튼
    const addbtn = document.querySelector('#addbtn');
    // 작성한 할 일 목록이 생성될 필드
    const listField = document.querySelector('#listField');

    
    // '추가'버튼을 누르면 작성한 할 일이 'listField'에 추가됨
    addbtn.addEventListener('click', function(){
        if(todo.value != ''){
            // 체크박스 만들기
            const workList = document.createElement('div');
            workList.classList.add('todo');
            workList.innerHTML = `
                <input type="checkbox" class="check">
                <span>${todo.value}</span>
                <input type="button" value="삭제" class="delbtn">`    
            // listField.innerHTML += `<input type="checkbox" value=${todo.value} class="work"> ${todo.value}<br>` ;

            // 출력필드에 '할 일' 추가하기            
            listField.append(workList);
            
            // '추가' 버튼을 눌렀을 때 입력칸을 초기화
            todo.value = '';

            // 삭제 버튼을 누르면 '삭제 버튼'이 포함된 
            // 1. DOM 출력
            // 2. DOM 지우기
            workList.querySelector('.delbtn').addEventListener('click', function(event){
                // event가 발생한 DOM
                console.log(event.target);
                // 그 부모
                console.log(event.target.parentNode);
                // 그 부모 삭제
                if(confirm('삭제하시겠습니까?')){
                    event.target.parentNode.remove();
                }
            })
        }
    })

    // '선택삭제' 버튼 누르면 선택된 checkbox 삭제하기
    document.querySelector('#selectDel').addEventListener('click', function(){
        // 1. 체크되어 있는 모든 checkbox 가져오기
        const checked = document.querySelectorAll(`[type=checkbox]:not(#all):checked`);
        // 2. 부모 지우기
        for(let i=0; i<checked.length; i++){
            checked[i].parentNode.remove();
        }
        // 3. 같은 부모의 del 버튼 클릭
        // for(let i=0; i<checked.length; i++){
        //     checked[i].parentNode.querySelector('.delbtn').click()
        // }
    })


    

    

    

}