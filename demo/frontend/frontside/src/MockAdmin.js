import AuthentificationService from "./components/AuthentificationService";
import classes from './MockAdmin.module.css';
import AuthHeader from './AuthHeader';
import MenuHeader from './components/MenuHeader';
import {useEffect} from 'react';
function MockAdmin()
{

    
     async function adminTest()
    {
            let response = await fetch("http://localhost:8080/admin", {
                method: 'get',
                credentials:'include'
            },
            {
                withCredentials:true,
            }
            );
            if (response.ok) {
               
                console.log("Status " + response.status);
               
                pasteData(await response.text());
            }
            else 
            {
                console.log("Error during executing fetch request: " + response.status);
                pasteData("Bad request: " +  response.status);
            }
            
    }

    function pasteData(data)
    {
       var element =  document.getElementById("data");
       element.innerText = data;
    }

    return (
        <>
        <AuthHeader />
                <MenuHeader />
        <div className={classes.container}>
             
            <p className={classes.msg_test}>Hello admin</p>
            <div >
                <button className={classes.btn} onClick={AuthentificationService.logout}>
                    LOGOUT
                </button>
                <button className={classes.btn} onClick={adminTest}>
                    ADMIN TEST
                </button>
                
            </div>
            <div id="data"></div>
        </div>
        </>
    );
}

export default MockAdmin;