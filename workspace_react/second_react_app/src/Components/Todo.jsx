import {useState} from 'react';
import {ListItem, Checkbox, ListItemText, InputBase} from '@mui/material';

function Todo(props){
    const [item, setItem] = useState(props.item);
    
    return(
        <ListItem>
            <Checkbox checked = {item.done} />
            <ListItemText>
                <InputBase
                    type="text" id={item.id} name={item.id} value={item.title}
                    multiline={true}
                    fullWidth={true}
                />
            </ListItemText>
            {/* <input type="checkbox" id={item.id} name={item.id} checked={item.done} />
            <label for={item.id}>{item.title}</label> */}
        </ListItem>
    )

}

export default Todo;