import { useState } from "react";

function Counter() {

    const [count, setCount] = useState(0); // count는 현재 상태값, setCount는 상태를 변경하는 함수

    // 증가 버튼을 클릭했을 때 실행될 함수
    const handlerIncrease = ()=> {
        setCount(count + 1);
    }

    // 감소 버튼
    const handlerDecrease = ()=> {
        setCount(count - 1);
    }

    return(
        <div>
            <h2>카운터</h2>
            <h1>{count}</h1>
            <button onClick ={handlerIncrease}>증가</button>
            <button onClick ={handlerDecrease}>감소</button>
        </div>
    )
    
}
export default Counter;