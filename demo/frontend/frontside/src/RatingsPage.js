import classes from './RatingsPage.module.css';
import AuthHeader from './AuthHeader';
import MenuHeader from './components/MenuHeader';
import { useEffect } from 'react';
import { useState } from 'react';
import { Pagination } from '@mui/material';
function RatingsPage() {

    const [data, setdata] = useState([]);
    const [page, setpage] = useState(1);
    const [totalPages, setTotalPages] = useState();

    useEffect(()=>
    {
        document.body.style.overflowY = "scroll";
        document.body.style.overflowX = "auto";
       
    },[]
    );

    useEffect(() => {

        fetch(`http://localhost:8080/ratings?page=${page-1}`,
            {
                credentials: 'include',
            },
            {
                withCredentials: true
            }).then((response) => { return response.json(); }).then(data => { setdata(data.items); setTotalPages(data.totalPagesCount);  console.log(data); });
           
    }, [page]);

    return (
        <>
            <div className={classes.container}>
                <AuthHeader />
                <MenuHeader />

                <div className={classes.thirdRow}>

                    <p className={classes.clubrating}>Рейтинг клубов 4М и 4М+</p>
                </div>





                <div className={classes.hr1}></div>
                <div className={classes.hr2}></div>


                <div className={classes.fifthRow}>

                    <div className={classes.rating}>
                        <p className={classes.ratingdesc}>СВОДНЫЙ РЕЙТИНГ</p>
                    </div>
                </div>


                <div className={classes.sixthRow}>
                    <table>
                        <tbody>
                            <tr className={classes.header}>
                                <th>№</th>
                                <th>Игровое имя</th>
                                <th>Баллы</th>
                                <th>Игры</th>
                                <th>% Побед</th>
                                <th>Ср.балл за игру</th>
                                <th>Победы</th>
                                <th>Поражения</th>
                                <th>Доп. баллы</th>
                                <th>Штраф</th>
                                <th>Компенсация</th>
                              
                            </tr>
                            {data.map((object, i) =>

                                <tr className={classes.datarow} key={i}>
                                    <td>{(i + 1)+20*(page-1)}</td>
                                    <td>{object.nickname}</td>
                                    <td>{object.totalPoints.toFixed(1)}</td>
                                    <td>{object.numberCounts}</td>
                                    <td>{(object.wins / object.numberCounts * 100).toFixed(1)}</td>
                                    <td>{(object.totalPoints / object.numberCounts).toFixed(4)}</td>
                                    <td>{object.wins}</td>
                                    <td>{object.loses}</td>
                                    <td>{object.totalExtraPoints.toFixed(2)}</td>
                                    <td>{(-(object.totalPenaltyPoints)).toFixed(2)}</td>
                                    <td>{(object.totalCompensationPoints).toFixed(2)}</td>
                                    
                                </tr>

                            )}


                        </tbody>
                    </table>
                    <div className={classes.Pagination_Container}><Pagination page={page} count={totalPages} onChange={(_, num) => setpage(num)} variant="outlined" shape="rounded" /></div>

                </div>

            </div>
        </>
    );
}


export default RatingsPage;
