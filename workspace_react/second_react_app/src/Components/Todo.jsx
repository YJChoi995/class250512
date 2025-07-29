import { useState } from 'react';
import { ListItem, ListItemText, InputBase, Checkbox, ListItemSecondaryAction, IconButton } from '@mui/material';
import DeleteOutlined from '@mui/icons-material/DeleteOutlined';
function Todo(props) {
    const [item, setItem] = useState(props.item);
    const deleteItem = props.deleteItem; // 부모 컴포넌트에서 전달된 deleteItem 함수
    const [readOnly, setReadOnly] = useState(true); // 읽기 전용 상태

    const editItem = props.editItem; // 부모 컴포넌트에서 전달된 editItem 함수

    // deleteEventHandler 함수는 아이템 삭제 버튼 클릭 시 호출
    const deleteEventHandler = () => {
        deleteItem(item); // 아이템 삭제 함수 호출
    };

    const checkboxHandler = (e) =>{
        item.done = e.target.checked; // 체크박스 상태 업테이트
        setItem({...item}); // 상태 업데이트
    }

    const editEventHandler = (e) => {
        item.title = e.target.value; // 입력 필드의 값으로 아아템 제목 업테이트
        editItem(); // 부모 컴포넌트의 editItem 함수 호출
    }

    const turnOffReadOnly = () => {
        setReadOnly(false); // 읽기 전용 상태를 false로 변경
    }

    const turnOnReadOnly = (e) => {
        if(e.key === 'Enter') {
            setReadOnly(true); // Enter 키를 누르면 읽기 전용 상태로 변경
        }
    }

    return (
        <ListItem>
            <Checkbox checked={item.done} onChange={checkboxHandler}/>
            <ListItemText>
                <InputBase 
                style={{ textDecoration: item.done ? 'line-through' : 'none' }}
                inputProps={{ readOnly: readOnly }} // 읽기 전용 상태에 따라 입력 필드 설정
                onClick = {turnOffReadOnly} // 클릭 시 읽기 전용 해제
                onKeyDown = {turnOnReadOnly} 
                onChange = {editEventHandler}
                    type="text"
                    id={item.id}
                    name={item.id}
                    value={item.title}
                    multiline={true}
                    fullWidth={true}
                />
            </ListItemText>
            <ListItemSecondaryAction>
                <IconButton onClick={deleteEventHandler}>
                    <DeleteOutlined />
                </IconButton>
            </ListItemSecondaryAction>
        </ListItem>
    );
}
export default Todo;