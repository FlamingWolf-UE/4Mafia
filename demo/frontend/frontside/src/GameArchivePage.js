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

        fetch(`http://localhost:8080/archive?page=${page-1}`,
            {
                credentials: 'include',
            },
            {
                withCredentials: true
            }).then((response) => { return response.json(); }).then(data => { setdata(data.items); setTotalPages(data.totalPagesCount);     });
           
    }, [page]);

    return (
        <>
            <div className={classes.container}>
                <AuthHeader />
                <MenuHeader />

                <div className={classes.thirdRow}>

                    <p className={classes.clubrating}>Все игры клуба</p>
                </div>





                <div className={classes.hr1}></div>
                <div className={classes.hr2}></div>


                <div className={classes.fifthRow}>

                    <div className={classes.rating}>
                        <p className={classes.ratingdesc}>АРХИВ ИГР</p>
                    </div>
                </div>


                <div className={classes.sixthRow}>
                    <table>
                        <tbody>
                            <tr className={classes.header}>
                                <th>№</th>
                                <th>Тип игры</th>
                                <th>Место</th>
                                <th>Дата</th>
                                <th>Номер игры</th>
                                <th>Исход</th>
                            </tr>
                            {data.map((object, i) =>

                                <tr className={classes.datarow} key={i}>
                                    <td>{(i + 1)+20*(page-1)}</td>
                                    <td>{object.gameType}</td>
                                    <td>{object.place}</td>
                                    <td>{object.date}</td>
                                    <td>{object.gameNumber}</td>
                                    <td>{object.result}</td>
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
