function Book(props){
    return(

        <div className='Book'>
            <img className="book-cover" src={props.imgSrc}/>
            <h2 className="book-title">{props.title}</h2>
            <p className="book-author">{props.author}</p>
            <p className="book-price">{props.price}</p>
        </div>

    );
}

export default Book;