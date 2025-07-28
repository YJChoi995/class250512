import { useState } from 'react';
import { ListItem, ListItemText, InputBase, Checkbox, ListItemSecondaryAction, IconButton } from '@mui/material';
import DeleteOutlined from '@mui/icons-material/DeleteOutlined';
function Todo(props) {
    const [item, setItem] = useState(props.item);
    const deleteItem = props.deleteItem; // 부모 컴포넌트에서 전달된 deleteItem 함수

    // deleteEventHandler 함수는 아이템 삭제 버튼 클릭 시 호출
    const deleteEventHandler = () => {
        deleteItem(item); // 아이템 삭제 함수 호출
    };

    const checkboxHandler = (e) =>{
        item.done = e.target.checked; // 체크박스 상태 업테이트
        setItem({...item}); // 상태 업데이트
    }

    return (
        <ListItem>
            <Checkbox checked={item.done} onChange={checkboxHandler}/>
            <ListItemText>
                <InputBase
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