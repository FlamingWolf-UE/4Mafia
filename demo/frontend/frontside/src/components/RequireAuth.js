import React from 'react'
import AuthentificationService from './AuthentificationService'

import {Navigate} from 'react-router-dom';
const RequireAuth = ({ children }) => {
  
    if (!AuthentificationService.isUserLoggedIn()) {
       return  <Navigate to="/login" replace />;
    }
    return children;
 };

export default RequireAuth;