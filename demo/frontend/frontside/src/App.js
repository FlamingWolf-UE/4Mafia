
import './App.css';
import LoginPage from './LoginPage';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import RequireAuth from './components/RequireAuth';
import RulesPage from './RulesPage';
import MockAdmin from './MockAdmin';
import RatingsPage from './RatingsPage';
import GameArchivePage from './GameArchivePage';
import Error404 from './404';
function App() {
  return (
    <Router>

      <Routes>
      <Route exact path="/archive" element={<RequireAuth><GameArchivePage/></RequireAuth>}/>
        <Route exact path="/ratings" element={<RequireAuth><RatingsPage/></RequireAuth>}/>
        <Route exact path="/login" element={<LoginPage/>}/>
        <Route exact path="/rules" element={<RulesPage/>}/>
        <Route exact path="/admin" element={<RequireAuth><MockAdmin/></RequireAuth>}/>
        <Route path="*" element={<Error404/>}/>
      </Routes>
    </Router>
     );
}

export default App;
