import {useState} from 'react';
import { Grid, TextField, Button } from '@mui/material';

function AddTodo(props){
    // 사용자 입력을 저장할 객체
    const [item, setItem] = useState({ title: ''});
    const addItem = props.addItems; // 부모 컴포넌트에서 전달된 addItem 함수

    const onInputChange=(e)=>{
        setItem({ title: e.target.value}); // 입력한 텍스트 값을 얻음
        console.log(item);
    }
    
    const onButtonClick = () => {
        // 아아팀이 비어있진 않으면 addItem 함수 호출
        if (item.title !== ""){
            addItem(item); // addItem 호출
            setItem({ title: '' }); // 입력창 초기화
        }
    }

    const enterKeyEventHandler = (e) => {
        if (e.key === 'Enter') {
            onButtonClick(); // Enter 키를 누르면 onButtonClick 호출
        }
    }

    return(
        // Grid: 레이아웃 구성
        <Grid container style={{ justifyContent: 'center', marginTop: 20}}>
            <Grid style={{paddingRight: '16px'}}>
                {/* 입력을 위한 TextField 컴포넌트 */}
                <TextField placeholder="Add Todo here" style={{ width: '700px' }} 
                onChange={onInputChange}
                onKeyPress={enterKeyEventHandler}
                value={item.title} />
            </Grid>
            <Grid>
                {/* 추가 버튼 */}
                <Button style={{ height: '100% '}} color="secondary" variant="outlined"
                onClick={onButtonClick}>
                    추가
                </Button>
            </Grid>
        </Grid>
    )
}
export default AddTodo;