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

    const checkboxHandler = (e) => {
        item.done = e.target.checked; // 체크박스 상태 업데이트
        // setItem({ ...item }) // 상태 업데이트
        editItem();
    };

    const editEventHandler = (e) => {
        item.title = e.target.value; // 입력 필드의 값으로 아이템 제목 업데이트
        editItem(); // 부모 컴포넌트의 editItem 함수 호출
    };

    const turnOffReadOnly = () => {
        setReadOnly(false); // 읽기 전용 상태를 false로 변경
    };

    const turnOnReadOnly = (e) => {
        if (e.key === 'Enter') {
            setReadOnly(true); // Enter 키를 누르면 읽기 전용 상태로 변경
        }
    };

    // 우선순위 아이콘 반환하는 함수
    const priorityIcon = () => {
        switch (item.priority) {
            case 'high':
                return '🔴'; // 높은 우선순위
            case 'medium':
                return '🟠'; // 중간 우선순위
            case 'low':
                return '🟢'; // 낮은 우선순위
            default:
                return null; // 우선순위가 설정되지 않은 경우
        }
    };

    // 우선순위 바꾸는 함수
    const changePriority = (newPriority) => {
        item.priority = newPriority; // 아이템의 우선순위 업데이트
        editItem(); // 부모 컴포넌트의 editItem 함수 호출
    };

    // 우선순위 사이클 함수
    const cyclePriority = () => {
        // 현재 우선순위를 확인하고 다음 우선순위로 변경
        switch (item.priority) {
            case 'high':
                changePriority('medium'); // 높은 우선순위에서 중간 우선순위로 변경
                break;
            case 'medium':
                changePriority('low'); // 중간 우선순위에서 낮은 우선순위로 변경
                break;
            case 'low':
                changePriority('high'); // 낮은 우선순위에서 높은 우선순위로 변경
                break;
            default:
                changePriority('high'); // 우선순위가 설정되지 않은 경우 높은 우선순위로 설정
                break;
        }
    };

    return (
        <ListItem>
            <Checkbox checked={item.done} onChange={checkboxHandler} />
            <span
                style={{ fontSize: '1.2rem', marginRight: '8px' }}
                onClick={cyclePriority} // 우선순위 변경을 위한 클릭 이벤트 핸들러
            >
                {priorityIcon()} {/* 우선순위 아이콘 표시 */}
            </span>
            <ListItemText>
                <InputBase
                    style={{ textDecoration: item.done ? 'line-through' : 'none' }}
                    inputProps={{ readOnly: readOnly }} // 읽기 전용 상태에 따라 입력 필드 설정
                    onClick={turnOffReadOnly} // 클릭 시 읽기 전용 해제
                    onKeyDown={turnOnReadOnly}
                    onChange={editEventHandler}
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
