import React from 'react'
import {BrowserRouter} from 'react-router-dom'

import Routes from './routes/index'

function App() {
  return (
    <React.Fragment>
      <BrowserRouter>
        <Routes />
      </BrowserRouter>
    </React.Fragment>
  );
}

export default App;
