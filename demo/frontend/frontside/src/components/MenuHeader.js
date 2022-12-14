



import classes from '../RulesPage.module.css';
import {useNavigate} from 'react-router-dom';
function MenuHeader()
{

    const navigate = useNavigate();
    return (
        <>
            <div className={classes.secondRow}>
                <div className=""></div>
                <button onClick={() => navigate("/ratings")} className={[classes.btn, classes.rating].join(' ')}>Рейтинг</button>
                <button onClick={() => navigate("/archive")} className={[classes.btn, classes.archive].join(' ')}>Архив</button>
                <button onClick={() => navigate("/rules")} className={[classes.btn, classes.rules].join(' ')}>Правила</button>
                <button onClick={() => navigate("/admin")} className={[classes.btn, classes.admin].join(' ')}>Админ</button>
            </div>
        </>
    );
}


export default MenuHeader;
