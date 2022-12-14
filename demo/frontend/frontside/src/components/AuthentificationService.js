import axios from 'axios';
export const USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUserId';


const API_URL = 'http://localhost:8080';


class AuthenticationService {


     async login(Username, Password) {
        let formData = new FormData()
        formData.append("username",Username)
        formData.append("password",Password)
        return fetch('http://localhost:8080/login', {
            method: 'post',
            credentials: 'include',
            headers: {
            },
            
            body: formData
        },
        {
            withCredentials: true,
        }
        );
    }


    registerSuccessfulLogin(username, password) {
        sessionStorage.setItem(USER_NAME_SESSION_ATTRIBUTE_NAME, username)
    }

    
    async logout() {
        
        var response = await fetch('http://localhost:8080/logout', 
            {
                method: 'post',
                credentials: 'include',
            },
            {
                withCredentials: true,
            }
            );
            if (response.ok)    
            {
                console.log("Success logout!");
            }
            else
            {
                console.log(response.status);
            }
            sessionStorage.removeItem(USER_NAME_SESSION_ATTRIBUTE_NAME);
    }

    async getAuthData()
    {
        return await fetch('http://localhost:8080/auth/principal', 
        {
            method: 'get',
            credentials: 'include',
            headers: {
                'Accept': 'application/json',
                 'Content-Type': 'application/json'
            }
        },
        {
            withCredentials: true,
        }
        );
    }

    isUserLoggedIn() {
        let user = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME)
        if (user === null) return false
        return true
    }

   

  
   
}


export default new AuthenticationService()