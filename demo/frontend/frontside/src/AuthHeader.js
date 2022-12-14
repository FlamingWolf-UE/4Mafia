import classes from './RulesPage.module.css';
import React from 'react';
import AuthentificationService from './components/AuthentificationService';


class AuthHeader extends React.Component {

    constructor(props, context) {
        super(props, context);
        this.state = {
            isLoggedIn: AuthentificationService.isUserLoggedIn(),
        };

    }



    render() {

        
        let user = localStorage.getItem("AuthUserData");
        let UserData = JSON.parse(user);
        if (this.state.isLoggedIn) {

            return (
                <>
                    <div className={classes.firstRow}>
                        <img src={require('./logotip_header.png')} className={classes.logopic} />
                        <div className={classes.profileInfo}>
                            <p className={classes.profileheader}>
                                Госпо{UserData.isMale ? 'дин' : 'жа'} {UserData.nickname}
                            </p>
                            {UserData.name != "" && <p className={classes.profileheader}>Также известн{UserData.isMale ? 'ый' : 'ная'} как: {UserData.name}</p>}
                            <p className={classes.profileheader}>Игровой клуб: {UserData.club.clubName} {UserData.club.clubName != "Нет" ? (UserData.club.city.name) : ""}</p>
                            <button className={[classes.btn, classes.problem].join(' ')}>Сообщить об ошибке</button>
                            <button className={[classes.btn, classes.profile].join(' ')}>Профиль</button>
                            <button onClick={() => { AuthentificationService.logout(); if (AuthentificationService.isUserLoggedIn()) { this.state.isLoggedIn = false; this.setState({ isLoggedIn: false, content: this.render() }) } }} className={[classes.btn, classes.quit].join(' ')}>Выйти</button>
                        </div>
                        <img src={require('./profile_pic.png')} className={classes.profilepic} />
                    </div>
                    <div className={classes.firstRowMobile}>
                        <div id="menuToggle">
                            <input type="checkbox" />
                            <span></span>
                            <span></span>
                            <span></span>
                            <ul id="menu">
                                <div className={classes.profileInfo}>
                                    <div className={classes.insideBurger}>
                                        <p className={classes.moreText}>  Госпо{UserData.isMale ? 'дин' : 'жа'} {UserData.nickname}</p><img src="media\\profile_pic.png" className={classes.profilepic} />
                                    </div>
                                    {UserData.name != "" && <p className={classes.otherText}>Также известн{UserData.isMale ? 'ый' : 'ная'} как: {UserData.name}</p>}
                                    <p className={classes.anotherText}>Игровой клуб: {UserData.club.clubName} {UserData.club.clubName != "Нет" ? (UserData.club.city.name) : ""}</p>
                                </div>
                                <div className={classes.hr2}>
                                    <hr />
                                </div>
                               
                                    <li><button className={[classes.btn, classes.problem].join(' ')}>Сообщить об ошибке</button></li>
                                
                                
                                    <li><button className={[classes.btn, classes.profile].join(' ')}>Профиль</button></li>
                                
                               
                                    <li> <button className={[classes.btn, classes.quit].join(' ')} onClick={() => { AuthentificationService.logout(); this.state.isLoggedIn = false; this.setState({ isLoggedIn: false, content: this.render() }) }}>Выйти</button></li>
                               
                            </ul>
                        </div>
                        <img src={require('./logotip_header.png')} className={classes.logopic} />
                    </div>
                </>
            );
        }
        else {
            return (
                <>
                    <div className={classes.firstRow}>
                        <img src={require('./logotip_header.png')} className={classes.logopic} />
                        <div className=""></div>
                        <div className={classes.signin}>

                            <img src={require('./register.png')} className={classes.loginpic2} /><a href="/login" className={[classes.btn, classes.login].join(' ')}>Вход</a>
                        </div>
                    </div>
                    <div className={classes.firstRowMobile}>
                        <div id="menuToggle">
                            <input type="checkbox" />
                            <span></span>
                            <span></span>
                            <span></span>
                            <ul id="menu">
                                <a href="#">
                                    <li><button className={[classes.btn, classes.problem].join(' ')}>Сообщить об ошибке</button></li>
                                </a>
                                <a href="#">
                                    <li> <a href="/login" className={[classes.btn, classes.quit].join(' ')}>Войти</a></li>
                                </a>
                            </ul>
                        </div>
                        <img src={require('./logotip_header.png')} className={classes.logopic} />
                    </div>
                </>
            );
        }
    }

}

export default AuthHeader;