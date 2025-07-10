window.addEventListener('load', bind);
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




    /* 문제 5. 피자 주문 시스템: 사이즈, 토핑, 도우 선택한 정보 한 번에 표시 */
    
    // 선택값 출력용 div의 변수
    let pizzaOrdered = document.querySelector('#pizzaOrdered');
    // 값을 저장할 변수
    let save = '';


    /*  */

}