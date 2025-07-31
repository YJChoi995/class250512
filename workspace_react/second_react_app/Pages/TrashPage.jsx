import { Container, IconButton, ListItemSecondaryAction, ListItemText } from "@mui/material";
import { Paper, List, ListItem } from '@mui/material';
import RestoreIcon from '@mui/icons-material/Restore';

function TrashPage(props) {
    // 삭제 아이템
    const deletedItems = props.deletedItems; // 부모 컴포넌트에서 전달된 삭제된 아이템 목록
    // 복원 함수
    const restoreItem = props.restoreItem; // 부모 컴포넌트에서 전달된 복원 함수

    return(
        <Container maxWidth="md">
            <h2>삭제된 아이템 목록</h2>
            <Paper style={{ margin: 16, boxShadow: '0 5px 8px rgba(0,0,0,0.5)', width: '100%'}}>
                <List>
                    {deletedItems === 0 ? (
                        <ListItem>
                            <ListItemText primary = "삭제된 아이템이 없습니다" />
                        </ListItem>
                    ) : (
                        deletedItems.map((item) => (
                            <ListItem key = {item.id}>
                                <ListItemText primary = {item.title} />
                                    <ListItemSecondaryAction>
                                        <IconButton onClick = {() => restoreItem(item)}>
                                            <RestoreIcon />
                                        </IconButton>    
                                    </ListItemSecondaryAction>
                            </ListItem>
                        ))
                    )}
                </List>
            </Paper>
        </Container>
    )
}
export default TrashPage;