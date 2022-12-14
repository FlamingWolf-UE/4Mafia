
import classes from './404.module.css';




function Error404()
{
    
    return (
        <>
            <div className={classes.container}>
                <div className={classes.imgDiv}>
               <img src={require('./404.jpg')}></img>
               <p className={classes.text}>Страница не найдена</p>
               </div>
            </div>
        </>
    );
}


export default Error404;