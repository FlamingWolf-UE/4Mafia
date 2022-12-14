import { useState } from 'react';
import classes from './LoginPage.module.css';
import AuthenticationService from './components/AuthentificationService';
import { useNavigate } from 'react-router-dom';
import {useEffect} from "react";



function LoginPage()
{
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    

    useEffect(() => {
        document.body.style.overflow = "hidden";
      }, []);
      
    async function sendRequest(event) {
        event.preventDefault();
        let response = await AuthenticationService.login(username,password);
        
        if (response.ok) {
            AuthenticationService.registerSuccessfulLogin();
            console.log("User authentificated: " + AuthenticationService.isUserLoggedIn());
            console.log("Response status: " + response.status);
           
             var dataResponse = await AuthenticationService.getAuthData();
                if (dataResponse.ok)
                {
                    var data = await dataResponse.json();
                    console.log(data);
                    localStorage.setItem("AuthUserData", JSON.stringify(data));
                }
                   
                navigate(-1);
        }
        else {
            console.log("Error during executing fetch request: " + response.status);
            console.log(response.text());
        }
    }

     


    
    return (
        <>
            <div className={classes.container}>
                <div className={classes.firstRow}>
                    <img src={require('./logotip_header.png')} className={classes.logopic} />
                </div>
                <div className={classes.firstRowMobile}>
                    <div className=""></div>
                    <img src={require('./logotip_header.png')} className={classes.logopic} />
                </div>



                <div className={classes.secondRow}>
                    <form className={classes.LoginForm} method="post" action="http://localhost:8080/login">
                        <div className={classes.someText}>
                            Вход
                        </div>
                        <div className={classes.logintext}>
                            <label htmlFor="login">Логин</label>
                            <input type="text" id="username" name="username"  onChange={(event)=> {setUsername(event.target.value);}} defaultValue="" required />
                            <label htmlFor="password">Пароль</label>
                            <input type="password" id="password" name="password" onChange={(event)=> {setPassword(event.target.value);}} defaultValue="" required />
                        </div>
                        <div className={classes.div}>
                            <button disabled={true} className={[classes.btn, classes.forgotPassword].join(' ')}>Забыли пароль?</button>
                        </div>
                        <div className={classes.div}>
                            <button className={[classes.btn, classes.login].join(' ')} type="submit" onClick={sendRequest}>Войти</button>
                        </div>

                    </form>
                </div>

            </div>
        </>
    );
}


export default LoginPage;