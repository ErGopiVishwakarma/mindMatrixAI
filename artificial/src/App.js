import logo from './logo.svg';
import './App.css';
import HomePage from './Pages/HomePage';
import Dashboard from './Pages/Dashboard';
import Loading from './Component/Dashboard/Loading';
import AllRoute from './Route/AllRoute';

function App() {
  return (
    <div className="App">
      <AllRoute />
    </div>
  );
}

export default App;
