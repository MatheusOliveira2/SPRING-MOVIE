import React from 'react'
import {BrowserRouter} from 'react-router-dom'

import GlobalStyle from './styles/GlobalStyle'
import Routes from './routes/index'

function App() {
  return (
    <React.Fragment>
      <BrowserRouter>
        <Routes />
      </BrowserRouter>
      <GlobalStyle />
    </React.Fragment>
  );
}

export default App;
